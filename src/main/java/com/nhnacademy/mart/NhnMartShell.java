package com.nhnacademy.mart;

import java.util.Scanner;
import java.util.StringTokenizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NhnMartShell {

    private static final Logger log = LoggerFactory.getLogger(NhnMartShell.class);

    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        BuyList buyList = inputBuyListFromShell();

        // TODO 본인이름 영어로 변수명 작성!
        // 본인이름을 각자 맞게 영어로 변경
        // 홍길동 학생
        // -> hongGilDong or gilDong
        Customer Kimminseok = new Customer(buyList);

        // 장바구니를 챙긴다.
        Kimminseok.bring(mart.provideBasket());

        // 식품을 담는다.
        Kimminseok.pickFoods(mart.getFoodStand());

        // 카운터에서 계산한다.
        Kimminseok.payTox(mart.getCounter());
    }

    private static BuyList inputBuyListFromShell() {
        // TODO Scanner 입력을 받아 buyList 만들기
        log.trace("테스트용");
        log.info("NHN 마트에 옴.");
        System.out.println("NHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요.");

        BuyList buyList = new BuyList();

        log.info("상품 입력.");
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        while(st.hasMoreTokens()){
            String name = st.nextToken();
            int amount = Integer.parseInt(st.nextToken());
            if(amount < 1) {
                log.warn("상품 오류 발생.. 상품을 1개 이상 담아야 함");
                throw new IllegalArgumentException("상품을 1개 이상 담아야 합니다.");
            }
            if(name.isEmpty()){
                log.warn("사고 싶은 물건을 골라야 합니다. ");
                throw new IllegalArgumentException("사고 싶은 물건을 골라주세요.");
            }

            buyList.add(new BuyList.Item(name, amount));
        }


        return buyList;
    }
}
