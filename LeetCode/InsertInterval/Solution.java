package InsertInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int [][] merged = new int[intervals.length+1][];
        int c = 0;
        for (int []i : intervals) {
            merged[c++] = i;
        }
        merged[intervals.length] = newInterval;
        Arrays.sort(merged , (a, b) -> Integer.compare(a[0], b[0]));
        List<int []> list = new ArrayList<>();
        for(int [] arr : merged){
            if(list.size() == 0) list.add(arr);
            else{
                int [] prevArr = list.get(list.size()-1);
                if(arr[0] <= prevArr[1]){
                    prevArr[1] = Math.max(prevArr[1] , arr[1]);
                }
                else list.add(arr);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}