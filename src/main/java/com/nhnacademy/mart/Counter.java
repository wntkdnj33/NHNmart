package com.nhnacademy.mart;

import java.util.ArrayList;

public class Counter {

    // TODO pay 메서드 구현 (카운터에서 계산 처리 메서드)



    public static int pay(Basket basket){
        int total = 0;
        for(Food food : basket.getFoods()){
            total += food.getPrice();
        }
        return total;

    }


}
