Index.html
<html>
<body>
<form action="validate" method="post">
<h2>setting cookie</h2>
enter your name:<input type="text"  name="user"/><br><br>
enter password:<input type="password"  name="pass"/><br><br>
<input type="submit" value="submit"/>
</form>
</body>
</html>
------
validate.java(servlet)

importjava.io.IOException;
importjava.io.PrintWriter;
importjavax.servlet.ServletException;
importjavax.servlet.http.Cookie;
importjavax.servlet.http.HttpServlet;
importjavax.servlet.http.HttpServletRequest;
importjavax.servlet.http.HttpServletResponse;


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
          Cookie ck=new Cookie("username",name);
response.addCookie(ck);

response.sendRedirect("first");
       }
else
out.println("Invalid password");
    }
}
----------- 
first.java(servlet)

importjava.io.IOException;
importjava.io.PrintWriter;
importjavax.servlet.ServletException;
importjavax.servlet.http.Cookie;
importjavax.servlet.http.HttpServlet;
importjavax.servlet.http.HttpServletRequest;
importjavax.servlet.http.HttpServletResponse;


public class first extends HttpServlet {

    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throwsServletException, IOException {
PrintWriter out=response.getWriter();
       //read cookie
Cookie[] cks=request.getCookies();
out.println("welcome   "+cks[0].getValue());
    }
}
