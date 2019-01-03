package com.lxk.service;

import com.lxk.dataObject.Cart;
import com.lxk.dataObject.ProductDataObject;

import java.util.List;

public interface ProductService {
    //展示所有商品
//    List<ProductDataObject> showAll();
    //通过商品名查询商品
    List<ProductDataObject> showByProductName(String productName);
    //通过小于价格区间查询
    List<ProductDataObject> showByMinPrice(double price);
    //通过大于价格区间查询
    List<ProductDataObject> showByMaxPrice(double price);
    //通过商品名和小于价格区间查询
    List<ProductDataObject> showByNameMinPrice(String productName,double price);
    //通过商品名和大于价格区间查询
    List<ProductDataObject> showByNameMaxPrice(String productName,double price);
    //分页展示商品  pageNum代表当前是第几页  count代表一页展示多少条数据
    List<ProductDataObject> pageHandle(int pageNum,int count);
    //分页选择栏
    int pageTotal(int count);
    //更新购物车  传入商品的id  传入
    Cart updateCart(int id,Cart cart);
}
