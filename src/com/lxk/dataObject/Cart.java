package com.lxk.dataObject;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Integer,CartItem> map = new HashMap<>(); //map中存储的是商品的id和商品项
    private double totalPrice;

    public Map<Integer, CartItem> getMap() {
        return map;
    }

    public void setMap(Map<Integer, CartItem> map) {
        this.map = map;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
