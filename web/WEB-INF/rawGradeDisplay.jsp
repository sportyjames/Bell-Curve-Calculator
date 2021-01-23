<%-- 
    Document   : rawGradeDisplay
    Created on : Apr 9, 2019, 10:28:08 AM
    Author     : wujiayu

    This page displays the raw grade of student.
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.io.*,java.util.*,java.sql.*"%>
<%@page import = "javax.servlet.http.*,javax.servlet.*"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri= "http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <!-- title of the web -->
        <title>Raw Grade Display</title>
    </head>
    <body id="body1">
        
        
        <div class = "input">
         <h1 class ="number"> RawGrade Info:</h1>
         
         <!-- table -->
          <table border = "3" width = "50%" align="center">
              <tr>

                       <th>StudentID</th>
                       <th>RawGrade</th>
              </tr>
              <c:forEach var="row" items="${dbData}">
                       <tr>
                           <td><c:out value="${row.get(0)}"/></td>
                           <td><c:out value="${row.get(1)}"/></td>
                       </tr>
                   </c:forEach>
          </table>
         
         <br>
         
         <div class="center2">
         <form action = "inputGrade2" method="POST">
             <input type="submit" class = "button" value="Back" >
         </form>
         
         
         <form action = "curveGradeDisplay" method="POST">
             <input type="submit" class = "button" value="Check Curved Grade" >
         </form>
             
             
         
         
       
         
         
         </div>
    </body> 
</html>
