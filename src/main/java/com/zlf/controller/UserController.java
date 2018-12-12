package com.zlf.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zlf.bo.UserBo;
import com.zlf.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService us;
	
	/**
	 * 登陆验证用户名密码
	 */
	@RequestMapping("/checkLogin")
	public String checkLogin(HttpServletRequest request){
		String username=request.getParameter("username");
		String pwd=request.getParameter("password");
		UserBo ub=new UserBo();
		ub.setUsername(username);
		ub.setPwd(pwd);
		UserBo userBo = us.queryByPwdAndUsername(ub);
		if(userBo !=null && userBo.getUserid()!=null){
			return  "test";
		}
		return "../log";
	}
	
}
