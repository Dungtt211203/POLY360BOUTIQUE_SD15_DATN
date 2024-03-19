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


    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>


</head>
<body>
<header>
    <jsp:include page="../template_home/header.jsp"/>
</header>


<div class="container mt-5">
    <div class="row">
        <div class="col-md-12 text-center">
            <h1 class="text-success">Đặt hàng thành công!</h1>
            <br>
            <img src="https://salt.tikicdn.com/desktop/img/mascot@2x.png">
            <br><br>
            <div id="buttons">

<%--                <a href="/poly360boutique/home" class="btn btn-primary btn-lg">Trang chủ</a>--%>
                <a href="/poly360boutique/home" class="btn btn-lg btn-primary ">Trang chủ </a>
                <a href="/donHang/donHangChiTiet/${idHD} " class="btn btn-secondary btn-lg">Xem đơn hàng</a>

            </div>
            <br>
            <br>
        </div>
    </div>
</div>


<jsp:include page="../template_home/footer.jsp"/>


<script type="text/javascript">
    let bigImg = document.querySelector('.big-img img');

    function showImg(pic) {
        bigImg.src = pic;
    }

</script>

</body>
</html>












