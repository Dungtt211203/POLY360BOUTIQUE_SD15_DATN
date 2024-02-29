<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:th="http://www.thymeleaf.org" lang="zxx">
<head>

    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Registration</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <meta charset="UTF-8"/>
    <meta name="description" content="Ogani Template"/>
    <meta name="keywords" content="Ogani, unica, creative, html"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>LOGIN POLY360BOUTIQUE</title>
    <link rel="icon" href="../../../svg/logohome.svg">
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet"/>
</head>

<style>
    body {
        display: flex;
        align-items: center;
        justify-content: center;
        height: 100vh;
        margin: 0;
        margin: auto;
    }

    .container {
        width: 1000px;
        overflow: hidden;
        background-color: orange;
        border-radius: 20px;
    }

    .image-container {
        width: 50%;
        float: left;
    }

    .image-container img {
        width: 100%;
        height: auto;
    }

    .registration-container {
        width: 50%;
        padding: 20px;
        box-sizing: border-box;
        float: left;
    }

    .registration-container h3 {
        text-align: center;
        font-weight: bold;
    }

    .registration-container input {
        width: 100%;
        padding: 12px;
        margin-bottom: 15px;
        box-sizing: border-box;
        border: 1px solid #ccc;
        border-radius: 20px;
        outline: none;
    }

    .registration-container button {
        background-color: #7fad39;
        border-radius: 30px;
        box-shadow: 7px 7px 10px rgba(0, 0, 0, 0.15);
        color: #fff;
        display: block;
        font-size: 16px;
        margin: 25px 0 15px;
        padding: 18px;
        text-align: center;
        text-decoration: none;
        cursor: pointer;
    }

    .registration-container button:hover {
        background-color: #90d626;
    }
</style>


<body>
<th:block th:include="/login/on" th:if="${taikhoandto.email}"></th:block>
<th:block th:include="/login/off" th:unless="${taikhoandto.email}"></th:block>

<%--<div class="container">--%>
<%--    <div class="row">--%>
<%--        <div class="col-md-6 col-md-offset-3">--%>

<%--                <div class="image-container">--%>
<%--                    <img src="../../../svg/logoLogin.png" alt="Nice Shoe Image">--%>
<%--                </div>--%>

<%--            <!-- success message -->--%>
<%--            <div th:if="${param.success}">--%>
<%--                <div class="alert alert-info"> You are successfull registered to our awsome app!</div>--%>
<%--            </div>--%>

<%--            <h1>Registration</h1>--%>
<%--            <form th:action="@{/registration}" method="post" th:object="${userdto}">--%>
<%--                <div class="form-group">--%>
<%--                    <label class="control-label" for="Email"> Email </label>--%>
<%--                    <input type="text" id="Email" class="form-control" th:field="*{email}" required--%>
<%--                           autofocus="autofocus"/>--%>
<%--                </div>--%>
<%--                <div th:if="${param.emailexist}">--%>
<%--                    <div class="alert alert-info"> You email have exist please register other email</div>--%>
<%--                </div>--%>

<%--                <div class="form-group">--%>
<%--                    <label class="control-label" for="UserDisplayName"> UserDisplayName </label>--%>
<%--                    <input type="text" id="UserDisplayName" class="form-control" th:field="*{userDisplayName}"--%>
<%--                           required/>--%>
<%--                </div>--%>

<%--                <div class="form-group">--%>
<%--                    <label class="control-label" for="Password"> Password </label>--%>
<%--                    <input type="password" id="Password" class="form-control" th:field="*{password}" required/>--%>
<%--                </div>--%>

<%--                <div class="form-group">--%>
<%--                    <label class="control-label" for="checkpass"> Check Password </label>--%>
<%--                    <input type="password" id="checkpass" class="form-control" th:field="*{checkPass}" required/>--%>
<%--                </div>--%>

<%--                <div th:if="${param.checkpass}">--%>
<%--                    <div class="alert alert-info"> You password and checkpass not same ! Please checkout it!</div>--%>
<%--                </div>--%>

<%--                <div class="form-group">--%>
<%--                    <button type="submit" class="btn btn-success">Register</button>--%>
<%--                    <span>Already registered ? <a href="/" th:href="@{/login}">Login here</a></span>--%>
<%--                </div>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>


<div class="container">
    <div class="image-container">
        <img src="../../../svg/logoLogin.png" alt="Nice Shoe Image">
    </div>

    <div class="registration-container">

        <form th:action="@{/registration}" method="post" th:object="${taikhoandto}" onsubmit="return validateForm()">
            <h2 style="text-align: center; font-weight: bold">ĐĂNG KÝ</h2>
            <br>
            <%--            <span class="header-title">--%>
            <%--                <span style="font-size: 17px;">Tên tài khoản</span>--%>
            <%--                --%>
            <%--                <input type="text" id="Email" class="form-control" th:field="*{email}" required--%>
            <%--                       autofocus="autofocus"/>--%>
            <%--                --%>
            <%--                </span>--%>

            <div class="form-group">
                <label class="control-label" for="Email"> Email </label>
                <input type="text" id="Email" class="form-control" th:field="*{email}" required
                       autofocus="autofocus"/>
            </div>
            <input id="usernameRegis" type="text" class="form-control" placeholder="Tên tài khoản..." required=""/>

            <br>
            <span class="header-title">
                    <span style="color: red"></span>
                    <span style="font-size: 17px;">Email</span>
<%--                <input type="text" id="Email" class="form-control" th:field=" *{email} "--%>
<%--                       required autofocus="autofocus"/>--%>
                </span>
            <input id="emailRegis" type="text" class="form-control" placeholder="Email..." required=""/>
            <br>

            <span class="header-title">
                    <span style="color: red"></span>
                    <span style="font-size: 17px;">Mật khẩu</span>
                </span>
            <input id="passwordRegis" type="password" class="form-control" placeholder="Mật khẩu..." required=""/>
            <br>
            <button type="submit" class="btn btn-warning"
                    style="color: white; background-color: black; margin-left: 190px;">Đăng
                ký
            </button>
        </form>
    </div>
</div>

<script>
    function validateForm() {
        var username = document.getElementById("usernameRegis").value;
        var email = document.getElementById("emailRegis").value;
        var password = document.getElementById("passwordRegis").value;

        if (username.trim() === "") {
            alert("Tên tài khoản không được để trống");
            return false;
        }

        if (email.trim() === "") {
            alert("Email không được để trống");
            return false;
        }

        if (password.trim() === "") {
            alert("Mật khẩu không được để trống");
            return false;
        }

        // Add more validation logic if needed

        return true;
    }
</script>
</body>

</html>
