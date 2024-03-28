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

    <style>
        body {
            font-family: Arial, sans-serif;
        }


        .form-section {
            flex: 1;
            margin: 10px;
        }

        input[type="text"],
        input[type="number"],
        select {
            flex: 1;
            /* Equal width for all fields within the section */
            padding: 10px;
            margin-bottom: 10px;
            border: 2px solid #007bff;
            /* Thick blue border for input fields and selects */
            border-radius: 5px;
            width: 100%;
            /* Full width within the section */
        }

        /* Style the submit button as a square */
        btn-diachi {
            background-color: #007bff;
            color: #fff;
            padding: 15px 20px;
            border: none;
            cursor: pointer;
            width: 100px;
            height: 50px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        /* Hover effect for the submit button */
        btn-diachi:hover {
            background-color: #0056b3;
            /* Darker blue on hover */
        }

        /* Màu cho radio button */
        input[type="radio"] {
            /* Màu khi radio button được chọn */
            color: #007BFF;
        }

        /* Màu cho nhãn */
        label {
            /* Màu văn bản của nhãn */
            color: #333;
        }

        input[type="radio"] {
            /* Màu khi radio button được chọn */
            color: #007BFF;
        }

        /* Màu cho nhãn */
        label {
            /* Màu văn bản của nhãn */
            color: #333;
        }

        #checkoutForm {
            max-width: 100%;
        }

        #checkoutForm .row {
            margin-bottom: 20px;
        }

        #checkoutForm .form-group {
            margin-bottom: 15px;
        }

        #checkoutForm label {
            font-weight: bold;
        }

        #checkoutForm input[type="text"],
        #checkoutForm input[type="email"],
        #checkoutForm select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        #checkoutForm #openModalBtn {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
        }

        #checkoutForm #openModalBtn:hover {
            background-color: #0056b3;
        }

        #checkoutForm .list-group-item {
            border: none;
            padding: 10px;
        }

        #checkoutForm .list-group-item p {
            margin-bottom: 5px;
        }

        #checkoutForm .btn-block {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 15px;
            cursor: pointer;
        }

        #checkoutForm .btn-block:hover {
            background-color: #0056b3;
        }

        .container-mathang {
            background-color: #f8f9fa; /* Màu nền của mỗi mục */
            padding: 15px; /* Khoảng cách bên trong mỗi mục */
            margin-bottom: 10px; /* Khoảng cách giữa các mục */
            border-radius: 10px; /* Độ cong của góc */
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); /* Đổ bóng */
        }

        .container-mathang:last-child {
            margin-bottom: 0; /* Không có khoảng cách dưới cùng nếu là mục cuối cùng */
        }

        #checkoutForm {
            border: 1px solid #ccc; /* Màu và độ dày của khung viền */
            border-radius: 10px; /* Độ cong của góc */
            padding: 20px; /* Khoảng cách bên trong form */
        }

        #checkoutForm .row {
            margin-bottom: 20px; /* Khoảng cách giữa các hàng */
        }

        #checkoutForm label {
            font-weight: bold;
        }

        #checkoutForm input[type="text"],
        #checkoutForm input[type="email"],
        #checkoutForm select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        #checkoutForm button[type="button"] {
            width: 100%;
            padding: 15px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        #checkoutForm button[type="button"]:hover {
            background-color: #0056b3;
        }

        .list-group-item {
            border: none;
        }

        .card {
            border: 1px solid #ccc; /* Màu và độ dày của khung viền */
            border-radius: 10px; /* Độ cong của góc */
        }

        .card-body {
            padding: 20px; /* Khoảng cách bên trong card */
        }

        .payment-method {
            border: 1px solid #ccc; /* Màu và độ dày của border */
            border-radius: 5px; /* Độ cong của góc */
            padding: 15px; /* Khoảng cách bên trong */
        }

        .payment-method h3 {
            margin-bottom: 10px; /* Khoảng cách dưới của tiêu đề */
        }

        .payment-method input[type="radio"] {
            display: none; /* Ẩn input radio mặc định */
        }

        .payment-method label {
            display: block;
            cursor: pointer;
            padding: 10px 0;
        }

        .payment-method label:hover {
            background-color: #f0f0f0; /* Màu nền khi hover */
        }

        .payment-method input[type="radio"] + label:before {
            content: '';
            display: inline-block;
            width: 20px; /* Kích thước của radio box */
            height: 20px; /* Kích thước của radio box */
            border: 2px solid #ccc; /* Màu và độ dày của border */
            border-radius: 50%; /* Độ cong của radio box */
            margin-right: 10px; /* Khoảng cách với label */
        }

        .payment-method input[type="radio"]:checked + label:before {
            background-color: #007bff; /* Màu nền của radio box khi được chọn */
        }

        /* Modal */
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.4);
        }

        /* Nội dung modal */
        .modal-content {
            background-color: #fefefe;
            margin: 10% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%;
            border-radius: 10px;
        }

        /* Nút Close */
        .close {
            color: orange;
            float: right;
            font-size: 50px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: cadetblue;
            text-decoration: none;
            cursor: pointer;
        }
        /* Tiêu đề modal */
        .modal-title {
            color: orange;
            text-align: center;
            padding: 10px;
            border-radius: 5px;
            margin-bottom: 20px;
        }

        /* Form section */
        .form-section {
            margin-bottom: 20px;
        }

        /* Radio box */
        .radio-custom {
            margin-right: 10px;
        }

        /* Button */
        .btn-add {
            background-color: #d9534f;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            display: block; /* Chuyển nút thành block để có thể căn giữa */
            margin: 0 auto; /* Căn giữa theo chiều ngang */
        }

        .btn-add:hover {
            background-color: #c9302c;
        }


    </style>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
    <script src="../../../js/themNhanhDIaChi.js"></script>

