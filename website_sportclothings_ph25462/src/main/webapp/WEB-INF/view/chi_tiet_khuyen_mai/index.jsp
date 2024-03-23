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


    .badges {
        padding: 5px 10px;
        border-radius: 5px;
        font-size: 14px;
    }

    .bg-lighthuy {
        background-color: #dfc2c4; /* Màu cam nhạt */
        color: #bb2d3b; /* Màu chữ trắng */
    }

    .bg-lightblue {
        background-color: #0dcaf0; /* Màu xanh nhạt */
        color: #0a53be; /* Màu chữ đen */
    }

    .bg-lightyellow {
        background-color: #8fdf82; /* Màu xanh nhạt */
        color: #d0512e; /* Màu chữ đen */
    }

    .bg-lightviolet {
        background-color: #dfc2c4; /* Màu xanh nhạt */
        color: #20b426; /* Màu chữ đen */
    }

    .bg-lightgreen {
        background-color: #5a8dee; /* Màu xanh nhạt */
        color: #6f42c1; /* Màu chữ đen */
    }
</style>
<body>

<h1 style="text-align: center">QUẢN LÝ KHUYẾN MẠI CHI TIẾT</h1>
<table class="table">
    <thead>
    <tr>

        <th>ID</th>
        <th>Mã Khuyến Mại Chi Tiết</th>
        <th>Hình Thức Giảm</th>
        <th>Giá Trị Giảm</th>
        <th>Sản Phẩm</th>
        <th>Khuyến Mại</th>
        <%--        <th>Ngày bắt Đầu</th>--%>

        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.content}" var="ctkm" varStatus="i">
        <tr>

            <td>${ctkm.id}</td>
            <td>${ctkm.maChiTietKhuyenMai}</td>
            <td>
                <c:choose>
                    <c:when test="${ctkm.hinhThucGiam == 1}">
                        <span class="badges bg-lightyellow">Giảm theo %</span>
                    </c:when>
                    <c:when test="${ctkm.hinhThucGiam == 0}">
                        <span class="badges bg-lightyellow">Giảm theo thành viên</span>
                    </c:when>
                </c:choose>
            </td>
            <td>${ctkm.giaTriGiam}</td>
            <td>${ctkm.chiTietSP.sanPham.ten}</td>
            <td>${ctkm.khuyenMai.tenKhuyenMai}</td>
                <%--            <td>${ctkm.ngayBatDau}</td>--%>


            <td>
                <button class="btn btn-success"><a href="/admin/chi-tiet-khuyen-mai/view-update/${ctkm.id}"
                                                   style="text-decoration: none;color: #FFFFFF">Update</a></button>
                <button class="btn btn-danger"><a href="/admin/chi-tiet-khuyen-mai/remove/${ctkm.id}"
                                                  style="text-decoration: none;color: #FFFFFF">Remove</a></button>
            </td>


        </tr>
    </c:forEach>
    <button class="btn btn-primary"><a href="/admin/chi-tiet-khuyen-mai/hien-thi-add"
                                       style="text-decoration: none;color: #FFFFFF">ADD</a></button>
    </tbody>
</table>
<nav aria-label="...">
    <ul class="pagination" style="margin-left: 700px">
        <li class="page-item disabled">
            <a class="page-link" href="/admin/chi-tiet-khuyen-mai/hien-thi?ctkm=0">Previous</a>
        </li>
        <li class="page-item"><a class="page-link"
                                 href="/admin/chi-tiet-khuyen-mai/hien-thi?ctkm=${page.number-1}"><<<</a>
        </li>
        <li class="page-item"><a class="page-link"
                                 href="/admin/chi-tiet-khuyen-mai/hien-thi?ctkm=${page.number+1}">>>></a>
        <li class="page-item">
            <a class="page-link" href="/admin/chi-tiet-khuyen-mai/hien-thi?ctkm=${page.totalPages+1}">Next</a>
        </li>
    </ul>
</nav>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
