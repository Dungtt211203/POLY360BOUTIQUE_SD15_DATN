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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


    <script>

        function confirmDelete(idGioHangChiTiet) {
            // Hiển thị hộp thoại xác nhận
            Swal.fire({
                icon: 'question',
                title: 'Xác nhận',
                text: 'Bạn có chắc chắn muốn xóa sản phẩm khỏi giỏ hàng?',
                showCancelButton: true,
                confirmButtonText: 'Đồng ý',
                cancelButtonText: 'Hủy bỏ',
            }).then((result) => {
                // Nếu người dùng đồng ý, thực hiện thao tác xóa bằng AJAX
                if (result.isConfirmed) {
                    var deleteUrl = "/shopping-cart/remove/" + idGioHangChiTiet;

                    $.ajax({
                        type: 'GET',
                        url: deleteUrl,
                        success: function () {


                            Swal.fire({
                                icon: 'success',
                                title: 'Thành công',
                                text: 'Sản Phẩm Đã Xóa Khỏi Giỏ Hàng. ',
                            }).then((result) => {
                                // Sau khi hộp thoại đóng, kiểm tra xem người dùng đã nhấn nút "OK" hay chưa
                                location.reload();

                            });

                        },
                        error: function () {
                            // Xảy ra lỗi khi thực hiện thao tác xóa
                            Swal.fire({
                                icon: 'error',
                                title: 'Lỗi!',
                                text: 'Đã Xảy Ra Lỗi Khi Xóa Sản phẩm Khỏi Giỏ Hàng.',
                            });
                        }
                    });
                }
            });
            // Ngăn chặn sự kiện mặc định (chuyển hướng trang khi nhấn vào liên kết)
            return false;
        }


        function delete1SanPham(idOrIndex, soLuongSanPham) {

            if (soLuongSanPham == 1) {
                confirmDelete(idOrIndex);
            } else {
                var url = "/shopping-cart/down/" + idOrIndex;

                $.ajax({
                    type: 'GET', // Hoặc 'POST' tùy thuộc vào phương thức bạn đã thiết lập trên server
                    url: url,  // Sửa tên biến từ deleteUrl thành url
                    success: function () {
                        location.reload();
                        // Thành công - thực hiện các bước cần thiết
                        console.log('Đã giảm số lượng sản phẩm');
                        // Gọi hàm cập nhật giao diện người dùng hoặc thực hiện các bước cần thiết khác
                    },
                    error: function () {
                        // Lỗi xảy ra khi thực hiện giảm số lượng sản phẩm
                        console.error('Lỗi khi giảm số lượng sản phẩm');
                    }
                });
            }
        }
    </script>


</head>
<body>
<header>
    <jsp:include page="../template_home/header.jsp"/>
</header>


<section class="middle">
    <div class="container">

        <div class="row">
            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
                <div class="text-center d-block mb-5">
                    <h2>Shopping Cart</h2>
                </div>
            </div>
        </div>


        <div class="row justify-content-between">
            <div class="col-12 col-lg-7 col-md-12">
                <ul class="list-group list-group-sm list-group-flush-y list-group-flush-x mb-4">

                    <c:if test="${empty carts}">
                        <img src="https://salanest.com/img/empty-cart.webp">
                    </c:if>


                    <c:if test="${carts != null}">
                        <c:forEach items="${carts}" var="cart" varStatus="cartIndex">
                            <li class="list-group-item">
                                <div class="row align-items-center">
                                    <div class="col-3">
                                        <!-- Image -->
                                        <a href="#"> <img src="../../../img/sp12ao.png" alt="..." class="img-fluid"></a>

                                    </div>
                                    <div class="col d-flex align-items-center justify-content-between">
                                        <div class="cart_single_caption pl-2">
                                            <h4 class="product_title fs-md ft-medium mb-1 lh-1"> ${cart.chiTietSanPham.sanPham.ten} </h4>
                                            <p class="mb-1 lh-1"><span class="text-dark" >Size: ${cart.chiTietSanPham.kichCo.ten}</span>
                                            </p>
                                            <p class="mb-3 lh-1"><span class="text-dark" >Color: ${cart.chiTietSanPham.mauSac.ten}</span>
                                            </p>
                                        </div>



                                        <div>
                                            <div class="input-group input-group-sm">

                                                <c:if test="${cart.id == 0}">
                                                    <a class="btn btn-outline-main1 rounded-left minus" type="button"
                                                       onclick="delete1SanPham(${cartIndex.index} , ${cart.soLuong})">
                                                        <i class="fi fi-rr-minus-small"> - </i>
                                                    </a>
                                                </c:if>


                                                <input disabled class=" text-center" style="width: 20%;" value="${cart.soLuong}">



                                                <a href="/shopping-cart/up/${cartIndex.index}"
                                                   class="btn btn-outline-main1 rounded-right minus" type="button">
                                                    <i class="fi fi-rr-plus-small"> + </i>
                                                </a>


                                            </div>

                                        </div>


                                        <div style="margin: 8px">
                                            <h4 class="fs-md ft-medium m-0 lh-1"><sup> ${cart.soLuong * cart.chiTietSanPham.gia }.đ </sup></h4>
                                        </div>

                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </c:if>
                </ul>
            </div>


            <div class="col-12 col-md-12 col-lg-4">

                <div class="card mb-4 gray mfliud">
                    <div class="card-body">
                        <ul class="list-group list-group-sm list-group-flush-y list-group-flush-x">

                            <li class="list-group-item d-flex text-dark fs-sm ft-regular">
                                <span>Tổng Cộng:   </span>  <span class="ml-auto text-dark ft-medium">  ${tongTien}.đ  </span>
                            </li>
                            <li class="list-group-item fs-sm text-center">
                                Chi phí vận chuyển được tính khi thanh toán *
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="form-group">
                    <a class="btn btn-block btn-dark mb-3">Tiến Hành Thanh Toán</a>
                </div>
                <div class="form-group">
                    <a class="btn stretched-link borders m-auto"><i
                            class="lni lni-reload mr-2"></i> Load lại giỏ hàng </a>
                </div>


                <a class="btn-link text-dark ft-medium" href="@{/products}">
                    <i class="ti-back-left mr-2"></i> Quay Lại Shopping
                </a>
            </div>

        </div>

    </div>
</section>


<jsp:include page="../template_home/footer.jsp"/>

<script type="text/javascript">
    let bigImg = document.querySelector('.big-img img');

    function showImg(pic) {
        bigImg.src = pic;
    }

</script>
</body>
</html>