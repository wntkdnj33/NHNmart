package com.nhnacademy.mart;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FoodStand {
    private static final Logger log = LoggerFactory.getLogger(FoodStand.class);
    private final ArrayList<Food> foods = new ArrayList<>();

    // TODO add 메서드 구현
    public void add(Food food){
        foods.add(food);
    }

    // TODO 장바구니에 담은 Food 삭제 구현
    public Food remove(String name) {
        int product = 0;
        for (Food food : foods) {
            if (food.getName().equals(name)) {
                return foods.remove(product);
            }
            product++;
        }
        log.warn("재고가 없음!");
        throw new IllegalArgumentException("재고가 부족합니다.");
    }
}
