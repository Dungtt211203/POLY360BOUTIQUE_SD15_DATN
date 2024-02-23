<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>POLY360BOUTIQUE_ADMIN</title>
    <link rel="icon" href="../../../svg/logohome.svg">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<h1 style="text-align: center">QUẢN LÝ CHI TIẾT SẢN PHẨM</h1>
<form:form method="post" action="/chitietsp/add" modelAttribute="sp">
    ID:<form:input path="id"/><br>
Ma:<form:input path="ma"/><br>
SoLuong:<form:input path="soLuong"/><br>
GiaHienHanh:<form:input path="giaHienHanh"/><br>

NgayTao:<form:input path="ngayTao"/><br>
NgaySua:<form:input path="ngaySua"/><br>

TenSP: <form:select path="sanPham">
    <form:options items="${sanPham}" itemLabel="ten"/>
</form:select><br>
KichCo: <form:select path="kichCo">
    <form:options items="${kichCo}" itemLabel="ten"/>
</form:select><br>
Mau Sac: <form:select path="mauSac">
    <form:options items="${mauSac}" itemLabel="ten"/>
</form:select><br>
ChatLieu: <form:select path="chatLieu">
    <form:options items="${chatLieu}" itemLabel="ten"/>
</form:select><br>
ThuongHieu: <form:select path="thuongHieu">
    <form:options items="${thuongHieu}" itemLabel="ten"/>
</form:select><br>
<form:button>Add</form:button>
</form:form>
<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Mã CTSP</th>
        <th>Số lượng</th>
        <th>Giá</th>
        <th>Ngày Tạo</th>
        <th>Ngày Sửa</th>
        <th>Sản Phẩm </th>
        <th>Kích Cỡ </th>
        <th>Màu Sắc </th>
        <th>Chất Liệu </th>
        <th>Thương Hiệu </th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="ctsp">
        <tr>
            <td>${ctsp.id}</td>
            <td>${ctsp.ma}</td>
            <td>${ctsp.soLuong}</td>
            <td>${ctsp.giaHienHanh}</td>
            <td>${ctsp.ngayTao}</td>
            <td>${ctsp.ngaySua}</td>
            <td>${ctsp.sanPham.ten}</td>
            <td>${ctsp.kichCo.ten}</td>
            <td>${ctsp.mauSac.ten}</td>
            <td>${ctsp.chatLieu.ten}</td>
            <td>${ctsp.thuongHieu.ten}</td>
            <td>
                <button class="btn btn-success"><a href="/chitietsp/detail/${ctsp.id}" style="text-decoration: none;color: #FFFFFF">Detail</a></button>
                <button class="btn btn-primary"><a href="/chitietsp/update/${ctsp.id}" style="text-decoration: none;color: #FFFFFF">Update</a></button>
                <button class="btn btn-danger"><a href="/chitietsp/delete/${ctsp.id}" style="text-decoration: none;color: #FFFFFF">Remove</a></button>
            </td>


        </tr>
    </c:forEach>
    <button class="btn btn-primary"><a href="/chitietsp/hien-thi-add" style="text-decoration: none;color: #FFFFFF">ADD</a></button>

    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
