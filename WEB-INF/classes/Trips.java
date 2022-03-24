import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*; 
import javax.servlet.*; 
  
public class Trips extends HttpServlet {  
  
public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();
out.println("<html><body>"); 
try{
Class.forName("com.mysql.jdbc.Driver");
String url = "jdbc:mysql://127.0.0.1/accounts";
Connection con=DriverManager.getConnection(url, "root", "root");
Statement st = con.createStatement();  
ResultSet rs = st.executeQuery("select * from package"); 			  	
out.println("<form name="trip">");
out.println("<table>");
out.println("<tr><h3 align="center">TRIP DETAILS</h3></tr>");
out.println("<tr><td align="right">Departure Date </td></tr>");
out.println("<tr><td align="right">Departure Time </td></tr>");
out.println("<tr><td align="right">Departure From </td></tr>");
out.println("<tr><td align="right">Number of Days </td></tr>");
out.println("<tr><td align="right">Number of Seats Available</td></tr>");
out.println("<tr><td align="right">Price per Seat</td></tr>");
while (rs.next()) 
             {  
                 String a = rs.getString("Departure_Date");  
                 String b = rs.getString("Departure_Time"); 
				 String c = rs.getString("Departure_From"); 
				 String d = rs.getString("No_of_Days"); 
				 String e = rs.getString("No_of_Seats");
				 String f = rs.getString("Price_Per_Seat");
                 int s = rs.getInt("sal");   
                 out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + s + "</td></tr>");   
             }
}    




   
String Email=request.getParameter("email");
String Password=request.getParameter("password"); 

          
try{  
Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/accounts";
			Connection con=DriverManager.getConnection(url, "root", "root");
			  
PreparedStatement ps=con.prepareStatement("select * from info where Email=? AND Password=?"); 
ps.setString(1,Email);  
ps.setString(2,Password); 

ResultSet rs = ps.executeQuery();
//request.setAttribute("key", Name);

if(rs.next())  
{  

  RequestDispatcher rd = request.getRequestDispatcher("trips.html");
  rd.forward(request,response);					  
} 
else{
	
	//response.sendError(403,"Record not found");
	RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.forward(request,response);
} 
  

              
}catch (Exception e2) {e2.printStackTrace();}  
 
  
}  
}  
