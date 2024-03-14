<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</head>
<body>
<header>
    <jsp:include page="../template_home/header.jsp"/>
</header>
<div class="flex-box">
    <div class="left">
        <div class="big-img">
            <img src="../../../img/sp12ao.png">
        </div>
        <div class="images">
            <div class="small-img">
                <img class="img-th" src="../../../img/ctsp12.2ao.png" onclick="showImg(this.src)">
            </div>
            <div class="small-img">
                <img class="img-th"  src="../../../img/ctsp12.2ao.png" onclick="showImg(this.src)">
            </div>
            <div class="small-img">
                <img class="img-th"  src="../../../img/ctsp12.3ao.png" onclick="showImg(this.src)">
            </div>
            <div class="small-img">
                <img class="img-th" src="../../../img/ctsp12.4ao.png" onclick="showImg(this.src)">
            </div>
        </div>
    </div>

    <div class="right">
        <div class="pname">T-Shirts for Men</div>
        <div class="ratings">
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star-half-alt"></i>
        </div>
        <div class="price">500.000 VNĐ</div>
        <div class="size">
            <p>Size :</p>
            <div class="psize active">M</div>
            <div class="psize">L</div>
            <div class="psize">XL</div>
            <div class="psize">XXL</div>
        </div>
        <div class="quantity">
            <p>Quantity :</p>
            <input type="number" min="1" max="100" value="1">
        </div>
        <div class="btn-box">
            <button class="cart-btn">Add to Cart</button>
            <button class="buy-btn">Buy Now</button>
        </div>
    </div>
</div>
<jsp:include page="../template_home/footer.jsp"/>

<script type="text/javascript">
    let bigImg = document.querySelector('.big-img img');
    function showImg(pic){
        bigImg.src = pic;
    }

</script>
</body>
</html>
