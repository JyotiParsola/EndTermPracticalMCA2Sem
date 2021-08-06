Create table userlist(name varchar2(25), pass varchar2(25));
   

Index.html

<!doctype html>
<html lang="en">
     <head>
          <title>Document</title>
     </head>
     <body>
          <form action="servlet1" method="post">
               <fieldset style="width:20%; background-color:#ccffcc">
                    <h2 align="center">Login Page</h2>
                    <hr>
                    <table>
                    <tr><td>Name</td><td><input type="text" name="username"/></td>
                    <tr><td>Password</td><td><input type="password" name="userpass"/></td></tr>
                    <tr><td></td><td><input type="submit" value="login"/></td></tr>
                    </table>
               </fieldset>
          </form>  
     </body>
</html>


FirstServlet.java

import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
public class FirstServlet extends HttpServlet
{
     public void doPost(HttpServletRequest request, HttpServletResponse response)  
     throws ServletException, IOException
     {  
          response.setContentType("text/html");  
          PrintWriter out = response.getWriter();  
          
          String n=request.getParameter("username");  
          String p=request.getParameter("userpass");  
          if(LoginDao.validate(n, p))
          {  
               RequestDispatcher rd=request.getRequestDispatcher("servlet2");  
               rd.forward(request,response);  
          }  
          else
          {  
               out.print("Sorry username or password error");  
               RequestDispatcher rd=request.getRequestDispatcher("index.html");  
               rd.include(request,response);  
          }  
          out.close();  
     }  
}


LoginDao.java


import java.sql.*;  
public class LoginDao
{  
     public static boolean validate(String name,String pass)
     {  
          boolean status=false;
          try
          {  
               Class.forName("oracle.jdbc.driver.OracleDriver");  
               Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","local","test");  
      
               PreparedStatement ps=con.prepareStatement(  
               "select * from userreg where name=? and pass=?");  
               ps.setString(1,name);  
               ps.setString(2,pass);  
               ResultSet rs=ps.executeQuery();  
               status=rs.next();  
          }
          catch(Exception e)
          {
               System.out.println(e);
          }  
          return status;  
     }  
}


WelcomeServlet.java


import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
public class WelcomeServlet extends HttpServlet
{  
     public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
     {    
          response.setContentType("text/html");  
          PrintWriter out = response.getWriter();  
          String n=request.getParameter("username");  
          out.print("Welcome "+n);  
          out.close();  
     }  
}


web.xml

<web-app>
  <servlet>
    <servlet-name>FirstServlet</servlet-name>
    <servlet-class>FirstServlet</servlet-class>
  </servlet>
  <servlet>
    <servlet-name>WelcomeServlet</servlet-name>
    <servlet-class>WelcomeServlet</servlet-class>
  </servlet>

  <servlet-mapping>
    <servlet-name>FirstServlet</servlet-name>
    <url-pattern>/servlet1</url-pattern>
  </servlet-mapping>
  <servlet-mapping>
    <servlet-name>WelcomeServlet</servlet-name>
    <url-pattern>/servlet2</url-pattern>
  </servlet-mapping>

  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
  </welcome-file-list>
  
</web-app>
        
        
