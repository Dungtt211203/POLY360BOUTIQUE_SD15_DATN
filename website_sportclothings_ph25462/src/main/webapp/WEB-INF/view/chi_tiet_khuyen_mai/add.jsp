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
        height: 1000px;
        margin: 0 auto;
        background-color: orange;
        border-radius: 20px;
        color: #FFFFFF;
        font-family: "Nunito";
    }

    input {
        width: 300px;
        margin-right: 20px;
        border-radius: 10px;
        border: none;
    }

    .input {
        display: flex;
        justify-content: space-between;
        margin-top: 50px;

    }

    .input label {
        padding-left: 50px;
    }

    #but {
        margin-left: 300px;
        width: 200px;
        border-radius: 10px;
        background-color: #3e8e41;
        font-weight: bold;
        margin-top: 70px;

    }

    h1 {
        text-align: center;
    }

    .tt {
        margin-left: 50px;
        margin-top: 50px;
    }

    .radio1 {
        margin-left: -135px;
    }
</style>
<br>

<body>
<div class="formAdd">
    <h1>THÊM/SỬA KHUYẾN MẠI CHI TIẾT</h1>
    <form:form action="/admin/chi-tiet-khuyen-mai/hien-thi-add" method="post" modelAttribute="ctkm">
        <div class="input">
            <label>Mã Khuyến Mại Chi Tiết</label>:
            <form:input path="maChiTietKhuyenMai"/>
            <form:errors path="maChiTietKhuyenMai" cssStyle="color: red"/>
            <br/>
        </div>

        <div id="hinhThucGiam">
            <label class="htg">Hình Thức giảm: </label>
            <form:radiobutton path="hinhThucGiam" value="1" checked="true" class="radio1"/>
            <span class="sp_next">Giảm theo %</span>
            <br>
            <form:radiobutton path="hinhThucGiam" value="0" class="radio"/> <span
                class="sp_next">Giảm theo thành viên</span>
            <br/>
        </div>

        <div class="input">
            <label>Giá Trị Giảm</label>:
            <form:input path="giaTriGiam"/>
            <form:errors path="giaTriGiam" cssStyle="color: red"/>
            <br/>
        </div>

        <form:select path="chiTietSP">
            <option value="">Chọn Một Sản Phẩm</option>
            <form:options items="${chiTietSP}" itemLabel="sanPham.ten" itemValue="id"/>
        </form:select><br>


        <form:select path="khuyenMai">
            <option value="">Chọn Một Khuyến Mãi</option>
            <form:options items="${khuyenMai}" itemLabel="tenKhuyenMai" itemValue="id"/>
        </form:select><br>


        <%--        <div class="input">--%>
        <%--            <label>Ngày Bắt Đầu</label>: <form:input type="datetime-local" path="ngayBatDau"/>--%>
        <%--            <form:errors path="ngayBatDau" cssStyle="color: red"/>--%>
        <%--            <br/>--%>
        <%--        </div>--%>
        <form:button type="submit" class="btn btn-success" id="but">ADD</form:button>

    </form:form>
    <button class="btn btn-primary"><a href="/chi-tiet-khuyen-mai/hien-thi"
                                       style="text-decoration: none;color: #FFFFFF">QUAY LẠI</a></button>


</div>
</body>
