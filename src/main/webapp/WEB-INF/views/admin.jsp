<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <META http-equiv="Content-Type"  content="text/html;charset=UTF-8">
    <title>Administer products</title>
    <link rel="stylesheet" href="/static/css/main.css">
</head>
<body>
<div class="container">
    <h1>
        Hello administrator!
    </h1>
    <form method="post" action="/admin/addProduct">
        <input type="submit" value="Add product"/>
    </form>
</div>
</body>
</html>