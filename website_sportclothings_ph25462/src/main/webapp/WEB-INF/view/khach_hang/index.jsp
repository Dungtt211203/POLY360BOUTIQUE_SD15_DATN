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
    button {
        width: 200px;
    }

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
    <div style="margin-left: 200px;margin-top: 100px">
        <h1 style="text-align: center;color: black">QUẢN LÝ KHÁCH HÀNG</h1>
        <button class="btn btn-primary"><a href="/admin/khach-hang/hien-thi-add"
                                           style="text-decoration: none;color: #FFFFFF"><i
                class="fa-sharp fa-solid fa-plus"></i>ADD</a></button>
        <table class="table-warning">
            <thead>
            <tr>
                <th>STT</th>
                <th>ID</th>
                <th>ID Tài Khoản</th>
                <th>Mã Khách Hàng</th>
                <th>Họ Khách Hàng</th>
                <th>Tên Đệm Khách Hàng</th>
                <th>Tên Khách Hàng</th>
                <th>Giới Tính</th>
                <th>Ngay Sinh</th>
                <th>Địa Chỉ</th>
                <th>Số Điện Thoại</th>
                <th>Email</th>
                <th>Trạng Thái</th>
                <th colspan="2">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.content}" var="kh" varStatus="i">
                <tr>
                    <td>${i.index+1}</td>
                    <td>${kh.id}</td>
                    <td>${kh.taiKhoanKH.id}</td>
                    <td>${kh.ma}</td>
                    <td>${kh.ho}</td>
                    <td>${kh.tenDem}</td>
                    <td>${kh.ten}</td>
                    <td>${kh.gioiTinh==0?"Nam":"Nữ"}</td>
                    <td>${kh.ngaySinh}</td>
                    <td>${kh.diaChi}</td>
                    <td>${kh.sdt}</td>
                    <td>${kh.email}</td>
                    <td>${kh.tt==0?"Hoạt Động":"Không Hoạt Động"}</td>
                    <td>
                        <a href="/admin/khach-hang/view-update/${kh.id}" style="color: black"> <i
                                class="fa-sharp fa-solid fa-pen-to-square"></i></a>
                        <a href="/admin/khach-hang/remove/${kh.id}" style="color: black"><i
                                class="fa-solid fa-trash"></i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <nav aria-label="...">
            <ul class="pagination" style="margin-left: 700px">
                <li class="page-item disabled">
                    <a class="page-link" href="/admin/khach-hang/hien-thi?kh=0">Previous</a>
                </li>
                <li class="page-item"><a class="page-link" href="/admin/khach-hang/hien-thi?kh=${page.number-1}"><<<</a>
                </li>
                <li class="page-item"><a class="page-link" href="/admin/khach-hang/hien-thi?kh=${page.number+1}">>>></a>
                <li class="page-item">
                    <a class="page-link" href="/admin/khach-hang/hien-thi?kh=${page.totalPages+1}">Next</a>
                </li>
            </ul>
        </nav>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
