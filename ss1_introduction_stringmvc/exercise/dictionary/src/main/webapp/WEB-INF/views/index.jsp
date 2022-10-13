<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 10/13/2022
  Time: 5:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="../../bootstrap-5.1.3-dist/css/bootstrap.min.css">
</head>
<body>
<h2>Dictionary</h2>

<form method="post">
    <div class="mb-3 row">
        <label for="englishWord" class="col-sm-2 col-form-label">English</label>
        <div class="col-sm-10">
            <input type="text"
                   class="form-control" name="englishWord" id="englishWord" aria-describedby="helpId"
                   placeholder="Enter English Word">
        </div>
    </div>
    <button type="submit">
        Check up
    </button>
</form>


<div class="mb-3 row">
    <label for="vietnameseMeaning" class="col-sm-2 col-form-label">Vietnamese meaning</label>
    <div class="col-sm-10">
        <p id="vietnameseMeaning"> ${result}</p>
    </div>
</div>
</body>
<script src="../../bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
</html>
