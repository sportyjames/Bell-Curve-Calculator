<%-- 
    Document   : login
    Created on : Mar 26, 2019, 11:09:04 AM
    Author     : wujiayu

    This page enables user to register an account in case the user does not have an existing account
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <!-- title of the web -->
        <title>register Account</title>
    </head>
    <body id="body0">
        
        <!-- class -->
        <br><br><br><br><br><br>
        
        <img class="mySlides2" src="user2.png" >    
        <div class = "input">
        <h1 id = "title3">User Register</h1>
        <br>
        <div class = "number">
        <form action = "registerSuccess" method="post">
            <p class = "input2">
              Username: <input type ="text" name="username1" placeholder="Your name.."/><br/><br/>
              Password:     <input type="password" name="password1" placeholder="Your password.."/><br/><br/>
            </p>
        <input type="submit" class = "button" value="Register" />
        </form>
        
        </div>
    </body>
</html>
