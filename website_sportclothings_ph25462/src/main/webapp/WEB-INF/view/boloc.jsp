<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        .filter-container {
            margin-bottom: 20px;
        }

        .filter-container label {
            font-weight: bold;
        }

        .filter-container select {
            width: 150px;
            margin-top: 5px;
        }

        .filter-container .color-option {
            display: inline-block;
            width: 30px;
            height: 30px;
            margin-right: 5px;
            border-radius: 50%;
            cursor: pointer;
        }

        .filter-container .color-option:hover {
            border: 2px solid #333;
        }
    </style>
</head>
<body>
<div class="filter-container">
    <label for="brand-filter">Thương hiệu:</label>
    <select id="brand-filter">
        <option value="">Tất cả</option>
        <option value="brand1">Thương hiệu 1</option>
        <option value="brand2">Thương hiệu 2</option>
        <option value="brand3">Thương hiệu 3</option>
    </select>
</div>

<div class="filter-container">
    <label for="price-filter">Giá:</label>
    <select id="price-filter">
        <option value="">Tất cả</option>
        <option value="0-50">Dưới 50</option>
        <option value="50-100">50 - 100</option>
        <option value="100-200">100 - 200</option>
        <option value="200-">Trên 200</option>
    </select>
</div>

<div class="filter-container">
    <label for="color-filter">Màu sắc:</label>
    <div id="color-filter">
        <div class="color-option" style="background-color: red;"></div>
        <div class="color-option" style="background-color: blue;"></div>
        <div class="color-option" style="background-color: green;"></div>
        <div class="color-option" style="background-color: yellow;"></div>
    </div>
</div>

<div class="filter-container">
    <label for="size-filter">Kích cỡ:</label>
    <select id="size-filter">
        <option value="">Tất cả</option>
        <option value="s">S</option>
        <option value="m">M</option>
        <option value="l">L</option>
        <option value="xl">XL</option>
    </select>
</div>
</body>
</html>
