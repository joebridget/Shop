<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>购物车</title>
    <script src="./static/js/shopcar.js" type="text/javascript"></script>
    <style type="text/css">
        a{
            text-decoration: none;
        }
        .c1{ text-align:right ;margin-right:50px }
        .c2{ text-align:right ;margin-right:50px ; color:blue; font-size:150% }
        body{ background-image:url("${pageContext.request.contextPath}/static/image/2.png");background-repeat:repeat }

        /*span{ font-size:30px; color:red; font-weight:bolder;margin-left:200px }*/
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
    <img src="${pageContext.request.contextPath}/static/image/zgc_px.png" align="middle" class="f"/>
    <span>欢迎访问我的购物网站</span>
    <hr/>
    <!--  Menu Bar  -->
    <div class="d">
        <a href="${pageContext.request.contextPath}/QueryProductView.jsp"><img src="${pageContext.request.contextPath}/static/image/index.png"/></a>
        <a href="UserManageView.html"><img src="${pageContext.request.contextPath}/static/image/reg.png"/></a>
        <a href="${pageContext.request.contextPath}/ShopCarView.jsp"><img src="${pageContext.request.contextPath}/static/image/cart.png"/></a>
        <a href=""><img src="${pageContext.request.contextPath}/static/image/order.png"/></a>
        <a href="LoginView.html"><img src="${pageContext.request.contextPath}/static/image/exit.png"/></a>
    </div>
    <form action="" method="post">
        <table border="1" bordercolor="blue" cellspacing="0" align="center" width="80%">
            <tbody id="tbody">
            <tr bgcolor="lightblue" align="center">
                <th>&nbsp;</th>
                <th>商品编号</th>
                <th>商品名称</th>
                <th>图片</th>
                <th>商品单价</th>
                <th>数量</th>
                <th>总价</th>
                <th>删除</th>
            </tr>
            <c:forEach var="map" items="${sessionScope.cart.map}">
                <tr onmouseover="over(this);" onmouseout="out(this);" align="center">
                    <td><input type="checkbox"/></td>
                    <td>${map.key}</td>
                    <td>${map.value.productDataObject.productName}</td>
                    <td><img width="78px" height="110px" src="${pageContext.request.contextPath}/static${map.value.productDataObject.picpath}"></td>
                    <td>${map.value.productDataObject.price}</td>
                    <td>
                        <%--<input type="button" value="-" onclick="sub(this);"/>--%>
                        <%--<input type="text" value="1" size="1" maxlength="1" name="1"/>--%>
                        <%--<input type="button" value="+" onclick="add(this);"/>--%>
                        ${map.value.count}
                    </td>
                    <td>${map.value.subtotal}</td>
                    <td><input type="button" value="delete" onclick="delRow(this);"/></td>
                </tr>
            </c:forEach>


            <tr align="center">
                <td colspan="8">
                    <input type="button" value="选中所有行" onclick="selectAll();"/>
                    <input type="button" value="取消选中" onclick="quxiao();"/>
                    <input type="button" value="删除选中的行" onclick="deleteSelected();"/>
                </td>
            </tr>
            </tbody>
        </table>
        <center><p><input type="submit" value="提交修改"/></p></center>
    </form>
    <center>
        <hr/>
        <a href="">提交订单</a>
    </center>
</div>

</body>
</html>
