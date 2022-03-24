import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import javax.swing.*;

public class UpdateRecord extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{        
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    
    String Departure_Date = request.getParameter("Departure_Date");
    String Departure_Time = request.getParameter("Departure_Time");
	String Departure_From = request.getParameter("Departure_From");
	String No_of_Days = request.getParameter("No_of_Days");
	String No_of_Seats= request.getParameter("No_of_Seats");
	//String Country = request.getParameter("country");
	String Price_Per_Seat = request.getParameter("Price_Per_Seat");
    

    //out.println("<h1>Welcome " + Name + " </h1>");
	try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/accounts";
			Connection con=DriverManager.getConnection(url, "root", "root");
			//Statement st=con.createStatement();
			String query = "UPDATE package SET Departure_Time=?,Departure_From=?,No_of_Days=?,No_of_Seats=?,Price_Per_Seat=? Where Departure_Date = ? ";
			
			PreparedStatement pstmt=con.prepareStatement(query);
			
			
            
			   
            pstmt.setString(1, Departure_Time);
			pstmt.setString(2, Departure_From);
			pstmt.setString(3, No_of_Days);
			pstmt.setString(4, No_of_Seats);
			pstmt.setString(5, Price_Per_Seat);
            pstmt.setString(6, Departure_Date); 
			int rs = pstmt.executeUpdate( );
			
			if(rs==1)    
            {    
        //    out.println("<h2>Values Inserted Successfully</h2>");   
        response.sendRedirect("viewpackages.jsp") ;
				

            }
			else{
				RequestDispatcher rd = request.getRequestDispatcher("addtrip.html");
				rd.forward(request,response);
			}
			
		}catch(Exception e)
		{e.printStackTrace();   
		}
   
    out.close(); 
	

	
	}


}