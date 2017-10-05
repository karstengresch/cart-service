package com.redhat.coolstore.cart.service;

import com.redhat.coolstore.cart.model.ShoppingCart;
import org.springframework.stereotype.Component;

/**
 * Created by Karsten Gresch on 05.10.17.
 */
@Component
public class PriceCalculationServiceImpl implements PriceCalculationService
{

  @Override public void priceShoppingCart(ShoppingCart shoppingCart)
  {

    Double shoppingCartItemTotal = Math.round(shoppingCart.getCartItemTotal()*100)/100.0;
    System.out.println("*+*+*+* shoppingCartItemTotal: " + shoppingCartItemTotal);
    Double shippingTotal = 0.0;

    if (shoppingCartItemTotal >= 50.00 && shoppingCartItemTotal <= 74.99) {
      System.out.println(">= 50.00 <= 74.99");
      shippingTotal = 6.99;
    } else if (shoppingCartItemTotal >= 25.00 && shoppingCartItemTotal <= 49.99) {
      System.out.println(">= 25.00 <= 49.99");
      shippingTotal = 4.99;
    }else if (shoppingCartItemTotal >= 0.01 && shoppingCartItemTotal <= 24.99) {
      System.out.println(">= 0.01 <= 24.99");
      shippingTotal = 2.99;
    }

    shoppingCart.setShippingTotal(Math.round(shippingTotal*100)/100.0);


  }
}
