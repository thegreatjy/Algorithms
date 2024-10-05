package Bj_20546;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int[] money = new int[2];
        money[0] = m; money[1] = m;
        int[] stock = new int[2];
        int[] price = new int[14];

        String[] input = br.readLine().split(" ");
        int increase = 0, decrease = 0;
        for(int i=0; i<14; i++){
            price[i] = Integer.parseInt(input[i]);

            if(i==13){
                // (현금 + 1월 14일의 주가 × 주식 수)
                money[0] = money[0] + price[i] * stock[0];
                // money[1] = money[1] + price[i] * stock[1];

                break;
            }

            // 준현
            if(money[0]/price[i] > 0) {
                stock[0] += money[0] / price[i];
                //money[0] = (money[0] % price[i]);
                money[0] -= price[i] * (money[0]/price[i]);
            }
        }

        // 성민
        for(int i=3; i<13; i++){
            if(price[i-3] < price[i-2] && price[i-2] < price[i-1]){
                // 전량 매도
                if(stock[1] > 0) {
                    money[1] += price[i] * stock[1];
                    stock[1] = 0;
                }
            }else if(price[i-3] > price[i-2] && price[i-2] > price[i-1]){
                // 전량 매수
                if(money[1] / price[i] > 0) {
                    stock[1] += money[1] / price[i];
                    money[1] -= price[i] * (money[1] / price[i]);
                }
            }
        }
        money[1] = money[1] + price[13] * stock[1];

        String result;
        if(money[0] == money[1]){
            result = "SAMESAME";
        }else if(money[0] > money[1]){
            result = "BNP";
        }else{
            result = "TIMING";
        }
        System.out.println(result);
    }
}
