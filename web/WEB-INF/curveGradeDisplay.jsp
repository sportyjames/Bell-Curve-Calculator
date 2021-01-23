<%-- 
    Document   : curveGradeDisplay
    Created on : Apr 9, 2019, 11:20:24 AM
    Author     : wujiayu

     This page displays the curve grade of student.
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
        <title>Curve Grade Display</title>
    </head>
    <body id="body1">
        
        <!-- class -->
        <div class = "number">
        <div id = "title2">The number of students are:</div>
        <p class="info"> ${STUDENTNUM} </p> </div>
        <hr>
        
        <br>
        <br>
        
        <!-- class -->
        <div class = "rank">
        <div id = "title2">
        <p>This is the rank of students' ID based on the grade on students' ID. </p>
        <p>Rank starts with the highest grade and ends with the lowest grade.</p>
        </div>
        <br>
        <p class="info">
        ${ORDER} 
        </p>
        </div>
        
        <br>
      
        <!-- class -->
        <div class = "distribution">
            
        <div id = "title2">
        A students are from rank 1 to ${a2} 
        <br>
        B students are from rank ${b1} to ${b2}    
        <br>
        C students are from rank ${c1} to ${c2} 
        <br>
        D students are from rank ${d1} to ${d2} 
        <br>
        F students are from rank ${f1} to ${f2} 
        </div>
        
        <br>
        <a href="index.jsp">Home</a> 
         
    </body>
</html>
