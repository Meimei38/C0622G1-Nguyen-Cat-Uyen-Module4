<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 10/17/2022
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
    <%--  Bootstrap online--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <%--       Bootstrap offline--%>
    <link rel="stylesheet" href="/WEB-INF/bootstrap-5.1.3-dist/css/bootstrap.min.css">
    <script src="/WEB-INF/bootstrap-5.1.3-dist/js/bootstrap.bundle.js"></script>
</head>
<style>
    table, th, tr, td {
        border: solid 1px black;
        border-collapse: collapse;
    }

    table {
        width: 50%;
    }
</style>
<body>
<h1> Setting List </h1>

<a href="/settings">
    <button type="button" class="btn btn-primary"> Create Setting</button>
</a>

<p style="color: red">${message}</p>
<table class="table">
    <thead>
    <tr>
        <th scope="col">No</th>
        <th scope="col">Id</th>
        <th scope="col">Language</th>
        <th scope="col">Page Size</th>
        <th scope="col">Spam Filter</th>
        <th scope="col">Signature</th>
        <th scope="col">Update Setting</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="setting" items="${settingList}" varStatus="loop">
        <tr>
            <td scope="row">${loop.count}</td>
            <td>${setting.id}</td>
            <td>${setting.languages}</td>
            <td>${setting.pageSize}</td>
            <td>${setting.spamsFilter}</td>
            <td>${setting.signature}</td>
            <td>
                <a href="/showUpdate/${setting.id}">
                    <button type="button" class="btn btn-primary"> Update Setting</button>
                </a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
