package com.redhat.coolstore.cart.service;

import com.redhat.coolstore.cart.model.ShoppingCart;
import com.redhat.coolstore.cart.model.ShoppingCartItem;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Karsten Gresch on 05.10.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class PriceCalculationServiceImplTest
{

    PriceCalculationService priceCalculationService = new PriceCalculationServiceImpl();


    @Test
    public void testShippingTotalCalculation() {


      ShoppingCart shoppingCart = new ShoppingCart();

      ShoppingCartItem shoppingCartItem1 = new ShoppingCartItem();
      shoppingCartItem1.setPrice(0.0);
      shoppingCart.addShoppingCartItem(shoppingCartItem1);
      priceCalculationService.priceShoppingCart(shoppingCart);

      Assert.assertEquals(0.0D, shoppingCart.getShippingTotal(), 0.0);

      ShoppingCartItem shoppingCartItem2 = new ShoppingCartItem();
      shoppingCartItem2.setPrice(0.01);
      shoppingCart.addShoppingCartItem(shoppingCartItem2);
      priceCalculationService.priceShoppingCart(shoppingCart);

      Assert.assertEquals(2.99D, shoppingCart.getShippingTotal(), 0.0);

      ShoppingCartItem shoppingCartItem3 = new ShoppingCartItem();
      shoppingCartItem3.setPrice(24.98);
      shoppingCart.addShoppingCartItem(shoppingCartItem3);
      priceCalculationService.priceShoppingCart(shoppingCart);

      Assert.assertEquals(2.99D, shoppingCart.getShippingTotal(), 0.0);

      ShoppingCartItem shoppingCartItem4 = new ShoppingCartItem();
      shoppingCartItem4.setPrice(0.01);
      shoppingCart.addShoppingCartItem(shoppingCartItem4);
      priceCalculationService.priceShoppingCart(shoppingCart);

      Assert.assertEquals(4.99D, shoppingCart.getShippingTotal(), 0.0);

      ShoppingCartItem shoppingCartItem5 = new ShoppingCartItem();
      shoppingCartItem5.setPrice(24.99);
      shoppingCart.addShoppingCartItem(shoppingCartItem5);
      priceCalculationService.priceShoppingCart(shoppingCart);

      Assert.assertEquals(4.99D, shoppingCart.getShippingTotal(), 0.0);

      ShoppingCartItem shoppingCartItem6 = new ShoppingCartItem();
      shoppingCartItem6.setPrice(0.01);
      shoppingCart.addShoppingCartItem(shoppingCartItem6);
      priceCalculationService.priceShoppingCart(shoppingCart);

      Assert.assertEquals(6.99D, shoppingCart.getShippingTotal(), 0.0);

      ShoppingCartItem shoppingCartItem7 = new ShoppingCartItem();
      shoppingCartItem7.setPrice(24.99);
      shoppingCart.addShoppingCartItem(shoppingCartItem7);
      priceCalculationService.priceShoppingCart(shoppingCart);

      Assert.assertEquals(6.99D, shoppingCart.getShippingTotal(), 0.0);

      ShoppingCartItem shoppingCartItem8 = new ShoppingCartItem();
      shoppingCartItem8.setPrice(0.01);
      shoppingCart.addShoppingCartItem(shoppingCartItem8);
      priceCalculationService.priceShoppingCart(shoppingCart);

      Assert.assertEquals(0.0D, shoppingCart.getShippingTotal(), 0.0);

      ShoppingCartItem shoppingCartItem9 = new ShoppingCartItem();
      shoppingCartItem9.setPrice(159039.39);
      shoppingCart.addShoppingCartItem(shoppingCartItem9);
      priceCalculationService.priceShoppingCart(shoppingCart);

      Assert.assertEquals(0.0D, shoppingCart.getShippingTotal(), 0.0);

    }

}
