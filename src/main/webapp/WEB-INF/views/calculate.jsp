<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <META http-equiv="Content-Type"  content="text/html;charset=UTF-8">
    <title>Calculate prices</title>
    <link rel="stylesheet" href="/static/css/main.css">
</head>
<body>
<div class="container">
    <h1>
        Welcome to the amazing price calculator!
    </h1>
    <form method="post">
        <dl>
            <dt>
                <label for="productId">Product</label>
            </dt>
            <dd>
                <select name="productId" id="productId">
                    <option value="SERVICE_PACKAGE">Service Package</option>
                    <option value="COURIER">Courier</option>
                </select>
            </dd>

            <br>

            <dt>
                <label for="weightInGrams">Weight (grams)</label>
            </dt>
            <dd>
                <input type="text" name="weightInGrams" id="weightInGrams" value="<c:out value="${weightInGrams}"/>"/>
            </dd>

            <br>

            <dt>
                <label for="numberOfZones">Number of zones</label>
            </dt>
            <dd>
                <select name="numberOfZones" id="numberOfZones">
                    <c:forEach var="i" begin="0" end="6">
                        <option value="${i}" <c:if test="${i == numberOfZones}">selected</c:if>>
                            ${i}
                        </option>
                    </c:forEach>
                </select>
            </dd>
        </dl>
        <input type="submit" value="Calculate price"/>
    </form>
    <hr>
    <c:if test="${errorMessages != null}">
        <c:forEach items="${errorMessages}" var="errorMessage">
            <span class="error"><c:out value="${errorMessage}"/></span>
            <br/>
        </c:forEach>
    </c:if>
    <c:if test="${price != null}">
        Price <strong><c:out value="${price}"/></strong>
    </c:if>
</div>
</body>
</html>