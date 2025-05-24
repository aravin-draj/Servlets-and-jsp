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

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");

        // Start a session and store username
        HttpSession session = request.getSession();
        session.setAttribute("username", username);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Login Successful!</h3>");
        out.println("<a href='dashboard'>Go to Dashboard</a>");
    }
}
