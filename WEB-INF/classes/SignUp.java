import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class SignUp extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
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
   // if(Name!=null && matcher.matches() && Password!=null && Confirm_Password!=null && Password == Confirm_Password && Gender!=null && Gender== "male" || Gender == "female" && Telephone!=null ){
	try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/accounts";
			Connection con=DriverManager.getConnection(url, "root", "root");
			//Statement st=con.createStatement();
			String query = "INSERT INTO info(Name,Email,Password,Confirm_Password,Gender,Telephone)VALUES(?,?,?,?,?,?) ";
			
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, Name);    
            pstmt.setString(2, Email);
			pstmt.setString(3, Password);
			pstmt.setString(4, Confirm_Password);
			pstmt.setString(5, Gender);
			pstmt.setString(6, Telephone);
			int rs = pstmt.executeUpdate( );
			
			if(rs==1)    
            {    
           //out.println("<h2>Values Inserted Successfully</h2>");   
           RequestDispatcher rd = request.getRequestDispatcher("trips.html");
				rd.forward(request,response);			
            }
			else{
				RequestDispatcher rd = request.getRequestDispatcher("signup.html");
				rd.forward(request,response);
			}
			
		}catch(Exception e)
		{e.printStackTrace();   
		}
	//}
	//else{
	//	response.sendRedirect("signup_again.html");
	//}
	
    
    out.close(); 
}

	
	


}