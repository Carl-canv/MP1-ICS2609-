<%-- 
    Document   : success
    Created on : Feb 17, 2024, 11:18:59 AM
    Author     : Granbell
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.*"%>
<% String seshuser = (String) session.getAttribute("user");
    response.setHeader("Cache-Control", "private, no-store, no-cache,must-revalidate");
    response.setHeader("Pragma", "no-cache");
    if (seshuser == null) {
        response.sendError(403);
    } else {
%>

<!DOCTYPE html>
<head>
    <meta http-equiv="cache-control" content="no-cache">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Character Counting</title>
    <link rel="stylesheet" href="styles.css">
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
    </ul>

    <div class="container">
        <div class="wrapper">
            <div class="title"><span>Welcome!</span></div>
            <form action="ServletniLogout" method="post">
                <div class="row">
                    <h3>Hello! <% out.print((String) session.getAttribute("user")); %>, Your role is:
                        <% out.print((String) session.getAttribute("role"));%></h3>
                </div>
                <div class="row button">
                    <input type="submit" value="Logout">
                </div>
            </form>
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
<% }%>