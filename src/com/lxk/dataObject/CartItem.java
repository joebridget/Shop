package com.lxk.dataObject;

public class CartItem {
    private ProductDataObject productDataObject;  //商品
    private int count;  //数量
    private double subtotal;  //小计

    public ProductDataObject getProductDataObject() {
        return productDataObject;
    }

    public void setProductDataObject(ProductDataObject productDataObject) {
        this.productDataObject = productDataObject;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
