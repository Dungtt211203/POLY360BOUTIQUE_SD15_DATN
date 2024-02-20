<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Update chuc vu</title>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary p-0">
    <div class="navbar-nav collapse navbar-collapse">
        <a class="nav-item nav-link" href="/cua-hang/hien-thi">Quản lý cửa hàng</a>
        <a class="nav-item nav-link" href="/san-pham/hien-thi">Quản lý sản phẩm</a>
        <a class="nav-item nav-link" href="/chuc-vu/hien-thi">Quản lý Chức vụ</a>
        <a class="nav-item nav-link" href="/mau-sac/hien-thi">Quản lý màu sắc</a>
        <a class="nav-item nav-link" href="/nxs/hien-thi">Quản lý nxs</a>
        <a class="nav-item nav-link" href="/dongsp/hien-thi">Quản lý Dòng SP</a>
        <a class="nav-item nav-link" href="/nhan-vien/hien-thi">Quản lý Nhân viên</a>
        <a class="nav-item nav-link" href="/khach-hang/hien-thi">Quản lý Khách hàng</a>
        <a class="nav-item nav-link" href="/chitietsp/hien-thi">Chi Tiết Sản Phẩm</a>

    </div>
</nav>
<form:form method="post" action="/chitietsp/update/${chitietsp.id}" modelAttribute="sp">
    Ten: <form:select path="sanPham">
    <form:options items="${sanPham}" itemLabel="ma"/>
</form:select><br>
    NSX: <form:select path="nsx">
    <form:options items="${Nsx}" itemLabel="ma"/>
</form:select><br>
    Mau Sac: <form:select path="mauSac">
    <form:options items="${mauSac}" itemLabel="ma"/>
</form:select><br>
    Dong Sp: <form:select path="dongSanPham">
    <form:options items="${dongSanPham}" itemLabel="ma"/>
</form:select><br>
    Nam BH:<form:input path="namBH"/><br>
    Mo ta:<form:input path="moTa"/><br>
    So Luong Ton:<form:input path="soLuongTon"/><br>
    Gia Nhap:<form:input path="giaNhap"/><br>
    Gia Ban:<form:input path="giaBan"/><br>
    <form:button class="btn btn-success" >Update</form:button>
</form:form>
</form>
</body>
</html>