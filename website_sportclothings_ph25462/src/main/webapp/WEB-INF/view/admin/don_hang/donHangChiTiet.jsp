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

</style>


<script>


    // xác nhận đơn hàng
    $(document).ready(function () {
        // Xử lý khi nút "Xác nhận" được nhấn
        $("#xacNhanButton").click(function () {

            var idDonHang = $("#idDonHang").val();

            if (idDonHang != null) {
                // Hiển thị hộp thoại xác nhận

                Swal.fire({
                    icon: 'question',
                    title: 'Xác nhận',
                    text: 'Bạn có chắc chắn muốn xác nhận các đơn hàng đã chọn?',
                    showCancelButton: true,
                    confirmButtonText: 'Đồng ý',
                    cancelButtonText: 'Hủy bỏ',
                }).then((result) => {
                    // Nếu người dùng đồng ý, thực hiện gửi dữ liệu lên server
                    if (result.isConfirmed) {
                        $.ajax({
                            type: "GET",
                            url: "/admin/donHang/xacNhan/" + idDonHang,

                            success: function (response) {

                                // Hiển thị thông báo thành công
                                Swal.fire({
                                    icon: 'success',
                                    title: 'Thành công',
                                    text: 'Đơn hàng đã được xác nhận.',
                                }).then((result) => {
                                    window.location.href = "/admin/donHang/donHangCho";

                                });

                            },

                            error: function (error) {
                                // Hiển thị thông báo lỗi
                                Swal.fire({
                                    icon: 'error',
                                    title: 'Lỗi!',
                                    text: 'Số Lượng Sản Phẩm Còn lại Không đủ.',
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
                    text: 'Vui lòng chọn ít nhất một đơn hàng để xác nhận.',
                });
            }
        });
    });



    // xác nhận Đơn hàng chờ giao
    $(document).ready(function () {
        // Xử lý khi nút "Xác nhận" được nhấn
        $("#donHangChoGiao").click(function () {

            var idDonHang = $("#idDonHang").val();

            if (idDonHang != null) {
                // Hiển thị hộp thoại xác nhận

                Swal.fire({
                    icon: 'question',
                    title: 'Xác nhận',
                    text: 'Bạn có chắc chắn muốn xác nhận giao đơn hàng đã chọn?',
                    showCancelButton: true,
                    confirmButtonText: 'Đồng ý',
                    cancelButtonText: 'Hủy bỏ',
                }).then((result) => {
                    // Nếu người dùng đồng ý, thực hiện gửi dữ liệu lên server
                    if (result.isConfirmed) {
                        $.ajax({
                            type: "GET",
                            url: "/admin/donHang/donHangChoGiao/" + idDonHang,

                            success: function (response) {

                                // Hiển thị thông báo thành công
                                Swal.fire({
                                    icon: 'success',
                                    title: 'Thành công',
                                    text: 'Đơn hàng đã được xác nhận đang giao.',
                                }).then((result) => {
                                    window.location.href = "/admin/donHang/donHangCho";

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


    // xác nhận Đơn hàng đang giao
    $(document).ready(function () {
        // Xử lý khi nút "Xác nhận" được nhấn
        $("#donHangDangGiao").click(function () {

            var idDonHang = $("#idDonHang").val();

            if (idDonHang != null) {
                // Hiển thị hộp thoại xác nhận

                Swal.fire({
                    icon: 'question',
                    title: 'Xác nhận',
                    text: 'Bạn có chắc chắn muốn xác nhận đã giao các đơn hàng đã chọn?',
                    showCancelButton: true,
                    confirmButtonText: 'Đồng ý',
                    cancelButtonText: 'Hủy bỏ',
                }).then((result) => {
                    // Nếu người dùng đồng ý, thực hiện gửi dữ liệu lên server
                    if (result.isConfirmed) {
                        $.ajax({
                            type: "GET",
                            url: "/admin/donHang/donHangDangGiao/" + idDonHang,

                            success: function (response) {

                                // Hiển thị thông báo thành công
                                Swal.fire({
                                    icon: 'success',
                                    title: 'Thành công',
                                    text: 'Đơn hàng đã được xác nhận giao thành công.',
                                }).then((result) => {
                                    window.location.href = "/admin/donHang/donHangCho";

                                });

                            },

                            error: function (error) {
                                // Hiển thị thông báo lỗi
                                Swal.fire({
                                    icon: 'error',
                                    title: 'Lỗi!',
                                    text: 'Đã xảy ra lỗi khi xác nhận dữ liệu.',
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
                    text: 'Vui lòng chọn ít nhất một đơn hàng để xác nhận.',
                });
            }
        });
    });




    // hủy đơn hàng
    $(document).ready(function () {
        // Xử lý khi nút "Xác nhận" được nhấn
        $("#xacNhanHuyButton").click(function () {
            // Tạo một mảng để lưu trữ các giá trị của các checkbox được chọn
            var idDonHang = $("#idDonHang").val();
            var inputLyDo = $("#lyDo").val();


            if (idDonHang != null) {
                // Hiển thị hộp thoại xác nhận
                if (inputLyDo.trim() === "") {
                    Swal.fire({
                        icon: 'warning',
                        title: 'Cảnh báo',
                        text: 'Hãy Nhập Lý Do Hủy.',
                    });
                } else
                    Swal.fire({
                        icon: 'question',
                        title: 'Xác nhận',
                        text: 'Bạn có chắc chắn hủy các đơn hàng đã chọn?',
                        showCancelButton: true,
                        confirmButtonText: 'Đồng ý',
                        cancelButtonText: 'Hủy bỏ',
                    }).then((result) => {


                        // Nếu người dùng đồng ý, thực hiện gửi dữ liệu lên server
                        if (result.isConfirmed) {
                            $.ajax({
                                type: "GET",
                                url: "/admin/donHang/huyXacNhan/" + idDonHang,
                                data: {lyDo: inputLyDo},
                                success: function (response) {
                                    // Hiển thị thông báo thành công
                                    Swal.fire({
                                        icon: 'success',
                                        title: 'Thành công',
                                        text: 'Đơn hàng đã được hủy.',
                                    }).then((result) => {
                                        // Sau khi hộp thoại đóng, kiểm tra xem người dùng đã nhấn nút "OK" hay chưa
                                        window.location.href = "/admin/donHang/donHangCho";

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
                    text: 'Vui lòng chọn ít nhất một đơn hàng! ',
                });
            }
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

<div class="content">

    <div class="ord_list_wrap border mb-4 mfliud">

        <div class="ord_list_head gray d-flex align-items-center justify-content-between px-3 py-3">
            <div class="olh_flex">
                <p class="m-0 p-0"><span class="text-muted">Mã Đơn Hàng</span></p>
                <h6 class="mb-0 ft-medium"><c:out value="${maDonHang}"/></h6>
            </div>
            <div class="olh_flex">
                <p class="m-0 p-0"><span class="text-muted">Tổng Tiền</span></p>
                <h6 class="mb-0 ft-medium"><c:out value="${tongTien}"/>.đ</h6>
            </div>
            <div class="olh_flex">
                <a href="javascript:void(0);" class="btn btn-sm btn-dark">Chi Tiết Đơn Hàng</a>
            </div>
        </div>



        <!--                  ==================================================-->


        <div class="ord_list_body text-left">
            <!-- First Product -->
            <div class="row align-items-center justify-content-center m-0 py-4 br-bottom">
                <c:forEach var="donHangChiTiet" items="${donHangChiTietList}">
                    <div class="col-xl-5 col-lg-5 col-md-5 col-12">
                        <div class="cart_single d-flex align-items-start mfliud-bot">
                            <div class="cart_selected_single_thumb">
                                <a href="#">
                                    <img src="<c:out value="${donHangChiTiet.chiTietSP.sanPham.hinhNen}"/>" width="75" class="img-fluid rounded" alt="">
                                </a>
                            </div>
                            <div class="cart_single_caption pl-3">
                                <p class="mb-0">Số Lượng: <span class="text-muted small"><c:out value="${donHangChiTiet.soLuong}"/></span></p>
                                <h4 class="product_title fs-sm ft-medium mb-1 lh-1">
                                    <a href="#"><c:out value="${donHangChiTiet.chiTietSP.sanPham.ten}"/></a>
                                </h4>
                                <p class="mb-2">
                                    <span class="text-dark medium"><c:out value="${donHangChiTiet.chiTietSP.kichCo.ten}"/></span>,
                                    <span class="text-dark medium"><c:out value="${donHangChiTiet.chiTietSP.mauSac.ten}"/></span>
                                </p>
                                <h4 class="fs-sm ft-bold mb-0 lh-1"><c:out value="${donHangChiTiet.donGia * donHangChiTiet.soLuong}"/>.đ</h4>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-lg-3 col-md-3 col-6">
                        <p class="mb-1 p-0"><span class="text-muted">Trạng Thái</span></p>
                        <div class="delv_status">
                            <c:choose>
                                <c:when test="${donHangChiTiet.hoaDon.trangThai eq 0}">
                                    <span class="badges bg-lighthuy">Đã Hủy</span>
                                </c:when>
                                <c:when test="${donHangChiTiet.hoaDon.trangThai eq 1}">
                                    <span class="badges bg-lightgreen">Thành Công</span>
                                </c:when>
                                <c:when test="${donHangChiTiet.hoaDon.trangThai eq 2}">
                                    <span class="badges bg-lightyellow">Chờ Xác Nhận</span>
                                </c:when>
                                <c:when test="${donHangChiTiet.hoaDon.trangThai eq 3}">
                                    <span class="badges bg-lightblue">Đã Xác Nhận</span>
                                </c:when>
                                <c:when test="${donHangChiTiet.hoaDon.trangThai eq 4}">
                                    <span class="badges bg-lightviolet">Đang Vận Chuyển</span>
                                </c:when>
                                <c:otherwise>
                                    <span class="badges bg-lightblack">Trạng thái không hợp lệ</span>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <br>
                        <div class="delv_status">
                            <c:choose>
                                <c:when test="${donHangChiTiet.hoaDon.trangThai ne 1}">
                                    <span class="badges bg-lightblue">Chưa Thanh Toán</span>
                                </c:when>
                                <c:when test="${donHangChiTiet.hoaDon.trangThai eq 1}">
                                    <span class="badges bg-lightgreen">Đã Thanh Toán</span>
                                </c:when>
                                <c:otherwise>
                                    <span class="badges bg-lightblack">Trạng thái không hợp lệ</span>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="col-xl-4 col-lg-4 col-md-4 col-6">
                        <p class="mb-1 p-0"><span class="text-muted">Ngày Đặt Hàng </span></p>
                        <h6 class="mb-0 ft-medium fs-sm"> ${donHangChiTiet.hoaDon.ngayTao}</h6>
                    </div>
                </c:forEach>
            </div>
        </div>




        <div class="text-right">
            <input type="text" name="idDonHang" id="idDonHang" value="${idDonHang}" style="display: none">
            <c:choose>
                <c:when test="${trangThai == 2}">
                    <a id="xacNhanButton" class="btn btn-success">Xác nhận</a>
                </c:when>
                <c:when test="${trangThai == 3}">
                    <a id="donHangChoGiao" class="btn btn-success">Giao Hàng</a>
                </c:when>
                <c:when test="${trangThai == 4}">
                    <a id="donHangDangGiao" class="btn btn-success">Giao Hàng Thành Công</a>
                </c:when>
            </c:choose>
            <a id="huyButton" class="btn btn-danger" data-toggle="modal" data-target="#huyModal">Hủy</a>


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
                            <input type="text" id="lyDo" name="lyDO" class="form-control" style="display: none;"
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


</body>
</html>
