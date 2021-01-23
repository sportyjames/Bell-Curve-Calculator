<%-- 
    Document   : index
    Created on : Mar 26, 2019, 11:09:04 AM
    Author     : wujiayu

    This is the index/login page. User need to enter username and password to use the program
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <!-- title of the web -->
        <title>welcome to curved grade system</title>
    </head>
    <body id="body0">
        
         
       
        
        <!-- class  -->     
        <div class = "column right"> 
        <form action = "inputGrade" method="POST">
            <p>
            User Name: <input type ="text" name="username2"/>
            Password:<input type="password" name="password2"/>
            </p>
        
            
            
        <input type="submit" class = "button" value="login"/>
        
        <a href="register.jsp">register</a>
        </div>
        
        <div id = "title">
        Curved Grade System     
        </div>
        
        </form>
        
        <!-- class  -->     
        <div class = "column left">
        <hr>    
        <h2 class = "subtitle2" >Introduction</h2>
        
        
        <p class = "color"> Regardless of any difference in the level of difficulty, real or perceived,
            the grading curve ensures a balanced distribution of academic results. 
            By using this system, students know how well they score by the letters A,B,C,D,F
            comparing to their classmates. This system will follow a perfect distribution of grade. 
            A = 7% of the class    B = 24% of the class    C = 38% of the class
            D = 24% of the class   F = 7% of the class
        </p>    
        <h2 class="subtitle2">Visualization</h2>
        </div>
 
        <!-- image  -->     
        <img class="mySlides" src="curve.png" >    
     
        
    </body>
</html>
