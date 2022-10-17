<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 10/17/2022
  Time: 10:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Create Setting </title>
    <%--Bootstrap online--%>
    <%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
                crossorigin="anonymous"></script>--%>
    <%--   Bootstrap offline--%>
    <link rel="stylesheet" href="/WEB-INF/bootstrap-5.1.3-dist/css/bootstrap.min.css">
    <script src="/WEB-INF/bootstrap-5.1.3-dist/js/bootstrap.bundle.js"></script>

</head>
<body>
<h1> Create Setting </h1>



<form:form modelAttribute="setting" action="/settings/save" method="post">
    <table>
        <tr>
            <td>
                <label for="languages">Languages</label>
            </td>
            <td>
                <form:select path="languages" items="${languages}" var="language" id="languages">
                    <form:option value="${language}"> ${language} </form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                <label for="pageSize">Page Size</label>

            </td>
            <td>
                <form:select path="pageSize" items="${pageSize}" var="page" id="pageSize">
                    <form:option value="${page}">${page}</form:option>
                </form:select>
            </td>

        </tr>
        <tr>
            <td>
                <label for="spamsFilter">Spams Filter</label>

            </td>
            <td>
                <form:checkbox path="spamsFilter" id="spamsFilter" label="Enables spams filter"></form:checkbox>
            </td>
        </tr>
        <tr>
            <td>
                <label for="signature" class="form-label">Signature</label>

            </td>
            <td>
                <form:textarea path="signature" type="text" id="signature"></form:textarea>

            </td>

        </tr>
        <tr>
            <td>

            </td>
            <td>
                <button type="submit" class="btn btn-primary">Submit</button>

            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
