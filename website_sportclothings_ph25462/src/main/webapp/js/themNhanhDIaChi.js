

var nameAndAddressRegex = /^[a-zA-Z0-9\sàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+$/u;
var namePattern = /^[a-zA-Z\sàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸ/]+$/u;
var phoneNumberRegex = /^\d{10,11}$/;

function validateForm() {
    var hoTen = document.getElementById("hoTen").value;
    var soDienThoai = document.getElementById("soDienThoai").value;
    var diaChi = document.getElementById("diaChi").value;
    var loaiDiaChi = document.querySelector('input[name="loaiDiaChi"]:checked');
    var city = document.getElementById("city").value;
    var district = document.getElementById("district").value;
    var ward = document.getElementById("ward").value;

    if (
        hoTen.trim() === "" ||
        soDienThoai.trim() === "" ||
        diaChi.trim() === "" ||
        !loaiDiaChi ||
        city === "" ||
        district === "" ||
        ward == null ||
        ward === ""
    ) {

        Swal.fire({
            icon: 'error',
            title: 'Lỗi!',
            text: 'Vui lòng điền đầy đủ thông tin và chọn các trường.',
        });
        return false;
    } else if (
        ward == 0 ||
        ward == null ||
        ward === "" ||
        ward === 0
    ) {

        Swal.fire({
            icon: 'error',
            title: 'Lỗi!',
            text: 'Vui lòng chọn Xã Phường. ',
        });
        return false;
    } else if (!nameAndAddressRegex.test(hoTen) || !nameAndAddressRegex.test(diaChi) || hoTen.length < 3 || diaChi.length < 3) {
        Swal.fire({
            icon: 'error',
            title: 'Lỗi!',
            text: 'Điền ít nhất 3 kí tự và không điền kí tự đặc biệt',
        });
        return false;
    } else if (!phoneNumberRegex.test(soDienThoai)) {
        Swal.fire({
            icon: 'error',
            title: 'Lỗi!',
            text: 'Vui lòng điền đúng số điện thoại.',
        });
        return false;
    } else if (!namePattern.test(hoTen)) {
        Swal.fire({
            icon: 'error',
            title: 'Lỗi!',
            text: 'Tên Người Phải Nhập Là Chữ cái',
        });
        return false;
    }


    // Các điều kiện validate khác có thể được thêm ở đây

    return true;
}

function confirmAddDiaChi() {
    // Hiển thị hộp thoại xác nhận

    if (validateForm()) {


        Swal.fire({
            icon: 'question',
            title: 'Xác nhận',
            text: 'Bạn có chắc chắn muốn thêm địa chỉ?',
            showCancelButton: true,
            confirmButtonText: 'Đồng ý',
            cancelButtonText: 'Hủy bỏ',
        }).then((result) => {
            // Nếu người dùng đồng ý, thực hiện validate và gửi bằng AJAX
            if (result.isConfirmed) {
                var form = document.forms["address"];
                var addUrl = "/create_address";

                $.ajax({
                    type: 'POST',
                    url: addUrl,
                    data: $(form).serialize(), // Gửi dữ liệu form qua Ajax
                    success: function () {
                        Swal.fire({
                            icon: 'success',
                            title: 'Thành công',
                            text: ' Đã Thêm Địa Chỉ Mới.',
                        }).then((result) => {
                            // Sau khi hộp thoại đóng, kiểm tra xem người dùng đã nhấn nút "OK" hay chưa
                            if (result.isConfirmed) {
                                // Đóng modal
                                var modal = document.getElementById("addressModal");
                                modal.style.display = 'none';

                                // Cập nhật nội dung trang hoặc thực hiện các hành động khác theo yêu cầu của bạn
                                location.reload();
                            }
                        });
                    },
                    error: function () {
                        Swal.fire({
                            icon: 'error',
                            title: 'Lỗi!',
                            text: 'Đã xảy ra lỗi khi thêm địa chỉ nhập đầy đủ thông tin.',
                        });
                    }
                });

            }
        });
    }
    // Ngăn chặn sự kiện mặc định (chuyển hướng trang khi nhấn vào nút submit)
    return false;
}


// thêm nhan địa chỉ
document.addEventListener('DOMContentLoaded', function () {
    // Get the modal and buttons
    var modal = document.getElementById('addressModal');
    var openModalBtn = document.getElementById('openModalBtn');
    var closeModalBtn = document.getElementById('closeModalBtn');

    // Open the modal
    openModalBtn.onclick = function () {
        modal.style.display = 'block';
    }

    // Close the modal
    closeModalBtn.onclick = function () {
        modal.style.display = 'none';
    }

    // Close the modal if the user clicks outside of it
    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = 'none';
        }
    }

    // You can handle the submission of the address here
    var submitAddressBtn = document.getElementById('submitAddressBtn');
    submitAddressBtn.onclick = function () {
        var addressInput = document.getElementById('addressInput').value;
        // Process the address as needed

        // You can add additional logic to handle the submitted address
        // For example, you might want to send it to a server for further processing
    }
});


