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

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script>

        document.addEventListener("DOMContentLoaded", function () {
            var form = document.getElementById("formThemGioHang");

            form.addEventListener("submit", function (event) {
                var selectedColor = document.querySelector('input[name="mauSac"]:checked');
                var selectedSize = document.querySelector('input[name="size"]:checked');
                var quantity = document.getElementById("soLuong").value.trim();

                if (!selectedColor || !selectedSize || quantity === "") {
                    event.preventDefault(); // Ngăn chặn sự kiện submit
                    Swal.fire({
                        icon: 'error',
                        title: 'Lỗi!',
                        text: 'Vui lòng chọn màu sắc, size sản phẩm và nhập số lượng.',
                    });
                    return; // Thoát khỏi hàm để không tiếp tục xử lý
                }

                var soLuongSPConLai = parseInt(document.getElementById("soLuongConLai").textContent) || 0;
                var soLuongChon = parseInt(quantity) || 0;

                if (soLuongSPConLai <= 0 || soLuongSPConLai < soLuongChon) {
                    event.preventDefault(); // Ngăn chặn sự kiện submit
                    Swal.fire({
                        icon: 'error',
                        title: 'Xin lỗi!',
                        text: soLuongSPConLai <= 0 ? 'Sản phẩm bạn chọn đã hết hàng.' : 'Số lượng sản phẩm còn lại không đủ.',
                    });
                    return; // Thoát khỏi hàm để không tiếp tục xử lý
                }

                event.preventDefault(); // Ngăn chặn sự kiện submit
                Swal.fire({
                    icon: 'question',
                    title: 'Xác nhận',
                    text: 'Bạn có chắc chắn muốn thêm sản phẩm vào giỏ hàng?',
                    showCancelButton: true,
                    confirmButtonText: 'Đồng ý',
                    cancelButtonText: 'Hủy bỏ',
                }).then((result) => {
                    if (result.isConfirmed) {
                        // Người dùng đã xác nhận, có thể submit form
                        form.submit();
                        Swal.fire({
                            icon: 'success',
                            title: 'Thành công',
                            text: 'Đã thêm sản phẩm vào giỏ hàng.',
                        }).then((result) => {
                            window.location.reload();
                        });
                    } else {
                        console.log('Form submission canceled');
                    }
                });
            });
        });


        function kiemTraSLSP() {
            var idMau = document.querySelector('input[name="mauSac"]:checked').value || 0;
            var idSize = document.querySelector('input[name="size"]:checked').value || 0;
            var idProduct = document.getElementById("idSanPham").value || 0;

            if (idMau && idSize && idProduct) {
                console.log("Đã chọn màu: " + idMau);
                console.log("Đã chọn size: " + idSize);

                fetch('/chitietsp/kiemTraSoLuongSanPham/' + idProduct + "/" + idMau + "/" + idSize)
                    .then(response => response.json())
                    .then(data => {
                        var soLuongSP = data.soLuongSPConLai;
                        console.log("Kiểm tra số lượng sản phẩm : " + soLuongSP);

                        var soLuongConLaiElement = document.getElementById('soLuongConLai');
                        soLuongConLaiElement.textContent = soLuongSP;
                        soLuongConLaiElement.style.color = soLuongSP <= 0 ? 'red' : 'black';
                    })
                    .catch(error => {
                        console.error('Lỗi Không kiểm tra được sản phẩm! ', error);
                    });
            }
        }




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
                        $(this).text(response + ".đ");
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
                        $(this).text(response + ".đ");
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

</head>
<body>
<header>
    <jsp:include page="../template_home/header.jsp"/>
</header>
<div class="flex-box">
    <div class="left">
        <div class="big-img">
            <img class="data-image-product" data-url="http://localhost:8080/img/imgsanpham/${sanPham.hinhNen}" src="../../../img/imgsanpham/${sanPham.hinhNen}">
        </div>
        <div class="images" >
            <c:forEach var="hinhAnh" items="${hinhAnhList}">
                <div class="small-img">
                    <img class="img-th data-image-product" data-url="http://localhost:8080/img/imgsanpham/${hinhAnh.url}" src="../../../img/imgsanpham/${hinhAnh.url}" onclick="showImg(this.src)">
                </div>
            </c:forEach>
        </div>
    </div>

    <div class="right">

        <div class="pname">${sanPham.ten}</div>
        <div class="ratings">Số Lượng: <h6 id="soLuongConLai">0</h6></div>
        <div class="ratings">
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star-half-alt"></i>
        </div>

        <%--        <div class="price">${sanPham.gia} .đ</div>--%>


        <div class="price elis_rty">
<%--            <label>Giá Gốc: </label>--%>
<%--            <span class="giaGoc text-muted ft-medium line-through mr-2"--%>
<%--                  id="${sanPham.id}">Giá Gốc</span>--%>

            <label>Giá bán: </label>
            <span class="giaBan ft-bold theme-cl fs-md" id="${sanPham.id}">Giá Bán</span>
        </div>







        <form id="formThemGioHang" method="post" action="/add-to-cart/${sanPham.id}">
            <input type="text" id="idSanPham" value="${sanPham.id}" style="display: none">

            <div class="size">
                <p class="d-flex align-items-center mb-0 text-dark ft-medium">Màu:</p>
                <div class="product-color text-left">
                    <c:forEach var="color" items="${listMauSac}" varStatus="colorState">
                        <div class="form-check size-option form-option form-check-inline mb-2">
                            <input type="radio" class="form-check-input " id="mauSac" name="mauSac" value="${color.id}"
                                   onchange="kiemTraSLSP()"
                                   style="background-color: ${color.ma};width: 20px;height: 20px;border-radius: 100%">
                            <div></div>
                            <span style="margin-top: 20px;margin-left: 10px">${color.ten}</span>
                        </div>
                    </c:forEach>
                </div>
            </div>

            <div class="size">
                <p class="d-flex align-items-center mb-0 text-dark ft-medium">Size:</p>
                <div class="text-left pb-0 pt-2">
                    <c:forEach var="size" items="${listKichCo}" varStatus="sizeState">
                        <div class="form-check size-option form-option form-check-inline mb-2">
                            <input class="psize" type="radio" id="size" name="size" value="${size.id}" checked
                                   onchange="kiemTraSLSP()">
                            <span>${size.ten}</span>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="quantity">
                <p>Quantity :</p>
                <input type="number" min="1" max="1000" value="1" name="soLuong" id="soLuong">


            </div>
            <div class="btn-box">
                <c:if test="${sanPham.trangThai == 0}">
                    <button type="submit" id="addToCard" class="cart-btn">Add to Cart</button>
                    <button type="button" class="buy-btn"> <a href="/checkout/show" style="text-decoration: none;color: #ffffff">Buy Now</a></button>
                </c:if>
                <c:if test="${sanPham.trangThai == 1}">
                    <button type="submit" id="addToCard" disabled="true"
                            style="background-color: orange;color: #ffffff">Không Hoạt Động
                    </button>
                    <%--                <button type="button" class="buy-btn">Buy Now</button>--%>
                </c:if>
            </div>

        </form>


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
    let arrImage = [];
    jQuery(".data-image-product").each(function name(params) {
        arrImage.push($(this).attr("data-url"))
    })
    localStorage.setItem(${sanPham.id}, arrImage.join());
    console.log(localStorage.getItem(${sanPham.id}));
</script>
</body>
</html>

