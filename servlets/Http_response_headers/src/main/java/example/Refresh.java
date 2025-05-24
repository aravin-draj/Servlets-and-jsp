package example;
import java.util.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Refresh")
public class Refresh extends HttpServlet {

	   public void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {

	      // Set the Refresh header to 5 seconds
	      response.setIntHeader("Refresh", 5);  

	      // Set the MIME type of the response
	      response.setContentType("text/html"); 

	      // Get current time
	      Calendar calendar = new GregorianCalendar();
	      int hour = calendar.get(Calendar.HOUR);
	      int minute = calendar.get(Calendar.MINUTE);
	      int second = calendar.get(Calendar.SECOND);
	      String am_pm = (calendar.get(Calendar.AM_PM) == 0) ? "AM" : "PM";

	      String currentTime = hour + ":" + minute + ":" + second + " " + am_pm;

	      // Output the response HTML
	      PrintWriter out = response.getWriter();
	      out.println("<html><head><title>Auto Refresh Header Setting</title></head>");
	      out.println("<body bgcolor='#f0f0f0'><h1 align='center'>Auto Refresh Header Setting</h1>");
	      out.println("<p>Current Time is: " + currentTime + "</p></body></html>");
	   }

	   public void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	      doGet(request, response); // Handle POST same as GET
	   }
	}
