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
        <div id="myDropdown" style="display: none;background-color: #FFFFFF;border-radius: 20px">
            <li class="nav-item admin-menu-hover">
                <a class="nav-link-admin" href="/san-pham/hien-thi" style="color: black;margin-left: 10px">Sản phẩm</a>
            </li>
            <li class="nav-item admin-menu-hover">
                <a class="nav-link-admin" href="/mau-sac/hien-thi" style="color: black;margin-left: 10px">Màu sắc</a>
            </li>
            <li class="nav-item admin-menu-hover">
                <a class="nav-link-admin" href="/kich-co/hien-thi" style="color: black;margin-left: 10px">Kích cỡ</a>
            </li>
            <li class="nav-item admin-menu-hover">
                <a class="nav-link-admin" href="/poly360boutique/chat-lieu/hien-thi" style="color: black;margin-left: 10px">Chất
                    liệu</a>
            </li>
            <li class="nav-item admin-menu-hover">
                <a class="nav-link-admin" href="/thuong-hieu/hien-thi" style="color: black;margin-left: 10px">Thương
                    hiệu</a>
            </li>
            <li class="nav-item admin-menu-hover">
                <a class="nav-link-admin" href="/chitietsp/hien-thi" style="color: black;margin-left: 10px">Chi tiết sản
                    phẩm</a>
            </li>
            <li class="nav-item admin-menu-hover">
                <a class="nav-link-admin" href="/hinh-anh/hien-thi" style="color: black;margin-left: 10px">Hình ảnh</a>
            </li>
        </div>
        <li class="nav-item">
            <a class="nav-link-admin" href="#">Bán hàng tại quầy</a>
        </li>
        <li class="nav-item" onclick="myFunction()">
            <div class="nav-link-admin">Quản lý tài khoản</div>
        </li>
        <div id="myPopup" style="display: none;background-color: #FFFFFF;border-radius: 20px">
            <li class="nav-item nav-popup">
                <a class="nav-link-admin" href="/khach-hang/hien-thi" style="color: black;margin-left: 20px">Khách hàng</a>
            </li>
            <li class="nav-item nav-popup">
                <a class="nav-link-admin" href="/nhan-vien/hien-thi" style="color: black;margin-left: 20px">Nhân viên</a>
            </li>
        </div>
        <li class="nav-item">
            <a class="nav-link-admin" href="/hoa-don/hien-thi">Quản lý hóa đơn</a>
        </li>
        <li class="nav-item" onclick="myKhuyenMai()">
            <div class="nav-link-admin">Quản lý khuyến mãi</div>
        </li>
        <div id="myKhuyenMai" style="display: none;background-color: #FFFFFF;border-radius: 20px">
            <li class="nav-item">
                <a class="nav-link-admin" href="/khuyen-mai/hien-thi" style="color: black;margin-left: 20px">Khuyến Mại</a>
            </li>
            <li class="nav-item">
                <a class="nav-link-admin" href="/chi-tiet-khuyen-mai/hien-thi" style="color: black;margin-left: 20px">Khuyến Mại Chi Tiết</a>
            </li>
        </div>
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
        popup.classList.toggle("ht");

    }

    function myDrowDown() {
        var dropDown = document.getElementById("myDropdown");
        dropDown.classList.toggle("show");
    }
    function myKhuyenMai() {
        var khuyenMai = document.getElementById("myKhuyenMai");
        khuyenMai.classList.toggle("show");
    }
</script>
<style>
    .ht{
        display: flex !important;
        flex-direction: column;
        gap: 10px;
        cursor: pointer;
    }
    .show {
        display: flex !important;
        flex-direction: column;
        gap: 10px;
        cursor: pointer;
    }

    .admin-menu-hover:hover {
        background-color: orange;
        width: 100%;
        color: #FFFFFF;
    }
    .nav-popup:hover{
        background-color: orange;
        width: 100%;
        color: #FFFFFF;
    }
</style>
</body>
</html>
