<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Manage Words</title>
    <link href="css/style.css" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,700" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script>window.onload=function(){$("#action").change(function(){switch(selection=$(this).val(),selection){case"addStudent":$("#addStudent").show(),$("#removeStudent").hide(),$("#addInstructor").hide(),$("#removeInstructor").hide();break;case"removeStudent":$("#addStudent").hide(),$("#removeStudent").show(),$("#addInstructor").hide(),$("#removeInstructor").hide();break;case"addInstructor":$("#addStudent").hide(),$("#removeStudent").hide(),$("#addInstructor").show(),$("#removeInstructor").hide();break;case"removeInstructor":$("#addStudent").hide(),$("#removeStudent").hide(),$("#addInstructor").hide(),$("#removeInstructor").show();break;default:$("#addStudent").hide(),$("#removeStudent").hide(),$("#addInstructor").hide(),$("#removeInstructor").hide()}})};</script>
</head>
<body>
<%
    String userName = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null)
    {
        for (Cookie cookie : cookies)
        {
            if (cookie.getName().equals("admin"))
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
            <li><a href="AdminHomepageServlet">Admin Homepage</a></li>
            <li><a href="manageAccounts.jsp" class="active">Manage Accounts</a></li>
            <li><a href="adminPastTests.jsp">View Grades</a></li>
            <li><a href="LogoutServlet">Logout</a></li>
        </ul>
    </header>
    <div>
        <div id="heading">
            <form action="ManageAccountServlet" method="post">
                <select id="action">
                    <option>Choose Action</option>
                    <option value="addStudent">Add Student</option>
                    <option value="removeStudent">Remove Student</option>
                    <option value="addInstructor">Add Instructor</option>
                    <option value="removeInstructor">Remove Instructor</option>
                </select>

                <div id="addStudent" style="display:none;">
                    <p><input type="text" name="studentUsername" placeholder="Username"></p>
                    <p><input type="password" name="studentPassword" placeholder="Password" data-validation="strength" data-validation-strength="3"><br></p>
                    <p style="text-align: center"><input type="submit" name="submit" value="Add Student"></p>
                </div>

                <div id="removeStudent" style="display:none;">
                    <p><input type="text" name="studentUsername" placeholder="Student Username"></p>
                    <p style="text-align: center"><input type="submit" name="submit" value="Remove Student"></p>
                </div>

                <div id="addInstructor" style="display:none;">
                    <p><input type="text" name="instructorUsername" placeholder="Username"></p>
                    <p><input type="password" name="instructorPassword" placeholder="Password" data-validation="strength" data-validation-strength="3"><br></p>
                    <p style="text-align: center"><input type="submit" name="submit" value="Add Instructor"></p>
                </div>

                <div id="removeInstructor" style="display:none;">
                    <p><input type="text" name="instructorUsername" placeholder="Instructor Username"></p>
                    <p style="text-align: center"><input type="submit" name="submit" value="Remove Instructor"></p>
                </div>
            </form>
        </div>
    </div>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>
    <script>
        $.validate({
            modules : 'security',
            onModulesLoaded : function() {}
        });
    </script>
</body>
</html>
