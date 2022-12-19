<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- BEGIN -->
<html>
    <head>
        <meta charset="UTF-8">
        <title>Delete</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
            crossorigin="anonymous">
    </head>
    <body>
    <table>
                <tr><td>ID = ${user.get("id")}</tr></td></tr>
                <tr><td>First Name = ${user.get("firstName")}</td></tr>
                <tr><td>Last Name = ${user.get("lastName")}</td></tr>
                <tr><td>Email = ${user.get("email")}</td></tr>
            </table>
<form action="/users/delete?id=${user.get("id")}" method="post">
    <button type="submit" class="btn btn-danger">Удалить</button>
</form>
</body>
</html>
<!-- END -->
