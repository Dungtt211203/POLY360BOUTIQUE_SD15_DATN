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
    <h1>THÊM/SỬA KHUYẾN MẠI</h1>
    <form:form method="post" modelAttribute="khuyenMai">
        <div class="input">
            <label>Mã Khuyến Mại</label>:
            <form:input path="maKhuyenMai" value="${khuyenMai.maKhuyenMai}"/>
            <form:errors path="maKhuyenMai" cssStyle="color: red"/>
            <br/>
        </div>
        <div class="input">
            <label>Tên Khuyến Mại</label>:
            <form:input path="tenKhuyenMai"/>
            <form:errors path="tenKhuyenMai" cssStyle="color: red"/>
            <br/>
        </div>
        <%--        <div class="input">--%>
        <%--            <label>Giá Trị</label>: <form:input path="giaTri"/>--%>
        <%--            <form:errors path="giaTri" cssStyle="color: red"/>--%>
        <%--            <br/>--%>
        <%--        </div>--%>
        <div class="input">
            <label>Ngày Tạo</label>:
            <form:input type="datetime-local" path="ngayTao" value="${khuyenMai.ngayTao}"/>
            <form:errors path="ngayTao" cssStyle="color: red"/>
            <br/>
        </div>
        <div class="input">
            <label>Ngày Kết Thúc</label>:
            <form:input type="datetime-local" path="ngayKetThuc" value="${khuyenMai.ngayKetThuc}"/>
            <form:errors path="ngayKetThuc" cssStyle="color: red"/>
            <br/>
        </div>
        <div class="input">
            <label>Ngày Cập Nhật</label>:
            <form:input type="datetime-local" path="ngayCapNhat" value="${khuyenMai.ngayCapNhat}"/>
            <form:errors path="ngayCapNhat" cssStyle="color: red"/>
            <br/>
        </div>

        <div class="form-group">
            <label for="trangThai">Trạng thái :</label>
            <select id="trangThai" name="trangThai" class="form-control" required>
                <option value="1" <c:if test="${khuyenMai.trangThai == 1}">selected</c:if>>Sắp diễn ra</option>
                <option value="2" <c:if test="${khuyenMai.trangThai == 2}">selected</c:if>>Đang hoạt động</option>
                <option value="3" <c:if test="${khuyenMai.trangThai == 3}">selected</c:if>>Ngừng hoạt động</option>
                <option value="4" <c:if test="${khuyenMai.trangThai == 4}">selected</c:if>>Hết hạn</option>
            </select>
        </div>
        <form:button type="submit" class="btn btn-success" id="but">CẬP NHẬT</form:button>
    </form:form>
</div>
</body>
