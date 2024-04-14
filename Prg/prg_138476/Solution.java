package prg_138476;

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        // Map<귤 크기, 개수>
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }

        // 귤 크기 리스트
        List<Integer> keyList = new ArrayList<>(map.keySet());
        // 귤 개수 내림차순으로 정렬
        keyList.sort((o1, o2) -> map.get(o2) - map.get(o1));

        // 뒤에서부터 k개 고르기
        int sum = 0, result = 0;
        for(Integer key: keyList){
            if(sum >= k){
                break;
            }
            sum += map.get(key);
            ++result;
        }

        return result;
    }
}
