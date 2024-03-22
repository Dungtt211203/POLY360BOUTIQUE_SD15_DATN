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
                            <a class="nav-link" href="#" style="color: #2D2D2D">Thương Hiệu
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
                            <a class="nav-link fw-bold menu_hover" href="/poly360boutique/chinh-sach"
                               style="font-weight: 400 !important;color: #2D2D2D" id="chinhsach">Chính Sách</a>
                        </li>
                    </ul>
                    <form class="d-flex" role="search" style="gap: 10px;">
                        <input class="search" type="search" placeholder="Tìm kiếm sản phẩm" aria-label="Search"
                               style="height: 40px;margin: unset;">
                        <button type="submit" class="btn btn-outline-warning">Search</button>
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
                                    <li><a href="/donHang/getAll">Thông tin đơn hàng</a></li>
                                    <li><a href="/logout">Đăng xuất</a></li>
                                </ul>
                            </c:otherwise>
                        </c:choose>
                    </div>

                    <div class="dropdown">
                        <i id="cartIcon" class="fa-sharp fa-regular fa-cart-shopping"
                           style="color: #2D2D2D; margin-right: 20px;margin-left: 20px;font-size: 30px"></i>
                        <div class="dropdown-menu" aria-labelledby="cartIcon" id="cartDropdown">

                            <c:if test="${empty carts}">
                                <img src="https://salanest.com/img/empty-cart.webp" height="250px"
                                     width="300px">
                            </c:if>

                            <c:forEach var="gioHangChiTiet" items="${carts}">


                                <ul id="cartItems">
                                    <h5> ${gioHangChiTiet.chiTietSanPham.sanPham.ten}</h5>
                                </ul>

                                <div class="col">
                                    <h6><span>Gia: ${gioHangChiTiet.chiTietSanPham.giaGoc}.đ</span></h6>
                                    <h6><span>Màu: ${gioHangChiTiet.chiTietSanPham.mauSac.ten}</span></h6>
                                    <h6><span>Size: ${gioHangChiTiet.chiTietSanPham.kichCo.ten}</span></h6>
                                    <h6><span><img src="../../../img/imgsanpham/${gioHangChiTiet.chiTietSanPham.sanPham.hinhNen}" style="width: 100px;height: 100px"/> </span></h6>
                                    <h6><span>Số Lượng: ${gioHangChiTiet.soLuong}</span></h6>
                                </div>

                                <a href="/checkout/show" class="btn buy-btn">Buy Now</a>
                                <a href="/gio-hang" class="btn cart-btn">Chỉnh Sửa</a>
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
</script>
<script src="../../../js/cart.js">

</script>
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
</style>
