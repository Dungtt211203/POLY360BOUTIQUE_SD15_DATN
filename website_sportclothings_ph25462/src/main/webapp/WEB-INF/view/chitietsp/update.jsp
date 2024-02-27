<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Update Chi Tiet San Pham</title>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>

<form:form method="post" action="/chitietsp/update/${chitietsp.id}" modelAttribute="sp">
    ID:<form:input path="id" value="${chitietsp.id}"/><br>
    Ma:<form:input path="ma" value="${chitietsp.ma}"/><br>
    SoLuong:<form:input path="soLuong" value="${chitietsp.soLuong}"/><br>

    NgayTao:<form:input path="ngayTao" value="${chitietsp.ngayTao}"/><br>
    NgaySua:<form:input path="ngaySua" value="${chitietsp.ngaySua}"/><br>

    TenSP: <form:select path="sanPham">
    <form:options items="${sanPham}" itemLabel="ten"  />
</form:select><br>
    KichCo: <form:select path="kichCo">
    <form:options items="${kichCo}" itemLabel="ten" />
</form:select><br>
    Mau Sac: <form:select path="mauSac">
    <form:options items="${mauSac}" itemLabel="ten" />
</form:select><br>
    ChatLieu: <form:select path="chatLieu">
    <form:options items="${chatLieu}" itemLabel="ten" />
</form:select><br>
    ThuongHieu: <form:select path="thuongHieu">
    <form:options items="${thuongHieu}" itemLabel="ten" />
</form:select><br>
    <form:button class="btn btn-primary">Update</form:button>
</form:form>
</form>
</body>
</html>