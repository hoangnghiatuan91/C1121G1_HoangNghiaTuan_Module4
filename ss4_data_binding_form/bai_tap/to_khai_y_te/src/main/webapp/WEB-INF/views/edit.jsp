<!DOCTYPE html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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

<div class="container">
    <div class="row">
        <div class="col-12 text-center">
            <h3>TỜ KHAI Y TẾ</h3>
        </div>
        <div class="col-12 text-center">
            <h5>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG
                CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h5>
        </div>
        <div class="col-12 text-center text-danger">
            <h5>Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể bị xử lý hình sự</h5>
        </div>
        <div class="col-12 mt-4">
            <form:form method="post" action="/save" modelAttribute="medicalDeclaration">
                <form:input type="hidden" path="idForm"/>
                <div class="form-group ">
                    <label>Họ tên (ghi chữ IN HOA) <span class="text-danger">(*)</span> </label>
                    <form:input type="text" class="form-control" aria-describedby="fullNameError" path="fullName"/>
                    <small id="fullNameError" class="form-text text-danger"></small>
                </div>
                <div class="form-group row">
                    <div class="col-4">
                        <label>Năm sinh <span class="text-danger">(*)</span> </label>
                        <form:input type="date" class="form-control" aria-describedby="birthError" path="birthday"/>
                        <small id="birthError" class="form-text text-danger"></small>
                    </div>
                    <div class="col-4">
                        <label>Giới tính <span class="text-danger">(*)</span> </label>
                        <form:select class="custom-select" path="gender" aria-describedby="genderError"
                                     items="${genderArray}">
                        </form:select>
                        <small id="genderError" class="form-text text-danger"></small>
                    </div>
                    <div class="col-4">
                        <label>Quốc tịch <span class="text-danger">(*)</span> </label>
                        <form:input type="text" class="form-control" aria-describedby="nationalityError"
                                    path="nationality"/>
                        <small id="nationalityError" class="form-text text-danger"></small>
                    </div>
                </div>
                <div class="form-group ">
                    <label>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác
                        <span class="text-danger">(*)</span> </label>
                    <form:input type="text" class="form-control" aria-describedby="idCardNumberError"
                                path="idCardNumber"/>
                    <small id="idCardNumberError" class="form-text text-danger"></small>
                </div>
                <div class="form-group">
                    <label>Thông tin đi lại <span class="text-danger">(*)</span> </label>
                    <div class="row">
                        <div class="form-check form-check-inline">
                            <form:radiobuttons class="form-check-input ml-3 mr-3" path="travelInfo"
                                               items="${travelInfoArray}"/>
                            <label class="form-check-label" path="travelInfo"></label>
                        </div>
                    </div>
                    <small id="travelInfoError" class="form-text text-danger"></small>
                </div>
                <div class="form-group row">
                    <div class="col-6">
                        <label>Số hiệu phương tiện</label>
                        <form:input path="vehicleNumber" type="text" class="form-control"/>
                    </div>
                    <div class="col-6">
                        <label>Số ghế</label>
                        <form:input type="text" class="form-control" path="seatNumber"/>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-6">
                        <div class="row">
                            <div class="col-3">
                                <label>Ngày khởi hành <span class="text-danger">(*)</span> </label>
                            </div>
                            <div class="col-9">
                                <form:input type="date" class="form-control" aria-describedby="startDayError"
                                            path="startDay"/>
                            </div>
                        </div>
                        <small id="startDayError" class="form-text text-danger"></small>
                    </div>
                    <div class="col-6">
                        <div class="row">
                            <div class="col-3">
                                <label>Ngày kết thúc <span class="text-danger">(*)</span> </label>
                            </div>
                            <div class="col-9">
                                <form:input type="date" class="form-control" aria-describedby="endDayError"
                                            path="endDay"/>
                            </div>
                        </div>
                        <small id="endDayError" class="form-text text-danger"></small>
                    </div>
                </div>
                <div class="form-group ">
                    <label>Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?
                        <span class="text-danger">(*)</span> </label>
                    <form:input type="text" class="form-control" aria-describedby="cityIn14dayError"
                                path="cityIn14day"/>
                    <small id="cityIn14dayError" class="form-text text-danger"></small>
                </div>
                <div class="form-group ">
                    <label>Địa chỉ liên lạc <span class="text-danger">(*)</span> </label>
                    <form:input type="text" class="form-control" aria-describedby="addressError" path="address"/>
                    <small id="addressError" class="form-text text-danger"></small>
                </div>
                <div class="form-group row">
                    <div class="col-6">
                        <label>Điện thoại <span class="text-danger">(*)</span> </label>
                        <form:input type="text" class="form-control" aria-describedby="phoneError" path="phone"/>
                        <small id="phoneError" class="form-text text-danger"></small>
                    </div>
                    <div class="col-6">
                        <label path="email">Email</label>
                        <form:input type="text" class="form-control" path="email"/>
                    </div>
                </div>
                <%--                <div class="form-group ">--%>
                <%--                    <label>Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiện dấu hiệu nào sau đây không?--%>
                <%--                        <span class="text-danger">(*)</span> </label>--%>
                <%--                    <div class="row">--%>
                <%--                        <div class="col-6">--%>
                <%--                            <table class="table border">--%>
                <%--                                <thead>--%>
                <%--                                <tr>--%>
                <%--                                    <th>Triệu chứng</th>--%>
                <%--                                    <th>Có</th>--%>
                <%--                                    <th>Không</th>--%>
                <%--                                </tr>--%>
                <%--                                </thead>--%>
                <%--                                <tbody>--%>
                <%--                                <tr>--%>
                <%--                                    <td>Sốt <span class="text-danger">(*)</span></td>--%>
                <%--                                    <div class="form-check form-check-inline">--%>
                <%--                                        <td>--%>
                <%--                                            <form:radiobuttons class="form-check-input ml-2"--%>
                <%--                                                               items="${booleanArray}" path="fever"/>--%>
                <%--                                        </td>--%>
                <%--                                    </div>--%>
                <%--                                </tr>--%>
                <%--                                <tr>--%>
                <%--                                    <td>Ho <span class="text-danger">(*)</span></td>--%>
                <%--                                    <div class="form-check form-check-inline">--%>
                <%--                                        <td>--%>
                <%--                                            <form:radiobuttons class="form-check-input ml-2"--%>
                <%--                                                               items="${booleanArray}" path="cough"/>--%>
                <%--                                        </td>--%>
                <%--                                    </div>--%>
                <%--                                </tr>--%>
                <%--                                <tr>--%>
                <%--                                    <td>Khó thở <span class="text-danger">(*)</span></td>--%>
                <%--                                    <div class="form-check form-check-inline">--%>
                <%--                                        <td>--%>
                <%--                                            <form:radiobuttons class="form-check-input ml-2" type="radio"--%>
                <%--                                                               items="${booleanArray}" path="dyspnea"/>--%>
                <%--                                        </td>--%>
                <%--                                    </div>--%>
                <%--                                </tr>--%>
                <%--                                <tr>--%>
                <%--                                    <td>Đau họng <span class="text-danger">(*)</span></td>--%>
                <%--                                    <div class="form-check form-check-inline">--%>
                <%--                                        <td>--%>
                <%--                                            <form:radiobuttons class="form-check-input ml-2"--%>
                <%--                                                               items="${booleanArray}" path="soreThroat"/>--%>
                <%--                                        </td>--%>
                <%--                                    </div>--%>
                <%--                                </tr>--%>
                <%--                                </tbody>--%>
                <%--                            </table>--%>
                <%--                        </div>--%>
                <%--                        <div class="col-6">--%>
                <%--                            <table class="table border">--%>
                <%--                                <thead>--%>
                <%--                                <tr>--%>
                <%--                                    <th scope="col">Triệu chứng</th>--%>
                <%--                                    <th scope="col">Có</th>--%>
                <%--                                    <th scope="col">Không</th>--%>
                <%--                                </tr>--%>
                <%--                                </thead>--%>
                <%--                                <tbody>--%>
                <%--                                <tr>--%>
                <%--                                    <td>Nôn/Buồn nôn <span class="text-danger">(*)</span></td>--%>
                <%--                                    <div class="form-check form-check-inline">--%>
                <%--                                        <td>--%>
                <%--                                            <form:radiobuttons class="form-check-input ml-2"--%>
                <%--                                                               items="${booleanArray}" path="nausea"/>--%>
                <%--                                        </td>--%>
                <%--                                    </div>--%>
                <%--                                </tr>--%>
                <%--                                <tr>--%>
                <%--                                    <td>Tiêu chảy <span class="text-danger">(*)</span></td>--%>
                <%--                                    <div class="form-check form-check-inline">--%>
                <%--                                        <td>--%>
                <%--                                            <form:radiobuttons class="form-check-input ml-2"--%>
                <%--                                                               items="${booleanArray}" path="diarrhea"/>--%>
                <%--                                        </td>--%>
                <%--                                    </div>--%>
                <%--                                </tr>--%>
                <%--                                <tr>--%>
                <%--                                    <td>Xuất huyết ngoài da <span class="text-danger">(*)</span></td>--%>
                <%--                                    <div class="form-check form-check-inline">--%>
                <%--                                        <td>--%>
                <%--                                            <form:radiobuttons class="form-check-input ml-2"--%>
                <%--                                                               items="${booleanArray}" path="skinHemorrhage"/>--%>
                <%--                                        </td>--%>
                <%--                                    </div>--%>
                <%--                                </tr>--%>
                <%--                                <tr>--%>
                <%--                                    <td>Nổi ban ngoài da <span class="text-danger">(*)</span></td>--%>
                <%--                                    <div class="form-check form-check-inline">--%>
                <%--                                        <td>--%>
                <%--                                            <form:radiobuttons class="form-check-input ml-2"--%>
                <%--                                                               items="${booleanArray}" path="skinRash"/>--%>
                <%--                                        </td>--%>
                <%--                                    </div>--%>
                <%--                                </tr>--%>
                <%--                                </tbody>--%>
                <%--                            </table>--%>
                <%--                        </div>--%>
                <%--                    </div>--%>
                <%--                </div>--%>
                <%--                <div class="form-group ">--%>
                <%--                    <label>Lịch sử phơi nhiễm: Trong vòng 14 ngày qua, Anh/Chị có?--%>
                <%--                        <span class="text-danger">(*)</span> </label>--%>
                <%--                    <table class="table border">--%>
                <%--                        <thead>--%>
                <%--                        <tr>--%>
                <%--                            <th scope="col"></th>--%>
                <%--                            <th scope="col">Có</th>--%>
                <%--                            <th scope="col">Không</th>--%>
                <%--                        </tr>--%>
                <%--                        </thead>--%>
                <%--                        <tbody>--%>
                <%--                        <tr>--%>
                <%--                            <td>Đến trang trại chăn nuôi / chợ buôn bán động vật sống / cơ sở giết mổ động vật / tiếp--%>
                <%--                                xúc động vật <span class="text-danger">(*)</span></td>--%>
                <%--                            <div class="form-check form-check-inline">--%>
                <%--                                <td>--%>
                <%--                                    <form:radiobuttons class="form-check-input ml-2"--%>
                <%--                                                       items="${booleanArray}" path="market"/>--%>
                <%--                                    <label class="form-check-label" path="market"></label>--%>
                <%--                                </td>--%>
                <%--                            </div>--%>
                <%--                        </tr>--%>
                <%--                        <tr>--%>
                <%--                            <td>Tiếp xúc gần (<2m) với người mắc bệnh viêm đường hô hấp do nCoV <span--%>
                <%--                                    class="text-danger">(*)</span></td>--%>
                <%--                            <div class="form-check form-check-inline">--%>
                <%--                                <td>--%>
                <%--                                    <form:radiobuttons class="form-check-input ml-2"--%>
                <%--                                                       items="${booleanArray}" path="nCoVContact"/>--%>
                <%--                                </td>--%>
                <%--                            </div>--%>
                <%--                        </tr>--%>
                <%--                        </tbody>--%>
                <%--                    </table>--%>
                <%--                </div>--%>
                <div class="col-12 text-danger">
                    <p>Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho việc phòng chống dịch, thuộc quản lý
                        của Ban chỉ đạo quốc gia về phòng chống dịch Covid-19. Khi bạn nhấn nút "Gửi" là bạn đã hiểu và
                        đồng ý.</p>
                </div>
                <button type="submit" class="btn btn-primary">Cập nhật tờ khai</button>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>