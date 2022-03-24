import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signuphandler extends HttpServlet 
{  
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String Name = request.getParameter("name");
		String Email = request.getParameter("email");
		String Password = request.getParameter("password");
		String Confirm_Password = request.getParameter("confirm_password");
		String Gender = request.getParameter("gender");
		String Telephone = request.getParameter("phone");
	   // String PATTERN = "(.*)(@)(.*)(.[a-z]{2,3})";
	//Pattern pattern = Pattern.compile(PATTERN);
	//Matcher matcher = pattern.matcher(Email);
	//if(matcher.matches()){
		try	
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/accounts";
			Connection con=DriverManager.getConnection(url, "root", "root");
			Statement st=con.createStatement();
			String query="Select * from info where Email='"+Email+"' ";
			System.out.println(query);
			ResultSet rs = st.executeQuery(query);
			if(rs.next())
			{
				String gmail = rs.getString("Email");
				RequestDispatcher rd = request.getRequestDispatcher("signup_again.html");
				rd.forward(request,response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("SignUp");
				rd.forward(request,response);
			}
		}catch(Exception e)
		{
			out.println("<h1>Error! Server-down.Try Again Later.</h1> ");
		}
	//}
	//else{
	//	response.sendRedirect("signup_again.html");
	//}
		out.println("</body></html>");
	}
}
