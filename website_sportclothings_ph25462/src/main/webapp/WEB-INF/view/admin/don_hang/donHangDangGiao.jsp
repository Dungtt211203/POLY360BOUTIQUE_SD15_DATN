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

    /* Đã Hủy */
    .badges.bg-lightred {
        background-color: lightcoral;
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


<script>
    // xác nhận đơn hàng
    $(document).ready(function () {
        // Xử lý khi nút "Xác nhận" được nhấn
        $("#xacNhanButton").click(function () {
            // Tạo một mảng để lưu trữ các giá trị của các checkbox được chọn
            var selectedItems = [];

            // Lặp qua tất cả các checkbox được chọn và lấy giá trị của chúng
            $(".select-checkbox:checked").each(function () {
                selectedItems.push($(this).val());
            });

            // Kiểm tra xem có mục được chọn hay không
            if (selectedItems.length > 0) {
                // Hiển thị hộp thoại xác nhận

                Swal.fire({
                    icon: 'question',
                    title: 'Xác nhận',
                    text: 'Bạn có chắc chắn muốn giao các đơn hàng đã chọn?',
                    showCancelButton: true,
                    confirmButtonText: 'Đồng ý',
                    cancelButtonText: 'Hủy bỏ',
                }).then((result) => {
                    // Nếu người dùng đồng ý, thực hiện gửi dữ liệu lên server
                    if (result.isConfirmed) {
                        $.ajax({
                            type: "POST",
                            url: "/admin/donHang/xacNhanDonHangDangGiao",
                            contentType: "application/json",
                            data: JSON.stringify(selectedItems),
                            success: function (response) {

                                // Hiển thị thông báo thành công
                                Swal.fire({
                                    icon: 'success',
                                    title: 'Thành công',
                                    text: 'Đơn hàng đã được xác nhận giao.',
                                }).then((result) => {
                                    // Sau khi hộp thoại đóng, kiểm tra xem người dùng đã nhấn nút "OK" hay chưa
                                    location.reload();

                                });

                            },

                            error: function (error) {
                                // Hiển thị thông báo lỗi
                                Swal.fire({
                                    icon: 'error',
                                    title: 'Lỗi!',
                                    text: 'Đã xảy ra lỗi khi xác nhận giao đơn hàng.',
                                });
                            }
                        });
                    }
                });
            } else {
                // Hiển thị thông báo khi không có mục nào được chọn
                Swal.fire({
                    icon: 'warning',
                    title: 'Cảnh báo',
                    text: 'Vui lòng chọn ít nhất một đơn hàng để xác nhận giao hàng.',
                });
            }
        });
    });

    // hủy đơn hàng
    $(document).ready(function () {
        // Xử lý khi nút "Xác nhận" được nhấn
        $("#xacNhanHuyButton").click(function () {
            // Tạo một mảng để lưu trữ các giá trị của các checkbox được chọn
            var selectedItems = [];
            var inputLyDo = $("#lyDo").val();

            // Lặp qua tất cả các checkbox được chọn và lấy giá trị của chúng
            $(".select-checkbox:checked").each(function () {
                selectedItems.push($(this).val());
            });

            // Kiểm tra xem có mục được chọn hay không


            if (selectedItems.length > 0) {
                // Hiển thị hộp thoại xác nhận
                if (inputLyDo === "") {
                    Swal.fire({
                        icon: 'warning',
                        title: 'Cảnh báo',
                        text: 'Hãy Nhập Lý Do Hủy.',
                    });
                } else
                    Swal.fire({
                        icon: 'question',
                        title: 'Xác nhận',
                        text: 'Bạn có chắc chắn hủy đơn hàng đã chọn?',
                        showCancelButton: true,
                        confirmButtonText: 'Đồng ý',
                        cancelButtonText: 'Hủy bỏ',
                    }).then((result) => {


                        // Nếu người dùng đồng ý, thực hiện gửi dữ liệu lên server
                        if (result.isConfirmed) {
                            $.ajax({
                                type: "POST",
                                url: "/admin/donHang/huyXacNhan",
                                contentType: "application/json",

                                data: JSON.stringify({
                                    selectedItems: selectedItems,
                                    lyDo: inputLyDo
                                }),

                                success: function (response) {
                                    // Hiển thị thông báo thành công
                                    Swal.fire({
                                        icon: 'success',
                                        title: 'Thành công',
                                        text: 'Đơn hàng đã được hủy.',
                                    }).then((result) => {
                                        // Sau khi hộp thoại đóng, kiểm tra xem người dùng đã nhấn nút "OK" hay chưa
                                        location.reload();

                                    });

                                },

                                error: function (error) {
                                    // Hiển thị thông báo lỗi
                                    Swal.fire({
                                        icon: 'error',
                                        title: 'Lỗi!',
                                        text: 'Đã xảy ra lỗi khi hủy đơn.',
                                    });
                                }
                            });
                        }
                    });
            } else {
                // Hiển thị thông báo khi không có mục nào được chọn
                Swal.fire({
                    icon: 'warning',
                    title: 'Cảnh báo',
                    text: 'Vui lòng chọn ít nhất một mục để xác nhận giao hàng.',
                });
            }
        });
    });


    // chọn All

    $(document).ready(function () {
        // Xử lý sự kiện click của ô chonAll
        $("#chonAll").click(function () {
            // Thiết lập trạng thái checked cho tất cả các ô select-checkbox
            $(".select-checkbox").prop("checked", $(this).prop("checked"));
        });

        // Xử lý sự kiện click của các ô select-checkbox
        $(".select-checkbox").click(function () {
            // Kiểm tra nếu tất cả các ô select-checkbox đã được chọn, thiết lập trạng thái checked cho ô chonAll
            $("#chonAll").prop("checked", $(".select-checkbox:checked").length === $(".select-checkbox").length);
        });
    });


    // mở modal hủy

    $(document).ready(function () {
        // Xử lý sự kiện khi nút "Hủy" được nhấn
        $("#huyButton").click(function () {
            // Kiểm tra xem có hóa đơn nào được chọn không
            if ($(".select-checkbox:checked").length > 0) {
                // Mở modal
                $("#huyModal").modal("show");
            } else {
                // Hiển thị thông báo nếu không có hóa đơn nào được chọn

            }
        });


    });


</script>


<body>

<h1 style="text-align: center">Quản Lý Hóa Đơn</h1>


<div class="content">
    <div class="card">
        <div class="card-body">
            <br><br>
            <!-- Chờ xác nhận, Chờ giao, Đang giao -->
            <div class="row">
                <div class="col-md-2">
                    <a class="btn btn-info btnx" href="/admin/donHang/donHangCho">Chờ xác nhận</a>
                </div>
                <div class="col-md-2">
                    <a class="btn btnx" href="/admin/donHang/donHangChoGiao">Chờ giao</a>
                </div>
                <div class="col-md-2">
                    <a class="btn btn1" href="/admin/donHang/donHangDangGiao">Đang giao</a>
                </div>
                <div class="col-md-2">
                    <a class="btn btnx" href="/admin/donHang/tatCaDonHang">Thành Công</a>
                </div>
                <div class="col-md-2">
                    <a class="btn btnx" href="/admin/donHang/tatCaDonHang">Đã Hủy</a>
                </div>
                <div class="col-md-2">
                    <a class="btn btnx" href="/admin/donHang/tatCaDonHang">Tất cả đơn hàng</a>
                </div>

            </div>

            <table class="table table-bordered">
                <thead>
                <tr>
                    <th><input type="checkbox" id="chonAll" name="chonAll" value="2"></th>
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
                <c:forEach var="donHang" items="${donHangDangGiao}">
                    <tr>
                        <!-- Thêm class "select-checkbox" vào input checkbox -->
                        <td><input type="checkbox" class="select-checkbox" name="myCheckbox" value="${donHang.id}"></td>
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


            <div class="text-right">
                <a id="xacNhanButton" class="btn btn-success">Xác nhận</a>
                <a id="huyButton" class="btn btn-danger" data-toggle="modal" data-target="#huyModal"> Hủy </a>

                <!-- Modal -->
                <div class="modal fade" id="huyModal" tabindex="-1" role="dialog"
                     aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Hủy Đơn Hàng</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <!-- Select lý do hủy -->


                                <label for="lyDoHuy">Lý do hủy:</label>
                                <select id="lyDoHuy" class="form-control" onchange="handleChange()">
                                    <option value="Không Liên Hệ Được Với Khách Hàng">Không Liên Hệ Được Với
                                        Khách Hàng
                                    </option>
                                    <option value="Khách từ chối nhận hàng">Khách từ chối nhận hàng</option>
                                    <option value="Khách yêu cầu hủy đơn hàng">Khách yêu cầu hủy đơn hàng
                                    </option>
                                    <option value="Hết Sản Phẩm Và Đã Thông Báo Cho Khách Hàng">Hết Sản Phẩm Và
                                        Đã Thông Báo Cho Khách Hàng
                                    </option>
                                    <option value="khac">Khác</option>
                                </select>

                                <!-- Ô input hiển thị lý do đã chọn hoặc lý do khác -->
                                <label for="lyDo" id="lyDoLabel">Lý do:</label>
                                <input type="text" id="lyDo" class="form-control" style="display: none;"
                                       disabled>

                                <script>
                                    // Hàm khởi tạo để đặt giá trị mặc định khi trang web được tải
                                    window.onload = function () {
                                        var lyDoHuySelect = document.getElementById("lyDoHuy");
                                        var lyDoLabel = document.getElementById("lyDoLabel");
                                        var lyDoInput = document.getElementById("lyDo");

                                        // Đặt giá trị mặc định là "Lý do 1"
                                        lyDoInput.value = "Không Liên Hệ Được Với Khách Hàng";
                                        lyDoLabel.style.display = "block";
                                        lyDoInput.style.display = "block";
                                    };

                                    function handleChange() {

                                        var lyDoHuySelect = document.getElementById("lyDoHuy");
                                        var lyDoLabel = document.getElementById("lyDoLabel");
                                        var lyDoInput = document.getElementById("lyDo");

                                        if (lyDoHuySelect.value === "khac") {
                                            lyDoLabel.style.display = "none";
                                            lyDoInput.style.display = "block";
                                            lyDoInput.value = ""
                                            lyDoInput.disabled = false;
                                        } else {
                                            lyDoLabel.style.display = "block";
                                            lyDoInput.style.display = "block";
                                            lyDoInput.disabled = true;
                                            lyDoInput.value = lyDoHuySelect.value; // Gán giá trị của ô select vào inputLyDo
                                        }
                                    }
                                </script>


                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng
                                </button>
                                <button type="button" class="btn btn-primary" id="xacNhanHuyButton">Hủy Đơn Hàng
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
