<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Admin Homepage</title>
    <link href="../css/style.css" rel="stylesheet"/>
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
        response.sendRedirect("adminLogin.html");
    }
%>
    <header>
        <ul class="topnav">
            <li><a href="../index.html">Home</a></li>
            <li><a href="adminHomepage.jsp" class="active">Admin Homepage</a></li>
            <li><a href="../manageAccounts.jsp">Manage Accounts</a></li>
            <li><a href="../index.html">Logout</a></li>
        </ul>
    </header>

    <div id="slide1">
        <div id="heading">
            <h2>Total Number of Students: ${noStudents}</h2>
            <h2>Total Number of Instructors: ${noInstructors}</h2>
        </div>
    </div>
</body>
</html>
