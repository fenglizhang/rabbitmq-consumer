package com.zlf.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zlf.bo.StaffBo;
import com.zlf.service.IStaffService;

@Controller
@RequestMapping("/staff")
public class StaffController {
	 @Resource  
	 private IStaffService staffService;
	
	 @RequestMapping("/showUser")  
	    public String toIndex(HttpServletRequest request,Model model){  
	        String userId = request.getParameter("id");  
	        StaffBo user = this.staffService.selectByPrimaryKey(userId);  
	        model.addAttribute("user", user);  
	        return "test";  
	    } 
	 
	 @RequestMapping("/test") 
	 @ResponseBody
	    public StaffBo test(HttpServletRequest request,Model model){  
	        String userId = request.getParameter("id");  
	        StaffBo user = this.staffService.selectByPrimaryKey(userId);  
	        return user;  
	    } 
	 
	 @RequestMapping("/login")
	 public String loginCheck(HttpServletRequest request){
		 String name=request.getParameter("username");
		 String id=request.getParameter("password");
		 StaffBo sb=new StaffBo();
		 sb.setId(id);
		 sb.setName(name);
		 StaffBo staff = staffService.queryOneStaff(sb);
		 if(staff !=null && staff.getId()!=null){
			 return "test";
		 }
		 return "../log";
	 }
}
