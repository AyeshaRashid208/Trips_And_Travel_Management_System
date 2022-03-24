import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
public class logout extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");		
		
		HttpSession session = request.getSession(false);
		
			session.invalidate();
			//session = request.getSession();
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request,response);
		
	}
}	