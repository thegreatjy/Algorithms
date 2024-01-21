import java.io.*;
import java.util.Arrays;

public class Main {
    static int n;   // 도시의 개수
    static int[][] w, dp;
    static final int INF = 16_000_000;

    // dfs: current 도시에서 방문하지 않은 도시를 모두 방문하고 처음 도시(0)으로 돌아가는 데 소요되는 최소 비용
    public static int dfs(int current, int visited){
        // 마지막 도시 -> 처음 도시
        if(visited == (1<<n) - 1){  // 모든 도시를 방문함.
            if(w[current][0] != 0){ // 가는 길이 있다면
                return w[current][0];
            }else{  // 순회 불가능
                return INF;
            }
        }

        if(dp[current][visited] != -1){ // 이미 계산한 적이 있으면
            return dp[current][visited];
        }


        int min = INF;

        for(int i=0; i<n; i++){
            // 현재 도시에서 i 도시까지 갈 수 있고, i 도시를 방문하지 않았으면 방문한다.
            if(w[current][i] != 0 && (visited & (1<<i)) == 0){
                min = Math.min(min, w[current][i] + dfs(i, (visited | (1<<i))));
            }
        }

        dp[current][visited] = min;

        return dp[current][visited];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        w = new int[n][n];
        String[] line;

        for(int i=0; i<n; i++){
            line = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                w[i][j] = Integer.parseInt(line[j]);
            }
        }

        dp = new int[n][1<<n];  // dp[i][방문한도시] = 현재 도시 i로부터 방문하지 않은 도시들을 지나 시작 도시로 순회하는 데 소요되는 비용
        for(int[] arr: dp){
            Arrays.fill(arr, -1);   // 방문하지 않은 점은 -1로 처리
        }

        int result = dfs(0, 1);
        System.out.println(result);
    }
}
