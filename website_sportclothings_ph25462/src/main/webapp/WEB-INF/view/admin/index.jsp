<!doctype html>
<html lang="en">
<%@ page pageEncoding="utf-8" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>POLY360BOUTIQUE_ADMIN</title>
    <link rel="stylesheet" href="../../../css/admin.css">
    <link href=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" data-purpose="Layout StyleSheet" title="Web Awesome"
          href="/css/app-wa-612dd696ed96d6777d290343ca9cef9d.css?vsn=d">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/all.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/sharp-thin.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/sharp-solid.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/sharp-regular.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/sharp-light.css">
    <link rel="icon" href="../../../svg/logohome.svg">
    <style>
        .image-logo {
            margin-left: 60px;
        }

        h1 {
            color: #FFFFFF;
            font-size: 20px;
            text-align: center;
        }

        .nav-link-admin {
            color: #FFFFFF;
            text-decoration: none;
        }

        .nav-link-admin:hover {
            color: black;
        }

    </style>
</head>
<body>
<aside>
    <img class="image-logo" src="../../../svg/logohome.svg" width="100px" height="100px">
    <h1>POLY360BOUTIQUE</h1>
    <ul class="nav flex-column" style="gap: 20px">
        <li class="nav-item">
            <a class="nav-link-admin" href="#">Trang chủ</a>
        </li>
        <li class="nav-item" onclick="myDrowDown()">
            <div class="nav-link-admin">Quản lý sản phẩm</div>
        </li>
        <div id="myDropdown" style="display: none">
            <li class="nav-item">
                <a class="nav-link-admin" href="/san-pham/hien-thi">Sản phẩm</a>
            </li>
            <li class="nav-item">
                <a class="nav-link-admin" href="/mau-sac/hien-thi">Màu sắc</a>
            </li>
            <li class="nav-item">
                <a class="nav-link-admin" href="/kich-co/hien-thi">Kích cỡ</a>
            </li>
            <li class="nav-item">
                <a class="nav-link-admin" href="/chat-lieu/hien-thi">Chất liệu</a>
            </li>
            <li class="nav-item">
                <a class="nav-link-admin" href="/thuong-hieu/hien-thi">Thương hiệu</a>
            </li>
            <li class="nav-item">
                <a class="nav-link-admin" href="/chitietsp/hien-thi">Chi tiết sản phẩm</a>
            </li>
        </div>

        <li class="nav-item">
            <a class="nav-link-admin" href="#">Bán hàng tại quầy</a>
        </li>
        <li class="nav-item" onclick="myFunction()">
            <div class="nav-link-admin">Quản lý tài khoản</div>
        </li>
        <div id="myPopup" style="display: none">
            <li class="nav-item nav-popup">
                <a class="nav-link-admin" href="/khach-hang/hien-thi">Khách hàng</a>
            </li>
            <li class="nav-item nav-popup">
                <a class="nav-link-admin" href="/nhan-vien/hien-thi">Nhân viên</a>
            </li>
        </div>
        <li class="nav-item">
            <a class="nav-link-admin" href="#">Quản lý hóa đơn</a>
        </li>
        <li class="nav-item">
            <a class="nav-link-admin" href="#">Quản Lý khuyến mãi</a>
        </li>
        <li class="nav-item">
            <a class="nav-link-admin" href="#">Quản lý đổi trả</a>
        </li>
    </ul>
</aside>

<script src=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
<script>
    function myFunction() {
        var popup = document.getElementById("myPopup");
        popup.classList.toggle("show");

    }

    function myDrowDown() {
        var dropDown = document.getElementById("myDropdown");
        dropDown.classList.toggle("show");
    }
</script>
<style>
    .show {
        display: flex !important;
        flex-direction: column;
        gap: 10px;
        cursor: pointer;
    }
</style>
</body>
</html>
