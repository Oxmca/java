Lab5
Index.html
<html>
<body>
<form action="validate" method="post">
<h2>setting session</h2>
enter your name:<input type="text"  name="user"/><br><br>
enter password:<input type="password"  name="pass"/><br><br>
<input type="submit" value="submit"/>
</form>
</body>
</html>
------- 
validate.java(servlet)

public class validate extends HttpServlet {

    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throwsServletException, IOException {
response.setContentType("text/html");
PrintWriter out=response.getWriter();
       String name=request.getParameter("user");
       String pass=request.getParameter("pass");

if(pass.equals("1234"))
       {
HttpSession session=request.getSession();
session.setAttribute("user",name);
response.sendRedirect("welcome");
       }
else
out.println("Invalid password");
    }
}
-------  
welcome.java(servlet)

importjava.io.IOException;
importjava.io.PrintWriter;
importjavax.servlet.ServletException;
importjavax.servlet.http.HttpServlet;
importjavax.servlet.http.HttpServletRequest;
importjavax.servlet.http.HttpServletResponse;
importjavax.servlet.http.HttpSession;


public class welcome extends HttpServlet {

    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throwsServletException, IOException {
PrintWriter out=response.getWriter();
HttpSession session=request.getSession();
        String user=(String)session.getAttribute("user");
out.println("hello   "+user);
    }
}
