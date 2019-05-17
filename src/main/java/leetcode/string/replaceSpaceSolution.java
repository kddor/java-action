package leetcode.string;

/**
 * Created by apple on 2019/5/16.
 */
public class replaceSpaceSolution {
    public String replaceSpace1(StringBuffer str) {
        StringBuffer res = new StringBuffer();
        int len = str.length() - 1;
        for(int i = len; i >= 0; i--){
            if(str.charAt(i) == ' ')
                res.append("02%");
            else
                res.append(str.charAt(i));
        }
        return res.reverse().toString();
    }


    public String replaceSpace2(StringBuffer str) {
        /*
            思路一：return str.toString().replace(" ", "%20");
            思路二：计算字符串的空格数量，空出对应的位置依次插入'%''2''0'三个字符
        */
        char c[] = new char[str.length()];
        int count = 0;
        for(int i=0;i<c.length;i++) {
            c[i] = str.charAt(i);
            if(c[i]==' ') {
                count++;
            }
        }
        char chr[] = new char[c.length+count*2];
        for(int i = 0,j = 0;i<c.length&&j<chr.length;) {
            if(c[i]==' ') {
                chr[j++] = '%';
                chr[j++] = '2';
                chr[j++] = '0';
            }
            else {
                chr[j] = c[i];
                j++;
            }
            i++;
        }
        return String.valueOf(chr);
    }

    public static void main(String args[]) {
        StringBuffer x1 = new StringBuffer("we are happy ");
        replaceSpaceSolution rep = new replaceSpaceSolution();
        System.out.println(rep.replaceSpace1(x1));
    }
}
