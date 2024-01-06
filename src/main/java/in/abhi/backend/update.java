package in.abhi.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class update extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String newGuestName = req.getParameter("name1");
		String newContactNumber = req.getParameter("contact1");
		int newRoomNumber= Integer.parseInt(req.getParameter("room1"));
		
		int reservationId =Integer.parseInt(req.getParameter("resID"));
		String sql = "UPDATE reservations SET guest_name = '" + newGuestName + "', " +
                "room_number = " + newRoomNumber + ", " +
                "contact_number = '" + newContactNumber + "' " +
                "WHERE reservation_id = " + reservationId;
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn=JCON.getconn();
		try (Statement statement = conn.createStatement()) {
            int affectedRows = statement.executeUpdate(sql);

            if (affectedRows > 0) {
            	resp.setContentType("text/html");
                out.println("<h3 style='color:green '>UPDATED SUCCESSFULLY</h3>");
            } 
            else {
            	resp.setContentType("text/html");
                out.println("<h3 style='color:red '>FAILED</h3>");
            }
        }
     catch (SQLException e) {
        e.printStackTrace();
    }
	
	}
}