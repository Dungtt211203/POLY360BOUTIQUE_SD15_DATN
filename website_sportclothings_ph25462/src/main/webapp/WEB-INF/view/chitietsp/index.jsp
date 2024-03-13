<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<style>
    table {
        border-collapse: collapse;
        width: 100%;
        font-family: Arial, sans-serif;
        margin-top: 30px;
    }

    th, td {
        padding: 8px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: #f2f2f2;
        font-weight: bold;
    }

    tr:nth-child(even) {
        background-color: #f9f9f9;
    }

    tr:hover {
        background-color: #e5e5e5;
    }
</style>
<body>
<div style="display: flex">
    <div>
        <jsp:include page="../admin/index.jsp"/>
    </div>
    <div style="margin-left: 300px;margin-top: 100px">
        <h1 style="text-align: center;color: black">QUẢN LÝ CHI TIẾT SẢN PHẨM</h1>
        <button class="btn btn-primary"><a href="/chitietsp/viewadd" style="text-decoration: none;color: #FFFFFF"><i
                class="fa-sharp fa-solid fa-plus"></i>ADD</a></button>
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Mã CTSP</th>
                <th>Số lượng</th>
                <th>Ngày Tạo</th>
                <th>Ngày Sửa</th>
                <th>Sản Phẩm</th>
                <th>Kích Cỡ</th>
                <th>Màu Sắc</th>
                <th>Chất Liệu</th>
                <th>Thương Hiệu</th>
                <th colspan="2">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="ctsp">
                <tr>
                    <td>${ctsp.id}</td>
                    <td>${ctsp.maChiTietSanPham}</td>
                    <td>${ctsp.soLuong}</td>
                    <td>${ctsp.ngayTao}</td>
                    <td>${ctsp.ngaySua}</td>
                    <td>${ctsp.sanPham.ten}</td>
                    <td>${ctsp.kichCo.ten}</td>
                    <td>${ctsp.mauSac.ten}</td>
                    <td>${ctsp.chatLieu.ten}</td>
                    <td>${ctsp.thuongHieu.ten}</td>
                    <td>
                        <a href="/chitietsp/update/${ctsp.id}" style="color: black"> <i
                                class="fa-sharp fa-solid fa-pen-to-square"></i></a>
                        <a href="/chitietsp/delete/${ctsp.id}" style="color: black"><i
                                class="fa-solid fa-trash"></i></a>
                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
