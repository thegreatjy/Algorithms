import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Town implements Comparable<Town>{
    int to;
    int cost;

    public Town(int to, int cost){
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Town o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static int n, m, x;
    static List<Town>[] list;
    static List<Town>[] reversedList;
    static int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        reversedList = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            list[i] = new ArrayList<>();
            reversedList[i] = new ArrayList<>();
        }

        int start = 0, finish = 0, time = 0;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            finish = Integer.parseInt(st.nextToken());
            time = Integer.parseInt(st.nextToken());

            list[start].add(new Town(finish, time));
            list[finish].add(new Town(start, time));
        }

        int[] go = dijkstra(list, x);
        int[] back = dijkstra(reversedList, x);

        int res = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            int dis = go[i] + back[i];

            if(dis>res){
                res = dis;
            }
        }

        System.out.println(res);
    }

    static int[] dijkstra(List<Town>[] list, int start){
        Queue<Town> q = new PriorityQueue<>();  // 방문할 곳 목록
        boolean[] visited = new boolean[n+1];
        int[] dp = new int[n+1];    // 최소 소요 시간을 담은 2차원 배열. dp[i] = (start -> i) 최소 소요 시간
        Arrays.fill(dp, INF);

        q.add(new Town(start, 0));
        dp[start] = 0;

        while(!q.isEmpty()){
            Town position = q.poll();
            int to = position.to;
            if(visited[to]) continue;

            visited[to] = true; // start -> to 방문함
            // to에서 인접 노드를 q에 저장함
            for(Town next: list[to]){
                if(dp[to] + next.cost < dp[next.to]){
                    dp[next.to] = dp[to] + next.cost;
                    q.add(new Town(next.to, dp[next.to]));
                }
            }
        }

        return dp;
    }
}
