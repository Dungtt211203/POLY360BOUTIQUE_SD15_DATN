<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>POLY360BOUTIQUE</title>
    <link rel="stylesheet" href="../../../css/index.css">
    <link href=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" data-purpose="Layout StyleSheet" title="Web Awesome"
          href="/css/app-wa-612dd696ed96d6777d290343ca9cef9d.css?vsn=d">
    <link rel="stylesheet" href="../../../css/thuong-hieu.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/all.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/sharp-thin.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/sharp-solid.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/sharp-regular.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/sharp-light.css">
    <link rel="icon" href="../../../svg/logohome.svg">


    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>

    <style>
        .badges {
            padding: 5px 10px;
            border-radius: 5px;
            font-size: 14px;
        }

        .bg-lighthuy {
            background-color: #FA0043; /* Màu cam nhạt */
            color: #fff; /* Màu chữ trắng */
        }

        .bg-lightblue {
            background-color: #0dcaf0; /* Màu xanh nhạt */
            color: #fff; /* Màu chữ đen */
        }

        .bg-lightyellow {
            background-color: #f6de42; /* Màu xanh nhạt */
            color: #fff; /* Màu chữ đen */
        }

        .bg-lightviolet {
            background-color: #7353fc; /* Màu xanh nhạt */
            color: #fff; /* Màu chữ đen */
        }

        .bg-lightgreen {
            background-color: #6ef669; /* Màu xanh nhạt */
            color: #fff; /* Màu chữ đen */
        }

        .bg-lightx {
            background-color: #ffc9c9;
            color: #f62222;
        }


    </style>

</head>
<body>
<header>
    <jsp:include page="../template_home/header.jsp"/>
</header>

<div class="ord_list_wrap border mb-4 mfliud">
    <div class="ord_list_head gray d-flex align-items-center justify-content-between px-3 py-3">
        <div class="olh_flex">
            <p class="m-0 p-0"><span class="text-muted">Mã Đơn Hàng</span></p>
            <h6 class="mb-0 ft-medium"></h6>
        </div>
        <div class="olh_flex">
            <div>Xem Chi Tiết</div>
        </div>
    </div>

    <!-- ==================================================-->

    <div class="ord_list_body text-left">
        <!-- First Product -->
        <c:forEach var="donHang" items="${donHangList}">
            <div class="row align-items-center justify-content-center m-0 py-4 br-bottom">

                <div class="col-xl-5 col-lg-5 col-md-5 col-12">
                    <div class="cart_single d-flex align-items-start mfliud-bot">
                        <div class="cart_selected_single_thumb">
<%--                            <a href="#"><img src="/" width="75" class="img-fluid rounded" alt=""></a>--%>
                        </div>
                        <div class="cart_single_caption pl-3">

                            <h3 class="product_title fs-sm ft-medium mb-1 lh-1">

                                <a href="/user/orderDetail/${donHang.id}" >${donHang.maHoaDon}</a>
                            </h3>

                        </div>
                    </div>
                </div>
                <div class="col-xl-3 col-lg-3 col-md-3 col-6">
                    <p class="mb-1 p-0"><span class="text-muted">Trạng Thái</span></p>
                    <div class="delv_status">
                        <c:choose>
                            <c:when test="${donHang.trangThai eq 0}">
                                <span class="badges bg-lighthuy">Đã Hủy</span>
                            </c:when>
                            <c:when test="${donHang.trangThai eq 1}">
                                <span class="badges bg-lightgreen">Thành Công</span>
                            </c:when>
                            <c:when test="${donHang.trangThai eq 2}">
                                <span class="badges bg-lightblue">Chờ xác Nhận</span>
                            </c:when>
                            <c:when test="${donHang.trangThai eq 3}">
                                <span class="badges bg-lightviolet">Đã Xác Nhận</span>
                            </c:when>
                            <c:when test="${donHang.trangThai eq 4}">
                                <span class="badges bg-lightyellow">Đang Vận Chuyển</span>
                            </c:when>
                            <c:otherwise>
                                <span class="badges bg-lightblack">Trạng thái không hợp lệ</span>
                            </c:otherwise>
                        </c:choose>
                    </div>

                </div>
                <div class="col-xl-4 col-lg-4 col-md-4 col-6">
                    <p class="mb-1 p-0"><span class="text-muted">Ngày Đặt Hàng </span></p>
                    <h6 class="mb-0 ft-medium fs-sm"><c:out value="${donHang.ngayTao}"/></h6>
                    <a class="btn btn-dark" href="/donHang/donHangChiTiet/${donHang.id}">Chi Tiết</a>

                </div>


            </div>
        </c:forEach>
    </div>



</div>


<jsp:include page="../template_home/footer.jsp"/>

<script type="text/javascript">
    let bigImg = document.querySelector('.big-img img');


    function showImg(pic) {

        function showImg(pic) {

            bigImg.src = pic;
        }
    }

</script>
</body>
</html>
