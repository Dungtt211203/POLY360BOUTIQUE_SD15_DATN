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
        /*margin-right: 20px;*/
        border-radius: 10px;
        border: none;
    }

    .input {
        display: flex;
        justify-content: space-between;
        margin-top: 50px;

    }

    /*.input label {*/
    /*    padding-left: 50px;*/
    /*}*/

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
        padding-top: 1.2rem;
    }

    /*.tt {*/
    /*    margin-left: 50px;*/
    /*    margin-top: 50px;*/
    /*}*/

    /*.sp_next{*/
    /*    margin-right: -100px;*/
    /*}*/

    /*.radio{*/
    /*    margin-right: -50px;*/
    /*}*/


</style>
<br>

<body>
<div class="formAdd">
    <h1>THÊM/SỬA HÌNH ẢNH</h1>
    <form:form action="/admin/hinh-anh/hien-thi-add" method="post" modelAttribute="hinhAnh">
        <div class="input">
            <label>URL</label>: <form:input type="file" path="url"/>
            <form:errors path="url" cssStyle="color: red"/>
            <br/>
        </div>
        <div class="input">
            <label>Ngày Tạo</label>: <form:input type="date" path="ngayTao"/>
            <form:errors path="ngayTao" cssStyle="color: red"/>
            <br/>
        </div>
        <div class="input">
            <label>Ngày Sửa</label>: <form:input type="date" path="ngaySua"/>
            <form:errors path="ngaySua" cssStyle="color: red"/>
            <br/>
        </div>
        <div id="tt">
            <label class="tt">Trạng Thái:</label> <form:radiobutton path="trangThai" value="0" checked="true"
                                                                    class="radio1"/>
            <span class="sp_next">Hoạt Động</span> <br>

            <form:radiobutton path="trangThai" value="1" class="radio"/> <span class="sp_next">Không Hoạt Động</span>
            <br/>
        </div>
        <form:button type="submit" class="btn btn-success" id="but"
                     onclick="return confirm('Bạn có chắc chắn muốn thêm hình ảnh này?')">Add</form:button>
    </form:form>
</div>
</body>
