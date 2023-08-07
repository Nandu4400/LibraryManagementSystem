package home;

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
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String BookName = request.getParameter("search"); 
	     HttpSession session = request.getSession();
	     RequestDispatcher dispatcher = null;
	     Connection con = null;

	     try {
	         Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management", "root", "password");
	         PreparedStatement pst = con.prepareStatement("select * from books where BookName = ?");
	         pst.setString(1, BookName);
	         ResultSet rs = pst.executeQuery();
	         if (rs.next()) {
	             session.setAttribute("search",BookName);
	             dispatcher = request.getRequestDispatcher("LendBook.jsp");
	         } else {
	             dispatcher = request.getRequestDispatcher("Home.jsp");
	             PrintWriter out=response.getWriter();
	        	 out.println("<script>alert('Book Not Found');window.location.href='Home.jsp';<script> ");
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
