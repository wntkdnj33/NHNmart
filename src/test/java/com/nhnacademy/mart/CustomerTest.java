package com.nhnacademy.mart;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {
    @Test
    @DisplayName("pickFoods 테스트")
    void pickFoodsTest() {
        BuyList buyList = new BuyList();
        FoodStand foodStand = new FoodStand();
        Customer customer = new Customer(buyList);
        Basket basket = new Basket();

        foodStand.add(new Food("양파", 1000));
        foodStand.add(new Food("파", 500));
        buyList.add(new BuyList.Item("양파", 1));
        buyList.add(new BuyList.Item("파", 1));

        customer.bring(basket);
        customer.pickFoods(foodStand);

        Assertions.assertEquals(2, basket.getFoods().size());
    }

    @Test
    @DisplayName("payTox 테스트")
    void payTox(){
        Basket basket = new Basket();
        int money = 20000;
        basket.add(new Food("양파", 1000));
        basket.add(new Food("계란", 5000));
        basket.add(new Food("파", 500));

        Counter.pay(basket);
        money = money - Counter.pay(basket);

        Assertions.assertEquals(6500, Counter.pay(basket));
        Assertions.assertEquals(13500, money);
    }
//    @Test
//    @DisplayName("money가 20000원이 넘을 경우")
//    void overtotalMoney(){
//        Basket basket = new Basket();
//        int money = 20000;
//        basket.add(new Food("양파", 1000));
//        basket.add(new Food("계란", 5000));
//        basket.add(new Food("파", 500));
//        basket.add(new Food("계란", 5000));
//        basket.add(new Food("계란", 5000));
//        basket.add(new Food("계란", 5000));
//
//        Counter.pay(basket);
//        Assertions.assertThrows(IllegalArgumentException.class, () -> Counter.pay(basket));
//
//
//    }



}