// mở modal
$(document).ready(function () {
    // Lưu ý: Chuyển đoạn mã JavaScript này vào một file riêng nếu có thể để tách biệt logic và giao diện.

    // Hàm mở cửa sổ popup
    function openWebPage(url) {
        window.open(url, 'popupWindow', 'width=600,height=400,scrollbars=yes');
    }

    // Gắn sự kiện cho nút hoặc liên kết
    $('a.btn').click(function (event) {
        // Ngăn chặn hành động mặc định của liên kết
        event.preventDefault();

        // Lấy URL từ thuộc tính href của liên kết
        var url = $(this).attr('href');

        // Gọi hàm mở cửa sổ popup
        openWebPage(url);
    });
});


$(document).ready(function () {
    // Gọi hàm khi trang được tải
    updateShippingFee($('select[name="address"]')[0]);

    // Đăng ký sự kiện onchange cho thẻ select
    $('select[name="address"]').change(function () {
        updateShippingFee(this);
    });
});


// lấy Tỉnh, Huyện, Xã cho modal

$(document).ready(function () {
    // Lấy danh sách tỉnh/thành phố khi trang được tải
    getProvinceList();

    function getProvinceList() {
        $.ajax({
            url: 'https://online-gateway.ghn.vn/shiip/public-api/master-data/province',
            type: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Token': '815fc5c9-9e33-11ee-96dc-de6f804954c9'
            },
            success: function (response) {
                // Xử lý danh sách tỉnh/thành phố
                var provinceList = response.data;

                // Cập nhật danh sách tỉnh/thành phố vào select
                updateProvinceSelect(provinceList);
            },
            error: function (error) {
                console.error('Lỗi khi lấy danh sách tỉnh/thành phố:', error);
            }
        });
    }

    //Hiển Thị Tỉnh
    function updateProvinceSelect(provinceList) {
        var selectElement = $('select[name="idTinhThanhPho"]');
        var inputTenTinh = $('input[name="tinhThanhPho"]');
        selectElement.empty(); // Xóa tất cả các option hiện tại

        // Thêm option mặc định
        selectElement.append('<option value="0">Chọn Tỉnh/Thành Phố</option>');

        // Thêm từng tỉnh/thành phố vào select
        $.each(provinceList, function (index, province) {
            var provinceID = province.ProvinceID;
            var provinceName = province.ProvinceName;
            selectElement.append('<option value="' + provinceID + '">' + provinceName + '</option>');
        });

        // Xử lý sự kiện khi lựa chọn thay đổi
        selectElement.on('change', function () {
            // Lấy giá trị tên tỉnh của lựa chọn đã chọn
            var selectedProvinceName = $(this).find(':selected').text();
            // Gán giá trị tên tỉnh vào inputTenTinh
            inputTenTinh.val(selectedProvinceName);
        });
    }


});


