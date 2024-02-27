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
    <h1>THÊM/SỬA NHÂN VIÊN</h1>
    <form:form action="/nhan-vien/hien-thi-add" method="post" modelAttribute="nhanVien">
        <div class="input">
            <label>Mã Nhân Viên</label>: <form:input path="ma"/>
            <form:errors path="ma" cssStyle="color: red"/>
            <br/>
        </div>
        <div class="input">
            <label>Họ Nhân Viên</label>: <form:input path="ho"/>
            <form:errors path="ho" cssStyle="color: red"/>
            <br/>
        </div>
        <div class="input">
            <label>Tên Đệm Nhân Viên</label>: <form:input path="tenDem"/>
            <form:errors path="tenDem" cssStyle="color: red"/>
            <br/>
        </div>
        <div class="input">
            <label>Tên Nhân Viên</label>: <form:input path="ten"/>
            <form:errors path="ten" cssStyle="color: red"/>
            <br/>
        </div>
        <label class="tt">Giới Tính:</label> <form:radiobutton path="gioiTinh" value="1" checked="true" class="radio1"/>Nam
        <form:radiobutton path="gioiTinh" value="0" class="radio"/>Nữ
        <br/>
        <div class="input">
            <label>Địa Chỉ</label>: <form:input path="diaChi"/>
            <form:errors path="diaChi" cssStyle="color: red"/>
            <br/>
        </div>
        <div class="input">
            <label>Số Điện Thoại</label>: <form:input path="sdt"/>
            <form:errors path="sdt" cssStyle="color: red"/>
            <br/>
        </div>
        <div class="input">
            <label>Email</label>: <form:input path="email"/>
            <form:errors path="email" cssStyle="color: red"/>
            <br/>
        </div>
        <div id="tt">
            <label class="tt">Trạng Thái:</label> <form:radiobutton path="tt" value="0" checked="true" class="radio1"/>Hoạt
            Động
            <form:radiobutton path="tt" value="1" class="radio"/>Không Hoạt Động
            <br/>
        </div>
        <form:button type="submit" class="btn btn-success" id="but">Add</form:button>
    </form:form>
</div>
</body>
