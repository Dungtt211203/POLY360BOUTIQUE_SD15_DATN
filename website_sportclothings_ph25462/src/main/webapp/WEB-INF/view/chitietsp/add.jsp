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
    <h1>THÊM/SỬA CTSP</h1>
    <form:form method="post" action="/chitietsp/add" modelAttribute="ctsp">
        ID:
        <form:input path="id"/><br>
        Ma:
        <form:input path="ma"/><br>
        Số Lượng:
        <form:input path="soLuong"/><br>
        Giá Gốc:
        <form:input path="giaGoc"/><br>
        Giá Hiện Hành:
        <form:input path="giaHienHanh"/><br>

        <div class="input">
            <label>Ngày Tạo</label>:
            <form:input type="datetime-local" path="ngayTao"/>
            <form:errors path="ngayTao" cssStyle="color: red"/>
            <br/>
        </div>
        <div class="input">
            <label>Ngày Sửa</label>:
            <form:input type="datetime-local" path="ngaySua"/>
            <form:errors path="ngaySua" cssStyle="color: red"/>
            <br/>
        </div>

        TenSP:
        <form:select path="sanPham">
            <form:options items="${sanPham}" itemLabel="ten"/>
        </form:select>
        <br>
        KichCo:
        <form:select path="kichCo">
            <form:options items="${kichCo}" itemLabel="ten"/>
        </form:select><br>
        Mau Sac:
        <form:select path="mauSac">
            <form:options items="${mauSac}" itemLabel="ten"/>
        </form:select><br>
        ChatLieu:
        <form:select path="chatLieu">
            <form:options items="${chatLieu}" itemLabel="ten"/>
        </form:select><br>
        ThuongHieu:
        <form:select path="thuongHieu">
            <form:options items="${thuongHieu}" itemLabel="ten"/>
        </form:select><br>

        <form:button class="btn btn-primary">Add</form:button>
    </form:form>
</div>
</body>
