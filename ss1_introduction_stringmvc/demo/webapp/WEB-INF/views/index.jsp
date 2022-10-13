<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 10/13/2022
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Currency Converter</title>

</head>
<body>
<form method="post"  >
    <div class="form-group">
        <label for="usdAmount">Currency Converter</label>
        <input type="text"
               class="form-control" name="usdAmount" id="usdAmount" aria-describedby="helpId"
               placeholder="Enter amount of VND">
    </div>
    <button type="submit"> Submit</button>
</form>

<h2> ${note}</h2>

<c:if test="${result!=null}">
    <h2> ${usdAmount} USD= ${result} VND</h2>
</c:if>


</body>
</html>
