<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Student Homepage</title>
    <link href="../css/style.css" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,700" rel="stylesheet">
</head>
<body>
    <header>
        <ul class="topnav">
            <li><a href="../index.html">Home</a></li>
            <li><a href="studentHomepage.jsp" class="active">Student Homepage</a></li>
            <li><a href="../test.jsp">Take Test</a></li>
            <li><a href="../pastTests.jsp">View Past Tests</a></li>
            <li><a href="../index.html">Logout</a></li>
        </ul>
    </header>

    <div id="slide1">
        <div id="heading">
            <h2>Total Tests Taken: ${noTestsTaken}</h2>
            <h2>Average Test Score: ${averageScore}</h2>
        </div>
    </div>
</body>
</html>
