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
    <link rel="icon" href="../../src/image/logohome.jpg">
</head>

<body>
<jsp:include page="header.jsp"/>
<section>
    <section>
        <div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel"
             style="margin-top: 50px;">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="../../img/banner.jpg" class="banner">
                </div>
                <div class="carousel-item">
                    <img src="../../img/banner1'.jpg" class="banner">
                </div>
                <div class="carousel-item">
                    <img src="../../img/banner2.jpg" class="banner">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying"
                    data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying"
                    data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </section>
    <h1 style="text-align: center">Thuong Hieu Noi Bat</h1>
    <section>
        <h1 style="text-align: center">Tat Ca San Pham</h1>
       <jsp:include page="../cart.jsp"/>
    </section>
    <section>
        <h1 style="text-align: center">San Pham Ban Chay</h1>
        <jsp:include page="../cart.jsp"/>
    </section>
</section>
<jsp:include page="footer.jsp"/>
<script src=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>

</body>

</html>