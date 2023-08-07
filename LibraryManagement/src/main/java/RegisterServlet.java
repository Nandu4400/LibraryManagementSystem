


import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/Registration")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String Firstname=request.getParameter("FirstName");
		String Lastname=request.getParameter("LastName");
		String Gurdianname=request.getParameter("GuardianName");
		String EmailId=request.getParameter("Email");
		String Mobile=request.getParameter("Contact");
		String Address=request.getParameter("Address");
		String Address2=request.getParameter("Address2");
		String city=request.getParameter("City");
		String district=request.getParameter("District");
		String state=request.getParameter("State");
		String country=request.getParameter("Country");
		String username=request.getParameter("user");
		String password=request.getParameter("Password");
		RequestDispatcher dispatcher=null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management","root","password");
			PreparedStatement pst= con.prepareStatement("insert into register(Firstname,Lastname,Gurdianname,EmailId,Mobile,Address,Address2,username,password,city,district,state,country)  values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, Firstname);
			pst.setString(2, Lastname);
			pst.setString(3, Gurdianname);
			pst.setString(4, EmailId);
			pst.setString(5, Mobile);
			pst.setString(6, Address);
			pst.setString(7, Address2);
			pst.setString(8, username);
			pst.setString(9, password);
			pst.setString(10, city);
			pst.setString(11, district);
			pst.setString(12, state);
			pst.setString(13, country);
			int row=pst.executeUpdate();
			if (row>0) {
	             dispatcher = request.getRequestDispatcher("index.jsp");
	         } else {
	             dispatcher = request.getRequestDispatcher("Registration.jsp");
	         }
			
			dispatcher.forward(request, response);
		}
			catch(Exception e) {
			e.printStackTrace();
		}
	}
}


