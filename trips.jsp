<%@page import="java.util.*" %> 
<%@page import="MyPack.*" %>
<jsp:useBean id="tripDAO" class = "MyPack.TripDAO" scope = "page"/>
<html> 
<body> 
<center> 
<h2>Available Package Detail</h2> 

<table border="1" > 

<tr> 
<th>Departure_Date</th> 
<th>Departure_Time</th> 
<th>Departure_From</th>
<th>No_of_Days</th>
<th>No_of_Seats</th>
<th>Price_Per_Seat</th>
</tr>
 
<% 
TripDAO trip = new TripDAO(); 
ArrayList tripList = trip.retrieveTripList(); 
%>


<%
TripBean trBean = null; 
// iterating over ArrayList to display trip details
for(int i=0; i<tripList.size(); i++){ 
 trBean = (TripBean)tripList.get(i); 
%> 

<tr> 
<td> <%= trBean.getDeparture_Date()%> </td> 
<td> <%= trBean.getDeparture_Time()%> </td> 
<td> <%= trBean.getDeparture_From()%> </td> 
<td> <%= trBean.getNo_of_Days()%> </td> 
<td> <%= trBean.getNo_of_Seats()%> </td> 
<td> <%= trBean.getPrice_Per_Seat()%> </td> 
</tr> 

<% 
} // end for 
%> 

</table></center> 
</body></html>