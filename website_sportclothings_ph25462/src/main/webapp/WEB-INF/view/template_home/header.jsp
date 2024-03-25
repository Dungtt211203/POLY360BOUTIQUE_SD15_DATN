<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="../../../css/header.css">
<%@ page pageEncoding="utf-8" %>
<header>

    <div>
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <a style="color: orange;font-family:Arial, Helvetica, sans-serif;margin-top: 10px;text-decoration: none;font-size: 30px"
                   href="/poly360boutique/home">
                    POLY360BOUTIQUE</a>
                <div class="collapse navbar-collapse" id="navbarSupportedContent" style="margin-left: 200px">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 d-flex justify-content-center">
                        <li class="nav-item">
                            <a class="nav-link active" id="homepage" aria-current="page"
                               href="/poly360boutique/home" style="color: #2D2D2D">Trang Chủ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#" style="color: #2D2D2D" onclick="toggleNavbar()">Thương Hiệu</a>
                            <div class="dropdown-content" style="display: none;">
                                <a href="/poly360boutique/thuong-hieu-nike">Nike</a>
                                <a href="/poly360boutique/thuong-hieu-nike">Adidas</a>
                                <a href="/poly360boutique/thuong-hieu-nike">Li-ning</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#" style="color: #2D2D2D">Sản Phẩm</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link fw-bold menu_hover" href="/poly360boutique/chinh-sach"
                               style="font-weight: 400 !important;color: #2D2D2D" id="chinhsach">Chính Sách</a>
                        </li>
                    </ul>
                    <form class="d-flex" role="search" style="gap: 10px;">
                        <input class="search" type="search" placeholder="Tìm kiếm sản phẩm" aria-label="Tìm kiếm"
                               style="height: 40px;margin: unset;" id="searchInput">
                        <button type="submit" class="btn btn-outline-warning" onclick="searchProducts()">Tìm kiếm</button>
                    </form>
                    <div onmouseover="myFunction()"><i class="fa-solid fa-user"
                                                       style="color: #2D2D2D;font-size: 30px;margin-left: 20px;"></i>
                    </div>
                    <div>${principal.tenTK}</div>
                    <div class="popuptext" id="myPopup">
                        <c:choose>
                            <c:when test="${empty principal}">
                                <ul class="nav-dropdown nav-submenu"
                                    style="margin: unset;padding: unset;list-style: none;">
                                    <li><a href="/login"
                                           style="background-color: black;color: WHITE;display: flex;justify-content: center;list-style: none">Đăng
                                        nhập</a></li>
                                    <li><a href="/dang-ky"
                                           style="display: flex;align-items: center;justify-content: center;border: 1px solid;margin-top: 15px;list-style: none">Đăng
                                        ký</a></li>
                                </ul>
                            </c:when>
                            <c:otherwise>
                                <ul class="nav-dropdown nav-submenu">
                                    <li><a href="/donHang/getAll" class="black-button"
                                           style="color: #ffffff;text-align: center">Thông tin đơn hàng</a></li>
                                    <li><a href="/logout" style="text-align: center">Đăng xuất</a></li>
                                </ul>
                            </c:otherwise>
                        </c:choose>
                    </div>

                    <div class="dropdown">
                        <i id="cartIcon" class="fa-sharp fa-regular fa-cart-shopping"
                           style="color: #2D2D2D; margin-right: 20px;margin-left: 20px;font-size: 30px"></i>
                        <div class="dropdown-menu" aria-labelledby="cartIcon" id="cartDropdown" style="overflow: auto">

                            <c:if test="${empty carts}">
                                <img src="https://salanest.com/img/empty-cart.webp" height="250px" width="300px">
                            </c:if>

                            <c:forEach var="gioHangChiTiet" items="${carts}">
                                <table class="cart-table">
                                    <tr>
                                        <td colspan="2">
                                            <h5>${gioHangChiTiet.chiTietSanPham.sanPham.ten}</h5>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <img src="../../../img/imgsanpham/${gioHangChiTiet.chiTietSanPham.sanPham.hinhNen}"
                                                 style="width: 100px; height: 100px"/>
                                        </td>
                                        <td>
                                            <div class="col">
                                                <h6><span>Giá: ${gioHangChiTiet.chiTietSanPham.giaHienHanh}.đ</span>
                                                </h6>
                                                <h6><span>Màu: ${gioHangChiTiet.chiTietSanPham.mauSac.ten}</span></h6>
                                                <h6><span>Size: ${gioHangChiTiet.chiTietSanPham.kichCo.ten}</span></h6>
                                                <h6><span>Số Lượng: ${gioHangChiTiet.soLuong}</span></h6>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <div class="cart-buttons">
                                                <a href="/checkout/show" class="btn buy-btn">Buy Now</a>
                                                <a href="/gio-hang" class="btn cart-btn">Chỉnh Sửa</a>
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                            </c:forEach>
                        </div>

                        <%-- <div class="popuptext" id="myPopup1">--%>
                        <%-- <a href="/poly360boutique/dang-nhap">Đăng nhập</a>--%>
                        <%-- <a>Đăng xuất</a>--%>
                        <%-- </div>--%>
                    </div>
                    <%-- <div class="span8">--%>
                    <%-- <div class="account pull-right">--%>
                    <%-- <ul class="user-menu">--%>
                    <%-- &lt;%&ndash; <li><a href="<c:url value='/cart/view' />">Your Cart
                            <b>(<span&ndash;%&gt;--%>
                    <%-- &lt;%&ndash; id="countTotal">${sessionScope.cart == null ?
                        '0' :
                        sessionScope.cart.tongsl}</span>)</b></a>&ndash;%&gt;--%>
                    <%-- &lt;%&ndash; </li>&ndash;%&gt;--%>
                    <%-- <c:if test="${empty sessionScope.taikhoan}">--%>
                    <%-- <li><a href="/poly360boutique/dang-nhap">Login</a></li>--%>
                    <%-- </c:if>--%>
                    <%-- <c:if test="${not empty sessionScope.taikhoan}">--%>
                    <%-- <li><a href="/poly360boutique/logout">Logout</a>
                        </li>--%>
                    <%-- <li><i>Welcome,</i>
                        <b>${sessionScope.taikhoan.tenTK}</b></li>--%>
                    <%-- </c:if>--%>
                    <%-- </ul>--%>
                    <%-- </div>--%>
                    <%-- </div>--%>
                </div>
            </div>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"
                    onclick="toggleNavbar()">
                <span class="navbar-toggler-icon"></span>
            </button>
        </nav>
    </div>
