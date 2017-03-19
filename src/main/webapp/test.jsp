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
        function modify_qty(val) {
            var qty = document.getElementById('qty').value;
            var new_qty = parseInt(qty,10) + val;

            if (new_qty < 0) {
                new_qty = 0;
            }

            document.getElementById('qty').value = new_qty;
            return new_qty;
        }
    </script>
    <script>
        function startTest() {
            $("#testForm").show()
            $("#start").hide()
        }
    </script>
</head>
<body>
    <header>
        <ul class="topnav">
            <li><a href="index.html">Home</a></li>
            <li><a href="WEB-INF/studentHomepage.jsp">Student Homepage</a></li>
            <li><a href="test.jsp" class="active">Take Test</a></li>
            <li><a href="pastTests.jsp">View Past Tests</a></li>
            <li><a href="LogoutServlet">Logout</a></li>
        </ul>
    </header>

    <div id="slide1">
        <div id="heading">
            <form action="StartTestServlet" method="post"><h1><p style="text-align: center"><input type="submit" id="start" onclick="startTest()" name="submit" value="Start Test"></p></h1></form>

            <div id="testForm" style="display: none">
                <h2><input id="qty" value="0" style="display: none"/></h2>

                <p><div class="progress" style="width: 50%; margin: auto;">
                    <div class="progress-bar" role="progressbar" aria-valuenow="0"
                         aria-valuemin="0" aria-valuemax="100" style="width:0%">
                    </div>
                </div></p>
                <br>

                <div id="add">
                    <p><input type="text" name="englishNoun" placeholder="Question" readonly="readonly">
                        <input type="text" name="welshNoun" placeholder="Answer"></p>
                    <p style="text-align: center"><input type="submit" id="code" onclick="modify_qty(1)" name="submit" value="Next"></p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
