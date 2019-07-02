package leetcode.string;

/**
 * Created by apple on 2019/6/29.
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 如果不存在公共前缀，返回空字符串 ""。

 示例 1:
 输入: ["flower","flow","flight"]
 输出: "fl"
 示例 2:
 输入: ["dog","racecar","car"]
 输出: ""
 解释: 输入不存在公共前缀。
 说明:
 所有输入只包含小写字母 a-z 。
 *
 */

public class LongestCommonPrefix {
    public static void main(String args[]){
        //String str[]= {"flower","flow","flight"};
        String str[]= {"aa","a"};
        String res= "";
        LongestCommonPrefix lst = new LongestCommonPrefix();
        res=lst.longestCommonPrefix(str);
        System.out.println(res);




    }

    public String longestCommonPrefix(String[] strs) {
        String res= "";
        int min =0;
        //如果数组为空，则返回空值
        if (strs.length ==0) return "";

        //获取数组中字符串长度最小的字符串，该字符串作为基础来对其他字符串进行遍历
        for(int k =0;k<strs.length;k++) {
            if (strs[k].length() < strs[min].length()) {
                min = k;
            }
        }
        System.out.println("数组中最小字符串的下标"+min);

        //找出其他字符串的公共部分
        for(int i= 0;i<strs[min].length();i++){
            for(int j=0;j<strs.length;j++){
                if(strs[min].charAt(i)==strs[j].charAt(i)){
                    if(j==strs.length-1) res+=strs[min].charAt(i);
                }
                else {
                    return res;
                }
            }
        }
        return res;
    }
}
