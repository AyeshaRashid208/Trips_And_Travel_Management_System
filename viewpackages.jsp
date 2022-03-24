<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,java.io.*,backend.*" session="false" %>
<%

String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://127.0.0.1/";
String database = "accounts";
String userid = "root";
String password = "root";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet rs = null;
%>
<!DOCTYPE html>
<html>
<head>
	<link href="viewpackages.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header class="header">
        <div class="left">
            <!-- left box for logo -->
            <img src="logo4.png" >
            <div class="logo">Tours Planet</div>
            
        </div>
        <div class="mid">
            <!-- mid box for navbar -->
            
            <ul class="navbar">
                <li><a href="http://localhost:8080/project/">Home</a></li>
                <li><a href="http://localhost:8080/project/login.html">LogIn</a></li>
                <li><a href="http://localhost:8080/project/signup.html">SignUp</a></li>
                <li><a href="http://localhost:8080/project/trips.html">Trips</a></li>
                <li><a href="http://localhost:8080/project/services.html">Services</a></li>
                <li><a href="http://localhost:8080/project/logout.jsp">LogOut</a></li>
            </ul>
        </div>
        <div class="right">
            <!-- right box for buttons -->
            <button class="btn">Call Us</button>
            <button class="btn">Email Us</button>
        </div>

    </header>
<div id = "container">
<h1 align = "center">Here are Available Pakages</h1>
<table border="1">
	<tr> 
		<th>Departure_Date</th> 
		<th>Departure_Time</th> 
		<th>Departure_From</th>
		<th>No_of_Days</th>
		<th>No_of_Seats</th>
		<th>Price_Per_Seat</th>
		</tr>
<%
HttpSession session = request.getSession(false);
if (session!=null){
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from package";
rs = statement.executeQuery(sql);
while(rs.next()){
%>
<tr>
	<td><%=rs.getString("Departure_Date") %></td>
	<td><%=rs.getString("Departure_Time") %></td>
	<td><%=rs.getString("Departure_From")%></td>
	<td><%=rs.getString("No_of_Days")%></td>
	<td><%=rs.getString("No_of_Seats")%></td>
	<td><%=rs.getString("Price_Per_Seat")%></td>
	</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
<form>
	<button class="b" type="submit"><b><a href="tel:+9230244410"  class="a" >CONTACT US</a></b> FOR FURTHER DETAILS</button>
</form>

</div>
<%
}
else{
    response.sendRedirect("login.html");
}
%>
	
</body>
</html>