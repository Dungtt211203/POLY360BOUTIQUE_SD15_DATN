<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>POLY360BOUTIQUE_ADMIN</title>


    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- Include Bootstrap JS -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <link rel="icon" href="../../../svg/logohome.svg">
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>


</head>


<style>
    .row {
        display: flex;
        align-items: center;
    }

    .col-md-2 {
        margin-right: 10px;
        /* Khoảng cách giữa các cột */
    }


    .btn1 {
        background-color: #ffffff;
        /* Màu nền */
        color: #333333;
        padding: 10px 20px;
        border: 2px solid #e46415;
        /* Màu xanh (#4CAF50) của viền */
        border-radius: 5px;
        /* Độ cong của góc viền */
        text-decoration: none;
        /* Loại bỏ đường gạch chân mặc định của liên kết */
    }

    /* Định dạng khi di chuột qua nút */
    .btn1:hover {
        background-color: #4CAF50;
        /* Màu nền khi di chuột qua */
        color: #ffffff;
        /* Màu chữ khi di chuột qua */
    }

    .btnx {
        background-color: #ffffff;
        /* Màu nền */
        color: #333333;
        padding: 10px 20px;
        border: 2px solid #dceddf;
        /* Màu xanh (#4CAF50) của viền */
        border-radius: 5px;
        /* Độ cong của góc viền */
        text-decoration: none;
        /* Loại bỏ đường gạch chân mặc định của liên kết */
    }

    /* Định dạng khi di chuột qua nút */
    .btnx:hover {
        background-color: #4CAF50;
        /* Màu nền khi di chuột qua */
        color: #ffffff;
        /* Màu chữ khi di chuột qua */
    }

    .badges {
        padding: 5px 10px;
        border-radius: 5px;
        font-size: 14px;
    }

    /* Đã Hủy */
    .badges.bg-lightred {
        background-color: red;
        color: #fff; /* Màu chữ tùy chỉnh */
    }

    /* Thành Công */
    .badges.bg-green {
        background-color: limegreen;
        color: #fff; /* Màu chữ tùy chỉnh */
    }

    /* Đã Xác Nhận */
    .badges.bg-lightgreen {
        background-color: lightgreen;
        color: #333; /* Màu chữ tùy chỉnh */
    }

    /* Đang Giao */
    .badges.bg-lightblue {
        background-color: lightblue;
        color: #333; /* Màu chữ tùy chỉnh */
    }

    /* Chờ Xác Nhận */
    .badges.bg-lightyellow {
        background-color: lightyellow;
        color: #333; /* Màu chữ tùy chỉnh */
    }


