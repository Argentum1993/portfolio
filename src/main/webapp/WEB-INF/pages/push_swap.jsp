<%--
  Created by IntelliJ IDEA.
  User: Наталья
  Date: 17.03.2021
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    This is push_swap <br>
    Back to <a href="/">main</a>.<br>
    <br>
    <div>
        <h1>Test push swap</h1>
        <p><input id="params" type="text" size="40" name="data"><span id="input"></span></p>
        <button type="button" onclick="testAjax()">Get commands</button>
    </div>
    <script>
        function testAjax(){
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("test").innerHTML =
                        this.responseText;
                }
            };

            xhttp.open("POST", "/push_swap", true);
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhttp.send("data=" + document.getElementById('params').value);
            document.getElementById("input").innerHTML =  " Input: " + document.getElementById("params").value;
        }
    </script>
    <br>
    <div id="test" style="width: auto">
    </div>
</body>
</html>
