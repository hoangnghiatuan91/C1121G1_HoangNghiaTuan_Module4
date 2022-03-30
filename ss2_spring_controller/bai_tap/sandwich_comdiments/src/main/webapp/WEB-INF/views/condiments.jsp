<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Sandwich Condiments</title>
</head>
<body>
<h1>
  Sandwich Condiments
</h1>

<form action="/condiment" method="get">
  <input type="checkbox" name="condiment" value="Lettuce">Lettuce
  <input type="checkbox" name="condiment" value="Tomato">Tomato
  <input type="checkbox" name="condiment" value="Mustard">Mustard
  <input type="checkbox" name="condiment" value="Sprouts">Sprouts
  <p></p>
  <input type="submit" value="Save">
</form>
<c:if test="${listCondiment != null}">
  <h3>Result Menu</h3>
  <c:forEach items="${listCondiment}" var="list">
    <span style="color: red">${list}</span>
  </c:forEach>
</c:if>

</body>
</html>