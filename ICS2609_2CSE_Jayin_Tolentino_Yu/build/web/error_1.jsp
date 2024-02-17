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
        <link rel="stylesheet" href="ErrorJSPstyles/error_1.css">
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

            <div id="error-prompt-container">
                <div class="error-prompt">
                    <h1>Oh no! Inputted username is not valid, try again.</h1>
                    <p>Go back to the <a class="error-login" href="index.jsp">Login Page</a> here:</p>
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

    </body>
</html>
