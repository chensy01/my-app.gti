package mypack.service;

import java.util.Date;

import javax.servlet.ServletContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;

import mypack.Entity.Users;

@Service
public class UserSerice implements IUserService {
	private SessionFactory sessionFactory; //for hibernate
	ApplicationContext ac;
	
	public UserSerice(){
		ac = ContextLoader.getCurrentWebApplicationContext();
		sessionFactory = (SessionFactory)ac.getBean("sessionFactory");
	}

	@Override
	public Users save(String username, String password) {
		// TODO Auto-generated method stub
		System.out.println("user service called");
		//ServletContext application = ServletActionContext.getServletContext();
//        ac = ContextLoader.getCurrentWebApplicationContext();
//        UserService userService = (UserService) act.getBean("userService");
        
        
//		ServletContext servletContext= request.getSession().getServletContext();
//		WebApplicationContext ac = (WebApplicationContext)servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//		sessionFactory = (SessionFactory)ac.getBean("sessionFactory");
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Users user = (Users)ac.getBean("user");
		user.setUsername(username);
		user.setPassword(password);
		user.setRegisterTime(new Date());
		String res;
		try{
			res = (String)session.save(user);
		}catch(Exception ex){
			res = null;
		}
		//session.save( new User( "A follow up event", new Date() ) );
		Users result;
		try{
			if(res != null){ //insert success
				session.getTransaction().commit();
				result = user;
			}else{
				session.getTransaction().rollback();
				result = null;
			}
		}catch(Exception ex){
			result = null;
		}
		session.clear();
//		session.close();
		return result;
	}

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
//		Users user = new Users();
//		user.setUsername(username);
//		user.setPassword(password);
		Users temp = (Users)session.get(Users.class, username);
//		System.out.println(temp.getRegisterTime());
		if(temp != null){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Users get(String username) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
//		Users user = new Users();
//		user.setUsername(username);
		return (Users)session.get(Users.class, username);
	}

	@Override
	public boolean isExists(String username) {
		// TODO Auto-generated method stub
		Users temp = get(username);
		if(null != temp){
			return true;
		}else{
			return false;
		}
	}
	
	

}
