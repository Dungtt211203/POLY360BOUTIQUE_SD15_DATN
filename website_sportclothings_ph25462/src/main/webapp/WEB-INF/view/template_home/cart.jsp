<!DOCTYPE html>

<html lang="en" dir="ltr">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous">


<head>
    <meta charset="utf-8">
    <title>Product Card Poly360Boutique</title>
    <link rel="stylesheet" href="../../../css/cart.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link rel="icon" href="../../../svg/logohome.svg">
</head>
<style>
    .giaBan {
        font-weight: bold;
    }
    .giaGoc{
        text-decoration-line: line-through;
    }

    .btn-muangay {
        width: 150px;
        margin-top: 50px;
        font-size: 15px;
    }

    .btn-giohang {
        width: 250px;
        margin-left: 80px;
        margin-top: 50px;
        font-size: 15px;
    }

    .button-container {
        margin-left: 20px;

    }
    .elis_rty{
        font-size: 25px;
    }
</style>
<body>


<div class="row">
    <c:forEach items="${hienthi.content}" var="hienthis">
        <div class="col-3 mt-3 col-12 col-sm-6 col-md-4 col-lg-3">
            <div class="card">
                <div id="cartItems">
                    <a href="/poly360boutique/san-pham/detail/${hienthis.id}">
                        <img src="/img/imgsanpham/${hienthis.hinhNen}"
                             class="card-img-top mx-auto d-block" alt=""
                             style="min-width: 319px; min-height: 319px"></a>
                    <div class="card-body" id="productList">
                        <h5 class="card-title">${hienthis.ten}</h5>
                    </div>
                    <ul class="list-group list-group-flush">
                        <div class="elis_rty">
                            <span class="giaGoc text-muted ft-medium line-through mr-2"
                                  id="${hienthis.id}">Giá Gốc</span>
                            <span class="giaBan ft-bold theme-cl fs-md" id="${hienthis.id}">Giá Bán</span>
                        </div>
<%--                        <div class="button-container">--%>
<%--                            <button type="button" class="btn btn-outline-warning btn-muangay"><a>Mua ngay</a></button>--%>
<%--                            <button type="button" class="btn btn-outline-dark btn-giohang"><a>Thêm vào giỏ hàng</a>--%>
<%--                            </button>--%>
<%--                        </div>--%>
                        <!-- Import thư viện jQuery (nếu chưa import) -->
                        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

                        <!-- Đoạn mã JavaScript -->
                        <script>
                            $(document).ready(function () {
                                // Lặp qua mỗi sản phẩm
                                $(".giaBan").each(function () {
                                    // Lấy id sản phẩm từ thẻ span
                                    var idSanPham = $(this).attr("id");
                                    console.log("id giá Bán : " + idSanPham)

                                    // Gửi yêu cầu Ajax đến API để lấy giá bán
                                    $.ajax({
                                        type: "GET",
                                        url: "/giaBan/" + idSanPham,
                                        success: function (response) {
                                            // Cập nhật nội dung của thẻ span với giá bán nhận được từ API
                                            $(this).text(response + " đ");
                                        },
                                        error: function (error) {
                                            console.error("Error fetching data: " + error);
                                        },
                                        context: this // Đảm bảo "this" trong success callback là thẻ span đang xử lý
                                    });
                                });

                                // Lặp qua mỗi sản phẩm
                                $(".giaGoc").each(function () {
                                    // Lấy id sản phẩm từ thẻ span
                                    var idSanPham = $(this).attr("id");
                                    console.log("id giá gốc : " + idSanPham)
                                    // Gửi yêu cầu Ajax đến API để lấy giá gốc
                                    $.ajax({
                                        type: "GET",
                                        url: "/giaGoc/" + idSanPham,
                                        success: function (response) {
                                            // Cập nhật nội dung của thẻ span với giá gốc nhận được từ API
                                            $(this).text(response + " đ");
                                        },
                                        error: function (error) {
                                            https://code.jquery.com/jquery-3.6.4.min.jscode.jquery.com/-strong/-heart:>:o:-((:-h

                                                console.error("Error fetching data: " + error);
                                        },
                                        context: this // Đảm bảo "this" trong success callback là thẻ span đang xử lý
                                    });
                                });
                            });
                        </script>


                    </ul>
                </div>

            </div>
        </div>
    </c:forEach>
</div>

<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:if test="${hienthi.totalPages > 0}">
            <c:forEach begin="0" end="${hienthi.totalPages - 1}" varStatus="loop">
                <li class="page-item">
                    <a class="page-link" href="/poly360boutique/home?page=${loop.index}">
                            ${loop.index + 1}
                    </a>
                </li>
            </c:forEach>
        </c:if>
    </ul>
</nav>

</div>


</div>

<script src="src/main/webapp/js/cart.js"></script>
</body>

</html>
