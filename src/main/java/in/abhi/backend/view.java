package in.abhi.backend;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/view")
public class view extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		

		try {
			Class.forName("org.postgresql.Driver");
			Connection conn=JCON.getconn();
			String sql = "SELECT reservation_id, guest_name, room_number, contact_number, reservation_date FROM reservations";
			try (Statement statement = conn.createStatement();
	                 ResultSet resultSet = statement.executeQuery(sql)) {
	    
	                out.println("Current Reservations:");
	                out.println("+----------------+-----------------+---------------+----------------------+-------------------------+");
	                out.println("| Reservation ID | Guest           | Room Number   | Contact Number      | Reservation Date        |");
	                out.println("+----------------+-----------------+---------------+----------------------+-------------------------+");
	    
	                while (resultSet.next()) {
	                    int reservationId = resultSet.getInt("reservation_id");
	                    String guestName = resultSet.getString("guest_name");
	                    int roomNumber = resultSet.getInt("room_number");
	                    String contactNumber = resultSet.getString("contact_number");
	                    String reservationDate = resultSet.getTimestamp("reservation_date").toString();
	    
	                    // Format and display the reservation data in a table-like format
	                    out.printf("| %-14d | %-15s | %-13d | %-20s | %-19s   |\n",
	                            reservationId, guestName, roomNumber, contactNumber, reservationDate);
	                }
	    
	                out.println("+----------------+-----------------+---------------+----------------------+-------------------------+");
	            }
	
		}catch (Exception e) {
			out.println(e.getMessage());
		}
	}
}
