1.Write a JAVA Servlet Program to implement a dynamic HTML using Servlet (user name and Password
should be accepted using HTML and displayed using a Servlet).
lab1
index.html

<html>
<head>
<title>servlet</title>
</head>
<body>
<form action="loginServlet" method="get">
enter your name:<input type="text"  name="username"/><br><br>
enter password:<input type="password"  name="pass"/><br><br>
<input type="submit" value="send"/>
<input type="reset" value="clear"/>
</form>
</body>
</html>


loginServlet.java(Servlet)




importjava.io.IOException;
importjava.io.PrintWriter;
importjavax.servlet.ServletException;
importjavax.servlet.http.HttpServlet;
importjavax.servlet.http.HttpServletRequest;
importjavax.servlet.http.HttpServletResponse;

public class loginServlet extends HttpServlet {

    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throwsServletException, IOException {

response.setContentType("text/html");
PrintWriter out=response.getWriter();
        String name=request.getParameter("username");
        String passwrd=request.getParameter("pass");
if(name.equals("toce")&&(passwrd.equals("oxford")))
         {
out.println("<html><body>");
out.println("<h2>welcome,you have entered</h2>");
out.println("<p>username:"+name+"</p>");
out.println("<p>password:"+passwrd+"</p>");
out.println("</html></body>");
         }
else
out.println("Invalid username and password");
    }
}
