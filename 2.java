Lab2
refreshPage.java(Servlet)

import java.io.IOException;
importjava.io.PrintWriter;
importjava.util.*;
importjavax.servlet.ServletException;
importjavax.servlet.http.HttpServlet;
importjavax.servlet.http.HttpServletRequest;
importjavax.servlet.http.HttpServletResponse;


public class refreshPage extends HttpServlet {
    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throwsServletException, IOException {
response.setContentType("text/html");
PrintWriter out=response.getWriter();

response.addHeader("Refresh", "3");

out.println("<h1>Auto Page Refresh using servlet</h1>");
out.println("<h2>Today's date and time</h2>"+new Date());

    }
}

