<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询商品</title>
    <style type="text/css">
        a{
            text-decoration: none;
        }
        .c1{ text-align:right ;margin-right:50px }
        .c2{ text-align:right ;margin-right:50px ; color:blue; font-size:150% }
        body{ background-image:url("${pageContext.request.contextPath}/static/image/2.png");background-repeat:repeat }

        .q_span{ font-size:30px; color:red; font-weight:bolder;margin-left:200px }
        .f{ width:150px; height:70px}
        .d{ text-align:center; word-spacing:20px;width:70%;margin: 0 auto}
        img{ border:none }
        .b{ background-color:yellow;
            background-image:url("${pageContext.request.contextPath}/static/image/button12.png") ;
            width:60px;height:30px; border:none
        }
        th,td{
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <!-- Title -->
        <img src="${pageContext.request.contextPath}/static/image/zgc_px.png" align="middle" class="f"/>
        <span class="q_span">欢迎访问我的购物网站</span>
        <hr/>

        <div class="c2"> 欢迎Luxw </div>

        <!--  Menu Bar  -->
        <div class="d">
            <a href="QueryProductView.html"><img src="${pageContext.request.contextPath}/static/image/index.png"/></a>
            <a href="UserManageView.html"><img src="${pageContext.request.contextPath}/static/image/reg.png"/></a>
            <a href="${pageContext.request.contextPath}/ShopCarView.jsp"><img src="${pageContext.request.contextPath}/static/image/cart.png"/></a>
            <a href=""><img src="${pageContext.request.contextPath}/static/image/order.png"/></a>
            <a href="LoginView.html"><img src="${pageContext.request.contextPath}/static/image/exit.png"/></a>
        </div>

        <!--  按条件搜索表单 -->
        <div style="width: 100%;margin: 0 auto;text-align: center;height: 50px;line-height: 50px;">
            <form action="${pageContext.request.contextPath}/filter/query" method="post">
                ProductName:<input type="text" name="productName" value=""/>&nbsp;
                Price:
                <select name="opt">
                    <option value="1">小于</option>
                    <option value="2">大于</option>
                </select>
                <input type="text" name="price" size="6" /> &nbsp;&nbsp;
                <input type="submit"   value="" class="b"/>
            </form>
        </div>


        <table border="1" bordercolor="blue" cellspacing=0 align="center" width="70%">
            <tr align="center" bgcolor="lightblue">
                <th>Id</th>
                <th>Name</th>
                <th>Price</th>
                <th>图片</th>
                <th><img src="${pageContext.request.contextPath}/static/image/car_new.png"/></th>
            </tr>
            <c:forEach var="product" items="${sessionScope.list}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.productName}</td>
                    <td>${product.price}</td>
                    <td><img width="78px" height="110px" src="${pageContext.request.contextPath}/static${product.picpath}"></td>
                    <td><a href="${pageContext.request.contextPath}/filter/cart?id=${product.id}"><img src="${pageContext.request.contextPath}/static/image/car_new.png"/></a></td>
                </tr>
            </c:forEach>
        </table>
        <!-- 分页 -->
        <form method="post" id="form" action="${pageContext.request.contextPath}/filter/productShow">
            <div style="width: 100%;margin: 20px auto;text-align: center;">
                <c:forEach var="page" begin="1" end="${sessionScope.pageTotal}" step="1">
                    <a href="${pageContext.request.contextPath}/filter/productShow?pageNum=${page}&count=${sessionScope.count}">
                        <span style="padding: 5px">第${page}页</span>
                    </a>
                    <input type="hidden" name="pageNum" value="${page}">
                </c:forEach>
                <select name="count" onchange="formSubmit();" style="margin-left: 40px;">
                    <option>--请选择条数--</option>
                    <option value="2">每页两条数据</option>
                    <option value="5">每页五条数</option>
                    <option value="15">每页十五条数</option>
                    <option value="20">每页二十条数</option>
                </select>
            </div>
        </form>

    </div>

    </div>
</body>
<script>
    function formSubmit() {
        var form = document.getElementById("form");
        form.submit();
    }
</script>
</html>
