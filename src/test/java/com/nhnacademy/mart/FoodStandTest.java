package com.nhnacademy.mart;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FoodStandTest {
    @Test
    @DisplayName("add 추가 테스트")
    void addTest() {
        Food food = new Food("양파", 1_000);
        boolean bool1 = false;
        String name = "양파";
        for (int i = 0; i < 2; i++) {
            if (food.getName().equals(name)) {
                bool1 = true;
            }
        }
        Assertions.assertTrue(bool1);
    }


}