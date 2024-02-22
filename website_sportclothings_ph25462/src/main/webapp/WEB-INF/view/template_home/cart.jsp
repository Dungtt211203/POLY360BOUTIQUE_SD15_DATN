<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8"--%>
<%--         pageEncoding="UTF-8" session="true" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

<!DOCTYPE html>
<!-- Created By CodingNepal - www.codingnepalweb.com -->
<html lang="en" dir="ltr">
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

<%--<div class="wrapper">--%>

<%--      product 1--%>
<%--    <div class="card">--%>
<%--        <img src="../../../img/sp01ao.png" alt="">--%>
<%--        <div class="content">--%>
<%--            <div class="row">--%>


<c:forEach items="${hienthihinh.content}" var="hienthihinh">
    <c:forEach items="${hienthi.content}" var="hienthi">
        <div class="col-3 mt-3">
            <div class="card">
                <img src="/img/${hienthihinh.linkAnh}" class="card-img-top" alt=""
                     style="width: 319px; height: 319px">
                    <%--                <img src="/img/${hienthis.img}" class="card-img-top"--%>
                    <%--
                                                        style="width: 319px; height: 319px">--%>
                <div class="card-body">
                    <h5 class="card-title">${hienthihinh.sanPham.ten}</h5>

                </div>

                <ul class="list-group list-group-flush">
                    <li class="list-group-item"> ${hienthi.sanPham.moTa }</li>
                    <li class="list-group-item">Gía tiền: ${hienthi.gia }

                            <%--                <fmt:formatNumber--%>
                            <%--                    pattern="###,### VNĐ"> --%>
                            <%--                </fmt:formatNumber> /bộ--%>

                    </li>
                </ul>
                <div class="card-body">
                    <div>
                        <a href="" class="btn btn-primary">Thêm vào giỏ hàng </a>
                    </div>
                    <div>
                        <a href="" class="btn btn-secondary">Xem chi tiết </a>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</c:forEach>

<nav aria-label="Page navigation example">
    <ul class="pagination">

        <c:forEach begin="0" end="${hienthi.totalPages - 1}" varStatus="loop">
            <li class="page-item"><a class="page-link" href="/home?page=${loop.index}">${loop.index+1}</a>
            </li>
        </c:forEach>

    </ul>
</nav>

<script src="src/main/webapp/js/cart.js"></script>
</body>
</html>
