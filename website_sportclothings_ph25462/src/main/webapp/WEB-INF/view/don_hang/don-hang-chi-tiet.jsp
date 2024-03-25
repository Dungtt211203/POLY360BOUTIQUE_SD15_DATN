<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="th" %>


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

        /* CSS cho bảng */
        table {
            width: 100%;
            border-collapse: collapse;
        }

        /* CSS cho header của bảng */
        th {
            background-color: #000000;
            color: #ffffff;
            padding: 8px;
            text-align: left;
        }

        /* CSS cho dòng chẵn trong bảng */
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        /* CSS cho dòng lẻ trong bảng */
        tr:nth-child(odd) {
            background-color: #ffffff;
        }

        /* CSS cho các ô trong bảng */
        td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ffc107; /* Đường viền dưới */
        }

        /* CSS cho khi con trỏ di chuột vào dòng trong bảng */
        tr:hover {
            background-color: orange;
        }

        /* Định dạng phần đầu của danh sách đơn hàng */
        .ord_list_wrap {
            border: 1px solid #ccc;
            margin-bottom: 20px;
        }

        /* Định dạng phần tiêu đề */
        .ord_list_head {
            background-color: #f2f2f2;
            padding: 10px;
        }

        /* Định dạng các thành phần trong phần tiêu đề */
        .ord_list_head .olh_flex {
            display: flex;
            align-items: center;
        }

        /* Định dạng các phần tử văn bản trong phần tiêu đề */
        .ord_list_head p, .ord_list_head h6 {
            margin: 0;
            padding: 0;
            font-size: 14px;
        }

        /* Định dạng văn bản màu xám */
        .ord_list_head .text-muted {
            color: #666;
        }

        /* Định dạng cho số đơn hàng và tổng tiền */
        .ord_list_head h6 {
            margin-left: 10px;
            font-weight: normal;
        }


    </style>

</head>
<body>
<header>
    <jsp:include page="../template_home/header.jsp"/>
</header>
<div>
    <h3 style="text-align: center;font-size: 30px">Chi Tiết Đơn Hàng</h3>
    <br>
</div>

<div class="ord_list_wrap border mb-4 mfliud">
    <div class="ord_list_head gray d-flex align-items-center justify-content-between px-3 py-3">
        <div class="olh_flex">
            <p class="m-0 p-0"><span class="text-muted">Mã Đơn Hàng</span></p>
            <h6 class="mb-0 ft-medium"><c:out value="${maDonHang}"/></h6>
        </div>
        <div class="olh_flex">
            <p class="m-0 p-0"><span class="text-muted">Tổng Tiền</span></p>
            <h6 class="mb-0 ft-medium"><c:out value="${tongTien}"/> đ</h6>
        </div>
    </div>
</div>

<div class="ord_list_body text-left">
    <table>
        <thead>
        <tr>
            <th>Số Lượng</th>
            <th>Tên Sản Phẩm</th>
            <th>Kích Cỡ</th>
            <th>Màu Sắc</th>
            <th>Đơn Giá</th>
            <th>Ngày Đặt Hàng</th>
            <th>Trạng Thái</th>
        </tr>
        </thead>
        <tbody>
        <!-- Loop through each order detail -->
        <c:forEach var="donHangChiTiet" items="${donHangChiTietList}">
            <tr>
                <td><c:out value="${donHangChiTiet.soLuong}"/></td>
                <td><a href="/products/${donHangChiTiet.chiTietSP.sanPham.id}"
                       th:text="${donHangChiTiet.chiTietSP.sanPham.ten}"></a></td>
                <td><c:out value="${donHangChiTiet.chiTietSP.kichCo.ten}"/></td>
                <td><c:out value="${donHangChiTiet.chiTietSP.mauSac.ten}"/></td>
                <td><c:out value="${donHangChiTiet.donGia * donHangChiTiet.soLuong}"/> đ</td>
                <td><c:out value="${donHangChiTiet.hoaDon.ngayTao}"/></td>
                <td>
                    <c:choose>
                        <c:when test="${donHangChiTiet.hoaDon.trangThai eq 0 || donHangChiTiet.trangThai eq 0}">
                            <span class="badges bg-lighthuy">Đã Hủy</span>
                        </c:when>
                        <c:when test="${donHangChiTiet.hoaDon.trangThai eq 1}">
                            <span class="badges bg-lightgreen">Thành Công</span>
                        </c:when>
                        <c:when test="${donHangChiTiet.hoaDon.trangThai eq 2}">
                            <span class="badges bg-lightblue">Chờ xác Nhận</span>
                        </c:when>
                        <c:when test="${donHangChiTiet.hoaDon.trangThai eq 3}">
                            <span class="badges bg-lightviolet">Đã Xác Nhận</span>
                        </c:when>
                        <c:when test="${donHangChiTiet.hoaDon.trangThai eq 4}">
                            <span class="badges bg-lightyellow">Đang Vận Chuyển</span>
                        </c:when>
                        <c:otherwise>
                            <span class="badges bg-lightblack">Trạng thái không hợp lệ</span>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:if test="${(donHangChiTiet.hoaDon.trangThai eq 2 || donHangChiTiet.hoaDon.trangThai eq 3) && donHangChiTiet.trangThai eq 1}">
                        <a href="/donHang/huy/${donHangChiTiet.id}" class="btn btn-danger"><span
                                class="text-muted">Hủy Đơn</span></a>
                    </c:if>
                    <c:if test="${donHangChiTiet.trangThai eq 0}">
                        <span class="badges ">Đơn Hàng Đã Hủy</span>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div style="position: fixedl">
    <jsp:include page="../template_home/footer.jsp"/>
</div>
</body>
</html>
