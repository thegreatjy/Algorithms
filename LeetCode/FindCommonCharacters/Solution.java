package FindCommonCharacters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        int[] numOfAlphabet = new int[26];
        Arrays.fill(numOfAlphabet, Integer.MAX_VALUE);

        for(int i=0; i<words.length; i++){
            // words[i]의 <구성문자, 개수>를 구함
            int[] wordConsistsOf = new int[26];
            for(int j=0; j<words[i].length(); j++){
                ++wordConsistsOf[words[i].charAt(j) - 'a'];
            }

            // 모든 알파벳의 최소 개수를 구한다.
            for(int k=0; k<26; k++){
                numOfAlphabet[k] = Math.min(numOfAlphabet[k], wordConsistsOf[k]);
            }
        }

        // 0이 아니고 Integer.MAX_VALUE가 아닌 알파벳을 개수만큼 꺼낸다.
        for(int i=0; i<26; i++){
            if(numOfAlphabet[i] != Integer.MAX_VALUE && numOfAlphabet[i] != 0) {
                for(int j=0; j<numOfAlphabet[i]; j++){
                    result.add( String.valueOf((char)('a' + i)) );
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