$(document).ready(function () {
    // Lấy danh sách tỉnh/thành phố khi trang được tải
    getProvinceList();

    // Sự kiện khi chọn tỉnh/thành phố
    $('select[name="idTinhThanhPho"]').change(function () {
        var selectedProvinceID = $(this).val();

        // Nếu đã chọn một tỉnh/thành phố
        if (selectedProvinceID !== '0') {
            // Lấy danh sách quận/huyện dựa trên tỉnh/thành phố đã chọn
            getDistrictList(selectedProvinceID);
        }
    });

    // Sự kiện khi chọn quận/huyện
    $('select[name="districtID"]').change(function () {
        var selectedDistrictID = $(this).val();

        // Nếu đã chọn một quận/huyện
        if (selectedDistrictID !== '0') {
            // Lấy danh sách phường/xã dựa trên quận/huyện đã chọn
            getWardList(selectedDistrictID);
        }
    });

    function getProvinceList() {
        // Gọi API lấy danh sách tỉnh/thành phố và cập nhật select
        // (Code giống như trong câu hỏi trước)
    }


    //Lấy danh sach
    function getDistrictList(selectedProvinceID) {
        // Gọi API lấy danh sách quận/huyện dựa trên tỉnh/thành phố đã chọn và cập nhật select
        $.ajax({
            url: 'https://online-gateway.ghn.vn/shiip/public-api/master-data/district',
            type: 'GET',
            data: {province_id: selectedProvinceID},
            headers: {
                'Content-Type': 'application/json',
                'Token': '815fc5c9-9e33-11ee-96dc-de6f804954c9'
            },
            success: function (response) {
                // Xử lý danh sách quận/huyện
                var districtList = response.data;
                updateDistrictSelect(districtList);
            },
            error: function (error) {
                console.error('Lỗi khi lấy danh sách quận/huyện:', error);
            }
        });
    }

    function getWardList(selectedDistrictID) {
        // Gọi API lấy danh sách phường/xã dựa trên quận/huyện đã chọn và cập nhật select
        $.ajax({
            url: 'https://online-gateway.ghn.vn/shiip/public-api/master-data/ward',
            type: 'GET',
            data: {district_id: selectedDistrictID},
            headers: {
                'Content-Type': 'application/json',
                'Token': '815fc5c9-9e33-11ee-96dc-de6f804954c9'
            },
            success: function (response) {
                // Xử lý danh sách phường/xã
                var wardList = response.data;
                updateWardSelect(wardList);
            },
            error: function (error) {
                console.error('Lỗi khi lấy danh sách phường/xã:', error);
            }
        });
    }

    // Hiển thị quận huyện
    function updateDistrictSelect(districtList) {
        // Cập nhật select của quận/huyện
        var selectElement = $('select[name="districtID"]');
        var inputTenHuyen = $('input[name="quanHuyen"]');
        selectElement.empty();
        selectElement.append('<option value="0">Chọn Quận/Huyện</option>');

        $.each(districtList, function (index, district) {
            var districtID = district.DistrictID;
            var districtName = district.DistrictName;

            // Thêm option vào selectElement
            selectElement.append('<option value="' + districtID + '">' + districtName + '</option>');
        });

        // Xử lý sự kiện khi lựa chọn thay đổi
        selectElement.on('change', function () {
            // Lấy giá trị tên huyện của lựa chọn đã chọn
            var selectedDistrictName = $(this).find(':selected').text();
            // Gán giá trị tên huyện vào inputTenHuyen
            inputTenHuyen.val(selectedDistrictName);
        });
    }


    // Hiển thị Phường xã
    function updateWardSelect(wardList) {
        // Cập nhật select của phường/xã
        var selectElement = $('select[name="wardCode"]');
        var inputTenXa = $('input[name="phuongXa"]');
        selectElement.empty();
        selectElement.append('<option value="0">Chọn Phường/Xã</option>');

        $.each(wardList, function (index, ward) {
            var WardCode = ward.WardCode;
            var wardName = ward.WardName;
            selectElement.append('<option value="' + WardCode + '">' + wardName + '</option>');
        });

        // Xử lý sự kiện khi lựa chọn thay đổi
        selectElement.on('change', function () {
            // Lấy giá trị tên phường/xã của lựa chọn đã chọn
            var selectedWardName = $(this).find(':selected').text();
            // Gán giá trị tên phường/xã vào inputTenXa
            inputTenXa.val(selectedWardName);
        });
    }

});