</head>
<body>
<header>
    <jsp:include page="../template_home/header.jsp"/>
</header>


<!--Nhập thông tin khách hàng-->

<section class="middle">
    <div class="container">
        <div class="row">
            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
                <div class="text-center d-block mb-5">
                    <h2>Chi tiết đơn hàng</h2>
                </div>
            </div>
        </div>
        <form action="/checkout/process" id="checkoutForm" method="post">
            <div class="row justify-content-between">
                <div class="col-12 col-lg-7 col-md-12">
                    <!-- Checkout Form -->
                    <!-- Add your existing form content here -->
                    <h5 class="mb-4 ft-medium">Chi Tiết Thanh Toán</h5>
                    <div class="row mb-2">

                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 col-12">
                            <div class="form-group">
                                <label class="text-dark">Họ Và Tên</label>
                                <input disabled type="text" class="form-control" id="hienThiTen"/>
                            </div>
                        </div>

                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                            <div class="form-group">
                                <label class="text-dark">Email </label>
                                <input disabled type="email" id="hienThiEmail" class="form-control"/>
                            </div>
                        </div>

                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                            <div class="form-group">
                                <label class="text-dark">Số Điện Thoại</label>
                                <input disabled type="text" class="form-control" id="hienThiSDT" value=""/>
                            </div>
                        </div>

                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                            <label class="text-dark mr-2">Địa Chỉ Nhận Hàng</label>
                            <div class="form-group d-flex align-items-center">
                                <div class="flex-grow-1">

                                    <select name="address" id="idDiaChi" class="form-control"
                                            onchange="updateShippingFee(this)">
                                        <c:forEach var="diaChi" items="${diaChiList}">
                                            <option value="${diaChi.thanhPho}"
                                                    data-districtID="${diaChi.districtID}"
                                                    data-wardCode="${diaChi.wardCode}"
                                                    data-SDT="${diaChi.sdt}"
                                                    data-ten="${diaChi.hoTen}"
                                                    data-email="${diaChi.taiKhoanKH.email}"
                                                    data-id="${diaChi.id}">

                                                <c:out value=" ${diaChi.hoTen} - ${diaChi.diaChi}- ${diaChi.phuongXa} - ${diaChi.quanHuyen} - ${diaChi.thanhPho}"/>
                                            </option>
                                        </c:forEach>
                                    </select>


                                </div>
                            </div>
                            <button type="button" id="openModalBtn" class="btn-diachi">Thêm Địa Chỉ</button>
                            <%--                            <button type="button" id="suaDiaChi" class="btn btn-danger">Sửa Địa Chỉ</button>--%>


                        </div>


                    </div>

                    <div class="row mb-4">
                        <div class="col-12 d-block">
                            <%--                            <input id="createaccount" class="checkbox-custom" name="createaccount" type="checkbox">--%>
                            <!--                                <label for="createaccount" class="checkbox-custom-label">Thêm tài khoản mới</label>-->
                        </div>
                    </div>


                </div>
                <!--                Nhập thông tin khách hàng-->

                <!-- Sidebar -->
                <div class="col-12 col-lg-4 col-md-12">
                    <div class="d-block mb-3">
                        <h4 class="mb-4">Các mặt hàng:</h4>
                        <ul class="list-group list-group-sm list-group-flush-y list-group-flush-x mb-4">
                            <c:forEach var="gioHangCT" items="${carts}">
                                <li class="list-group-item container-mathang">
                                    <div class="d-flex justify-content-between">
                                        <div>
                                            <h5 class="mb-1">${gioHangCT.chiTietSanPham.sanPham.ten}</h5>
                                            <p class="mb-1">Số lượng: ${gioHangCT.soLuong}</p>
                                            <p class="mb-1">Kích cỡ: ${gioHangCT.chiTietSanPham.kichCo.ten}</p>
                                            <p class="mb-1">Màu sắc : ${gioHangCT.chiTietSanPham.mauSac.ten}</p>
                                            <p class="mb-1">Đơn Giá : ${gioHangCT.chiTietSanPham.giaHienHanh}.₫</p>
                                        </div>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="payment-method">
                        <h3 style="font-size: 25px">Phương thức thanh toán</h3>
                        <input type="radio" id="cash-on-delivery" name="payment-method" value="cash">
                        <label for="cash-on-delivery">Thanh toán khi nhận hàng</label><br>
                        <input type="radio" id="vnpay" name="payment-method" value="vnpay">
                        <label for="vnpay">Thanh toán bằng VNPAY</label>
                    </div>


                    <!-- Cart Summary -->
                    <!-- Thêm thông tin tổng cộng sau danh sách sản phẩm -->
                    <ul id="cartItemsList"
                        class="list-group list-group-sm list-group-flush-y list-group-flush-x mb-4"></ul>

                    <!-- Thêm thông tin tổng cộng -->
                    <div class="card mb-4 gray">
                        <div class="card-body">
                            <!-- Thông tin tổng cộng details -->
                            <ul class="list-group list-group-sm list-group-flush-y list-group-flush-x">
                                <!-- ... (danh sách sản phẩm giỏ hàng) ... -->
                            </ul>

                            <!-- Thêm thông tin tổng cộng vào đây -->
                            <li class="list-group-item d-flex justify-content-between text-dark fs-sm ft-regular">
                                <span>Tổng</span> <span class="ml-auto text-dark ft-medium"
                                                        id="tongTien">${totalAmount}đ</span>
                                <input type="number" id="tongTienPC" value="999" style="display: none">

                            </li>

                            <li class="list-group-item d-flex justify-content-between text-dark fs-sm ft-regular">
                                <span>Phí vận chuyển</span> <span name="phiVanChuyen"
                                                                  class="ml-auto text-dark ft-medium"
                                                                  id="phiVanChuyen">30.000.đ</span>

                            </li>
                            <input name="shippingFee" id="shippingFee" style="display: none">

                            <li class="list-group-item d-flex justify-content-between text-dark fs-sm ft-regular">
                                <span>Ngày giao hàng dự Kiến </span>
                                <span class="ml-auto text-dark ft-medium"
                                      id="ngayDuKienGiao"> Hãy Chọn Địa Chỉ </span>
                            </li>

                            <li class="list-group-item d-flex justify-content-between text-dark fs-sm ft-regular">
                                <span>Tổng Tiền</span>
                                <span class="ml-auto text-dark ft-medium"
                                      id="hienThiTongTien" name="hienThiTongTien"></span>

                                <input name="tongTien" style="display: none"
                                       value="${totalAmount}">
                            </li>
                        </div>
                    </div>
                    <button type="button" class="btn btn-block btn-dark mb-3" onclick="validateAndSubmit()">Đặt Hàng
                    </button>
                    <!-- End Checkout Button -->
                </div>
            </div>
        </form>


        <!--            <button id="openModalBtn">Mở model</button>-->

        <div id="addressModal" class="modal">
            <div class="modal-content">
                <span class="close" id="closeModalBtn">&times;</span>
                <div>
                    <h2 class="modal-title">Tạo Địa chỉ giao hàng mới</h2>
                    <form class="row m-0" name="address" method="post">
                        <!-- SoDiaChi fields -->
                        <div class="form-section">
                            <label for="hoTen">Họ tên:</label>
                            <input type="text" id="hoTen" name="hoTen" required>

                            <label for="soDienThoai">Số Điện Thoại:</label>
                            <input type="text" id="soDienThoai" name="sdt" required>

                            <label for="diaChi">Địa Chỉ:</label>
                            <input type="text" id="diaChi" name="diaChi" required>
                            <br>
                            <br>

                            <label style="font-size: larger">Nơi ở:</label>
                            <input class="radio-custom" type="radio" name="loaiDiaChi" id="inlineRadio1" value="1"
                                   checked>
                            <label class="radio-custom-label" for="inlineRadio1">Chung cư/Nhà riêng</label>

                            <input class="radio-custom" type="radio" name="loaiDiaChi" id="inlineRadio2" value="0">
                            <label class="radio-custom-label" for="inlineRadio2">Cơ quan/Công ty</label>


                        </div>

                        <div class="form-section">
                            <label for="city">Tỉnh/Thành phố:</label>
                            <select class="form-select form-select-sm mb-3" id="city" name="idTinhThanhPho"
                                    aria-label=".form-select-sm">
                                <option value="" selected>Chọn tỉnh thành</option>
                            </select>

                            <label for="district">Quận/Huyện:</label>
                            <select class="form-select form-select-sm mb-3" id="district" name="districtID"
                                    aria-label=".form-select-sm">
                                <option value="" selected>Chọn quận huyện</option>
                            </select>

                            <label for="ward">Phường/Xã:</label>
                            <select class="form-select form-select-sm" id="ward" name="wardCode"
                                    aria-label=".form-select-sm">
                                <option value="" selected>Chọn phường xã</option>
                            </select>

                            <input type="text" id="thanhPho" name="thanhPho" value="" style="display: none;">
                            <input type="text" id="quanHuyen" name="quanHuyen" value="" style="display: none;">
                            <input type="text" name="phuongXa" value="" style="display: none;">

                            <!-- Tương tự cho các trường khác -->

                            <br>
                            <br>

                            <div class="form-check" style="display: none">
                                <input class="form-check-input" type="checkbox" value="1" id="flexCheckDefault"
                                       name="trangThai"
                                       checked>
                                <label class="form-check-label" for="flexCheckDefault"
                                       style="font-size: larger; display: flex; align-items: center; color: red">
                                    Đặt làm địa chỉ mặc định
                                </label>
                            </div>

                        </div>

                    </form>
                    <button type="button" class="btn btn-light btn-danger btn-add" onclick="confirmAddDiaChi()">Thêm
                    </button>

                </div>
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

