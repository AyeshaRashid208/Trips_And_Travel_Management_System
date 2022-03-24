package MyPack;
import java.io.*; 
import java.sql.*; 
import java.util.*; 
import MyPack.TripBean;
public class TripDAO implements Serializable{ 

private Connection con; 

public TripDAO() throws ClassNotFoundException,SQLException { 
establishConnection(); 
} 

//********** establishConnection method *************

private void establishConnection() throws ClassNotFoundException,SQLException{ 

try{ 
Class.forName("com.mysql.jdbc.Driver");
String url = "jdbc:mysql://127.0.0.1/accounts";
Connection con =DriverManager.getConnection(url, "root", "root");

}catch(Exception ex){ 
System.out.println(ex); 
} 

} 

//*********** retrieveTripList method ******************** 

public ArrayList retrieveTripList(){ 

ArrayList tripList = new ArrayList(); 

try{ 
String sql = "SELECT * from package"; 
PreparedStatement pStmt = con.prepareStatement(sql); 
// pStmt.setString(1, ); 
ResultSet rs = pStmt.executeQuery(); 

    String Departure_Date ;
    String Departure_Time;
	String Departure_From ;
	String No_of_Days ;
	String No_of_Seats;
	String Price_Per_Seat;

 
while ( rs.next() ) { 

        Departure_Date=rs.getString("Departure_Date");    
        Departure_Time =rs.getString("Departure_Time");
		Departure_From=	rs.getString("Departure_From");
		No_of_Days=	rs.getString("No_of_Days");
		No_of_Seats=rs.getString("No_of_Seats");
		Price_Per_Seat=	rs.getString("Price_Per_Seat"); 

// creating a TripBean object 
TripBean tBean = new TripBean(); 
tBean.setDeparture_Date(Departure_Date); 
tBean.setDeparture_Time(Departure_Time);
tBean.setDeparture_From(Departure_From); 
tBean.setNo_of_Days(No_of_Days); 
tBean.setNo_of_Seats(No_of_Seats); 
tBean.setPrice_Per_Seat(Price_Per_Seat); 
// adding a bean to arraylist 
tripList.add(tBean); 
} 

con.close();

}catch(Exception ex){ 
System.out.println(ex); 
}

// returning ArrayList object 
return tripList; 

} // end retrieveMobileList

}//end MobileDAO 

