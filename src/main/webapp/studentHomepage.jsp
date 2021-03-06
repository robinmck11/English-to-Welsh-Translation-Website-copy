<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Student Homepage</title>
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
            response.sendRedirect("studentLogin.html");
        }
    %>
    <header>
        <ul class="topnav">
            <li><a href="StudentHomepageServlet" class="active">Student Homepage</a></li>
            <li><a href="StartTestServlet">Take Test</a></li>
            <li><a href="PastTestsServlet">View Past Tests</a></li>
            <li><a href="LogoutServlet">Logout</a></li>
        </ul>
    </header>

    <div>
        <div id="heading">
            <h2>Total Tests Taken: ${noTestsTaken}</h2>
            <h2>Average Test Score: ${averageScore}%</h2>
        </div>
    </div>
</body>
</html>
