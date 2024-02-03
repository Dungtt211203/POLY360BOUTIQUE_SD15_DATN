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
</head>
<body>
<table>
    <thead>
    <tr>
        <th>#</th>
        <th>MaPhieu</th>
        <th>TenPhieu</th>
        <th>NgayBatDau</th>
        <th>NgayKetThuc</th>
        <th>TrangThai</th>
        <th>TenKhachHang</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${load}" var="ms" varStatus="i">
        <tr>
            <td>${i.index+1}</td>
            <td>${ms.id}</td>
            <td>${ms.ten}</td>
            <td>${ms.ngayTao}</td>
            <td>${ms.ngaySua}</td>
            <td>${ms.tt}</td>
            <td>
                <button><a href="/ms/detail/${ms.id}">Detail</a></button>
                <button><a href="/ms/remove/${ms.id}">Remove</a></button>
            </td>


        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
