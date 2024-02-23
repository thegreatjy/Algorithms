package Bj_10988;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int length = inputStr.length();

        int result = 1;
        for(int i=0; i<length/2; i++){
            if(inputStr.charAt(i) != inputStr.charAt(length -1 - i)){
                result = 0;
                break;
            }
        }

        System.out.println(result);
    }
}
