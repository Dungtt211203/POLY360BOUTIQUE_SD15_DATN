<link rel="stylesheet"  type="text/css" href="../../../css/header.css">
<%@ page pageEncoding="utf-8" %>
<header>
    <div>
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <h3 style="color: orange;font-family:Arial, Helvetica, sans-serif;margin-top: 10px;">
                    POLY360BOUTIQUE</h3>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#" style="color: #2D2D2D">Trang Chủ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#"style="color: #2D2D2D">Thương Hiệu
                                <div class="dropdown-content">
                                    <a href="/poly360boutique/thuong-hieu-nike">Nike</a>
                                    <a href="/poly360boutique/thuong-hieu-nike">Adidas</a>
                                    <a href="/poly360boutique/thuong-hieu-nike">Li-ning</a>
                                </div>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#" style="color: #2D2D2D">Sản Phẩm</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#" style="color: #2D2D2D">Chính Sách</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#" style="color: #2D2D2D">Giới Thiệu</a>
                        </li>
                    </ul>
                    <form class="d-flex" role="search" style="gap: 10px;">
                        <input class="search" type="search" placeholder="Tìm kiếm sản phẩm" aria-label="Search"
                               style="height: 40px;margin: unset;">
                        <button type="submit" class="btn btn-outline-warning">Search</button>
                    </form>
                    <div onclick="myFunction()"><i class="far fa-user"
                                  style="color: #2D2D2D;font-size: 30px;margin-left: 20px;"></i></div>
                    <div class="popuptext" id="myPopup" style="display: none">
                        <button>Đăng nhập</button>
                        <button>Đăng xuất</button>
                    </div>
                    <a href=""> <i class="fa-sharp fa-regular fa-cart-shopping"
                                                         style="color: #2D2D2D; margin-right: 20px;margin-left: 20px;font-size: 30px"></i></a>
                </div>
            </div>
        </nav>
    </div>
</header>
<script>
    function myFunction() {
        var popup = document.getElementById("myPopup");
        popup.classList.toggle("show");
    }
</script>
<style>
    .show{
        display: flex!important;
        flex-direction: column;
        position: relative;
        top: 65px;
        width: 0;
        right: 80px;
        gap: 10px;
    }
    .show button{
        width: 150px;
    }
</style>
