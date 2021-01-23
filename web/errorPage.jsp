<%-- 
    Document   : errorPage
    Created on : Apr 8, 2019, 1:24:15 PM
    Author     : wujiayu
    This JSP Page is error page. It displays whenever there is an error in calculation
--%>

<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style2.css">
        <!-- title of the web -->
        <title>input fail</title>
    </head>
    <body id="body3">
        
        <!-- class -->
        <div class = "fail">INPUT FAILED</div>
        
        <div class = "message">
        <p> 
            THE INPUT VALUE TYPE CAN ONLY BE INTEGERS
        </p>
        <p> PLEASE TRY AGAIN
        </p>
        
        
        
        </div>
        
        <form action = "inputGrade2" method="POST">
             <input type="submit" class="back" value="Back" >
        </form>
        </div>
        
        
    </body>
</html>
