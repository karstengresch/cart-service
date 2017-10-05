package com.redhat.coolstore.cart.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = -1108043957592113528L;

    private String id;

    private double cartItemTotal;

    private double shippingTotal;

    private double cartTotal;

    private List<ShoppingCartItem> shoppingCartItemList = new ArrayList<ShoppingCartItem>();

    public ShoppingCart() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ShoppingCartItem> getShoppingCartItemList() {
        return shoppingCartItemList;
    }

    public void setShoppingCartItemList(List<ShoppingCartItem> shoppingCartItemList) {
        this.shoppingCartItemList = shoppingCartItemList;
    }

    public void resetShoppingCartItemList() {
        shoppingCartItemList = new ArrayList<ShoppingCartItem>();
    }

    public void addShoppingCartItem(ShoppingCartItem shoppingCartItem) {
        if (shoppingCartItem != null) {
            shoppingCartItemList.add(shoppingCartItem);
            updateShoppingCartItemTotal();
        }
    }

    public boolean removeShoppingCartItem(ShoppingCartItem sci) {
        boolean removed = false;
        if (sci != null) {
            removed = shoppingCartItemList.remove(sci);
        }
        return removed;
    }

    private void updateShoppingCartItemTotal() {
        System.out.println("Shopping Cart Item List size: " + shoppingCartItemList.size());
        Double newShoppingCartItemSum = shoppingCartItemList.stream().map(ShoppingCartItem::getPrice).mapToDouble(Double::doubleValue).sum();
        this.setCartItemTotal((newShoppingCartItemSum*100)/100.0);
    }

    public double getCartItemTotal() {
        return cartItemTotal;
    }

    public void setCartItemTotal(double cartItemTotal) {
        this.cartItemTotal = cartItemTotal;
    }

    public double getShippingTotal() {
        return shippingTotal;
    }

    public void setShippingTotal(double shippingTotal) {
        this.shippingTotal = shippingTotal;
    }

    public double getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(double cartTotal) {
        this.cartTotal = cartTotal;
    }

    @Override
    public String toString() {
        return "ShoppingCart [" + "id=" + id + "cartItemTotal=" + cartItemTotal + ", shippingTotal="
                + shippingTotal + " cartTotal=" + cartTotal + ", shoppingCartItemList="
                + shoppingCartItemList + "]";
    }

}

