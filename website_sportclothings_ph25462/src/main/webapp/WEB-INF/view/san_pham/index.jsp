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
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/all.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/sharp-thin.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/sharp-solid.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/sharp-regular.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/sharp-light.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<h1 style="text-align: center">QUẢN LÝ SẢN PHẨM</h1>
<table class="ui celled table" style="width: 1000px;margin-top: 50px">
    <thead>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Mã Sản Phẩm</th>
        <th>Tên Sản Phẩm</th>
        <th>Gíá Sản Phẩm</th>
        <th>Mô Tả</th>
        <%--        <th>Ngày Tạo</th>--%>
        <%--        <th>Người Tạo</th>--%>
        <th>Trạng Thái</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${load}" var="sp" varStatus="i">
        <tr>
            <td>${i.index+1}</td>
            <td>${sp.id}</td>
            <td>${sp.ma}</td>
            <td>${sp.ten}</td>
            <td>${sp.gia}</td>
            <td>${sp.moTa}</td>
                <%--            <td>${sp.ngayTao}</td>--%>
                <%--            <td>${sp.nguoiTao}</td>--%>
            <td>${sp.tt==0?"Hoạt Động":"Không Hoạt Động"}</td>
            <td>
                <a href="/san-pham/view-update/${sp.id}" style="color: black"> <i
                        class="fa-sharp fa-solid fa-pen-to-square"></i></a>
                <a href="/san-pham/remove/${sp.id}" style="color: black"><i class="fa-solid fa-trash"></i></a>
            </td>
        </tr>
    </c:forEach>
    <button type="button" class="btn btn-primary" style="width: 100px;"><a href="/san-pham/hien-thi-add"
                                                                          style="color: #FFFFFF;text-decoration: none"><i
            class="fa-sharp fa-solid fa-plus"></i>ADD</a></button>


    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
