<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Test</title>
    <link href="css/style.css" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,700" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script>
        jQuery(function ($) {
            $('#nextQuestionButton').click(function () {
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
                %>], <%
            }
            %>];

        function nextQuestion(answer)
        {
            ans.push( document.getElementById('answer').value);
            var qty = document.getElementById('qty').value;
            if (qty != 19)
            {
                if (qty == 18)
                {
                    $("#lastQuestion").show();
                    $("#nextQuestionButton").hide();
                }

                qty = parseInt(qty, 10) + 1;

                if (qty < 0)
                    qty = 0;

                document.getElementById('qty').value = qty;

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
                ans.push(ran);
                $('#answer').val('');
            }
            else
            {
                var score = 0;
                for (var i = 0; i < 20; i++)
                {
                    var ansType = ans[i*2];
                    var userAns = ans[i*2+1];
                    if (ansType === 0)
                    {
                        if (userAns.toUpperCase() === nouns[i][2].toUpperCase())
                            score++;
                    }
                    else if (ansType===1)
                    {
                        if (userAns.toUpperCase() === nouns[i][0].toUpperCase())
                            score++;
                    }
                    else
                    {
                        if (userAns.toUpperCase() === "MALE")
                            userAns = "M";
                        else if (userAns.toUpperCase() === "FEMALE")
                            userAns = "F";

                        if (userAns.toUpperCase() === nouns[i][1].toUpperCase())
                            score++;
                    }
                }
                document.getElementById("scoreField").value = score;
            }
        }
        
        function endTest()
        {
            var score = 0;
            for (var i = 0; i < 20; i++)
            {
                var ansType = ans[i*2];
                var userAns = ans[i*2+1];
                if (ansType === 0)
                {
                    if (userAns === nouns[i][2])
                        score++;
                }
                else if (ansType===1)
                {
                    if (userAns === nouns[i][0])
                        score++;
                }
                else
                {
                    /*if (userAns.toUpperCase() === "MALE")
                        userAns = "M";
                    else if (userAns.toUpperCase() === "FEMALE")
                        userAns = "F";
*/
                    if (userAns=== nouns[i][1])
                        score++;
                }
            }
            method ="post"; // Set method to post by default if not specified.

            // The rest of this code assumes you are not using a library.
            // It can be made less wordy if you use one.
            var form = document.createElement("form");
            form.setAttribute("method", method);
            form.setAttribute("action", "FinishTestServlet");

            var hiddenField = document.createElement("input");
            hiddenField.setAttribute("name", "score");
            hiddenField.setAttribute("value", score);
            form.appendChild(hiddenField);

            document.body.appendChild(form);
            form.submit();

        }

        function startTest()
        {
            $("#testForm").show();
            $("#start").hide()

            var ran = Math.floor(Math.random() * 3);
            var question;

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
            <li><a href="PastTestsServlet">View Past Tests</a></li>
            <li><a href="LogoutServlet">Logout</a></li>
        </ul>
    </header>

    <div>
        <div id="heading">
            <form>
                <h1 style="text-align: center"><input style="background: none; border: none; color: #000000; font-family: 'Raleway', sans-serif; font-size: 19px; font-weight: lighter; cursor: pointer; text-align: center"
                        id="start" onclick="startTest()" name="submit" value="Start Test"></h1>
            </form>

            <div id="testForm" style="display: none">
                <h2><input id="qty" value="0" style="display: none"/></h2>

                <p>
                <div class="progress" style="width: 50%; margin: auto;">
                    <div class="progress-bar" role="progressbar" aria-valuenow="0"
                         aria-valuemin="0" aria-valuemax="100" style="width:0">
                    </div>
                </div>

                <br>

                <div id="add">
                    <p id="question"></p>
                    <p><input id="answer" type="text" name="welshNoun" placeholder="Answer"></p>
                    <p style="text-align: center"><input type="submit" id="nextQuestionButton" onclick="nextQuestion();" name="submit" value="Next"></p>
                    <p style="text-align: center"><input type="submit" id="lastQuestion" onclick="endTest();" name="submit" value="End" style="display: none;"></p>

                </div>
            </div>
        </div>
    </div>
</body>
</html>