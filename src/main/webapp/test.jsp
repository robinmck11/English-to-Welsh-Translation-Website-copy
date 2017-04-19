<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Test</title>
    <link href="css/style.css" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,700" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script>
        jQuery(function ($) {
            $('#code').click(function () {
                var val = ((document.getElementById('qty').value) * 5) + '%';
                $('.progress-bar').width(val).text(val)
            })
        });
    </script>
    <script>
        function startTest() {
            $("#testForm").show();
            $("#start").hide();
        }
    </script>
    <script>
        function nextQuestion(answer) {
            var qty = document.getElementById('qty').value;
            var new_qty = parseInt(qty, 10) + 1;

            if (new_qty < 0)
                new_qty = 0;

            document.getElementById('qty').value = new_qty;

            var ran = Math.floor(Math.random() * 3);
            var question;

            var englishStr = "nouns" + qty + "0";
            var english = '${englishStr}';
            var welshStr = "nouns" + qty + "1";
            var welsh = '${welshStr}';
            var genderStr = "nouns" + qty + "2";
            var gender = '${genderStr}';

            <%--var english = '${"nouns" + qty + "0"}';--%>
            <%--var english = eval("'" + "\${nouns00}" + "'");--%>
            <%--var english = eval('<%=request.getAttribute("nouns00")%>');--%>
            <%--var english = '<%= session.getAttribute("nouns0" + "0") %>';--%>

            <%--var welsh = '${nouns01}';--%>
            <%--var gender = '${nouns02}';--%>

            if (ran === 0)
                question = "What is the gender of the Welsh noun " + welsh + "?";
            else if (ran === 1)
                question = "What is the meaning of the Welsh noun " + welsh + "?";
            else
                question = "What is the Welsh noun for the English word for " + english + "?";
            document.getElementById("question").innerHTML = question;
        }
    </script>
</head>
<body>
    <header>
        <ul class="topnav">
            <li><a href="StudentHomepageServlet">Student Homepage</a></li>
            <li><a href="test.jsp" class="active">Take Test</a></li>
            <li><a href="pastTests.jsp">View Past Tests</a></li>
            <li><a href="LogoutServlet">Logout</a></li>
        </ul>
    </header>

    <div id="slide1">
        <div id="heading">
            <form><h1><p style="text-align: center"><input style="background: none; border: none; color: #000000; font-family: 'Raleway', sans-serif; font-size: 19px; font-weight: lighter; cursor: pointer;" id="start" onclick="startTest()" name="submit" value="Start Test"></p></h1></form>

            <div id="testForm" style="display: none">
                <h2><input id="qty" value="0" style="display: none"/></h2>

                <p>
                    <div class="progress" style="width: 50%; margin: auto;">
                        <div class="progress-bar" role="progressbar" aria-valuenow="0"
                             aria-valuemin="0" aria-valuemax="100" style="width:0">
                        </div>
                    </div>
                </p>

                <br>

                <%--<table>--%>
                    <%--<tr>--%>
                        <%--<td><%=request.getAttribute("nouns:0:0")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:0:1")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:0:2")%></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td><%=request.getAttribute("nouns:1:0")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:1:1")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:1:2")%></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td><%=request.getAttribute("nouns:2:0")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:2:1")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:2:2")%></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td><%=request.getAttribute("nouns:3:0")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:3:1")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:3:2")%></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td><%=request.getAttribute("nouns:4:0")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:4:1")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:4:2")%></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td><%=request.getAttribute("nouns:5:0")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:5:1")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:5:2")%></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td><%=request.getAttribute("nouns:6:0")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:6:1")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:6:2")%></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td><%=request.getAttribute("nouns:7:0")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:7:1")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:7:2")%></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td><%=request.getAttribute("nouns:8:0")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:8:1")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:8:2")%></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td><%=request.getAttribute("nouns:9:0")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:9:1")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:9:2")%></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td><%=request.getAttribute("nouns:10:0")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:10:1")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:10:2")%></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td><%=request.getAttribute("nouns:11:0")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:11:1")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:11:2")%></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td><%=request.getAttribute("nouns:12:0")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:12:1")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:12:2")%></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td><%=request.getAttribute("nouns:13:0")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:13:1")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:13:2")%></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td><%=request.getAttribute("nouns:14:0")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:14:1")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:14:2")%></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td><%=request.getAttribute("nouns:15:0")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:15:1")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:15:2")%></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td><%=request.getAttribute("nouns:16:0")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:16:1")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:16:2")%></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td><%=request.getAttribute("nouns:17:0")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:17:1")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:17:2")%></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td><%=request.getAttribute("nouns:18:0")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:18:1")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:18:2")%></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td><%=request.getAttribute("nouns:19:0")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:19:1")%></td>--%>
                        <%--<td><%=request.getAttribute("nouns:19:2")%></td>--%>
                    <%--</tr>--%>
                <%--</table>--%>

                <div id="add">
                    <p id="question"></p>
                    <p><input type="text" name="welshNoun" placeholder="Answer"></p>
                    <p style="text-align: center"><input type="submit" id="code" onclick="nextQuestion();" name="submit" value="Next"></p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
