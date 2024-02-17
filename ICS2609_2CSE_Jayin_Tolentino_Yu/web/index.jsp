<%-- 
Document   : index
Created on : Feb 17, 2024, 10:42:59 AM
Author     : Granbell
--%>


<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  session = request.getSession(false);
    session.removeAttribute("user");
    session.invalidate();
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="cache-control" content="no-cache">
        <link rel="stylesheet" href="styles.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
    </head>

    <body>
        <div class="body">
            <header class="header">
                <div class="content">
                    <h3>Subject: <% out.print(getServletContext().getInitParameter("Subject")); %></h3>
                    <h3>Section: <% out.print(getServletContext().getInitParameter("Section")); %></h3>
                    <h3>Name: <% out.print(getServletContext().getInitParameter("Name")); %></h3>
                </div>
            </header>

        <div class="container">
            <div class="wrapper">
                <div class="title"><span>Login Form</span></div>
                <form action="ServletniLogin" method="post">
                    <div class="row">
                        <i class="fas fa-user"></i>
                        <input name= "username" id="username" type="text" placeholder="Username" required>
                    </div>
                    <div class="row">
                        <i class="fas fa-lock"></i>
                        <input name="password" id="password" type="password" placeholder="Password" required>
                    </div>
                    <div class="row button">
                        <input type="submit" value="Login">
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="footer">

        <div class="content">
            <h3><% out.print(getServletContext().getInitParameter("ProjectName")); %></h3>
            <h3>Section: <% out.print(getServletContext().getInitParameter("Section")); %></h3>
            <h3>Name: <% out.print(getServletContext().getInitParameter("Name"));%></h3>
        </div>

    </div>
</div>
</body>
</html>