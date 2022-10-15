<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 10/14/2022
  Time: 1:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="../bootstrap-5.1.3-dist%20(1)/bootstrap-5.1.3-dist/css/bootstrap.min.css">
<html>
<head>
    <title>Sandwich Condiment</title>
</head>

<body>


    <form action="/save" method="post">
        <div class="btn-group" role="group" aria-label="Basic checkbox toggle button group">

            <span><input type="checkbox" class="btn-check" id="btncheck1" name="condiment" value="lettuce"
                         autocomplete="off"> Lettuce </span>

            <span><input type="checkbox" class="btn-check" id="btncheck2" name="condiment" value="tomato"
                         autocomplete="off"> Tomato </span>

            <span><input type="checkbox" class="btn-check" id="btncheck3" name="condiment" value="mustard"
                         autocomplete="off"> Mustard </span>

            <span><input type="checkbox" class="btn-check" id="btncheck4" name="condiment" value="sprouts"
                         autocomplete="off"> Sprouts </span>

        </div>

        <button class="btn btn-primary" type="submit">Save</button>

    </form>


        <span>${condiment}</span>



</body>
<script src="../bootstrap-5.1.3-dist%20(1)/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
</html>
