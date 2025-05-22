package welcome;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Using getParameter() for single-value fields
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String country = request.getParameter("country");

        // Using getParameterValues() for multi-value field (checkbox)
        String[] subjects = request.getParameterValues("subject");

        out.println("<h2>Registration Details</h2>");
        out.println("Name: " + name + "<br>");
        out.println("Email: " + email + "<br>");
        out.println("Gender: " + gender + "<br>");
        out.println("Country: " + country + "<br>");

        out.println("Subjects: ");
        if (subjects != null) {
            for (String subject : subjects) {
                out.print(subject + " ");
            }
        } else {
            out.print("None");
        }

        // Using getParameterNames() to list all form fields submitted
        out.println("<hr><h3>All Submitted Form Data:</h3>");
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String param = paramNames.nextElement();
            String[] values = request.getParameterValues(param);
            out.println("<b>" + param + "</b>: ");
            for (String value : values) {
                out.print(value + " ");
            }
            out.println("<br>");
        }

        out.close();
    }
}
