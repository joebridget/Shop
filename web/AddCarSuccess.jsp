<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加购物车成功</title>
    <style type="text/css">
        body{
            background-image:url("${pageContext.request.contextPath}/static/image/2.png");
            background-repeat:repeat
        }
        .container{
            width: 100%;
            margin: 0 auto;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <img src="${pageContext.request.contextPath}/static/image/success.png"/>
        <h1> 已成功将XXX商品添加至购物车</h1>
        <h1><a href="${pageContext.request.contextPath}/filter/productShow?pageNum=${sessionScope.pageNum}&count=${sessionScope.count}">继续购物</a>&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/ShopCarView.jsp">去购物车结算</a>
        </h1>
    </div>
</body>
</html>
