
    <%@ page import="java.sql.*" %>

        <% String driver="com.mysql.jdbc.Driver" ; 
        String url="jdbc:mysql://127.0.0.1/accounts" ; 
        String user="root" ;
            String psw="root" ;
         %>
            <% String Departure_Date=request.getParameter("Departure_Date"); 
            String Departure_Time=request.getParameter("Departure_Time");
             String Departure_From=request.getParameter("Departure_From"); 
             String No_of_Days=request.getParameter("No_of_Days"); 
             String No_of_Seats=request.getParameter("No_of_Seats");
                String Price_Per_Seat=request.getParameter("Price_Per_Seat"); 
                Connection con=null; 
                PreparedStatement pstmt=null; 
                try { 
                Class.forName(driver); 
                con=DriverManager.getConnection(url,user,psw); 
                String sql="Update package set Departure_Date=?, Departure_Time=?,Departure_From=?,No_of_Days=?,No_of_Seats=?,Price_Per_Seat=? Where Departure_Date =  "+Departure_Date; 
                pstmt=con.prepareStatement(sql); 
                pstmt.setString(1, Departure_Date); 
                pstmt.setString(2,Departure_Time); 
                pstmt.setString(3, Departure_From); 
                pstmt.setString(4, No_of_Days); 
                pstmt.setString(5,No_of_Seats); 
                 pstmt.setString(6, Price_Per_Seat); 
                int i=pstmt.executeUpdate(); 
                if(i==1)
                {
                response.sendRedirect("viewpackages.jsp") ;
                }
                else
                {
                RequestDispatcher rd = request.getRequestDispatcher("adminpage.html");
                rd.forward(request,response);
                }
                }

                catch(Exception e)
                {e.printStackTrace();
                }
                
            %>