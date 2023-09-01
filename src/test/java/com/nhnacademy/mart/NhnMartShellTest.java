package com.nhnacademy.mart;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NhnMartShellTest {
    @Test
    @DisplayName("NHN 상품 제대로 담겼는지 확인")
    void inputBuyListTest(){
        BuyList buyList = new BuyList();
        ArrayList<BuyList.Item> items = buyList.getItems();
        buyList.add(new BuyList.Item("양파", 2));
        boolean boolean1 = false;
        for(BuyList.Item item : items){
            if (item.getName().equals("양파") && item.getAmount() == 2) {
                boolean1 = true;
            }
        }
        Assertions.assertTrue(boolean1);
    }

    @Test
    @DisplayName("상품 수량이 0일 경우")
    void AmountinputBuyListTest(){
        BuyList buyList = new BuyList();
        ArrayList<BuyList.Item> items = buyList.getItems();
        boolean boolean1 = false;
        buyList.add(new BuyList.Item("양파", 0));
        for(BuyList.Item item : items){
            if (item.getName().equals("양파") && item.getAmount() == 0) {
                boolean1 = false;
            }
        }
        Assertions.assertFalse(boolean1);

    }
    @Test
    @DisplayName("상품 이름이 빈 칸일 경우")
    void isEmptyinputBuyListTest(){
        BuyList buyList = new BuyList();
        ArrayList<BuyList.Item> items = buyList.getItems();
        boolean boolean1 = false;
        buyList.add(new BuyList.Item("", 2));
        for(BuyList.Item item : items){
            if (item.getName().isEmpty() && item.getAmount() == 2) {
                boolean1 = false;
            }
        }
        Assertions.assertFalse(boolean1);

    }

}