package com.lxk.controller;

import com.lxk.dataObject.Cart;
import com.lxk.service.ProductService;
import com.lxk.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CartAction",urlPatterns = "/filter/cart")
public class CartAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建service对象
        ProductService ps = new ProductServiceImpl();
        //接收id
        int id = Integer.parseInt(request.getParameter("id"));
        //获取session中的cart
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        //判断购物是否为null  如果为null就创建一个新的购物车
        if(cart == null){
            cart = new Cart();
        }
        //更新购物车  返回一个更新内容的购物车
        Cart newcart = ps.updateCart(id,cart);
        //把购物车存储在session中  供后续展示操作
        session.setAttribute("cart",newcart);
        //请求转发到展示页面中
        request.getRequestDispatcher("/AddCarSuccess.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
