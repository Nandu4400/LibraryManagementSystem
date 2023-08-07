package admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Adminwork
 */
@WebServlet("/adminwork")
public class Adminwork extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uniqueId = request.getParameter("unique");
        String BookName = request.getParameter("bookName");
        String PublishDate = request.getParameter("publishDate");
        String AddDate = request.getParameter("BookAddDate");
        String BookId = request.getParameter("bookId");
        String button = request.getParameter("action");
        RequestDispatcher dispatcher = null;
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management", "root", "password");
            if ("Add book".equalsIgnoreCase(button)) {
                PreparedStatement pst = con.prepareStatement("insert into books(BookUniqueId,BookId,BookName,publicationDate,BookAddedDatel) values(?,?,?,?,?)"); // Corrected the column name
                pst.setString(1, uniqueId);
                pst.setString(2, BookId);
                pst.setString(3, BookName);
                pst.setString(4, PublishDate);
                pst.setString(5, AddDate);
                int row = pst.executeUpdate();
                System.out.println(pst);
                if (row > 0) {
                    dispatcher = request.getRequestDispatcher("Admin.jsp");
                }
                dispatcher.forward(request, response);
            } else if ("Remove book".equalsIgnoreCase(button)) {
                PreparedStatement pst = con.prepareStatement("delete from books where BookUniqueId = ?"); // Corrected the column name
                pst.setString(1, uniqueId);
                int row = pst.executeUpdate();
                System.out.println(pst);
                if (row > 0) {
                    dispatcher = request.getRequestDispatcher("Home.jsp");
                } 
                dispatcher.forward(request, response);
            }
            
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
