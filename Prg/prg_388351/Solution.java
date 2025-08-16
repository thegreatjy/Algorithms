package prg_388351;

public class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        int successDay = 0, curDay = 0, coverTime = 0;
        for(int i=0; i<schedules.length; i++){
            successDay = 0; // i번째 직원의 성공일 수
            coverTime = schedules[i] + 10;  // i번째 직원의 출근 가능 시각
            if(coverTime%100 >= 60){
                coverTime = (coverTime/100 + 1) * 100 + ((coverTime%100)%60);
            }

            for(int j=0; j<timelogs[i].length; j++){
                curDay = (startday + j) % 7;
                // 주말
                if(curDay == 6 || curDay == 0) continue;

                // 평일
                if(timelogs[i][j] <= coverTime) ++successDay;
            }

            if(successDay >= 5){
                ++answer;
            }
        }

        return answer;
    }
}
