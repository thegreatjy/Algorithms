package Bj_2042;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N, M, K;
    static long[] num;
    static long[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line;
        line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        K = Integer.parseInt(line[2]);

        num = new long[N+1];
        for(int i=1; i<=N; i++){
            num[i] = Long.parseLong(br.readLine());
        }

        tree = new long[4*N];
        init(1, N, 1);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M+K; i++){
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            long c = Long.parseLong(line[2]);

            if(a==1){
                long dif = c - num[b];
                num[b] = c;
                update(1, N, 1, b, dif);
            }else if(a==2){
                sb.append(sum(1, N, 1, b, (int)c) + "\n");
            }
        }

        System.out.println(sb.toString());
    }

    // start~end의 합을 가진 tree[node]를 구한다.
    public static long init(int start, int end, int node){
        if(start == end){
            tree[node] = num[start];
            return tree[node];
        }

        int mid = (start+end)/2;
        tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
        return tree[node];
    }

    // tree[node] = start~end의 합을 가지고 있음
    // left~right의 구간합을 구함
    public static long sum(int start, int end, int node, int left, int right){
        // 범위 밖
        if(left > end || right < start){
            return 0;
        }
        // 범위 내
        if(left <= start && end <= right){
            return tree[node];
        }

        int mid = (start+end)/2;
        return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
    }

    // tree[node] = start~end의 합
    // index 원소의 값을 dif로 바꿈
    public static void update(int start, int end, int node, int index, long dif){
        // 범위 밖
        if(start > index || index > end){
            return;
        }

        // 범위 내
        tree[node] += dif;
        if(start == end){
            return;
        }

        int mid = (start+end)/2;
        update(start, mid, node*2, index, dif);
        update(mid+1, end, node*2+1, index, dif);
    }
}
