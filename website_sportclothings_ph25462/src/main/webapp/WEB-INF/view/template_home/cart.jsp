<!DOCTYPE html>

<html lang="en" dir="ltr">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">


<head>
    <meta charset="utf-8">
    <title>Product Card Poly360Boutique</title>
    <link rel="stylesheet" href="../../../css/cart.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link rel="icon" href="../../../svg/logohome.svg">
</head>
<body>

<div id="top-bar" class="container">
    <%--    <div class="row">--%>
    <%--        &lt;%&ndash;        <div class="span4">&ndash;%&gt;--%>
    <%--        &lt;%&ndash;&lt;%&ndash;            <form method="POST" class="search_form">&ndash;%&gt;&ndash;%&gt;--%>
    <%--        &lt;%&ndash;&lt;%&ndash;                <input type="text" class="input-block-level search-query" Placeholder="eg. T-sirt">&ndash;%&gt;&ndash;%&gt;--%>
    <%--        &lt;%&ndash;&lt;%&ndash;            </form>&ndash;%&gt;&ndash;%&gt;--%>
    <%--        &lt;%&ndash;        </div>&ndash;%&gt;--%>

    <%--        <div class="span8">--%>
    <%--            <div class="account pull-right">--%>
    <%--                <ul class="user-menu">--%>
    <%--                    &lt;%&ndash;                    <li><a href="<c:url value='/cart/view' />">Your Cart <b>(<span&ndash;%&gt;--%>
    <%--                    &lt;%&ndash;                            id="countTotal">${sessionScope.cart == null ? '0' : sessionScope.cart.tongsl}</span>)</b></a>&ndash;%&gt;--%>
    <%--                    &lt;%&ndash;                    </li>&ndash;%&gt;--%>
    <%--                    <c:if test="${empty sessionScope.user}">--%>
    <%--                        <li><a href="/poly360boutique/dang-nhap">Login</a></li>--%>
    <%--                    </c:if>--%>
    <%--                    <c:if test="${not empty sessionScope.user}">--%>
    <%--                        <li><a href="/poly360boutique/logout">Logout</a></li>--%>
    <%--                        <li><i>Welcome,</i> <b>${sessionScope.user.username}</b></li>--%>
    <%--                    </c:if>--%>
    <%--                </ul>--%>
    <%--            </div>--%>
    <%--        </div>--%>
    <%--    </div>--%>
    <%--</div>--%>


    <div class="row">
        <c:forEach items="${hienthi.content}" var="hienthis">
            <div class="col-3 mt-3">
                <div class="card">
                    <div id="cartItems">
                        <img src="/img/${hienthis.url}" class="card-img-top mx-auto d-block" alt=""
                             style="min-width: 319px; min-height: 319px">
                        <div class="card-body">
                            <h5 class="card-title">${hienthis.sanPham.ten}</h5>
                        </div>
                        <ul class="list-group list-group-flush">
                                <%--                        <li class="list-group-item"> ${hienthis.sanPham.moTa }</li>--%>
                                <%--<<<<<<< HEAD--%>
                            <li class="list-group-item">Gía tiền: ${hienthis.sanPham.gia }
                                    <%--                        <fmt:formatNumber--%>
                                    <%--                                pattern="###,### VNĐ">--%>
                                    <%--                        </fmt:formatNumber>--%>
                            </li>
                        </ul>

                        <!-- Các sản phẩm trong giỏ hàng sẽ được thêm vào đây -->
                    </div>
                    <div class="button-container">
                        <button class="btn1" style="background-color: whitesmoke; color: orange">Xem chi
                            tiết
                        </button>
                        <button class="btn1" style="background-color: orange;color: #FFFFFF"
                                onclick="addToCart()">Thêm vào
                            giỏ hàng
                        </button>
                    </div>

                </div>
            </div>
        </c:forEach>
    </div>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <c:forEach begin="0" end="${hienthi.totalPages - 1}" varStatus="loop">
                <li class="page-item"><a class="page-link"
                                         href="/poly360boutique/home?page=${loop.index}">${loop.index+1}</a>
                </li>
            </c:forEach>
        </ul>
    </nav>

</div>
<script src="src/main/webapp/js/cart.js"></script>
</body>
</html>
