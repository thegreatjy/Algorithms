package prg_43164;

import java.util.*;

class Solution {
    static List<String> list = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        String[] answer = {};

        boolean[] useTickets = new boolean[tickets.length];
        dfs(0, "ICN", "ICN", tickets, useTickets);

        Collections.sort(list);
        String str = list.get(0);
        // string -> String[]
        answer = str.split(" ");
        return answer;
    }

    public static void dfs(int depth, String start, String route, String[][] tickets, boolean[] usedTickets){
        // 종료
        if(depth >= tickets.length){
            list.add(route);
            return;
        }

        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals(start) && !usedTickets[i]){
                usedTickets[i] = true;
                dfs(depth+1, tickets[i][1], route + " " + tickets[i][1], tickets, usedTickets);
                usedTickets[i] = false;
            }
        }
    }
}