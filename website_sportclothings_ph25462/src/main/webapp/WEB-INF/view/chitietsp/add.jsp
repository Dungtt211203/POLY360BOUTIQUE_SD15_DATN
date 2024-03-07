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
    <h1>THÊM/SỬA CTSP</h1>
    <form:form method="post" action="/chitietsp/add" modelAttribute="ctsp">
        <div class="input">
            <label>Mã CTSP</label>: <form:input path="maChiTietSanPham"/>
            <form:errors path="maChiTietSanPham" cssStyle="color: #ff0000"/>
            <br/>
        </div>
        <div class="input">
            <label>Số Lượng</label>: <form:input path="soLuong"/>
            <form:errors path="soLuong" cssStyle="color: #ff0000"/>
            <br/>
        </div>

        <div class="input">
            <label>Ngay tao</label>: <form:input type="date" path="ngayTao"/>
            <form:errors path="ngayTao" cssStyle="color: red"/>
            <br/>
        </div>
        <div class="input">
            <label>Ngay sua</label>: <form:input type="date" path="ngaySua"/>
            <form:errors path="ngaySua" cssStyle="color: red"/>
            <br/>
        </div>

        TenSP: <form:select path="sanPham">
        <form:options items="${sanPham}" itemLabel="ten"/>
    </form:select><br>
        KichCo: <form:select path="kichCo">
        <form:options items="${kichCo}" itemLabel="ten"/>
    </form:select><br>
        Mau Sac: <form:select path="mauSac">
        <form:options items="${mauSac}" itemLabel="ten"/>
    </form:select><br>
        ChatLieu: <form:select path="chatLieu">
        <form:options items="${chatLieu}" itemLabel="ten"/>
    </form:select><br>
        ThuongHieu: <form:select path="thuongHieu">
        <form:options items="${thuongHieu}" itemLabel="ten"/>
    </form:select><br>
        <form:button class="btn btn-primary">Add</form:button>
    </form:form>
</div>
</body>
