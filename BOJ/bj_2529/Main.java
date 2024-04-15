package bj_2529;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static boolean[] visited = new boolean[10]; // 0~9 숫자 사용 여부
    static int[] maxResult;
    static int[] minResult;

    // sign[current] 뒤의 정수인 array[current+1]을 구함
    public static void backTracking(int current, int[] array, String[] sign){
        // 종료
        if(current >= n){
            if(maxResult == null){
                maxResult = array.clone();
                minResult = array.clone();
            }else{
                minResult = array.clone();
            }

            return ;
        }

        for(int i=9; i>=0; i--){
            // 사용된 숫자 여부 확인
            if(visited[i])  continue;

            // 이전 정수와 i의 부등호 관계 성립 여부 확인
            int prevInt = array[current];
            if(sign[current].equals(">")){
                // prevInt > i가 성립되지 않을 경우
                if(prevInt <= i){
                    continue;
                }
            }else if(sign[current].equals("<")){
                // prevInt < i가 성립되지 않을 경우
                if(prevInt >= i){
                    continue;
                }
            }else{
                return;
            }

            array[current + 1] = i;
            visited[i] = true;
            backTracking(current + 1, array, sign);
            array[current + 1] = 0;
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] sign = br.readLine().split(" ");

        int[] array = new int[n+1];
        for(int b=9; b>=0; b--) {
            array[0] = b;
            visited[b] = true;
            backTracking(0, array, sign);
            array[0] = 0;
            visited[b] = false;
        }

        Arrays.stream(maxResult).forEach(obj -> System.out.print(obj));
        System.out.println();
        Arrays.stream(minResult).forEach(obj -> System.out.print(obj));
    }
}
