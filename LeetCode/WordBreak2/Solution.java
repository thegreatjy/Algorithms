package WordBreak2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// 18:10 - 19:14
public class Solution {
    /**
     * s.substring(begin) 문장에서 유효한 문장들을 반환한다.
     * @param s
     * @param wordDict
     * @param begin
     * @return
     */
    public List<String> backtracking(String s, HashSet<String> wordDict, int begin){
        List<String> resultList = new ArrayList<>();

        // base case
        if(begin >= s.length()){
            resultList.add("");
        }

        List<String> validSentences;
        for(int end=begin; end<s.length(); end++){
            String prefix = s.substring(begin, end+1);

            if(wordDict.contains(prefix)){
                validSentences = backtracking(s, wordDict, end+1);

                for(String sentence: validSentences){
                    resultList.add(prefix.concat(" ").concat(sentence).trim());
                }
            }
        }

        return resultList;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> dictionary = new HashSet<>(wordDict);

        List<String> list = backtracking(s, dictionary, 0);

        return list;
    }

    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> wordDict = List.of(new String[]{"apple", "pen", "applepen", "pine", "pineapple"});

        List<String> list = new Solution().wordBreak(s, wordDict);
        list.stream().forEach(e -> System.out.print(e + ", "));
    }
}
