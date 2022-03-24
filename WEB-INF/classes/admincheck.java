import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class admincheck extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String Email = request.getParameter("email");
		String Password = request.getParameter("password");
		String PATTERN = "(.*)(@)(.*)(.[a-z]{2,3})";
		Pattern pattern = Pattern.compile(PATTERN);
		Matcher matcher = pattern.matcher(Email);
        if(matcher.matches() && Password!=null){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/accounts";
			Connection con = DriverManager.getConnection(url, "root", "root");

			PreparedStatement ps = con.prepareStatement("select * from admin where Email=? AND Password=?");
			ps.setString(1, Email);
			ps.setString(2, Password);

			ResultSet rs = ps.executeQuery();
			

			if (rs.next()) {
                HttpSession session = request.getSession();
				String email = rs.getString("email");
				String password = rs.getString("password");
				session.setAttribute("Email",email);
				//session.setAttribute("Password",password);
				RequestDispatcher rd = request.getRequestDispatcher("adminpage.html");
				rd.forward(request, response);
			} else {

				
				RequestDispatcher rd = request.getRequestDispatcher("LogIn");
				rd.forward(request, response);
			}

		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}
	else{
		response.sendRedirect("login_again.html");
	}
	}
	

}

