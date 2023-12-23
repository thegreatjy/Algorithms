import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public int[] sortByBits(int[] arr) {
        int[] result = new int[arr.length];
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>(); // 이진법 표현에서 1의 개수, 해당하는 arr 요소 큐
        for(int i=0; i<15; i++){
            map.put(i, new PriorityQueue<Integer>());
        }

        for(int i=0; i<arr.length; i++){
            int cnt = cntOne(arr[i]);
            PriorityQueue<Integer> pq = map.get(cnt);
            pq.add(arr[i]);
        }

        int r = 0;
        for(int i=0; i<15; i++){
            PriorityQueue<Integer> pq = map.get(i);
            int size = pq.size();
            if(size == 0)  continue;
            for(int j=0; j<size; j++){
                result[r++] = pq.poll();
            }
        }
        return result;
    }

    public int cntOne(int num){
        String binStr = Integer.toBinaryString(num);
        long cnt = binStr.chars()
                .filter(c->c == '1')
                .count();
        return (int) cnt;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8};
        int[] result = new Solution().sortByBits(arr);
        for(int r:result){
            System.out.print(r+" ");
        }
    }
}