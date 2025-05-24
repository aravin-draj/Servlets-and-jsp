package example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ReadCookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h3>Reading Cookies</h3>");
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                out.println("Name: " + cookie.getName() + ", Value: " + cookie.getValue() + "<br>");
            }
        } else {
            out.println("No cookies found.");
        }
        out.println("<br><a href='index.html'>Go Back</a>");
    }
}
