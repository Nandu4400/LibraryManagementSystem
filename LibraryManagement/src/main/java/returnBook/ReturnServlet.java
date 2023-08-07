package returnBook;

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

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;

/**
 * Servlet implementation class ReturnServlet
 */
@WebServlet("/Return")
public class ReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String BookName=request.getParameter("BookName");
		String LendDate=request.getParameter("LendDate");
		String ReturnDate=request.getParameter("ReturnDate");
		HttpSession session = request.getSession();
	     RequestDispatcher dispatcher = null;
	     Connection con = null;

	     try {
	         Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management", "root", "password");
	         PreparedStatement pst=con.prepareStatement("select * from lendreturnbook where BookName = ? and LendDate = ?");
	         pst.setString(1, BookName);
	         pst.setString(2, LendDate);
	         ResultSet rs=pst.executeQuery();
	         System.out.println(pst);
				if (rs.next()) {
					 session.setAttribute("ReturnDate",ReturnDate);
					 pst = con.prepareStatement("update lendreturnbook set ReturnDate =? where LendDate = ? ");
			         pst.setString(1, ReturnDate);
			         pst.setString(2, LendDate);
			         pst.executeUpdate();
		             dispatcher = request.getRequestDispatcher("Home.jsp");
			         }
		          else {
		        	  System.out.println("Not working");
		             dispatcher = request.getRequestDispatcher("ReturnBook.jsp");
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
