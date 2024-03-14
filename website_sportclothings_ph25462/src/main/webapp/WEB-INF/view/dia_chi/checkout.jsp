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

        .modal {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
        }

        .modal-content {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            text-align: center;
        }

        .close {
            position: absolute;
            top: 10px;
            right: 10px;
            font-size: 20px;
            cursor: pointer;
        }


        .form-container {
            max-width: 600px;
            margin: 0 auto;
            display: flex;
            flex-wrap: wrap;
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
        button[type="submit"] {
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
        button[type="submit"]:hover {
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


        /* Định dạng cho nội dung của modal */
        .modal-content {
            background-color: #fefefe;
            padding: 20px;
            border: 1px solid #888;
            width: 60%; /* Chiều rộng của nội dung modal */
        }

        /* Định dạng cho nút đóng modal */
        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
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
                    <h2>Checkout</h2>
                </div>
            </div>
        </div>
        <form action="#" id="checkoutForm" method="post">
            <div class="row justify-content-between">
                <div class="col-12 col-lg-7 col-md-12">
                    <!-- Checkout Form -->
                    <!-- Add your existing form content here -->
                    <h5 class="mb-4 ft-medium">Chi Tiết Thanh Toán </h5>
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
                                <input disabled type="email" class="form-control"/>
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

                                    <select name="address" id="idDiaChi" class="form-control" onchange="updateShippingFee(this)">
                                        <c:forEach var="diaChi" items="${diaChiList}">
                                            <option value="${diaChi.thanhPho}"
                                                    data-districtID="${diaChi.districtID}"
                                                    data-wardCode="${diaChi.wardCode}"
                                                    data-SDT="0333484685"
                                                    data-ten="Hoang Van Be"
                                                    data-id="1">

                                                <c:out value="${diaChi.phuongXa} - ${diaChi.quanHuyen} - ${diaChi.thanhPho}"/>
                                            </option>
                                        </c:forEach>
                                    </select>


                                </div>
                            </div>
                            <button type="button" id="openModalBtn">Thêm Địa Chỉ</button>
                            <button type="button" id="suaDiaChi" class="btn btn-danger">Sửa Địa Chỉ</button>


                        </div>


                    </div>

                    <div class="row mb-4">
                        <div class="col-12 d-block">
                            <input id="createaccount" class="checkbox-custom" name="createaccount" type="checkbox">
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
                            <li class="list-group-item">
                                <div class="d-flex justify-content-between">
                                    <div>
                                        <%--                                <h5 class="mb-1" th:text="'Tên Sản Phẩm: '+ ${carts.productName}"></h5>--%>
                                        <%--                                <p class="mb-1" th:text="'Số lượng: ' + ${carts.quantity}"></p>--%>
                                        <%--                                <p class="mb-1" th:text="'Kích cỡ: ' + ${carts.productSize}"></p>--%>
                                        <%--                                <p class="mb-1" th:text="'Màu sắc : ' + ${carts.productColor}"></p>--%>
                                        <%--                                <p class="mb-1" th:text="'Đơn Giá : ' + ${carts.productPrice} + '.₫'"></p>--%>


                                    </div>

                                </div>
                            </li>
                        </ul>
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
                                <span>Tổng</span> <span class="ml-auto text-dark ft-medium" id="tongTien">100</span>
                                <input type="number" id="tongTienPC" value="999" style="display: none">

                            </li>

                            <li class="list-group-item d-flex justify-content-between text-dark fs-sm ft-regular">
                                <span>Phí vận chuyển</span> <span name="phiVanChuyen"
                                                                  class="ml-auto text-dark ft-medium"
                                                                  id="phiVanChuyen"> 30.000.đ </span>

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
                                       value="6">
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
                    <h2 style="color: red; background: #d2d728; text-align: center ">Tạo Địa chỉ giao hàng mới</h2>
                    <form class="row m-0" name="address" method="post">
                        <!-- SoDiaChi fields -->
                        <div class="form-section">
                            <label for="hoTen">Họ tên:</label>
                            <input type="text" id="hoTen" name="hoTen" required>

                            <label for="soDienThoai">Số Điện Thoại:</label>
                            <input type="text" id="soDienThoai" name="soDienThoai" required>

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

                            <input type="text" name="thanhPho" value="" style="display: none;">
                            <input type="text" name="quanHuyen" value="" style="display: none;">
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
                    <button type="button" class="btn btn-light btn-danger" onclick="confirmAddDiaChi()">Thêm
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
<script></script>
</body>
</html>
