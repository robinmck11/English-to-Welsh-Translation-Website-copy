<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Admin Homepage</title>
    <link href="css/style.css" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,700" rel="stylesheet">
</head>
<body>
<%
    String userName = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null)
    {
        for (Cookie cookie : cookies)
        {
            if (cookie.getName().equals("user"))
            {
                userName = cookie.getValue();
            }
        }
    }
    if (userName == null)
    {
        response.sendRedirect("instructorLogin.html");
    }
%>
    <header>
        <ul class="topnav">
            <li><a href="InstructorHomepageServlet" class="active">Instructor Homepage</a></li>
            <li><a href="manageWords.jsp">Manage Words</a></li>
            <li><a href="instructorPastTests.jsp">View Grades</a></li>
            <li><a href="LogoutServlet">Logout</a></li>
        </ul>
    </header>

    <div>
        <div id="heading">
            <h2>Total Number of Words: ${noWords}</h2>
        </div>
    </div>
</body>
</html>
