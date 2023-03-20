Lab3
index.html

<html>
<body>
<form action="loginServ" method="get">
<h2>Using Get method</h2>
enter name:<input type="text"  name="uname"/><br><br>
<input type="submit" value="get()"/>
<input type="reset" value="clear"/>
</form>
<form action="loginServ" method="post">
<h2>Using Get method</h2>
enter name:<input type="text"  name="uname1"/><br><br>
<input type="submit" value="post()"/>
<input type="reset" value="clear"/>
</form>
</body>
</html>
---------
loginServ.java (Servlet)

importjava.io.IOException;
importjava.io.PrintWriter;
importjavax.servlet.ServletException;
importjavax.servlet.http.HttpServlet;
importjavax.servlet.http.HttpServletRequest;
importjavax.servlet.http.HttpServletResponse;

public class loginServ extends HttpServlet { 

    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throwsServletException, IOException {
response.setContentType("text/html");
PrintWriter out=response.getWriter();
        String uname=request.getParameter("uname");
out.println("<html><body>");
out.println("<h1>Details of Get()</h1>");
out.println("<p>you entered name:"+uname+"</p>");
out.println("</html></body>");
    }

    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throwsServletException, IOException {
response.setContentType("text/html");
PrintWriter out=response.getWriter();
        String uname1=request.getParameter("uname1");
out.println("<html><body>");
out.println("<h1>Details of Post()</h1>");
out.println("<p>you entered name:"+uname1+"</p>");
out.println("</html></body>");
    }
