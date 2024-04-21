package Bj_1987;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_3 {
    static int r, c, max = 0;
    static int[] rows = {0, 0, 1, -1};
    static int[] cols = {1, -1, 0, 0};

    static void backtracking(int curR, int curC, char[][] map, boolean[] alphabetSets, int sum){
        // 종료
        if(curR >= r || curC >= c){
            return;
        }

        max = Math.max(max, sum);

        // 상하좌우 탐색
        for(int i=0; i<4; i++){
            int newR = curR + rows[i];
            int newC = curC + cols[i];

            if(newR >= r || newR < 0 || newC >= c || newC < 0)   continue;

            char ch = map[newR][newC];
            if(alphabetSets[ch - 'A'])  continue;   // 사용한 적이 있는 알파벳

            // 방문
            alphabetSets[ch - 'A'] = true;
            backtracking(newR, newC, map, alphabetSets, sum + 1);
            alphabetSets[ch - 'A'] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        r = Integer.parseInt(line[0]);
        c = Integer.parseInt(line[1]);

        char[][] map = new char[r][c];
        for(int i = 0; i< r; i++){
            line[0] = br.readLine();
            for(int j=0; j<line[0].length(); j++){
                map[i][j] = line[0].charAt(j);
            }
        }

        boolean[] alphabetSets = new boolean[26];
        char ch = map[0][0];
        alphabetSets[ch - 'A'] = true;

        backtracking(0, 0, map, alphabetSets, 1);

        System.out.print(max);
    }
}
