package IsSubsequence;

class Solution {
    public boolean isSubsequence(String s, String t) {
        boolean result = false;

        int sPointer = 0, tPointer = 0;

        for(tPointer = 0; tPointer<t.length(); tPointer++){
            if(sPointer >= s.length()){
                result = true;
                break;
            }

            if(t.charAt(tPointer) == s.charAt(sPointer)){
                ++sPointer;
            }
        }
        if(sPointer >= s.length()){
            result = true;
        }

        return result;
    }

    public static void main(String[] args) {
        //String s= "abc", t = "ahbgdc";
        String s= "axc", t = "ahbgdc";
        boolean res = new Solution().isSubsequence(s, t);
        System.out.println(res);
    }
}