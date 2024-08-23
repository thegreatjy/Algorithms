package Prg_42889;

import java.util.Arrays;
import java.util.Comparator;

public class Solution2 {
    public int[] solution(int N, int[] stages) {
        int[] reach = new int[N+2];    // i단계 도달 플레이어 수
        double[] fail = new double[N+1]; // i단계 실패율 = i단계 클리어x수/i단계 도달수 = (i단계 도달수 - i+1단계 도달수)/i단계 도달수

        for(int i=0; i<stages.length; i++){
            ++reach[stages[i]];
        }
        for(int i=N+1; i>=1; i--){
            reach[i-1] += reach[i];

            if(i == N+1)    continue;
            if(reach[i] == 0){
                fail[i] = 0;
            }else{
                fail[i] = (double)(reach[i] - reach[i+1]) / reach[i];
            }
        }

        Integer[] index = new Integer[N];
        for(int i=0; i<=index.length - 1; i++){
            index[i] = i + 1;
        }

        Arrays.sort(index, new Comparator<Integer>() {
            @Override
            public int compare(Integer index1, Integer index2) {
                // 내림차순
                return Double.compare(fail[index2], fail[index1]);
            }
        });

        return Arrays.stream(index)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        /*
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
         */

        int N = 4;
        int[] stages = {4,4,4,4,4};

        int[] result = new Solution2().solution(N, stages);
        for(int r: result){
            System.out.print(r + " ");
        }
    }
}
