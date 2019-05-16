package leetcode.string;

/**
 * Created by apple on 19/5/15.
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 输入: 123   输出: 321
 * 输入: -123  输出: -321
 * 输入: 120   输出: 21
 * desc: https://leetcode-cn.com/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode/
 */
public class reverseNum {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String args[]){
        int x =123;
        reverseNum resnum = new reverseNum();
        System.out.println(resnum.reverse(x));
    }
}
