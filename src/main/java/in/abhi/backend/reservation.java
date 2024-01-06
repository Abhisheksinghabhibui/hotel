  package in.abhi.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.catalina.connector.Response;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reserveroom")
public class reservation extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		
		String myname = req.getParameter("name1");
		String mycontact = req.getParameter("contact1");
		int myroom= Integer.parseInt(req.getParameter("room1"));
		

		try {
			Class.forName("org.postgresql.Driver");
			Connection conn=JCON.getconn();
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO reservations(guest_name,room_number,contact_number) VALUES('" + myname + "', " + myroom + ", '" + mycontact + "')");

			int count = ps.executeUpdate();
			if (count<0) {
				resp.setContentType("text/html");
				out.print("<h3 style='color:red '>FAILED! ROOM NOT BOOKED</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
				rd.include(req, resp);
			}
			else {
				resp.setContentType("text/html");
				out.print("<h3 style='color:green '>ROOM BOOKED</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/reserve.jsp");
				rd.include(req, resp);
				
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
		
	}

	}


