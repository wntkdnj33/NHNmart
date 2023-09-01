package com.nhnacademy.mart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NhnMart {
    private static final Logger log = LoggerFactory.getLogger(NhnMart.class);
    private final FoodStand foodStand = new FoodStand();

    public void prepareMart() {
        fillFoodStand();
    }


    // 음식 세팅
    private void fillFoodStand() {
        try {
            for (int i = 0; i < 2; i++) {
                foodStand.add(new Food("양파", 1_000));
            }
            for (int i = 0; i < 5; i++) {
                foodStand.add(new Food("계란", 5_000));
            }
            for (int i = 0; i < 10; i++) {
                foodStand.add(new Food("파", 500));
            }
            for (int i = 0; i < 20; i++) {
                foodStand.add(new Food("사과", 2_000));
            }
        } catch(IllegalArgumentException e){
            log.warn("식품 매대에 없는 상품!!");
            System.out.println(e.getMessage());
        }
    }

    public Basket provideBasket() {
        return new Basket();
    }

    public FoodStand getFoodStand() {
        return foodStand;
    }

    public Counter getCounter() {
        return new Counter();
    }
}
