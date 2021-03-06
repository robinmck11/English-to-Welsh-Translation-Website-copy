<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Manage Words</title>
    <link href="css/style.css" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,700" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script>window.onload=function(){$("#action").change(function(){switch(selection=$(this).val(),selection){case"add":$("#add").show(),$("#remove").hide(),$("#update").hide();break;case"remove":$("#add").hide(),$("#remove").show(),$("#update").hide();break;case"update":$("#add").hide(),$("#remove").hide(),$("#update").show();break;default:$("#add").hide(),$("#remove").hide(),$("#update").hide()}})};</script>
</head>
<body>
    <%
        String userName = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
        {
            for (Cookie cookie : cookies)
            {
                if (cookie.getName().equals("instructor"))
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
            <li><a href="InstructorHomepageServlet">Instructor Homepage</a></li>
            <li><a href="manageWords.jsp" class="active">Manage Words</a></li>
            <li><a href="instructorPastTests.jsp">View Grades</a></li>
            <li><a href="LogoutServlet">Logout</a></li>
        </ul>
    </header>
    <div>
        <div id="heading">
            <form action="ManageWordServlet" method="post">
                <select id="action">
                    <option>Choose Action</option>
                    <option value="add">Add Word</option>
                    <option value="remove">Delete Word</option>
                    <option value="update">Update Word</option>
                </select>

                <div id="add" style="display:none;">
                    <p><input type="text" name="welshNoun" placeholder="Welsh Noun"></p>
                    <p><input type="text" name="englishNoun" placeholder="English Noun"></p>
                    <p><input type="text" name="gender" placeholder="Gender [f/m]"></p>
                    <p style="text-align: center"><input type="submit" name="submit" value="Add"></p>
                </div>

                <div id="remove" style="display:none;">
                    <p><input type="text" name="welshNoun" placeholder="Welsh Noun"></p>
                    <p style="text-align: center"><input type="submit" name="submit" value="Remove"></p>
                </div>

                <div id="update" style="display:none;">
                    <p><input type="text" name="welshNounOriginal" placeholder="Welsh Noun Original"></p>
                    <p><input type="text" name="welshNounNew" placeholder="Welsh Noun New"></p>
                    <p><input type="text" name="englishNounOriginal" placeholder="English Noun Original"></p>
                    <p><input type="text" name="englishNounNew" placeholder="English Noun New"></p>
                    <p><input type="text" name="gender" placeholder="Gender [f/m]"></p>
                    <p style="text-align: center"><input type="submit" name="submit" value="Update"></p>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
