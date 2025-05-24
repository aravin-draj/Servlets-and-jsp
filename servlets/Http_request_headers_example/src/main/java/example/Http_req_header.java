package example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Http_req_header extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      out.println("<html><head><title>HTTP Header Request Example</title></head>");
      out.println("<body><h1 align='center'>HTTP Header Request Example</h1>");
      out.println("<table border='1' align='center'><tr><th>Header Name</th><th>Value</th></tr>");

      Enumeration<String> headerNames = request.getHeaderNames();
      while (headerNames.hasMoreElements()) {
         String headerName = headerNames.nextElement();
         String headerValue = request.getHeader(headerName);
         out.println("<tr><td>" + headerName + "</td><td>" + headerValue + "</td></tr>");
      }

      out.println("</table></body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      doGet(request, response);
   }
}
