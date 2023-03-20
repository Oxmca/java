servlet.java(servlet)

importbm.Student;
importbm.StudentFacadeLocal;
importjava.io.IOException;
importjava.io.PrintWriter;
importjava.util.List;
importjavax.ejb.EJB;
importjavax.servlet.ServletException;
importjavax.servlet.annotation.WebServlet;
importjavax.servlet.http.HttpServlet;
importjavax.servlet.http.HttpServletRequest;
importjavax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/servlet"})
public class servlet extends HttpServlet {

    @EJB
privateStudentFacadeLocalstudentFacade;


protected void processRequest(HttpServletRequest request, HttpServletResponse response)
throwsServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
out.println("<title>Servlet servlet</title>");            
out.println("</head>");
out.println("<body>");
out.println("<h1>Servlet servlet at " + request.getContextPath() + "</h1>");
            List<Student>info=(List<Student>)studentFacade.findAll();
out.println("<h3>the data in student table</h3><hr/><table style='border:solid';>");
out.println("<tr><th>sid</th><th>sname<th></tr>");
for(inti=0;i<studentFacade.count();i++)
            {
out.println("<tr><td>"+info.get(i).getSid()+"</td>");
out.println("<tr><td>"+info.get(i).getSname()+"</td>");
            }
out.println("</table>");
out.println("</body>");
out.println("</html>");
        }
    }


    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throwsServletException, IOException {
processRequest(request, response);
    }


    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throwsServletException, IOException {
processRequest(request, response);
    }
}
------- 
j.jsp 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<form action="servlet">
<input type="submit" value="send">
</form>
</body>
</html>
