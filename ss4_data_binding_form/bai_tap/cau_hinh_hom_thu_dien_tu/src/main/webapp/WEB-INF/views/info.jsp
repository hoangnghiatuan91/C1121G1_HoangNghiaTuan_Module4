<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Setting Info</title>
</head>
<body>
<h1>Setting info</h1>
<table>
        <tr>
            <td>Languages</td>
            <td>${emailSettings.languages}</td>
        </tr>
        <tr>
            <td>Page Size: </td>
            <td>${emailSettings.pageSize}</td>
        </tr>
        <tr>
            <td>Spam Filter: </td>
          <td>${emailSettings.spamFilter}</td>
        </tr>
        <tr>
            <td>Signature: </td>
            <td>${emailSettings.signature}</td>
        </tr>

<form:form method="post" action="/settings/edit" modelAttribute="emailSettings">
    <form:input type="hidden" path="languages" value = "${emailSettings.languages}" />
    <form:input type="hidden" path="pageSize"  value = "${emailSettings.pageSize}" />
    <form:input type="hidden" path="spamFilter" value = "${emailSettings.spamFilter}" />
    <form:input type="hidden" path="signature" value = "${emailSettings.signature}" />
        <button>Edit</button>
</form:form>
</table>
</body>
</html>
