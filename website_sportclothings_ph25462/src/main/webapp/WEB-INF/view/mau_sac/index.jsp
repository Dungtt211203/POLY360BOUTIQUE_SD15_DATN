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
<h1 style="text-align: center">QUẢN LÝ MÀU SẮC</h1>
<table class="table">
    <thead>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Mã Màu Sắc</th>
        <th>Tên Màu Sắc</th>
        <th>Trạng Thái</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${load}" var="ms" varStatus="i">
        <tr>
            <td>${i.index+1}</td>
            <td>${ms.id}</td>
            <td>${ms.ma}</td>
            <td>${ms.ten}</td>
            <td>${ms.tt}</td>
            <td>

                <button class="btn btn-success"><a href="/mau-sac/view-update/${ms.id}" style="text-decoration: none;color: #FFFFFF">Update</a></button>

                <button class="btn btn-success"><a href="/mau-sac/hien-thi-add" style="text-decoration: none;color: #FFFFFF">ADD</a></button>

                <button class="btn btn-danger"><a href="/mau-sac/remove/${ms.id}" style="text-decoration: none;color: #FFFFFF">Remove</a></button>
            </td>
        </tr>

    </c:forEach>
    <button class="btn btn-primary"><a href="/mau-sac/hien-thi-add" style="text-decoration: none;color: #ffffff">ADD</a></button>

    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
