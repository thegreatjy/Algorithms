package ValidWord;

public class Solution {
    public boolean isValid(String word) {
        boolean result = false;

        if(word.length() <= 2)    return false;

        boolean containsVowels = false;
        boolean containsConsonant = false;

        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);

            if(c<48 || (c>57 && c<65) || (c>90 && c<97) || c>122){
                return false;
            }

            if(c < 65)  continue;
            if(c==65 || c==69 || c==73 || c==79 || c==85)   containsVowels = true;
            else if(c==97 || c==101 || c==105 || c==111 || c==117)   containsVowels = true;
            else containsConsonant = true;
        }

        result = containsVowels && containsConsonant;

        return result;
    }
}
