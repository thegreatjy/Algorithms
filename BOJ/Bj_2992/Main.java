package Bj_2992;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static int x = 0;
    private static int size = 0;    // input 자릿수
    private static int result = Integer.MAX_VALUE;

    public static void dfs(List<Integer> list, int depth, boolean[] visited, int[] resultArr){
        if(depth == size){
            int tempResult = 0;
            for(int i=0; i<resultArr.length; i++){
                tempResult += resultArr[i] * (int) Math.pow(10, (size - 1) - i);
            }

            if(tempResult > x){
                result = Math.min(result, tempResult);
            }

            return;
        }

        for(int l=0; l<list.size(); l++){
            // 현재 자리 depth에 리스트의 l번째 수를 넣어본다.
            // 리스트 숫자가 사용된 적 없을 경우
            if(!visited[l]){
                visited[l] = true;
                resultArr[depth] = list.get(l);
                dfs(list, depth + 1, visited, resultArr);
                visited[l] = false;
            }
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        x = Integer.parseInt(input);
        size = input.length();

        // 1. 구성 수를 구한다.
        List<Integer> list = new ArrayList<>();
        int tempX = x;
        while(tempX > 0){
            list.add(tempX % 10);
            tempX /= 10;
        }

        // 2. 정렬
        list.sort(Comparator.naturalOrder());

        // 3. 모든 수를 구한다.
        boolean[] visited = new boolean[size];
        int[] resultArr = new int[size];

        dfs(list, 0, visited, resultArr);

        result = (result == Integer.MAX_VALUE) ? 0 : result;
        System.out.println(result);
    }
}
