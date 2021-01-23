<%-- 
    Document   : inputGrade
    Created on : Apr 8, 2019, 11:46:14 AM
    Author     : wujiayu

    This page allows user to input information needed for the program.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <!-- title of the web -->
        <title>grade input</title>
    </head>
    
     <body id="body0">
        <form action = "rawGradeDisplay" method="POST">
            
        <!-- class -->
        <div class = "input2">
        <br>
        <div id="title3"> Enter the following information</div>
        <br>
        <br>
        <div class="subtitle3"> The information could be entered as many times as you want. Click the back button from the next page to enter again.
        </div>
        <br>
        <br>
        
        <div class = "center">
        <h2>Student's school ID number:  <input type="text" name="ID"> </h2>
        
            
        <h2>Grade for ID number: <input type="text" name="grade"> </h2>  
        
        <!-- button -->
        <input type="submit" class = "button2" value="Submit" >
        
        </div>
        
        
       
        
        </div>
        </form>
    </body>
</html>
