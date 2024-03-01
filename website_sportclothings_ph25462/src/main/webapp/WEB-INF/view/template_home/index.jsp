<!DOCTYPE html>
<html lang="en">
<%@ page pageEncoding="utf-8" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>POLY360BOUTIQUE</title>
    <link rel="stylesheet" href="../../../css/index.css">
    <link href=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" data-purpose="Layout StyleSheet" title="Web Awesome"
          href="/css/app-wa-612dd696ed96d6777d290343ca9cef9d.css?vsn=d">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/all.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/sharp-thin.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/sharp-solid.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/sharp-regular.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/sharp-light.css">
    <link rel="icon" href="../../../svg/logohome.svg">

</head>

<body>
<jsp:include page="header.jsp"/>
<section>
    <section>
        <div id="carouselExampleRide" class="carousel slide" data-bs-ride="true">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="img-banner" src="../../../img/imgbanner/banner1.png" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img class="img-banner" src="../../../img/imgbanner/banner1.png" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img class="img-banner" src="../../../img/imgbanner/banner1.png" class="d-block w-100" alt="...">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleRide"
                    data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleRide"
                    data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </section>
    <section style="margin-top: 30px">
        <h1 style="text-align: center;margin-top: 30px">Tất Cả Sản Phẩm</h1>
        <jsp:include page="../template_home/cart.jsp"/>
    </section>
    <section style="margin-top: 30px">
        <h1 style="text-align: center;margin-top: 30px">Sản Phẩm Bán Chạy</h1>
        <jsp:include page="../template_home/cart.jsp"/>
    </section>
</section>
<jsp:include page="footer.jsp"/>
<script src=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
<script type="text/javascript">
    jQuery('.nav-link').on('click', function name(params) {
        jQuery('.nav-link').each(function name(params) {
            jQuery(this).removeClass('active')
        })
        jQuery(this).addClass('active')
    })
</script>


</body>

</html>
