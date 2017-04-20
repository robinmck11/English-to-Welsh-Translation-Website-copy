<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Past Test</title>
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
            <li><a href="AdminHomepageServlet" class="active">Instructor Homepage</a></li>
            <li><a href="manageWords.jsp">Manage Words</a></li>
            <li><a href="PastTestsServlet" class="active">View Grades</a></li>
            <li><a href="LogoutServlet">Logout</a></li>
        </ul>
    </header>

    <div>
        <div id="heading">
            <form action="PastTestsServlet" method="get">
                <div id="chooseStudent" style="display:none;">
                    <p><input type="text" name="studentUsername" placeholder="Student Username"></p>
                    <p style="text-align: center"><input type="submit" name="submit" value="Get Grades"></p>
                </div>
            </form>
            <p id="resultsTable"></p>
        </div>
    </div>

    <script>
        var myArray = [<%
                String[][] array = (String[][])session.getAttribute("grades");
                if (array != null && array[0] != null)
                {
                    for (int i = 0; i < array.length; i++)
                    {%>[<%
                        for (int j = 0; j < array[0].length; j++)
                        {
                            %>"<%= array[i][j] %>", <%
                        }
                        %>], <%
                    }
                }
            %>];
        var myTable = "<table style='margin: 0px auto;'><tr><th>Grade</th><th>Date Achieved</th><th>Time Achieved</th></tr>";
        for (var i = 0; i < myArray.length; i++)
        {
            myTable += "<tr>";

            for (var j = 1; j < myArray[0].length; j++)
            {
                myTable += "<th>";
                myTable += myArray[i][j];
                myTable += "</th>";
            }

            myTable += "</tr>";
        }
        myTable += "</table>";

        document.getElementById("resultsTable").innerHTML = myTable;
    </script>
</body>
</html>
