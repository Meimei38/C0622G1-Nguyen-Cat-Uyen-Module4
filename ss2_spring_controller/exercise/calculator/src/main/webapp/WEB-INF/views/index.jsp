<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 10/14/2022
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Calculator</title>
    <link rel="stylesheet" href="../bootstrap-5.1.3-dist/css/bootstrap.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

  </head>
  <style>
    h2{
      padding-left: 18%;
    }
    .col-4, .col-2{
      display: inline;
    }
    .row{
      margin-bottom: 20px;
    }
 .form-control{
   width: 50%!important;
 }
button{
  width: 12%;
}
h3{
  color: red;
}
  </style>
  <body>
  <div class="row">
    <h2>Calculator</h2>
  </div>
  <form method="get" action="/calculate">
  <div class="row">
   <div class="col-4">

     <input type="number" class="form-control" name="number1" value="${number1}" id="number1" required placeholder="Enter number 1">
   </div>
    <div class="col-4">

      <input type="number" class="form-control" name="number2" value="${number2}" id="number2" required placeholder="Enter number 2">
    </div>
  </div>
  <div class="row d-inline">
    <div class="col-2">
      <button type="submit" name="function" class="btn btn-primary" value="+">Addition</button>
    </div>
    <div class="col-2">
      <button type="submit" name="function" class="btn btn-primary" value="-">Subtraction</button>
    </div>
    <div class="col-2">
      <button type="submit" name="function" class="btn btn-primary" value="*">Multiplication</button>
    </div>
    <div class="col-2">
      <button type="submit" name="function" class="btn btn-primary" value="/">Division</button>
    </div>
  </div>
  </form>

  <h3>${result}</h3>

  </body>
<script src="../bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
</html>
