package MyPack;
import java.io.*; 
public class TripBean implements Serializable{ 

 private    String Departure_Date ;
 private    String Departure_Time;
 private	String Departure_From ;
 private	String No_of_Days ;
 private	String No_of_Seats;
 private	String Price_Per_Seat;

// no argument constructor 
public TripBean() {
    Departure_Date = "" ;
         Departure_Time= "";
    	 Departure_From = "";
    	 No_of_Days= "" ;
    	 No_of_Seats= "";
    	 Price_Per_Seat = "";
     
} 

// setters 
public void setDeparture_Date(String a){ 
 Departure_Date = a; 
} 
public void setDeparture_Time(String b){ 
 Departure_Time = b; 
}
public void setDeparture_From(String c){ 
 Departure_From = c; 
}
public void setNo_of_Days(String d){ 
 No_of_Days = d; 
}
public void setNo_of_Seats(String e){ 
 No_of_Seats = e; 
}
public void setPrice_Per_Seat(String f){ 
 Price_Per_Seat = f; 
}


// getters 
public String getDeparture_Date( ){ 
 return Departure_Date; 
} 

public String getDeparture_Time( ){ 
 return Departure_Time; 
} 

public String getDeparture_From( ){ 
 return Departure_From; 
} 
public String getNo_of_Days( ){ 
 return No_of_Days; 
} 
public String getNo_of_Seats( ){ 
 return No_of_Seats; 
} 
public String getPrice_Per_Seat( ){ 
 return Price_Per_Seat; 
} 

} // end class 

