Lab6
index.html
<html>
<head><title>lab6</title></head>
<body>
<form action="login.jsp" method="post">
enter your name:<input type="text" name="uname"/><br><br>
enter password:<input type="password" name="passwrd"/><br><br>
<input type="submit" value="submit"/>
<input type="reset" value="clear"/>
</form>
</body>
</html>
---- 
login.jsp

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Login Page</title></head>
<body>
<% String pass=request.getParameter("passwrd");
if(pass.equals("admin123"))
                { %>
<jsp:forward page="welcome.jsp"/>
<% } else { %>
<h2> please re-enter username and password</h2>
<jsp:include page="index.html"/>
<% } %>
</body>
</html>
-------- 

welcome.jsp

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Welcome Page</title></head>
<body>
<h3>login successful</h3>
welcome, <%= request.getParameter("uname") %>
</body>
</html>
