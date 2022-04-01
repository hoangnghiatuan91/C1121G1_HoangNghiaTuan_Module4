<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>TỜ KHAI Y TẾ</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>
<body>
<h4>Thông tin khai báo:</h4>
<p>
    <a href="/">
        Khai báo lại
    </a>
</p>
<p>
    <a href="/edit/${idForm}">
        Cập nhật thông tin
    </a>
</p>

<form:form modelAttribute="medicalDeclaration1">
    <p>
        <span></span>
    </p>
    <table class="table table-striped">
        <tbody>
        <tr>
            <td>Họ tên: <form:input disabled="true" type="text" path="fullName" value="${medicalDeclaration1.fullName}"/></td>
        </tr>
        <tr>
            <td>Năm sinh:</td>
            <td ${medicalDeclaration1.birthday}></td>
        </tr>
        <tr>
            <td>Giới tính:</td>
            <td ${medicalDeclaration1.gender}></td>
        </tr>
        <tr>
            <td>Quốc tịch:</td>
            <td ${medicalDeclaration1.nationality}></td>
        </tr>
        <tr>
            <td>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác:</td>
            <td ${medicalDeclaration1.idCardNumber}></td>
        </tr>
        <tr>
            <td>Thông tin đi lại:</td>
            <td ${medicalDeclaration.travelInfo}></td>
        </tr>
        <tr>
            <td>Số hiệu phương tiện:</td>
            <td ${medicalDeclaration1.vehicleNumber}></td>
        </tr>
        <tr>
            <td>Số ghế:</td>
            <td ${medicalDeclaration1.seatNumber}></td>
        </tr>
        <tr>
            <td>Ngày khởi hành:</td>
            <td ${medicalDeclaration1.startDay}></td>
        </tr>
        <tr>
            <td>Ngày kết thúc:</td>
            <td ${medicalDeclaration1.endDay}></td>
        </tr>
        <tr>
            <td>Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?:</td>
            <td ${medicalDeclaration1.cityIn14day}></td>
        </tr>
        <tr>
            <td>Địa chỉ liên lạc:</td>
            <td ${medicalDeclaration1.address}></td>
        </tr>
        <tr>
            <td>Điện thoại:</td>
            <td ${medicalDeclaration1.phone}></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td ${medicalDeclaration1.email}></td>
        </tr>

        </tbody>
    </table>
</form:form>



</body>
</html>