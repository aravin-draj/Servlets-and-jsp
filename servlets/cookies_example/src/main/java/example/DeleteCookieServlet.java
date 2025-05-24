package example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteCookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h3>Deleting Cookies</h3>");
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                out.println("Deleted: " + cookie.getName() + "<br>");
            }
        } else {
            out.println("No cookies to delete.");
        }
        out.println("<br><a href='index.html'>Go Back</a>");
    }
}
