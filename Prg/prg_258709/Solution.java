package prg_258709;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    static ArrayList<int[]> combDiceA;
    static ArrayList<Integer> score;

    public int[] solution(int[][] dice) {
        int[] answer = {};
        int n = dice.length;
        int[] diceA = new int[n/2];
        combDiceA = new ArrayList<>();
        score = new ArrayList<>();
        int maxWinCnt = 0;

        combination(0, 0, n, diceA);

        for (int i = 0; i < combDiceA.size() / 2; i++) {
            int myIdx = i;
            int oppIdx = combDiceA.size() - i - 1;

            int[] myCombination = combDiceA.get(myIdx);
            int[] oppCombination = combDiceA.get(oppIdx);

            //점수 조합 압축
            HashMap<Integer, Integer> myScoreCnt = calculateScoreCnt(myCombination, 0, n / 2, dice);
            HashMap<Integer, Integer> oppScoreCnt = calculateScoreCnt(oppCombination, 0, n / 2, dice);

            int winCnt = 0;
            int loseCnt = 0;
            for (int m : myScoreCnt.keySet()) {
                for (int o : oppScoreCnt.keySet()) {
                    if (m > o) {
                        winCnt += (myScoreCnt.get(m) * oppScoreCnt.get(o));
                    } else if (m < o) {
                        loseCnt += (myScoreCnt.get(m) * oppScoreCnt.get(o));
                    }
                }
            }
            if (maxWinCnt < winCnt) {
                maxWinCnt = winCnt;
                answer = myCombination;
            }
            if (maxWinCnt < loseCnt) {
                maxWinCnt = loseCnt;
                answer = oppCombination;
            }
        }

        // index 0 주사위 > 1번 주사위 변경 작업
        for (int i = 0; i < answer.length; i++) {
            answer[i]++;
        }

        return answer;
    }

    // 주사위 조합
    public void combination(int start, int currentDepth, int maxDepth, int[] diceA){
        // 종료
        if(currentDepth >= maxDepth/2){
            combDiceA.add(Arrays.stream(diceA).toArray());
            return ;
        }

        for(int i=start; i<maxDepth; i++){
            diceA[currentDepth] = i;
            combination(i + 1, currentDepth + 1, maxDepth, diceA);
        }
    }

    private HashMap<Integer, Integer> calculateScoreCnt(int[] combi, int curDepth, int maxDepth, int[][] dice) {
        if (curDepth == maxDepth) {
            HashMap<Integer, Integer> scoreCnt = new HashMap<>();
            for (int s : score) {
                if (!scoreCnt.containsKey(s)) {
                    scoreCnt.put(s, 1);
                } else {
                    scoreCnt.put(s, scoreCnt.get(s) + 1);
                }
            }
            score.clear();
            return scoreCnt;
        }
        int idx = combi[curDepth];
        if (score.size() == 0) {
            for (int i = 0; i < 6; i++) {
                score.add(dice[idx][i]);
            }
        } else {
            int size = score.size();
            for (int i = 0; i < size; i++) {
                int s = score.remove(0);
                for (int j = 0; j < 6; j++) {
                    score.add(dice[idx][j] + s);
                }
            }
        }
        return calculateScoreCnt(combi, curDepth + 1, maxDepth, dice);
    }

    public static void main(String[] args) {
        int[][] dice = {
                {1, 2, 3, 4, 5, 6},
                {3, 3, 3, 3, 4, 4},
                {1, 3, 3, 4, 4, 4},
                {1, 1, 4, 4, 5, 5}
        };
        int[] result = new Solution().solution(dice);
        for(int r: result){
            System.out.print(r + " ");
        }
    }
}
