package com.zhanglf;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.rabbitmq.client.Address;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownListener;
import com.rabbitmq.client.ShutdownSignalException;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.zlf.bo.StaffBo;
import com.zlf.service.IStaffService;

public class RabbitMqListenerIpsByImplementsServletContextListener implements ServletContextListener {

	private Address[] addre;
	private String vhost;
	private String user;
	private String pwd;
	private String queueName;
	
	public RabbitMqListenerIpsByImplementsServletContextListener(){
		this.addre = new Address[] { new Address("10.100.82.121", 5672),
				new Address("10.100.82.122", 5672),
				new Address("10.100.82.123", 5672) };
		this.vhost = "gf-iih";
		this.user = "admin";
		this.pwd = "admin";
		this.queueName = "tkq.queue";
	}
	
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		IStaffService staffService = applicationContext.getBean(IStaffService.class);	
		RabbitMqListenerIpsByImplementsServletContextListener mqListener = new	RabbitMqListenerIpsByImplementsServletContextListener();
		mqListener.StartQueueListener(new ShutdownListener() {
			@Override
			public void shutdownCompleted(ShutdownSignalException arg0) {
				System.out.println("Connection Shutdown!");
			}
		}, staffService);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}
	
	private Connection getConnection(ShutdownListener listener) {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setUsername(user);
		factory.setPassword(pwd);
		factory.setVirtualHost(vhost);
		factory.setAutomaticRecoveryEnabled(true);

		Connection conn = null;
		try {
			conn = factory.newConnection(addre);
			conn.addShutdownListener(listener);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void StartQueueListener(ShutdownListener listener,final IStaffService staffService) {
		Connection conn = getConnection(listener);
		if (conn == null) {
			System.out.println("Failed to Create Connection!");
			return;
		}
		try {
			final Channel channel = conn.createChannel();
			// 设置ACK为手动模式，不在自动ACK
			boolean autoAck = false;
			/**channel.basicConsume各个参数的解释
			 * String queueName:队列名
			 * boolean autoAck: 服务器是否要手动应答/确认，true-不需要。false-需要。所以这里我们要在处理完业务逻辑后，消费掉mq后发送ack。
			 * String consumerTag:用于建立上下文的客户端标签。每个标签都代表一个独立的订阅。同一个channel的不同consumer使用不同的标签。
			 * Consumer callback: 消费端接口，实现Consumer的最方便方法是继承DefualtConsumer，并将其作为参数传给basicConsumer方法。答
			 */
			channel.basicConsume(queueName, autoAck, "zhanglfConsumerTag",
					new DefaultConsumer(channel) {
						@Override
						public void handleDelivery(
								String consumerTag,
								Envelope envelope, 
								BasicProperties properties,
								byte[] body)
						throws IOException {
							long deliveryTag = envelope.getDeliveryTag();
							String out = new String(body, "UTF-8");
							StaffBo staffBo = staffService.selectByPrimaryKey("s01");
							System.out.println("------------------"+staffBo.getName()+"------------");
							if ("业务处理结果".equals("业务处理结果")) {
								// 通知mq服务器移除此条mq。设置ack为每条mq都ack，不是批量ack。
								channel.basicAck(deliveryTag, false);
							} else {
								// 如果业务处理异常，通知服务器回收此条mq。
								channel.basicNack(deliveryTag, false, true);
							}
						}
					});

		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
		
		
	}

}
