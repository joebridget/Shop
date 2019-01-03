package com.lxk.dao;

import com.lxk.dataObject.ProductDataObject;

import java.util.List;

public interface ProductDAO {
    //查询所有商品
//    List<ProductDataObject> slectAll();
    //通过id查询商品
    ProductDataObject selectByID(int id);
    //通过商品名查询商品
    List<ProductDataObject> selectByProductName(String productName);
    //通过大于价格区间查询
    List<ProductDataObject> selectByMinPrice(double price);
    //通过小于价格区间查询
    List<ProductDataObject> selectByMaxPrice(double price);
    //通过商品名和小于价格区间查询
    List<ProductDataObject> selectByNameMinPrice(String productName,double price);
    //通过商品名和大于价格区间查询
    List<ProductDataObject> selectByNameMaxPrice(String productName,double price);
    //查询商品的总数
    int productTotal();
    //分页查询 传入当前页数  和 一页分多少条
    List<ProductDataObject> selectByPage(int pageNum,int count);
}
