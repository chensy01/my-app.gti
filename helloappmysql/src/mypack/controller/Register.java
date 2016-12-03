package mypack.controller;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import mypack.Entity.Users;
import mypack.service.IUserService;

public class Register implements Controller{
	private static final Log logger = LogFactory.getLog(Register.class);
//	private SessionFactory sessionFactory; //for hibernate
//	ApplicationContext ac;
	
	@Autowired
	IUserService userService;
		
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		logger.info("RegisterController is calling");
//		ac = WebApplicationContextUtils.getWebApplicationContext();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		//ac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
//		ServletContext servletContext= request.getSession().getServletContext();
//		WebApplicationContext ac = (WebApplicationContext)servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//		sessionFactory = (SessionFactory)ac.getBean("sessionFactory");
//		
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		
//		Users user = (Users)ac.getBean("user");
//		user.setUsername(username);
//		user.setPassword(password);
//		user.setRegisterTime(new Date());
//		session.save(user);
//		//session.save( new User( "A follow up event", new Date() ) );
//		session.getTransaction().commit();
//		session.close();
		Users temp = userService.save(username, password);
		if(null == temp){
			return new ModelAndView("wrong", "message","user register fail,please check!");
		}else{
			return new ModelAndView("welcome", "user", userService.save(username, password));
		}		
	}

}
