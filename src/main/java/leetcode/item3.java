package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by apple on 19/1/27.
 */


public class item3 {
    public static void main(String args[]){
        String S = "abcabcbb";
        int ans =  lengthOfLongestSubstring(S);
        System.out.println(ans);
    }


    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public static  boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

}
