Processbean.java
package com;
importjava.util.logging.Level;
importjava.util.logging.Logger;
importjavax.ejb.ActivationConfigProperty;
importjavax.ejb.MessageDriven;
importjavax.jms.JMSException;
importjavax.jms.Message;
importjavax.jms.MessageListener;
importjavax.jms.TextMessage;
@MessageDriven(mappedName = "jms/testq", activationConfig =  {
@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
    })
public class processbean implements MessageListener {
publicprocessbean() {
    }
@Override
public void onMessage(Message message) {
TextMessage t=null;
        t=(TextMessage)message;
try{
System.out.println(t.getText());

        }
catch(JMSException e)
{
Logger.getLogger(processbean.class.getName()).log(Level.SEVERE, null, e);
           }
}
}

Index.jsp
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
<form action="callmdb" >
sendmsg: <input type="text" name="msg"><br>
<input type="submit" value="send">

</form>
</body>
</html>

Callmdb
package com;

importjava.io.IOException;
importjava.io.PrintWriter;
importjava.util.logging.Level;
importjava.util.logging.Logger;
importjavax.annotation.Resource;
importjavax.jms.Connection;
importjavax.jms.ConnectionFactory;
importjavax.jms.JMSException;
importjavax.jms.Message;
importjavax.jms.MessageProducer;
importjavax.jms.Queue;
importjavax.jms.Session;
importjavax.jms.TextMessage;
importjavax.servlet.ServletException;
importjavax.servlet.annotation.WebServlet;
importjavax.servlet.http.HttpServlet;
importjavax.servlet.http.HttpServletRequest;
importjavax.servlet.http.HttpServletResponse;

@WebServlet(name="callmdb", urlPatterns={"/callmdb"})
public class callmdb extends HttpServlet {
@Resource(name = "jms/testq")
private Queue testq;
@Resource(name = "jms/testqueue")
privateConnectionFactorytestqueue;

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
throwsServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();
try {

this.sendJMSMessageToTestq(request);
        }
catch(Exception e){ }
finally {
out.close();
        }
    }
private Message createJMSMessageForjmsTestq(Session session, Object messageData) throws JMSException {
TextMessage tm = session.createTextMessage();
HttpServletRequestrq=(HttpServletRequest)messageData;
tm.setText(rq.getParameter("msg"));
return tm;
    }

private void sendJMSMessageToTestq(Object messageData) throws JMSException {
        Connection connection = null;
        Session session = null;
try {
connection = testqueue.createConnection();
session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
MessageProducermessageProducer = session.createProducer(testq);
messageProducer.send(createJMSMessageForjmsTestq(session, messageData));
        } finally {
if (session != null) {
try {
session.close();
                } catch (JMSException e) {
Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot close session", e);
                }	
            }
if (connection != null) {
connection.close();
            }
        }
    }
}
