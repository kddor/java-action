package Action.FourthArray;

/**
 * Created by apple on 19/1/26.
 */

public class ArrayDemo2 {
    public static void main(String[] args) {
        int score[] = null;
        score = new int[3];
        for (int x = 0; x < 3; x++) {
            score[x] = x * 2 + 1;
        }
        for (int x = 0; x < 3; x++) {
            System.out.println("score[" + x + "] = " + score[x]);
        }

        //数组初始化
        int score_b[] = {91, 92, 93, 94, 95, 96};
        System.out.println("println score_b");
        for (int x = 0; x < score_b.length; x++) {
            System.out.println("score_b[" + x + "]=" + score_b[x]);
        }

        //二维数据组
        int score_two[][] = new int[4][3];
        score_two[0][1] = 30;
        score_two[2][1] = 10;
        score_two[3][1] = 25;
        for (int i = 0; i < score_two.length; i++) {
            for (int j = 0; j < score_two[i].length; j++) {
                System.out.println(score_two[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    //可变参数
    public static void fun(int... arg) {
        for (int i = 0; i < arg.length; i++) {
            System.out.println(arg[i] + "、");
        }
    }
}





