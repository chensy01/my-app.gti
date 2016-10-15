package mypack;

import javax.servlet.http.*;
import java.io.*;
import java.util.Date;
import mypack.Util.*;
import javax.servlet.*;
import java.sql.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import mypack.Entity.*;



public class DispatcherServlet extends HttpServlet{
	private String target="/hello.jsp";
	private String welcome="/welcome.jsp";	
	private SessionFactory sessionFactory; //for hibernate
	public void init(ServletConfig config)	throws ServletException{
			super.init(config);

			
			// A SessionFactory is set up once for an application!
			final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
					.configure() // configures settings from hibernate.cfg.xml
					.build();
			try {
				sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
			}
			catch (Exception e) {
				// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
				// so destroy it manually.
				System.out.println(e.getMessage());
				StandardServiceRegistryBuilder.destroy( registry );
			}
		
	}

	public void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String action = request.getParameter("action");


		if("register".equals(action)){  
			request.setAttribute("USER", username);
                        request.setAttribute("PASSWORD", password);
			
			//save username and password to db
			/*String sql = "insert into users(name, password) values(' " + username + "', '" + password + "')";
			System.out.println(sql);
			try{
				mypack.Util.DbConnection.getInstance().execute(sql);
			}
			catch(Exception ex){
				System.out.println("execute sql error");
			}*/
			//user hibernate to save username and password
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			UsersId id = new UsersId(username, password, new Date());
			session.save( new Users(id));
			//session.save( new User( "A follow up event", new Date() ) );
			session.getTransaction().commit();
			session.close();
	
			//now lets pull events from the database and list them
			//session = sessionFactory.openSession();
			//session.beginTransaction();
			//List result = session.createQuery( "from Event" ).list();
			//for ( Event event : (List<Event>) result ) {
			//	System.out.println( "Event (" + event.getDate() + ") : " + event.getTitle() );
			//}
			//session.getTransaction().commit();
			//session.close();



            ServletContext context = getServletContext();
            System.out.println("Redirecting to " + welcome);
            RequestDispatcher dispatcher = context.getRequestDispatcher(welcome);
            dispatcher.forward(request,response);
		}               
		else{
			request.setAttribute("USER", username);
			request.setAttribute("PASSWORD", password);

			ServletContext context = getServletContext();
			System.out.println("Redirecting to " + target);
			RequestDispatcher dispatcher = context.getRequestDispatcher(target);
			dispatcher.forward(request,response);
		}
	}
	
	public void destroy(){
		if ( sessionFactory != null ) {
			sessionFactory.close();
		}
	}

}
