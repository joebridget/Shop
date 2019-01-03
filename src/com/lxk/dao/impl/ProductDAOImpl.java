package com.lxk.dao.impl;

import com.lxk.dao.ProductDAO;
import com.lxk.dataObject.ProductDataObject;
import com.lxk.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    @Override
    public ProductDataObject selectByID(int id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ProductDataObject product = null;
        try{
            //创建连接
            conn = JDBCUtil.getConnection();
            //准备SQL
            String sql = "select * from shop_product where id = ?";
            //创建载体 并为载体赋值
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,id);
            //执行SQL  结果集接收
            rs = pstm.executeQuery();
            if(rs.next()){
                product = new ProductDataObject();
                product.setId(rs.getInt(1));
                product.setProductName(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                product.setPicpath(rs.getString(4));
                product.setDiscription(rs.getString(5));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,pstm,conn);
        }
        return product;
    }

    @Override
    public int productTotal() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int total = 0;
        try{
            //创建连接
            conn = JDBCUtil.getConnection();
            //准备SQL
            String sql = "select count(*) from shop_product";
            //创建载体 装载SQL
            pstm = conn.prepareStatement(sql);
            //执行SQL
            rs = pstm.executeQuery();
            //处理结果集
            if(rs.next()){
                total = rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,pstm,conn);
        }
        return total;
    }

    @Override
    public List<ProductDataObject> selectByPage(int pageNum, int count) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<ProductDataObject> list = new ArrayList<>();
        try{
            //创建连接
            conn = JDBCUtil.getConnection();
            //准备SQL
            String sql = "select * from (select p.*,rownum rn from shop_product p order by id) where rn between ? and ?";
            //创建载体  并 装载SQL
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,(pageNum-1)*count+1);
            pstm.setInt(2,pageNum*count);
            //执行SQL  并用rs结果集接收
            rs = pstm.executeQuery();
            //处理结果集
            while (rs.next()){
                //创建list集合
                //创建实体类对象
                ProductDataObject product = new ProductDataObject();
                product.setId(rs.getInt(1));
                product.setProductName(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                product.setPicpath(rs.getString(4));
                product.setDiscription(rs.getString(5));
                list.add(product);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            JDBCUtil.close(rs,pstm,conn);
        }
    }

    @Override
    public List<ProductDataObject> selectByProductName(String productName) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<ProductDataObject> list = new ArrayList<>();
        try{
            //创建连接
            conn = JDBCUtil.getConnection();
            //准备SQL
            String sql = "select * from shop_product where productName like ?";
            //创建载体 并为载体赋值
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,"%"+productName+"%");
            //执行SQL  结果集接收
            rs = pstm.executeQuery();
            if(rs.next()){
                ProductDataObject product = new ProductDataObject();
                product.setId(rs.getInt(1));
                product.setProductName(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                product.setPicpath(rs.getString(4));
                product.setDiscription(rs.getString(5));
                list.add(product);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,pstm,conn);
        }
        return list;
    }

    @Override
    public List<ProductDataObject> selectByMinPrice(double price) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<ProductDataObject> list = new ArrayList<>();
        try{
            //创建连接
            conn = JDBCUtil.getConnection();
            //准备SQL
            String sql = "select * from shop_product where price < ?";
            //创建载体 并为载体赋值
            pstm = conn.prepareStatement(sql);
            pstm.setDouble(1,price);
            //执行SQL  结果集接收
            rs = pstm.executeQuery();
            while (rs.next()){
                ProductDataObject product = new ProductDataObject();
                product.setId(rs.getInt(1));
                product.setProductName(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                product.setPicpath(rs.getString(4));
                product.setDiscription(rs.getString(5));
                list.add(product);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,pstm,conn);
        }
        return list;
    }

    @Override
    public List<ProductDataObject> selectByMaxPrice(double price) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<ProductDataObject> list = new ArrayList<>();
        try{
            //创建连接
            conn = JDBCUtil.getConnection();
            //准备SQL
            String sql = "select * from shop_product where price > ?";
            //创建载体 并为载体赋值
            pstm = conn.prepareStatement(sql);
            pstm.setDouble(1,price);
            //执行SQL  结果集接收
            rs = pstm.executeQuery();
            while (rs.next()){
                ProductDataObject product = new ProductDataObject();
                product.setId(rs.getInt(1));
                product.setProductName(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                product.setPicpath(rs.getString(4));
                product.setDiscription(rs.getString(5));
                list.add(product);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,pstm,conn);
        }
        return list;
    }

    @Override
    public List<ProductDataObject> selectByNameMinPrice(String productName, double price) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<ProductDataObject> list = new ArrayList<>();
        try{
            //创建连接
            conn = JDBCUtil.getConnection();
            //准备SQL
            String sql = "select * from shop_product where price < ? and PRODUCTNAME like ?";
            //创建载体 并为载体赋值
            pstm = conn.prepareStatement(sql);
            pstm.setDouble(1,price);
            pstm.setString(2,"%"+productName+"%");
            //执行SQL  结果集接收
            rs = pstm.executeQuery();
            while (rs.next()){
                ProductDataObject product = new ProductDataObject();
                product.setId(rs.getInt(1));
                product.setProductName(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                product.setPicpath(rs.getString(4));
                product.setDiscription(rs.getString(5));
                list.add(product);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,pstm,conn);
        }
        return list;
    }

    @Override
    public List<ProductDataObject> selectByNameMaxPrice(String productName, double price) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<ProductDataObject> list = new ArrayList<>();
        try{
            //创建连接
            conn = JDBCUtil.getConnection();
            //准备SQL
            String sql = "select * from shop_product where price > ? and PRODUCTNAME like ?";
            //创建载体 并为载体赋值
            pstm = conn.prepareStatement(sql);
            pstm.setDouble(1,price);
            pstm.setString(2,"%"+productName+"%");
            //执行SQL  结果集接收
            rs = pstm.executeQuery();
            while (rs.next()){
                ProductDataObject product = new ProductDataObject();
                product.setId(rs.getInt(1));
                product.setProductName(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                product.setPicpath(rs.getString(4));
                product.setDiscription(rs.getString(5));
                list.add(product);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,pstm,conn);
        }
        return list;
    }
}
