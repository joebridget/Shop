package com.lxk.controller;

import com.lxk.dataObject.ProductDataObject;
import com.lxk.service.ProductService;
import com.lxk.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductShowByPage",urlPatterns = "/filter/productShow")
public class ProductShowByPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //分页展示数据需要接受 客户端传进来的 当前页数 和  一页展示多少条 两个参数
        //当前页数
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));
        //展示条数
        int count = Integer.parseInt(request.getParameter("count"));
        //根据分页获取展示的数据
        ProductService ps = new ProductServiceImpl();
        List<ProductDataObject> list = ps.pageHandle(pageNum,count);
        //获取总页数
        int pageTotal = ps.pageTotal(count);
        //把 list 总页数 一页展示多少条数据 存储在作用域中
        HttpSession session = request.getSession();
        session.setAttribute("list",list);
        session.setAttribute("pageTotal",pageTotal);
        session.setAttribute("pageNum",pageNum);
        session.setAttribute("count",count);
        //请求转发到展示商品数据页面中
        request.getRequestDispatcher("/QueryProductView.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
