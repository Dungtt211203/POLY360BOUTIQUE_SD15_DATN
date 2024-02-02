<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>POLY360BOUTIQUE</title>
    <link rel="stylesheet" href="../../../css/thuong-hieu.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/all.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/sharp-thin.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/sharp-solid.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/sharp-regular.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/sharp-light.css">
</head>
<body>
<div class="flex-box">
    <div class="left">
        <div class="big-img">
            <img src="../../../img/sp12ao.png">
        </div>
        <div class="images">
            <div class="small-img">
                <img src="../../../img/ctsp12.1ao.png" onclick="showImg(this.src)">
            </div>
            <div class="small-img">
                <img src="../../../img/sp12ao.2ao.png" onclick="showImg(this.src)">
            </div>
            <div class="small-img">
                <img src="../../../img/sp12ao.3ao.png" onclick="showImg(this.src)">
            </div>
            <div class="small-img">
                <img src="../../../img/sp12ao.4ao.png" onclick="showImg(this.src)">
            </div>
        </div>
    </div>

    <div class="right">
        <div class="url">Home > Product > T-Shirt</div>
        <div class="pname">T-Shirts for Men</div>
        <div class="ratings">
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star-half-alt"></i>
        </div>
        <div class="price">$40</div>
        <div class="size">
            <p>Size :</p>
            <div class="psize active">M</div>
            <div class="psize">L</div>
            <div class="psize">XL</div>
            <div class="psize">XXL</div>
        </div>
        <div class="quantity">
            <p>Quantity :</p>
            <input type="number" min="1" max="5" value="1">
        </div>
        <div class="btn-box">
            <button class="cart-btn">Add to Cart</button>
            <button class="buy-btn">Buy Now</button>
        </div>
    </div>
</div>


<script>
    let bigImg = document.querySelector('.big-img img');
    function showImg(pic){
        bigImg.src = pic;
    }
</script>
</body>
</html>