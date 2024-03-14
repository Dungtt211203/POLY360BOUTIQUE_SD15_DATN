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
        width: 100px;
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
    <div style="margin-left: 300px;margin-top: 100px">
        <h1 style="text-align: center;color: black">QUẢN LÝ NHÂN VIÊN</h1>
        <table class="table-warning">
            <thead>
            <tr>
                <th>STT</th>
                <th>ID</th>
                <th>ID Tài Khoản</th>
                <th>Mã Nhân Viên</th>
                <th>Họ Nhân Viên</th>
                <th>Tên Đệm Nhân Viên</th>
                <th>Tên Nhân Viên</th>
                <th>Giới Tính</th>
                <th>Địa Chỉ</th>
                <th>Số Điện Thoại</th>
                <th>Email</th>
                <th>Trạng Thái</th>
                <th colspan="2">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${load}" var="nv" varStatus="i">
                <tr>
                    <td>${i.index+1}</td>
                    <td>${nv.id}</td>
                    <td>${nv.taiKhoanNV.id}</td>
                    <td>${nv.ma}</td>
                    <td>${nv.ho}</td>
                    <td>${nv.tenDem}</td>
                    <td>${nv.ten}</td>
                    <td>${nv.gioiTinh==1?"Nam":"Nữ"}</td>
                    <td>${nv.diaChi}</td>
                    <td>${nv.sdt}</td>
                    <td>${nv.email}</td>
                    <td>${nv.tt==0?"Hoạt Động":"Không Hoạt Động"}</td>
                    <td>
                        <a href="/nhan-vien/view-update/${nv.id}" style="color: black"> <i
                                class="fa-sharp fa-solid fa-pen-to-square"></i></a>
                        <a href="/nhan-vien/remove/${nv.id}" style="color: black"><i class="fa-solid fa-trash"></i></a>
                    </td>
                </tr>
            </c:forEach>
            <button class="btn btn-primary"><a href="/nhan-vien/hien-thi-add"
                                               style="text-decoration: none;color: #FFFFFF"><i
                    class="fa-sharp fa-solid fa-plus"></i>ADD</a></button>
            </tbody>
        </table>
    </div>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
