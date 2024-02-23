package Bj_1543;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        String keyword = br.readLine();
        int n = inputStr.length();
        int m = keyword.length();

        int result = 0;
        for(int i=0; i<=n-m; i++){
            if(inputStr.substring(i, i + m).equals(keyword)){
                i += m - 1;
                ++result;
            }
        }
        System.out.println(result);
    }
}