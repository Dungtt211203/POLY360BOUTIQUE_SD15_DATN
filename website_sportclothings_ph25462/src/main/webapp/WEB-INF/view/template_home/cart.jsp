<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- Created By CodingNepal - www.codingnepalweb.com -->
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <title>Product Card Poly360Boutique</title>
    <link rel="stylesheet" href="../../../css/cart.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link rel="icon" href="../../../svg/logohome.svg">
</head>
<body>
<div class="wrapper">
    <div class="card">
        <img src="../../../img/sp01ao.png" alt="">
        <div class="content">
            <div class="row">
                <c:forEach items="${product.content}" var="hienthi">
                    <h3>${hienthi.ten}</h3>
                    <%--                    <div class="details">--%>
                    <%--                     value       ${hienthi.ten}--%>
                    <%--                    </div>--%>
                    <%--                    <div class="price">$30</div>--%>
                </c:forEach>
            </div>

            <div class="buttons">
                <button class="cart-btn">Detail</button>
                <button>Buy Now</button>
                <button class="cart-btn">Add to Cart</button>
            </div>
        </div>
    </div>
    <div class="card">
        <img src="../../../img/sp02quan.png" alt="">
        <div class="content">
            <div class="row">
                <div class="details">
                    <span>Apple Watch</span>
                    <p>Premium digital watch</p>
                </div>
                <div class="price">$80</div>
            </div>
            <div class="buttons">
                <button>Buy Now</button>
                <button class="cart-btn">Add to Cart</button>
            </div>
        </div>
    </div>
    <div class="card">
        <img src="../../../img/sp03quan.png" alt="">
        <div class="content">
            <div class="row">
                <div class="details">
                    <span>Apple Airpod</span>
                    <p>Premium black airpod</p>
                </div>
                <div class="price">$50</div>
            </div>
            <div class="buttons">
                <button>Buy Now</button>
                <button class="cart-btn">Add to Cart</button>
            </div>
        </div>
    </div>
    <div class="card">
        <img src="../../../img/sp04quan.png" alt="">
        <div class="content">
            <div class="row">
                <div class="details">
                    <span>Apple Airpod</span>
                    <p>Premium black airpod</p>
                </div>
                <div class="price">$50</div>
            </div>
            <div class="buttons">
                <button>Buy Now</button>
                <button class="cart-btn">Add to Cart</button>
            </div>
        </div>
    </div>
    <div class="card">
        <img src="../../../img/sp05ao.png" alt="">
        <div class="content">
            <div class="row">
                <div class="details">
                    <span>Apple Airpod</span>
                    <p>Premium black airpod</p>
                </div>
                <div class="price">$50</div>
            </div>
            <div class="buttons">
                <button>Buy Now</button>
                <button class="cart-btn">Add to Cart</button>
            </div>
        </div>
    </div>
    <div class="card">
        <img src="../../../img/sp06ao.png" alt="">
        <div class="content">
            <div class="row">
                <div class="details">
                    <span>Apple Airpod</span>
                    <p>Premium black airpod</p>
                </div>
                <div class="price">$50</div>
            </div>
            <div class="buttons">
                <button>Buy Now</button>
                <button class="cart-btn">Add to Cart</button>
            </div>
        </div>
    </div>
    <div class="card">
        <img src="../../../img/sp07.png" alt="">
        <div class="content">
            <div class="row">
                <div class="details">
                    <span>Apple Airpod</span>
                    <p>Premium black airpod</p>
                </div>
                <div class="price">$50</div>
            </div>
            <div class="buttons">
                <button>Buy Now</button>
                <button class="cart-btn">Add to Cart</button>
            </div>
        </div>
    </div>
    <div class="card">
        <img src="../../../img/sp08ao.png" alt="">
        <div class="content">
            <div class="row">
                <div class="details">
                    <span>Apple Airpod</span>
                    <p>Premium black airpod</p>
                </div>
                <div class="price">$50</div>
            </div>
            <div class="buttons">
                <button>Buy Now</button>
                <button class="cart-btn">Add to Cart</button>
            </div>
        </div>
    </div>
</div>

<script src="src/main/webapp/js/cart.js"></script>
</body>
</html>
