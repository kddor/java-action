package leetcode.string;

/**
 * Created by apple on 19/5/15.
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *s = "leetcode" 返回 0.
 *s = "loveleetcode", 返回 2.
 */

public class firstUniqChar {
    public int firstUniq(String s) {
        int[] letter=new int[26];//存储各字符出现次数
        //toCharArray() 方法将字符串转换为字符数组。
        for (char c:s.toCharArray())//第一次遍历
            letter[c-'a']++;
        for (int i = 0; i <s.length() ; i++) {//第二次遍历
            if(letter[s.charAt(i)-'a']==1) return i;
        }
        return -1;//无解
    }


    public static void main(String args[]){
        String x1 ="aadadaad";
        firstUniqChar firstu = new firstUniqChar();
        System.out.println(firstu.firstUniq(x1));

        String x2 ="loveleetcode";
        System.out.println(firstu.firstUniq(x2));




    }
}

