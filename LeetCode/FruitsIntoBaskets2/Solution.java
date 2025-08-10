package FruitsIntoBaskets2;

import java.util.Arrays;

public class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int result = 0;

        boolean[] available = new boolean[baskets.length];
        Arrays.fill(available, true);

        int cnt = 0;
        for(int i = 0; i < fruits.length; i++){
            for(int j = 0; j < baskets.length; j++){
                if( available[j] && (baskets[j] >= fruits[i]) ){
                    available[j] = false;
                    ++cnt;
                    break;
                }
            }
        }

        result = fruits.length - cnt;
        return result;
    }
}
