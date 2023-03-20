Lab9
index.jsp
<%@page contentType="text/html" pageEncoding="UTF-8" autoFlush="false" buffer="8kb" errorPage="error.jsp" import="java.util.Date" info="homepage jsp" isELIgnored="true" language="java" isThreadSafe="true" session="true" %>
<!DOCTYPE html>
<html>
<body>
<p>todays date:</p>
<%= new java.util.Date()%>
<form action="login.jsp" method="post">
enter your username:<input type="text" name="uname"/>
enter password:<input type="password" name="pass"/>
<input type="submit" name="login.jsp"/>
<input type="reset" name="clear"/>
</form>
</body>
</html>
----- 
login.jsp
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<body>
<% String user=request.getParameter("uname");
          String pass=request.getParameter("pass");
if(user.equals("")||pass.equals("")){
throw new ServletException("parameter passing is mandatory");
   }%>
Hi  <%=user%>
</body>
</html>
------- 
error.jsp
<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<body>
<h2>sorry an exception occurred!</h2>
exception is:   <%=exception%>
</body>
</html>
