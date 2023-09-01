package com.nhnacademy.mart;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Customer {
    private static final Logger log = LoggerFactory.getLogger(Customer.class);


    // 고객 구매 목록
    private final BuyList buyList;

    // 고객 장바구니
    private Basket basket;

    private final int money = 20000;


    public Customer(BuyList buyList) {
        this.buyList = buyList;
    }

    // 장바구니 챙기기
    public void bring(Basket basket) {
        this.basket = basket;
    }

    // TODO pickFoods 메서드 구현
    public void pickFoods(FoodStand foodStand){
        ArrayList<BuyList.Item> Items = buyList.getItems();
        for(BuyList.Item item : Items){
            for (int i = 0; i < item.getAmount(); i++) {
                basket.add(foodStand.remove(item.getName()));
            }
        }
    }


    // TODO payTox 메서드 구현
    public void payTox(Counter counter){
        int totalprice = counter.pay(basket);

        if(money > 20000) {
            log.warn("소지금이 20000원 이상!");
            throw new IllegalArgumentException("소지금이 20000원을 넘을수 없습니다.");
        }
        System.out.println("총 가격은 " + totalprice + " 입니다.");
        System.out.println("고객님 결제 후 잔액 : "  + (money-totalprice));

    }

}



