package com.lxk.service.impl;

import com.lxk.dao.ProductDAO;
import com.lxk.dao.impl.ProductDAOImpl;
import com.lxk.dataObject.Cart;
import com.lxk.dataObject.CartItem;
import com.lxk.dataObject.ProductDataObject;
import com.lxk.service.ProductService;

import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private ProductDAO pd = new ProductDAOImpl();

    @Override
    public List<ProductDataObject> showByProductName(String productName) {
        return pd.selectByProductName(productName);
    }

    @Override
    public List<ProductDataObject> showByMinPrice(double price) {
        return pd.selectByMinPrice(price);
    }

    @Override
    public List<ProductDataObject> showByMaxPrice(double price) {
        return pd.selectByMaxPrice(price);
    }

    @Override
    public List<ProductDataObject> showByNameMinPrice(String productName, double price) {
        return pd.selectByNameMinPrice(productName,price);
    }

    @Override
    public List<ProductDataObject> showByNameMaxPrice(String productName, double price) {
        return pd.selectByNameMaxPrice(productName,price);
    }

    @Override
    public List<ProductDataObject> pageHandle(int pageNum, int count) {
        return pd.selectByPage(pageNum,count);
    }

    @Override
    public int pageTotal(int count) {
        return (int)Math.ceil((double)pd.productTotal()/count);
    }

    @Override
    public Cart updateCart(int id, Cart cart) {
        //通过id查询到该商品
        ProductDataObject product = pd.selectByID(id);
        //获取购物车中的map
        Map<Integer, CartItem> map = cart.getMap();
        //在map中取出 购物项
        CartItem cartItem = map.get(id);
        //判断该购物项是否存在  如果存在就在该购物项的基础上操作 不存在就创建一个该商品的购物项
        if(cartItem != null){
            //数量+1
            cartItem.setCount(cartItem.getCount()+1);
            //小计：原来的小计+当前商品的价格
            cartItem.setSubtotal(cartItem.getSubtotal()+product.getPrice());
            //购物车中的总价：原来的价格+该商品的价格
            cart.setTotalPrice(cart.getTotalPrice()+product.getPrice());
        }else {
            //创建一个该商品的购物项
            CartItem cartItem1 = new CartItem();
            //为购物项的参数赋值
            //把该商品放入购物项中
            cartItem1.setProductDataObject(product);
            //购物项的数量为 1
            cartItem1.setCount(1);
            //小计为商品的价格
            cartItem1.setSubtotal(product.getPrice());
            //把该购物项添加到购物车中
            cart.getMap().put(id,cartItem1);
            //购物车的总价：原始的价格+商品价格
            cart.setTotalPrice(cart.getTotalPrice()+product.getPrice());
        }
        return cart;
    }
}
