package leetcode.string;

/**
 * Created by apple on 2019/5/16.
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 */
public class isAnagramSolution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] letter=new int[26];//存储各字符出现次数
        //toCharArray() 方法将字符串转换为字符数组。
        for (char s1:s.toCharArray())
            letter[s1-'a']++;
        for (char t1:t.toCharArray())
            letter[t1-'a']--;
        for (int i = 0; i <s.length() ; i++) {
            if(letter[s.charAt(i)-'a']>0) return false;
        }

        return true;
    }

    public static void main(String args[]){
        isAnagramSolution isAn = new isAnagramSolution();
        String s = "aa";
        String t = "bb";
        System.out.println(isAn.isAnagram(s,t));
    }

}

