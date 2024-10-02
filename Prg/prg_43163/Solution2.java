package prg_43163;

public class Solution2 {
    static int minDepth = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        boolean[] visited = new boolean[words.length];
        dfs(begin, 0, target, words, visited);

        if(minDepth == Integer.MAX_VALUE){
            return 0;
        }

        return minDepth;
    }

    public void dfs(String currentWord, int depth, String target, String[] words, boolean[] visited){
        // 종료
        if(currentWord.equals(target)){
            minDepth = Math.min(minDepth, depth);
            return;
        }

        // 현재 단어 -> word[i]
        for(int i=0; i<words.length; i++){
            if(!visited[i] && diff(currentWord, words[i]) == 1){
                visited[i] = true;
                dfs(words[i], depth + 1, target, words, visited);
                visited[i] = false;
            }
        }
    }

    // a, b 캐릭터 차이 리턴
    public int diff(String a, String b){
        int cnt = 0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                ++cnt;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        //String[] words = {"hot", "dot", "dog", "lot", "log"};
        int result = new Solution2().solution(begin, target, words);
        System.out.println(result);
    }
}