</style>
<body>
<h1 style="text-align: center">Quản Lý Hóa Đơn</h1>
<div class="content">
    <div class="card">
        <div class="card-body">
            <br><br>
            <!-- Chờ xác nhận, Chờ giao, Đang giao -->
            <div class="row">
                <div class="col-md-2">
                    <a class="btn btnx" href="/admin/donHang/donHangCho">Chờ xác nhận</a>
                </div>
                <div class="col-md-2">
                    <a class="btn btnx" href="/admin/donHang/donHangChoGiao">Chờ giao</a>
                </div>
                <div class="col-md-2">
                    <a class="btn btnx" href="/admin/donHang/donHangDangGiao">Đang giao</a>
                </div>
                <div class="col-md-2">
                    <a class="btn btnx" href="/admin/donHang/tatCaDonHang">Thành Công</a>
                </div>
                <div class="col-md-2">
                    <a class="btn btnx" href="/admin/donHang/tatCaDonHang">Đã Hủy</a>
                </div>
                <div class="col-md-2">
                    <a class="btn btn-info btn1" href="/admin/donHang/tatCaDonHang">Tất cả đơn hàng</a>
                </div>
            </div>

            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>Mã hóa đơn</th>
                    <th>Khách hàng</th>
                    <th>Tổng Tiền</th>
                    <th>Ngày Đặt</th>
                    <th>Địa Chỉ</th>
                    <th>Trạng Thái</th>
                    <th>Xem Chi Tiết</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="donHang" items="${tatCaDonHang}">
                    <tr>
                        <!-- Thêm class "select-checkbox" vào input checkbox -->
                        <td>${donHang.maHoaDon}</td>
                        <td>${donHang.taiKhoan.email}</td>
                        <td>${donHang.tongTien}.đ</td>
                        <td>${donHang.ngayTao}</td>
                        <td>${donHang.diaChiNguoiNhan}</td>
                        <td>
                            <c:choose>
                                <c:when test="${donHang.trangThai == 0}">
                                    <span class="badges bg-lightred">Đã Hủy</span>
                                </c:when>
                                <c:when test="${donHang.trangThai == 1}">
                                    <span class="badges bg-green">Thành Công</span>
                                </c:when>
                                <c:when test="${donHang.trangThai == 2}">
                                    <span class="badges bg-lightgreen">Đã Xác Nhận</span>
                                </c:when>
                                <c:when test="${donHang.trangThai == 3}">
                                    <span class="badges bg-lightblue">Đang Giao</span>
                                </c:when>
                                <c:when test="${donHang.trangThai == 4}">
                                    <span class="badges bg-lightyellow">Chờ Xác Nhận</span>
                                </c:when>
                            </c:choose>
                        </td>
                        <td><a class="button" href="/admin/donHang/${donHang.id}">Chi Tiết</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


            <%--            <div class="text-right">--%>
            <%--                <a id="xacNhanButton" class="btn btn-success">Xác nhận</a>--%>
            <%--                <a id="huyButton" class="btn btn-danger" data-toggle="modal" data-target="#huyModal"> Hủy </a>--%>

            <%--                <!-- Modal -->--%>
            <%--                <div class="modal fade" id="huyModal" tabindex="-1" role="dialog"--%>
            <%--                     aria-labelledby="exampleModalLabel"--%>
            <%--                     aria-hidden="true">--%>
            <%--                    <div class="modal-dialog" role="document">--%>
            <%--                        <div class="modal-content">--%>
            <%--                            <div class="modal-header">--%>
            <%--                                <h5 class="modal-title" id="exampleModalLabel">Hủy Đơn Hàng</h5>--%>
            <%--                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
            <%--                                    <span aria-hidden="true">&times;</span>--%>
            <%--                                </button>--%>
            <%--                            </div>--%>
            <%--                            <div class="modal-body">--%>
            <%--                                <!-- Select lý do hủy -->--%>


            <%--                                <label for="lyDoHuy">Lý do hủy:</label>--%>
            <%--                                <select id="lyDoHuy" class="form-control" onchange="handleChange()">--%>
            <%--                                    <option value="Không Liên Hệ Được Với Khách Hàng">Không Liên Hệ Được Với--%>
            <%--                                        Khách Hàng--%>
            <%--                                    </option>--%>
            <%--                                    <option value="Khách từ chối nhận hàng">Khách từ chối nhận hàng</option>--%>
            <%--                                    <option value="Khách yêu cầu hủy đơn hàng">Khách yêu cầu hủy đơn hàng--%>
            <%--                                    </option>--%>
            <%--                                    <option value="Hết Sản Phẩm Và Đã Thông Báo Cho Khách Hàng">Hết Sản Phẩm Và--%>
            <%--                                        Đã Thông Báo Cho Khách Hàng--%>
            <%--                                    </option>--%>
            <%--                                    <option value="khac">Khác</option>--%>
            <%--                                </select>--%>

            <%--                                <!-- Ô input hiển thị lý do đã chọn hoặc lý do khác -->--%>
            <%--                                <label for="lyDo" id="lyDoLabel">Lý do:</label>--%>
            <%--                                <input type="text" id="lyDo" class="form-control" style="display: none;"--%>
            <%--                                       disabled>--%>

            <%--                                <script>--%>
            <%--                                    // Hàm khởi tạo để đặt giá trị mặc định khi trang web được tải--%>
            <%--                                    window.onload = function () {--%>
            <%--                                        var lyDoHuySelect = document.getElementById("lyDoHuy");--%>
            <%--                                        var lyDoLabel = document.getElementById("lyDoLabel");--%>
            <%--                                        var lyDoInput = document.getElementById("lyDo");--%>

            <%--                                        // Đặt giá trị mặc định là "Lý do 1"--%>
            <%--                                        lyDoInput.value = "Không Liên Hệ Được Với Khách Hàng";--%>
            <%--                                        lyDoLabel.style.display = "block";--%>
            <%--                                        lyDoInput.style.display = "block";--%>
            <%--                                    };--%>

            <%--                                    function handleChange() {--%>

            <%--                                        var lyDoHuySelect = document.getElementById("lyDoHuy");--%>
            <%--                                        var lyDoLabel = document.getElementById("lyDoLabel");--%>
            <%--                                        var lyDoInput = document.getElementById("lyDo");--%>

            <%--                                        if (lyDoHuySelect.value === "khac") {--%>
            <%--                                            lyDoLabel.style.display = "none";--%>
            <%--                                            lyDoInput.style.display = "block";--%>
            <%--                                            lyDoInput.value = ""--%>
            <%--                                            lyDoInput.disabled = false;--%>
            <%--                                        } else {--%>
            <%--                                            lyDoLabel.style.display = "block";--%>
            <%--                                            lyDoInput.style.display = "block";--%>
            <%--                                            lyDoInput.disabled = true;--%>
            <%--                                            lyDoInput.value = lyDoHuySelect.value; // Gán giá trị của ô select vào inputLyDo--%>
            <%--                                        }--%>
            <%--                                    }--%>
            <%--                                </script>--%>


            <%--                            </div>--%>
            <%--                            <div class="modal-footer">--%>
            <%--                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng--%>
            <%--                                </button>--%>
            <%--                                <button type="button" class="btn btn-primary" id="xacNhanHuyButton">Hủy Đơn Hàng--%>
            <%--                                </button>--%>
            <%--                            </div>--%>
            <%--                        </div>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--            </div>--%>
            <%--        </div>--%>
        </div>
    </div>
</body>
</html>
