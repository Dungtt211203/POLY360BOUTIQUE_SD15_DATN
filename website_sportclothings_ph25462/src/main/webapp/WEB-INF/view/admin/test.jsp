<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>POLY360BOUTIQUE</title>
    <link rel="stylesheet" href="../../../css/index.css">
    <link href=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">


    <link rel="stylesheet" data-purpose="Layout StyleSheet" title="Web Awesome"
          href="/css/app-wa-612dd696ed96d6777d290343ca9cef9d.css?vsn=d">
    <link rel="stylesheet" href="../../../css/thuong-hieu.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/all.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/sharp-thin.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/sharp-solid.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/sharp-regular.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/sharp-light.css">
    <link rel="icon" href="../../../svg/logohome.svg">

    <style>
        body {
            font-family: Arial, sans-serif;
        }

        .modal {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
        }

        .modal-content {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            text-align: center;
        }

        .close {
            position: absolute;
            top: 10px;
            right: 10px;
            font-size: 20px;
            cursor: pointer;
        }


        .form-container {
            max-width: 600px;
            margin: 0 auto;
            display: flex;
            flex-wrap: wrap;
        }

        .form-section {
            flex: 1;
            margin: 10px;
        }

        input[type="text"],
        input[type="number"],
        select {
            flex: 1;
            /* Equal width for all fields within the section */
            padding: 10px;
            margin-bottom: 10px;
            border: 2px solid #007bff;
            /* Thick blue border for input fields and selects */
            border-radius: 5px;
            width: 100%;
            /* Full width within the section */
        }

        /* Style the submit button as a square */
        button[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 15px 20px;
            border: none;
            cursor: pointer;
            width: 100px;
            height: 50px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        /* Hover effect for the submit button */
        button[type="submit"]:hover {
            background-color: #0056b3;
            /* Darker blue on hover */
        }

        /* Màu cho radio button */
        input[type="radio"] {
            /* Màu khi radio button được chọn */
            color: #007BFF;
        }

        /* Màu cho nhãn */
        label {
            /* Màu văn bản của nhãn */
            color: #333;
        }

        input[type="radio"] {
            /* Màu khi radio button được chọn */
            color: #007BFF;
        }

        /* Màu cho nhãn */
        label {
            /* Màu văn bản của nhãn */
            color: #333;
        }


        /* Định dạng cho nội dung của modal */
        .modal-content {
            background-color: #fefefe;
            padding: 20px;
            border: 1px solid #888;
            width: 60%; /* Chiều rộng của nội dung modal */
        }

        /* Định dạng cho nút đóng modal */
        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }


    </style>


    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
    <script src="../../../js/themNhanhDiaChi.js"></script>

</head>
<body>
<header>
    <jsp:include page="../template_home/header.jsp"/>
</header>


<!--Nhập thông tin khách hàng-->

<h1> ok </h1>

<jsp:include page="../template_home/footer.jsp"/>


<script type="text/javascript">
    let bigImg = document.querySelector('.big-img img');

    function showImg(pic) {
        bigImg.src = pic;
    }

</script>

</body>
</html>
