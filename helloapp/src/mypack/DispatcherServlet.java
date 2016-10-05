package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;



public class DispatcherServlet extends HttpServlet{
	private String target="/hello.jsp";
	private String welcome="/welcome.jsp";	
	public void init(ServletConfig config)	throws ServletException{
			super.init(config);
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
	}

}
