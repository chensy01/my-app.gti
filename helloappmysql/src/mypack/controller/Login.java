package mypack.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import mypack.service.IUserService;

public class Login implements Controller{
	private static final Log logger = LogFactory.getLog(Register.class);
	
	@Autowired
	IUserService userService;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		logger.info("LoginController is calling");
		String username = arg0.getParameter("username");
		String password = arg0.getParameter("password");
		boolean isValid = userService.login(username, password);
		if(isValid){
			return new ModelAndView("welcome", "user", userService.get(username));
		}else{
			return new ModelAndView("sorry");
		}
	}

}