// lấy giá ship
function updateShippingFee(selectElement) {

    var selectedOption = selectElement.options[selectElement.selectedIndex];
    var districtID = selectedOption.getAttribute('data-districtID');
    var wardCode = selectedOption.getAttribute('data-wardCode');

    // gán tổng tiền
    var inputTongTien = $('input[name="tongTien"]').val();
    //$('#hienThiTongTien').text(inputTongTien);


    //gán tên với SDT
    var tenKhachHang = selectedOption.getAttribute('data-ten');
    var SDTKhachHang = selectedOption.getAttribute('data-SDT');
    var idSoDiaChi = selectedOption.getAttribute('data-id');


    $('#hienThiTen').val(tenKhachHang);
    $('#hienThiSDT').val(SDTKhachHang);

    // Sự kiện khi nút "Sửa Địa Chỉ" được click
    $('#suaDiaChi').click(function () {
        /*Lấy giá trị idSoDiaChi tương ứng*/
        ;
        window.location.href = "/user/editAddress/" + idSoDiaChi;
    });


    $.ajax({
        url: 'https://online-gateway.ghn.vn/shiip/public-api/v2/shipping-order/preview',
        type: 'POST',
        headers: {
            'token': '815fc5c9-9e33-11ee-96dc-de6f804954c9',
            'Content-Type': 'application/json',
            'ShopId': '4778514'
        },
        data: JSON.stringify({
            // ... (Các trường thông tin khác),

            "payment_type_id": 2,
            "note": "Tintest 123",
            "required_note": "KHONGCHOXEMHANG",
            "return_phone": "0333484685",
            "return_address": "39 NTT",
            "return_district_id": null,
            "return_ward_code": "",
            "client_order_code": "",
            "to_name": "TinTest124",
            "to_phone": "0987654321",
            "to_address": "Đường Trịn Văn Bô, Phường Phương Canh, Quận Nam Từ Liêm, Hà Nội",
            "to_ward_code": wardCode,
            "to_district_id": districtID,
            "cod_amount": 2000,
            "content": "ABCDEF",
            "weight": 200,
            "length": 10,
            "width": 20,
            "height": 5,
            "pick_station_id": 0,
            "insurance_value": 2000,
            "service_id": 0,
            "service_type_id": 2,
            "coupon": null,
            "pick_shift": [2],
            "items": [
                {
                    "name": "Quần Áo",
                    "code": "Polo123",
                    "quantity": 1,
                    "price": 2000000,
                    "length": 20,
                    "width": 10,
                    "height": 5,
                    "category":
                        {
                            "level1": "Áo"
                        }
                }

            ]


        }),

        success: function (response) {
            // Xử lý phản hồi từ API
            var shippingFee = response.data.total_fee; // Thay 'total_fee' bằng trường phù hợp từ API của bạn
            var duKienGiao = response.data.expected_delivery_time;

            // Cập nhật hiển thị phí vận chuyển trên trang
            $('#phiVanChuyen').text(shippingFee + ".đ");
            $('#ngayDuKienGiao').text(duKienGiao);
            $('#shippingFee').val(shippingFee);


            var tongTienNumber = parseFloat(inputTongTien);
            var phiVanChuyenNumber = parseFloat(shippingFee);

            var tongTien = (tongTienNumber + phiVanChuyenNumber);

            $('#hienThiTongTien').text(tongTien +'.₫');

            // $('#suaDiaChi').attr("href", "/user/edit/" + idSoDiaChi);

            $(document).ready(function () {
                // Gọi hàm khi trang được tải
                updateShippingFee($('select[name="address"]')[0]);

                // Đăng ký sự kiện onchange cho thẻ select
                $('select[name="address"]').change(function () {
                    updateShippingFee(this);
                });

            });


        },
        error: function (error) {
            console.error('Lỗi khi gọi API:', error);
        }
    });
}

$(document).ready(function () {


});


function validateAndSubmit() {
    var tongTien = document.getElementById("tongTienPC").value || 0;
    var diaChi = document.getElementById("idDiaChi").value;

    if (tongTien <= 0) {
        Swal.fire({
            icon: 'error',
            title: 'Lỗi!',
            text: 'Giỏ Hàng Đang Trống Hãy Quay Lại Tiếp Tục Mua Sắm Nhé!',
        });
        return false;
    }

    if (diaChi === "") {
        Swal.fire({
            icon: 'error',
            title: 'Lỗi!',
            text: 'Hãy Địa Chỉ Nhận Hàng Để Đặt Hàng.',
        });
        return false;
    }

    // Nếu không có lỗi, hiển thị hộp thoại xác nhận
    Swal.fire({
        title: 'Xác nhận đặt hàng',
        text: 'Bạn có chắc chắn muốn đặt hàng không?',
        icon: 'question',
        showCancelButton: true,
        confirmButtonText: 'Đồng ý',
        cancelButtonText: 'Hủy',
    }).then((result) => {
        if (result.isConfirmed) {
            // Nếu người dùng đồng ý, tiếp tục submit form
            document.getElementById("checkoutForm").submit();
        }
    });
}

