package mypack;


import javax.servlet.http.*;
import javax.servlet.*;
import org.apache.log4j.Logger; 

public class Init extends HttpServlet{
	public void init(ServletConfig config)	throws ServletException{
		System.out.println("***********************************************");
		Logger log = Logger.getLogger("test");
		log.error("i came to logg");
	}
	
}