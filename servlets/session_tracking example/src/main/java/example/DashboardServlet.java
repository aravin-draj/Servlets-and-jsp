package example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false); // Don't create new session if none exists
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (session != null && session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");
            out.println("<h2>Welcome to Dashboard, " + username + "!</h2>");
            out.println("<a href='logout'>Logout</a>");
        } else {
            out.println("<h3>Please login first!</h3>");
            out.println("<a href='index.html'>Login</a>");
        }
    }
}
