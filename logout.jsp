<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
    <!DOCTYPE html>
<html>
<head>
	<link href="logout.css" rel="stylesheet" type="text/css">
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
    <%
    if(request.getSession(false)!=null) {
    	request.getSession(false).invalidate();
	%>
    <div>
        <p class="l">Logged out successfully</p>
    </div>	
	<%	
	}else {
		
    %>
    <div>
        <p class="l">You are not Logged In <a href="http://localhost:8080/project/login.html">LogIn here</a></p>

    </div>
    <%
	}

    	
    %>
</body>
</html>