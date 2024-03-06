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


<div class="row">
    <c:forEach items="${hienthi.content}" var="hienthis">
        <div class="col-3 mt-3">
            <div class="card">
                <div id="cartItems">

                    <a href="/poly360boutique/san-pham/detail/${hienthis.id}">
                        <img src="/img/${hienthis.url}" class="card-img-top mx-auto d-block"
                             alt="" style="min-width: 319px; min-height: 319px"></a>
                    <div class="card-body">
                        <h5 class="card-title">${hienthis.sanPham.ten}</h5>
                    </div>
                    <ul class="list-group list-group-flush">

                        <li class="list-group-item">Gía tiền: ${hienthis.sanPham.gia }
                                <%--                        <fmt:formatNumber--%>
                                <%--                                pattern="###,### VNĐ">--%>
                                <%--                        </fmt:formatNumber>--%>
                        </li>
                    </ul>

                </div>

            </div>
        </div>
    </c:forEach>
</div>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:forEach begin="0" end="${hienthi.totalPages -1}" varStatus="loop">
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
