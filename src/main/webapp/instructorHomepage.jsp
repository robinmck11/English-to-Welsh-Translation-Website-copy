<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Admin Homepage</title>
    <link href="css/style.css" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,700" rel="stylesheet">
</head>
<body>
    <header>
        <ul class="topnav">
            <li><a href="index.html">Home</a></li>
            <li><a href="instructorHomepage.jsp" class="active">Instructor Homepage</a></li>
            <li><a href="manageWords.jsp">Manage Words</a></li>
            <li><a href="LogoutServlet">Logout</a></li>
        </ul>
    </header>

    <div id="slide1">
        <div id="heading">
            <h2>Total Number of Words: ${noWords}</h2>
        </div>
    </div>
</body>
</html>
