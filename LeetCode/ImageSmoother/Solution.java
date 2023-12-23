import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] result = new int[m][n];

        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                int sum = 0;
                int cnt = 0;

                // img[r][c] + surroundings of img[r][c]
                for(int row=Math.max(0, r-1); row<Math.min(m, r+2); row++){
                    for(int col=Math.max(0, c-1); col<Math.min(n, c+2); col++){
                        sum += img[row][col];
                        ++cnt;
                    }
                }

                result[r][c] = sum / cnt;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[][] img = {{100,200,100},{200,50,200},{100,200,100}};
        int[][] result = new Solution().imageSmoother(img);

        for(int[] arr:result){
            for(int i:arr){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}