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
        background-color: orange;
    }
    .table tbody tr:hover {
        cursor: pointer;
    }
</style>
<body>
<div style="display: flex">
    <div>
        <jsp:include page="../admin/index.jsp"/>
    </div>
    <div style="margin-left: 300px;margin-top: 100px">
        <h1 style="text-align: center;color: black">QUẢN LÝ KHUYẾN MẠI</h1>
        <table style="width: 1000px">
            <thead>
            <tr>
                <th>STT</th>
                <th>ID</th>
                <th>Mã Khuyến Mại</th>
                <th>Tên Khuyến Mại</th>
                <%--        <th>Giá Trị</th>--%>
                <th>Ngày Tạo</th>
                <th>Ngày Kết Thúc</th>
                <th>Ngày Cập Nhật</th>
                <th>Trạng Thái</th>
                <th colspan="2">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${load}" var="km" varStatus="i">
                <tr>
                    <td>${i.index+1}</td>
                    <td>${km.id}</td>
                    <td>${km.maKhuyenMai}</td>
                    <td>${km.tenKhuyenMai}</td>
                        <%--            <td>${km.giaTri}</td>--%>
                    <td>${km.ngayTao}</td>
                    <td>${km.ngayKetThuc}</td>
                    <td>${km.ngayCapNhat}</td>
                    <td>
                        <c:choose>
                            <c:when test="${km.trangThai == 1}">
                                <span class="badges bg-lightyellow">Sắp diễn ra</span>
                            </c:when>
                            <c:when test="${km.trangThai == 2}">
                                <span class="badges bg-lightblue">Đang hoạt động</span>
                            </c:when>
                            <c:when test="${km.trangThai == 3}">
                                <span class="badges bg-lightviolet">Ngừng hoạt động</span>
                            </c:when>
                            <c:when test="${km.trangThai == 4}">
                                <span class="badges bg-lightgreen">Hết hạn</span>
                            </c:when>
                        </c:choose>
                    </td>

                    <td>
                        <a href="/admin/khuyen-mai/view-update/${km.id}" style="color: black"> <i
                                class="fa-sharp fa-solid fa-pen-to-square"></i></a>
                        <a href="/admin/khuyen-mai/remove/${km.id}" style="color: black"><i
                                class="fa-solid fa-trash"></i></a>
                    </td>


                </tr>
            </c:forEach>
            <button  class="btn btn-outline-warning"><a href="/khuyen-mai/hien-thi-add"
                                               style="text-decoration: none;color: black"><i
                    class="fa-sharp fa-solid fa-plus"></i> ADD</a></button>
            </tbody>
        </table>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>

