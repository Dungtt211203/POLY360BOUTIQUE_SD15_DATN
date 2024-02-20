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
<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Mã CTSP</th>
        <th>Số lượng</th>
        <th>Giá</th>
        <th>Trạng Thái</th>
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
    <c:forEach items="${load}" var="ctsp" varStatus="i">
        <tr>
            <td>${ctsp.id}</td>
            <td>${ctsp.ma}</td>
            <td>${ctsp.soLuong}</td>
            <td>${ctsp.giaHienHanh}</td>
            <td>${ctsp.trangThai}</td>
            <td>${ctsp.ngayTao}</td>
            <td>${ctsp.ngaySua}</td>
            <td>${ctsp.sanPham}</td>
            <td>${ctsp.kichCo}</td>
            <td>${ctsp.mauSac}</td>
            <td>${ctsp.chatLieu}</td>
            <td>${ctsp.thuongHieu}</td>
            <td>
                <button class="btn btn-success"><a href="/chitietsp/detail/${ctsp.id}" style="text-decoration: none;color: #FFFFFF">Detail</a></button>
                <button class="btn btn-danger"><a href="/chitietsp/remove/${ctsp.id}" style="text-decoration: none;color: #FFFFFF">Remove</a></button>
            </td>


        </tr>
    </c:forEach>
    <button class="btn btn-primary"><a href="/chitietsp/hien-thi-add" style="text-decoration: none;color: #FFFFFF">ADD</a></button>

    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
