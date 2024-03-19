<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

    <style>

        body {
            font-family: Arial, sans-serif;
        }

        label {
            margin-right: 10px;
        }

        input[type="date"] {
            width: 150px;
            margin-right: 10px;
        }

        button {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 8px 15px;
            cursor: pointer;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }

        th {
            background-color: #007bff;
            color: #fff;
        }

        [ng-show] {
            display: inline-block;
        }

        <%----%>
        body {
            font-family: Arial, sans-serif;
        }

        form {
            display: flex;
            flex-wrap: wrap;
            justify-content: flex-end;
            margin-bottom: 20px;
        }

        label {
            margin-bottom: 10px;
            display: block;
            margin-right: 10px;
        }

        select {
            padding: 8px;
            margin-bottom: 10px;
            width: 150px;
        }

        button {
            background-color: #709004;
            color: #fff;
            border: none;
            padding: 8px 15px;
            cursor: pointer;
            margin-bottom: 10px;
        }
    </style>

</head>
<body>
<div>
    <h1 style="text-align: center">Thống Kê Doanh Thu Theo Ngày Tháng Năm</h1>
    <div>

        <form action="/thong-ke/hien-thi" method="get">
            <label for="day">Ngày:</label>
            <select id="day" name="day">
                <c:forEach begin="1" end="31" var="d">
                    <option value="${d}">${d}</option>
                </c:forEach>
            </select>

            <label for="month">Tháng:</label>
            <select id="month" name="month">
                <c:forEach begin="1" end="12" var="m">
                    <option value="${m}">${m}</option>
                </c:forEach>
            </select>

            <label for="year">Năm:</label>
            <select id="year" name="year">
                <c:forEach begin="2015" end="2035" var="y">
                    <option value="${y}">${y}</option>
                </c:forEach>
            </select>

            <label for="thongKe">Trạng thái :</label>
            <select id="thongKe" name="trangThai" class="form-control" required>
                <option value="1" <c:if test="${thongKe.trangThai == 1}">selected</c:if>>Thành Công</option>
                <option value="2" <c:if test="${thongKe.trangThai == 2}">selected</c:if>>Trờ Xác Nhận</option>
                <option value="3" <c:if test="${thongKe.trangThai == 3}">selected</c:if>>Đã Xác Nhận</option>
                <option value="4" <c:if test="${thongKe.trangThai == 4}">selected</c:if>>Đang giao</option>
                <option value="5" <c:if test="${thongKe.trangThai == 5}">selected</c:if>>Giao Thành Công</option>
                <option value="0" <c:if test="${thongKe.trangThai == 0}">selected</c:if>>Đã Hủy</option>
            </select>


            <button type="submit">Load</button>
        </form>

        <%--        co the dong lai--%>
        <div class="col-lg-3 col-sm-6 col-12 d-flex">
            <div class="dash-count">
                <div class="dash-counts">
                    <h5>Tổng Đơn Hàng</h5>
                </div>
                <div class="dash-imgs">
                    <h4><c:out value="${tongSoLuongHoaDon}"/><i class="fas fa-shopping-basket ng-binding" style="background: white;padding: 10px;
                    border-radius: 10px;
                    color: rgb(12 231 250);"> Hóa Đơn</i></h4>

                </div>
            </div>
        </div>

        <div class="col-lg-3 col-sm-6 col-12 d-flex">
            <div class="dash-count das3">
                <div class="dash-counts">
                    <h5>Doanh thu</h5>
                    <h4>
                        <c:if test="${doanhThuNgayThangNam != null}">
                            <span><c:out value="${doanhThuNgayThangNam}"/> <i class="fas fa-shopping-basket ng-binding"
                                                                              style="background: white;padding: 10px;
                            border-radius: 10px;
                            color: rgb(12 231 250);"> VND</i></span>
                        </c:if>
                    </h4>

                </div>

            </div>
        </div>

        <!-- script doanh thu cot -->
        <div class="row">
            <div class="col-lg-7 col-sm-12 col-12">
                <div class="card">
                    <div class="card-header pb-0">
                        <h4>Thống kê doanh thu theo tháng</h4>
                    </div>
                    <div class="card-body">
                        <!-- Thành phần Canvas cho biểu đồ cột -->
                        <canvas id="barChart" width="800" height="400"></canvas>

                        <!-- Script để vẽ biểu đồ -->
                        <script th:inline="javascript">
                            var thongKeDoanhThuTheoThang = /*[[${thongKeDoanhThuTheoThang}]]*/ {};
                            var labels = Object.keys(thongKeDoanhThuTheoThang);
                            var data = Object.values(thongKeDoanhThuTheoThang);

                            // Vẽ biểu đồ cột
                            var barChart = new Chart(document.getElementById('barChart'), {
                                type: 'bar',
                                data: {
                                    labels: labels,
                                    datasets: [{
                                        label: 'Doanh thu',
                                        data: data,
                                        backgroundColor: "#d21f1f" // Màu của cột
                                    }]
                                },
                                options: {
                                    scales: {
                                        y: {
                                            beginAtZero: true
                                        }
                                    }
                                }
                            });
                        </script>

                    </div>
                </div>
            </div>
        </div>

        <div class="box-shadow-page">
            <div class="card-body">
                <form:form action="/thong-ke/hien-thi" method="get">
                    <label for="startDate">Ngày Bắt Đầu:</label>
                    <input type="datetime-local" id="startDate" name="startDate" value="${startDate}" required>

                    <label for="endDate">Ngày Kết Thúc:</label>
                    <input type="datetime-local" id="endDate" name="endDate" value="${endDate}" required>

                    <button type="submit">Tìm kiếm</button>
                </form:form>

                <%--     tim kiem doanh thu theo ngay--%>
                <table>
                    <thead>
                    <tr>
                        <th>Ngày/Tháng/Năm</th>
                        <th>Số lượng hóa đơn</th>
                        <th>Tổng doanh thu</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>
                            <c:if test="${startDate != null}"> Từ ngày <fmt:formatDate value="${startDate}"
                                                                                       pattern="dd/MM/yyyy"/></c:if>
                            <c:if test="${endDate != null}"> Đến ngày <fmt:formatDate value="${endDate}"
                                                                                      pattern="dd/MM/yyyy"/></c:if>
                        </td>
                        <td><c:out value="${tongSoLuongHoaDon}"/></td>
                        <td><c:out value="${doanhThuNgayThangNam}"/></td>

                    </tr>
                    </tbody>
                </table>

            </div>
        </div>
    </div>
</div>
</body>
</html>
