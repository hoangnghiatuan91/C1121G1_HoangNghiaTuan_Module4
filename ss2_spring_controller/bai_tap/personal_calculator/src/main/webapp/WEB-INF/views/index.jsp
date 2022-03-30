
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
  <form action="/calculate" method="get">
    <input type="text" name="num1" placeholder="enter number 1"><br>
    <input type="text" name="num2" placeholder="enter number 2"><br>
    <input type="submit" name="input" value="sub">
    <input type="submit" name="input" value="sum">
    <input type="submit" name="input" value="mul">
    <input type="submit" name="input" value="div"><br>
    <input type="text" disabled name="result" value="${total}">
    <h3>${message}</h3>
  </form>

  </body>
</html>
