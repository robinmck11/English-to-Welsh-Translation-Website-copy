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
        var ans = [];
        var nouns = [<%
            String[][] array = (String[][])session.getAttribute("nouns");
            for (int i = 0; i < array.length; i++)
            {%>[<%
              	for (int j = 0; j < array[0].length; j++)
                {
                %>"<%= array[i][j] %>", <%
                }
                %>],<%
            }
            %> ];

        function nextQuestion(answer) {
            ans = [ans, document.getElementById('answer').value];
            var qty = document.getElementById('qty').value;
            var new_qty = parseInt(qty, 10) + 1;

            if (new_qty < 0)
                new_qty = 0;

            document.getElementById('qty').value = new_qty;

            var ran = Math.floor(Math.random() * 3);
            var question;





            var english = nouns[qty][0];
            var welsh = nouns[qty][1];
            var gender = nouns[qty][2];

            if (ran === 0)
                question = "What is the gender of the Welsh noun " + welsh + "?";
            else if (ran === 1)
                question = "What is the meaning of the Welsh noun " + welsh + "?";
            else
                question = "What is the Welsh noun for the English word for " + english + "?";
            document.getElementById("question").innerHTML = question;
            ans = [ans, ran];
            window.alert(ans);
        }

        function startTest() {
            var ran = Math.floor(Math.random() * 3);
            var question;
            $("#testForm").show();
            $("#start").hide()

            var english = nouns[0][0];
            var welsh = nouns[0][1];
            var gender = nouns[0][2];

            if (ran === 0)
                question = "What is the gender of the Welsh noun " + welsh + "?";
            else if (ran === 1)
                question = "What is the meaning of the Welsh noun " + welsh + "?";
            else
                question = "What is the Welsh noun for the English word for " + english + "?";
            document.getElementById("question").innerHTML = question;
            ans = [ran]
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

                <div id="add">
                    <p id="question"></p>
                    <p><input id ="answer" type="text" name="welshNoun" placeholder="Answer"></p>
                    <p style="text-align: center"><input type="submit" id="code" onclick="nextQuestion();" name="submit" value="Next"></p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
