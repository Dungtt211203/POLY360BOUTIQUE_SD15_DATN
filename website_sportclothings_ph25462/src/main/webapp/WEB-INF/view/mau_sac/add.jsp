<%@ page pageEncoding="utf-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
<link
        rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css"
/>
<link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet"
/>
<style>

    body{
        background-color: #D9D9D9;
    }
    .formAdd{
        width: 700px;
        height: 600px;
        margin: 0 auto;
        background-color: #37517E;
        border-radius: 20px;
        color: #FFFFFF;
        font-family: "Nunito";
    }

    form{
        margin-left: 50px;
    }

    .formAdd>form>.mb-3>.col-sm-8{
        margin-top: 20px;
    }

    .formAdd>h1{
        text-align: center;
        padding-top: 40px;
    }
    .formAdd>form>.mb-3>label{
        margin-top: 20px;
    }

    .buttonSubmit{
        margin-top: 50px;
        margin-left: -50px;
        text-align: center;
    }
    .buttonSubmit>button{
        background-color: #FFFFFF;
        color: black;
        font-weight: bold;
        width: 120px;
        height: 40px;
        border-radius: 10px;
        border: 0px;
    }

    .radioButton{
        margin-top: 10px;
    }
</style>
<br>

<body>
<div class="formAdd">
    <h1>THÊM/SỬA MÀU SẮC</h1>

<%--    <form:form action="/mau-sac/hien-thi-add" method="post" modelAttribute="ms">--%>
<%--        TenMauSac: <form:input path="ten"/>--%>
<%--        <br/>--%>
<%--    </form:form>--%>
</div>
</body>
