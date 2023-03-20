Lab7
lab7.jsp
<html>
<body>
<jsp:plugin type="applet" code="myapplet.class" width="400" height="400">
<jsp:fallback>unable to load applet</jsp:fallback>
</jsp:plugin>
</body>
</html>
-------- 
myapplet.java(normal java)

import java.awt.*;
importjava.applet.*;

public class myapplet extends Applet{
public void init(){
setBackground(Color.red);
        }
    @Override
public void paint(Graphics g){
g.drawString("welcome to jsp applet", 100, 100);
}
}
