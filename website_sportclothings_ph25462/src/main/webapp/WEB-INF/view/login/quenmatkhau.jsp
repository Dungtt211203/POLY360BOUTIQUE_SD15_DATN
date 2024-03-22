<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zxx">

<head>
    <meta charset="UTF-8" />
    <meta name="description" content="Ogani Template" />
    <meta name="keywords" content="Ogani, unica, creative, html" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>POLY360BOUTIQUE</title>
    <link rel="shortcut icon" type="image/png" href="/assets/images/z4754478488073_3d987c07976994288f3feae0cc9f3835_preview_rev_1.png" />
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet" />
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
        border-radius:20px;
    }

    .image-container {
        width: 50%;
        float: left;
    }

    .image-container img {
        width: 100%;
        height: auto;
    }

    .reset-password-container {
        width: 50%;
        padding: 20px;
        box-sizing: border-box;
        float: left;
    }

    .reset-password-container h3 {
        text-align: center;
        font-weight: bold;
    }

    .reset-password-container input {
        width: 100%;
        padding: 12px;
        margin-bottom: 15px;
        box-sizing: border-box;
        border: 1px solid #ccc;
        border-radius: 20px;
        outline: none;
    }

    .reset-password-container button {
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

    .reset-password-container button:hover {
        background-color: #90d626;
    }
</style>

<body>
<div class="container">
    <div class="image-container">
        <img src="../../../svg/logoLogin.png" alt="Nice Shoe Image">
    </div>

    <div class="reset-password-container">
        <form onsubmit="return validateForm()">
            <h3 style="text-align: center; font-weight: bold">POLY 360 BOUTIQUE</h3>
            <br>
            <span class="header-title">
                    <span style="color: red"></span>
                    <span style="font-size: 15px;">Email</span>
                </span>
            <input id="emailReset" type="email" class="form-control" placeholder="Email ..." required="" />
            <br>
            <span class="header-title">
                    <span style="color: red"></span>
                    <span style="font-size: 15px;">Mật khẩu mới</span>
                </span>
            <input id="newPassword" type="password" class="form-control" placeholder="Mật khẩu mới ..." required="" />
            <br>
            <span class="header-title">
                    <span style="color: red"></span>
                    <span style="font-size: 15px;">Xác nhận mật khẩu</span>
                </span>
            <input id="confirmPassword" type="password" class="form-control" placeholder="Xác nhận mật khẩu ..." required="" />
            <br>
            <span class="header-title">
                    <span style="color: red"></span>
                    <span style="font-size: 15px;">Mã xác nhận</span>
                </span>
            <input id="verificationCode" type="text" class="form-control" placeholder="Mã xác nhận từ email ..." required="" />
            <br>
            <button class="btn btn-warning" style="color: white; background-color: darkorange; margin-left: 155px;">Đặt lại mật khẩu</button>
        </form>
    </div>
</div>

<script>
    function validateForm() {
        var email = document.getElementById("emailReset").value;
        var newPassword = document.getElementById("newPassword").value;
        var confirmPassword = document.getElementById("confirmPassword").value;
        var verificationCode = document.getElementById("verificationCode").value;

        if (email.trim() === "") {
            alert("Email không được để trống");
            return false;
        }

        if (newPassword.trim() === "") {
            alert("Mật khẩu mới không được để trống");
            return false;
        }

        if (confirmPassword.trim() === "") {
            alert("Xác nhận mật khẩu không được để trống");
            return false;
        }

        if (verificationCode.trim() === "") {
            alert("Mã xác nhận không được để trống");
            return false;
        }

        if (newPassword !== confirmPassword) {
            alert("Mật khẩu mới và xác nhận mật khẩu không khớp");
            return false;
        }


        alert("Mật khẩu đã được đặt lại thành công.");
        return true;
    }
</script>
</body>

</html>
