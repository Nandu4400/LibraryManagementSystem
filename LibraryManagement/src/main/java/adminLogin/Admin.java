package adminLogin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String userId = request.getParameter("user");
	     String password = request.getParameter("password"); 
	     HttpSession session = request.getSession();
	     RequestDispatcher dispatcher = null;
	     Connection con = null;

	     try {
	         Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management", "root", "password");
	         PreparedStatement pst = con.prepareStatement("select * from admin where userId = ? and password = ?");
	         pst.setString(1, userId);
	         pst.setString(2, password);
	         ResultSet rs = pst.executeQuery();
	         if (rs.next()) {
	             session.setAttribute("userId",userId);
	             dispatcher = request.getRequestDispatcher("Admin.jsp");
	         } else {
	             dispatcher = request.getRequestDispatcher("AdminLogin.jsp");
	         }

	         dispatcher.forward(request, response);
	     } catch (Exception e) {
	         e.printStackTrace();
	     } finally {
	         try {
	             if (con != null) {
	                 con.close();
	             }
	         } catch (SQLException e) {
	             e.printStackTrace();
	         }
	     }
	 }

}