</header>
<script>
    function myFunction() {
        var popup = document.getElementById("myPopup");
        popup.classList.toggle("show");
    }

    function myFunction1() {
        var popup = document.getElementById("myPopup1");
        popup.classList.toggle("show");
    }

    const link = document.querySelector('.nav-link');

    link.addEventListener('click', function (event) {
        event.preventDefault(); // Prevent the default link behavior
        const url = this.getAttribute('href');
        window.location.href = url; // Redirect to the specified URL
    });

    function toggleNavbar() {
        var dropdownContent = document.querySelector('.dropdown-content');
        if (dropdownContent.style.display === 'block') {
            dropdownContent.style.display = 'none';
        } else {
            dropdownContent.style.display = 'block';
        }
    }
    // Lấy giá trị từ ô nhập liệu
    var searchText = document.getElementById('searchInput').value.toLowerCase();

    // Lấy danh sách sản phẩm
    var productList = document.getElementById('productList').getElementsByTagName('li');

    // Lặp qua danh sách sản phẩm và ẩn/hiện sản phẩm phù hợp
    for (var i = 0; i < productList.length; i++) {
        var productName = productList[i].textContent.toLowerCase();
        if (productName.indexOf(searchText) > -1) {
            // Nếu tên sản phẩm chứa từ khóa tìm kiếm, hiện sản phẩm
            productList[i].style.display = '';
        } else {
            // Nếu không, ẩn sản phẩm
            productList[i].style.display = 'none';
        }
    }
</script>
<script src="../../../js/cart.js"></script>
<style>
    a.nav-link.active {
        border-bottom: 4px solid #ffc107;
    }

    .show {
        display: flex !important;
        flex-direction: column;
        position: absolute;
        top: 129px;
        width: 0;
        right: 80px;
        gap: 0px;
    }

    .show button {
        width: 150px;
    }

    a:hover {
        color: orange;
    }

    /* Định dạng danh sách ul */
    .nav-dropdown {
        list-style-type: none; /* Ẩn điểm liệt kê */
        padding: 0;
        margin: 0;
    }

    /* Định dạng mỗi mục trong danh sách */
    .nav-dropdown li {
        padding: 8px 0; /* Khoảng cách giữa các mục */
    }

    /* Định dạng liên kết */
    .nav-dropdown li a {
        text-decoration: none; /* Ẩn gạch chân của liên kết */
        color: #333; /* Màu văn bản */
        display: block; /* Hiển thị liên kết dưới dạng khối */
        padding: 5px 10px; /* Khoảng cách giữa các đường viền */
    }

    /* Hover hiển thị */
    .nav-dropdown li a:hover {
        background-color: #f2f2f2; /* Màu nền khi di chuột vào */
    }

    /* Phần tử con của danh sách con */
    .nav-dropdown .nav-submenu li {
        padding-left: 20px; /* Thụt lề bên trái cho phần tử con */
    }

    /* Định dạng nút màu đen */
    .black-button {
        background-color: #000;
        padding: 10px 20px; /* Kích thước padding */
        border: none; /* Ẩn viền */
        border-radius: 10px; /* Bo tròn góc */
        cursor: pointer; /* Biến con trỏ thành dấu nhấp chuột */
        text-decoration: none; /* Ẩn gạch chân */
        height: 50px;
    }

    /* Hover hiển thị */
    .black-button:hover {
        background-color: #333; /* Màu nền khi di chuột vào */
    }

    .cart-table {
        width: 100%;
        border-collapse: collapse;
        border: 1px solid #ddd;
        margin-bottom: 20px;
    }

    .cart-table th, .cart-table td {
        padding: 12px;
        text-align: left;
    }

    .cart-table th {
        background-color: #f2f2f2;
        color: #333;
        border-bottom: 2px solid #ddd;
    }

    .cart-table td {
        border-bottom: 1px solid #ddd;
    }

    .cart-table tr:last-child td {
        border-bottom: none;
    }

    .cart-table tbody tr:hover {
        background-color: #f9f9f9;
    }

    .cart-buttons {
        display: flex;
        justify-content: space-between;
    }

    @media only screen and (max-width: 600px) {
        body {
            background-color: #ffffff;
        }
    }

    /* Hiển thị menu khi nút được nhấn */
    @media (max-width: 768px) {
        .navbar-collapse {
            display: none;
        }

        .navbar-collapse.show {
            display: block;
        }
    }


</style>
