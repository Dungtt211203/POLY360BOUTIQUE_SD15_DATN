<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zxx">
<head>


    <meta charset="UTF-8"/>
    <meta name="description" content="Ogani Template"/>
    <meta name="keywords" content="Ogani, unica, creative, html"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>POLY360BOUTIQUE</title>
    <link rel="icon" href="../../../svg/logohome.svg">
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet"/>
    <link rel="icon" href="../../../svg/logohome.svg">

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
<div class="container">
    <div class="image-container">
        <img src="../../../svg/logoLogin.png" alt="Nice Shoe Image">
    </div>

    <div class="registration-container">

        <form action="/poly360boutique/dang-ky/add" method="post"
              onsubmit="return validateForm()">
            <h3 style="text-align: center; font-weight: bold;font-size: 30px">POLY 360 BOUTIQUE</h3>
            <br>
            <span class="header-title">
                    <span style="color: red"></span>
                    <span style="font-size: 17px;">Email</span>
                </span>
            <input name="emailRegis" type="text" class="form-control" placeholder="Email..." required=""/>
            <br>

            <span class="header-title">
                    <span style="color: red"></span>
                    <span style="font-size: 17px;">Tên đăng nhập</span>
                </span>
            <input name="userRegis" type="text" class="form-control" placeholder="Tên đang nhập..." required=""/>
            <br>

            <span class="header-title">
                    <span style="color: red"></span>
                    <span style="font-size: 17px;">Mật khẩu</span>
                </span>
            <input name="passwordRegis" type="password" class="form-control" placeholder="Mật khẩu..." required=""/>
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
