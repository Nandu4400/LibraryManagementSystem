package lendBook;

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
 * Servlet implementation class LendBook
 */
@WebServlet("/LendBook")
public class LendBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String username = request.getParameter("user");
	     String BookName = request.getParameter("BookName");
	     String LendDate = request.getParameter("LendDate");
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
					 session.setAttribute("BookName",BookName);
					 pst = con.prepareStatement("insert into lendreturnbook(BookName,UserName,LendDate) values(?,?,?);");
			         pst.setString(1, BookName);
			         pst.setString(2, username);
			         pst.setString(3, LendDate);
			         pst.executeUpdate();
		             dispatcher = request.getRequestDispatcher("Home.jsp");
		         } else {
		             dispatcher = request.getRequestDispatcher("LendBook.jsp");
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
