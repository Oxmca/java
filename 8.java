Lab8
student.html
<html>
<body>
<form action="student.jsp">
<center>
<h2>student details</h2>
<b>enter usn:</b><input type="text" name="usn"/><br><br>
<b>enter name:</b><input type="text" name="name"/><br><br>
<b>enter marks:</b><input type="text" name="marks"/><br><br>
<input type="submit" value="submit"/>
</center>
</form>
</body>
</html>
------ 
StudentBean.java(create folder in source package with name coreservlets then in that folder this java file)
packagecoreservlets;

public class StudentBean {
private String name;
private String usn;
privateint marks;

public void setUsn(String usn)
    {
this.usn=usn;
    }
public String getUsn()
    {
returnusn;
    }
public void setName(String name)
    {
        this.name=name;
    }
public String getName()
    {
return name;
    }
public void setMarks(int marks)
    {
this.marks=marks;
    }
publicintgetMarks()
    {
return marks;
    }
}
----- 
student.jsp
<html>
<body>
<center>
<h2>student information</h2>
<jsp:useBean id="st" class="coreservlets.StudentBean"/>
<jsp:setProperty name="st" property="*"/>
studentusn:<jsp:getProperty name="st" property="usn"/><br><br>
student name:<jsp:getProperty name="st" property="name"/><br><br>
student marks:<jsp:getProperty name="st" property="marks"/><br><br>
</center>
</body>
</html>
