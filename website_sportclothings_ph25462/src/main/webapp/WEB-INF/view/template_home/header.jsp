<link rel="stylesheet" type="text/css" href="../../../css/header.css">
<%@ page pageEncoding="utf-8" %>
<header>
    <div>
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <a style="color: orange;font-family:Arial, Helvetica, sans-serif;margin-top: 10px;text-decoration: none;font-size: 30px"
                   href="/poly360boutique/home">
                    POLY360BOUTIQUE</a>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="/poly360boutique/home"
                               style="color: #2D2D2D">Trang Chủ</a>
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
                            <a class="nav-link" href="#" style="color: #2D2D2D">Chính Sách</a>
                        </li>
                    </ul>
                    <form class="d-flex" role="search" style="gap: 10px;">
                        <input class="search" type="search" placeholder="Tìm kiếm sản phẩm" aria-label="Search"
                               style="height: 40px;margin: unset;">
                        <button type="submit" class="btn btn-outline-warning">Search</button>
                    </form>
                    <div onclick="myFunction()"><i class="far fa-user"
                                                   style="color: #2D2D2D;font-size: 30px;margin-left: 20px;"></i>
                    </div>
                    <div class="popuptext" id="myPopup">
                        <a href="/poly360boutique/dang-nhap">Đăng nhập</a>
                        <a>Đăng xuất</a>
                    </div>
                    <div class="dropdown">
                        <i id="cartIcon" class="fa-sharp fa-regular fa-cart-shopping"
                           style="color: #2D2D2D; margin-right: 20px;margin-left: 20px;font-size: 30px"></i>
                        <div class="dropdown-menu" aria-labelledby="cartIcon" id="cartDropdown">
                            <h3>Giỏ hàng</h3>
                            <ul id="cartItems"></ul>
                        </div>
                    </div>

                    <%--                    <div class="span8">--%>
                    <%--                        <div class="account pull-right">--%>
                    <%--                            <ul class="user-menu">--%>
                    <%--                                &lt;%&ndash;                                <li><a href="<c:url value='/cart/view' />">Your Cart <b>(<span&ndash;%&gt;--%>
                    <%--                                &lt;%&ndash;                                        id="countTotal">${sessionScope.cart == null ? '0' : sessionScope.cart.tongsl}</span>)</b></a>&ndash;%&gt;--%>
                    <%--                                &lt;%&ndash;                                </li>&ndash;%&gt;--%>
                    <%--                                <c:if test="${empty sessionScope.taikhoan}">--%>
                    <%--                                    <li><a href="/poly360boutique/dang-nhap">Login</a></li>--%>
                    <%--                                </c:if>--%>
                    <%--                                <c:if test="${not empty sessionScope.taikhoan}">--%>
                    <%--                                    <li><a href="/poly360boutique/logout">Logout</a></li>--%>
                    <%--                                    <li><i>Welcome,</i> <b>${sessionScope.taikhoan.tenTK}</b></li>--%>
                    <%--                                </c:if>--%>
                    <%--                            </ul>--%>
                    <%--                        </div>--%>
                    <%--                    </div>--%>


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
<script src="../../../js/cart.js">

</script>
<style>
    .show {
        display: flex !important;
        flex-direction: column;
        position: relative;
        top: 65px;
        width: 0;
        right: 80px;
        gap: 0px;
    }

    .show button {
        width: 150px;
    }
</style>
