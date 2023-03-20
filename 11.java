Lab11
calcbean.java(in ejb)

packageSessionBean;

importjavax.ejb.Stateless;


@Stateless
public class calcbean implements calcbeanLocal {

    @Override
public Integer addition(int a, int b) {
return (a+b);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
public Integer subtraction(int a, int b) {
return (a-b);
    }

    @Override
public Integer multiplication(int a, int b) {
return (a*b);
    }

    @Override
public Integer division(int a, int b) {
return (a/b);
    }   
}
------ 
calcservlet.java(servlet)

importjava.io.IOException;
importjava.io.PrintWriter;
importjavax.ejb.EJB;
importjavax.servlet.ServletException;
importjavax.servlet.http.HttpServlet;
importjavax.servlet.http.HttpServletRequest;
importjavax.servlet.http.HttpServletResponse;


public class calcservlet extends HttpServlet {

    @EJB
Private calcbeanLocal calcbean;

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
throwsServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
out.println("<title>Servlet calcservlet</title>");            
out.println("</head>");
out.println("<body>");
int a=Integer.parseInt(request.getParameter("t1"));
int b=Integer.parseInt(request.getParameter("t2"));
            String f=request.getParameter("g");
int result=0;
if(f.equals("1"))
            {
result=calcbean.addition(a, b);
            }
else if(f.equals("2"))
            {
result=calcbean.subtraction(a, b);
            }
else if(f.equals("3"))
            {
result=calcbean.multiplication(a, b);
            }
else
            {
result=calcbean.division(a, b);
            }
out.println("<h1>result= "+result+"</h1>");
out.println("</body>");
out.println("</html>");
        }
    }
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throwsServletException, IOException {
processRequest(request, response);
    }
}
-------- 
calcjsp.jsp

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
<form action="calcservlet" method="post">
value1:<input type="text" name="t1"/>
value2:<input type="text" name="t2"/><br>
<input type="radio" name="g" value="1"/>Addition<br>
<input type="radio" name="g" value="2"/>Subtraction<br>
<input type="radio" name="g" value="3"/>Multiplication<br>
<input type="radio" name="g" value="4"/>Division<br>
<input type="submit" value="="/>
</form>
</body>
</html>
