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
    <div class="col-3 mt-3">
        <div class="card">
            <div id="cartItems">

                <img src="" class="card-img-top mx-auto d-block"
                     alt="" style="min-width: 319px; min-height: 319px"> ${detail.url}

                <div class="card-body">
                    <h5 class="card-title">${detail.sanPham.ten}</h5>
                </div>

                <ul class="list-group list-group-flush">

                    <li class="list-group-item">Gía tiền:${detail.sanPham.gia}
                        <fmt:formatNumber
                                pattern="###,### VNĐ">
                        </fmt:formatNumber>
                    </li>

                    <li class="list-group-item">Mô tả: ${detail.sanPham.moTa }
                    </li>
                </ul>

            </div>
        </div>
    </div>
</div>
</div>

<script src="src/main/webapp/js/cart.js"></script>
</body>
</html>
