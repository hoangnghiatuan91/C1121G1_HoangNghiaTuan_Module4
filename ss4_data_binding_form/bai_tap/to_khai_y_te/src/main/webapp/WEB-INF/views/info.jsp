<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>TỜ KHAI Y TẾ</title>
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

    <p>
        <span></span>
    </p>
    <table class="table table-striped">
        <tbody>
        <tr>
            <td>Họ tên:</td>
            <td>${medicalDeclaration1.fullName}</td>
        </tr>
        <tr>
            <td>Năm sinh:</td>
            <td >${medicalDeclaration1.birthday}</td>
        </tr>
        <tr>
            <td>Giới tính:</td>
            <td >${medicalDeclaration1.gender}</td>
        </tr>
        <tr>
            <td>Quốc tịch:</td>
            <td ${medicalDeclaration1.nationality}></td>
        </tr>
        <tr>
            <td>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác:</td>
            <td> ${medicalDeclaration1.idCardNumber}</td>
        </tr>
        <tr>
            <td>Thông tin đi lại:</td>
            <td >${medicalDeclaration.travelInfo}</td>
        </tr>
        <tr>
            <td>Số hiệu phương tiện:</td>
            <td >${medicalDeclaration1.vehicleNumber}</td>
        </tr>
        <tr>
            <td>Số ghế:</td>
            <td ${medicalDeclaration1.seatNumber}></td>
        </tr>
        <tr>
            <td>Ngày khởi hành:</td>
            <td >${medicalDeclaration1.startDay}</td>
        </tr>
        <tr>
            <td>Ngày kết thúc:</td>
            <td >${medicalDeclaration1.endDay}</td>
        </tr>
        <tr>
            <td>Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?:</td>
            <td >${medicalDeclaration1.cityIn14day}</td>
        </tr>
        <tr>
            <td>Địa chỉ liên lạc:</td>
            <td ${medicalDeclaration1.address}></td>
        </tr>
        <tr>
            <td>Điện thoại:</td>
            <td >${medicalDeclaration1.phone}</td>
        </tr>
        <tr>
            <td>Email:</td>
            <td >${medicalDeclaration1.email}</td>
        </tr>

        </tbody>
    </table>




</body>
</html>