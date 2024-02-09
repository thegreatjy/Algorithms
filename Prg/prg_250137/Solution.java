class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;    // 현재 체력. 처음엔은 최대 최력으로 시작.
        int t = bandage[0], x = bandage[1], y = bandage[2];
        int lastAttackedTime = 0;   // 마지막으로 공격당한 시각
        int recoveryTime = 0;   // 연속 회복 시간


        for(int i=0; i<attacks.length; i++){
            recoveryTime = (attacks[i][0] - lastAttackedTime) - 1;  // 연속 회복 시간

            // 현재 체력이 최대 체력이 아닐 경우 회복
            if(answer < health){
                // 현재 체력 += 연속회복시간 * 1초당 회복 체력 + 추가 회복 체력
                answer += (recoveryTime * x) + (recoveryTime / t) * y;
                answer = (answer > health) ? health : answer;   // 현재 체력은 최대 체력보다 클 수 없다.
                
                //answer = Math.min(answer + (recoveryTime * x) + (recoveryTime / t) * y, health);
            }

            // 공격 당하기
            answer -= attacks[i][1];
            // 현재 체력이 0 이하이면 캐릭터가 죽는다.
            if(answer <= 0){
                answer = -1;
                break;
            }
            lastAttackedTime = attacks[i][0];   // 마지막 공격당한 시각을 현재 시각으로 갱신
        }

        return answer;
    }
}
