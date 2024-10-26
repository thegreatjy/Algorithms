package Bj_2357;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] nums;
    static int[] minTree, maxTree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N+1];
        for(int i=1; i<=N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        minTree = new int[4*N];
        maxTree = new int[4*N];
        initMin(1, N, 1);
        initMax(1, N, 1);

        StringBuilder sb = new StringBuilder();
        int a, b;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sb.append(getMin(1, N, 1, a, b) + " ");
            sb.append(getMax(1, N, 1, a, b) + "\n");
        }

        System.out.println(sb.toString());


    }

    // minTree[node] = start~end 구간 중에서 최소값
    // left~right 구간 중 최솟값 구하기
    public static int getMin(int start, int end, int node, int left, int right){
        // 범위 밖
        if(left > end || right < start){
            return Integer.MAX_VALUE;
        }
        // 범위 내
        if(left <= start && end <= right){
            return minTree[node];
        }

        int mid = (start+end)/2;
        int min = Math.min(getMin(start, mid, node*2, left, right), getMin(mid+1, end, node*2+1, left, right));
        return min;
    }

    // maxTree[node] = start~end 구간 중에서 최대값
    // left~right 구간 중 최대값 구하기
    public static int getMax(int start, int end, int node, int left, int right){
        // 범위 밖
        if(left > end || right < start){
            return -1;
        }
        // 범위 내
        if(left <= start && end <= right){
            return maxTree[node];
        }

        int mid = (start+end)/2;
        int max = Math.max(getMax(start, mid, node*2, left, right), getMax(mid+1, end, node*2+1, left, right));
        return max;
    }

    // minTree[node] = start~end 구간 중에서 최소값
    public static int initMin(int start, int end, int node){
        if(start == end){
            minTree[node] = nums[start];
            return minTree[node];
        }

        int mid = (start+end)/2;
        int min = Math.min(initMin(start, mid, node*2), initMin(mid+1, end, node*2+1));
        minTree[node] = min;
        return minTree[node];
    }

    // maxTree[node] = start~end 구간 중에서 최대값
    public static int initMax(int start, int end, int node){
        if(start == end){
            maxTree[node] = nums[start];
            return maxTree[node];
        }

        int mid = (start+end)/2;
        int max = Math.max(initMax(start, mid, node*2), initMax(mid+1, end, node*2+1));
        maxTree[node] = max;
        return maxTree[node];
    }

}
