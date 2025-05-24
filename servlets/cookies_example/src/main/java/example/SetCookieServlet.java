package example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SetCookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");

        Cookie first = new Cookie("first_name", firstName);
        Cookie last = new Cookie("last_name", lastName);

        first.setMaxAge(10); // 1 day
        last.setMaxAge(60);

        response.addCookie(first);
        response.addCookie(last);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Cookies Set Successfully!</h3>");
        out.println("<a href='index.html'>Go Back</a>");
    }
}
