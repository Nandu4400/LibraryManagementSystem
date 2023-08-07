package login;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user");
	     String password = request.getParameter("password");
	     HttpSession session = request.getSession();
	     RequestDispatcher dispatcher = null;
	     Connection con = null;
	     PrintWriter out=response.getWriter();
	     response.setContentType("text/javascript");

	     try {
	         Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management", "root", "password");
	         PreparedStatement pst = con.prepareStatement("select * from register where username = ? and password = ?");
	         pst.setString(1, username);
	         pst.setString(2, password);
	         ResultSet rs = pst.executeQuery();
	         if (rs.next()) {
	             session.setAttribute("username",username);	             
	             dispatcher = request.getRequestDispatcher("Home.jsp");
	         } else {
	        	 request.setAttribute("Status","Failed");
	             dispatcher = request.getRequestDispatcher("index.jsp");
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
