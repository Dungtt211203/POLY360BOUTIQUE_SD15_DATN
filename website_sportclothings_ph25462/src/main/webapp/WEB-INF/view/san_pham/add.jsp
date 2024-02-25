<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
<link
        rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css"
/>
<link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet"
/>
<link rel="icon" href="../../../svg/logohome.svg">
<style>

    body {
        background-color: #D9D9D9;
    }

    .formAdd {
        width: 700px;
        height: 600px;
        margin: 0 auto;
        background-color: orange;
        border-radius: 20px;
        color: #FFFFFF;
        font-family: "Nunito";
    }
</style>
<br>
<body>
<div class="formAdd">
<<<<<<< HEAD
    <h1>THÊM/SỬA SẢN PHẨM</h1>
=======
<%--    <th>STT</th>--%>
<%--    <th>ID</th>--%>
<%--    <th>Mã Sản Phẩm</th>--%>
<%--    <th>Tên Sản Phẩm</th>--%>
<%--    <th>Mô Tả</th>--%>
<%--    <th>Ngày Tạo</th>--%>
<%--    <th>Người Tạo</th>--%>
<%--    <th>Trạng Thái</th>--%>
<%--    <th colspan="2">Action</th>--%>
    <h1>THÊM/SỬA SẢN PHẤM</h1>
>>>>>>> hoanglc_PH27504
    <form:form action="/san-pham/hien-thi-add" method="post" modelAttribute="sanPham">
        Mã Sản Phẩm: <form:input path="ma"/>
        <br/>
        Tên Sản Phẩm: <form:input path="ten"/>
        <br/>
<<<<<<< HEAD
        Mô Tả Sản Phẩm: <form:textarea path="moTa"/>
        <br/>
        Người Tạo: <form:input path="nguoiTao"/>
=======
        Mô Tả: <form:input path="mo_ta"/>
        <br/>
        Tên Ngày Tạo: <form:input path="ngay_tao"/>
        <br/>
        Tên Người Sửa: <form:input path="nguoi_sua"/>
        <br/>
        Tên Người Tạo: <form:input path="nguoi_tao"/>
>>>>>>> hoanglc_PH27504
        <br/>
        TrangThai: <form:radiobutton path="tt" value="0" checked="true"/>Hoat Dong
        <form:radiobutton path="tt" value="1"/>Khong Hoat Dong
        <br/>
        <form:button type="submit">Add</form:button>
    </form:form>
</div>
</body>
