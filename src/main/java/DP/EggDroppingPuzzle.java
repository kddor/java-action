package DP;

/**
 * Created by apple on 18/2/24.
 */
public class EggDroppingPuzzle {
    /**
     *
     * @Title: eggDroppingRecursion
     * @Description: 递归方式求解问题
     * @param: n  鸡蛋数
     * @param: k  楼层数
     * @return:
     * @return: int
     * @throws: 上面的程序问题是复杂度太大O(2^k)。如果k=36的话，基本是跑不出结果。
     */
    public static int eggDroppingRecursion(int n, int k){
        //边界条件判断
        if(k == 1 || k == 0)
            return k;
        //如果只有一个鸡蛋，最坏的情况下是k次测试，一层层
        if(n == 1)
            return k;

        int min = 65535;
        int res;

        //考虑从第一层到第k层扔下鸡蛋的所有情况的最小结果
        for(int i = 1; i <= k; i++){
            //一种情况是碎了，那还剩下n-1个鸡蛋，i-1层楼
            //一种情况是没碎，那还剩下n个鸡蛋，k-i层楼
            res = Math.max(eggDroppingRecursion(n-1, i-1), eggDroppingRecursion(n, k-i));
            if(res < min)
                min = res;
        }
        return min+1;
    }
    //上面的程序问题是复杂度太大 O(2^k)。如果k=36的话，基本是跑不出结果。

    public static int eggDropping(int n, int k){
        //构建状态转移矩阵
        int[][] tc = new int[n+1][k+1];
        int res;

        //初始化状态转移矩阵
        for(int i = 0; i <= n; i++){
            tc[i][1] = 1;
            tc[i][0] = 0;
        }

        //只有一个鸡蛋时
        for(int j = 1; j <= k; j++){
            tc[1][j] = j;
        }

        //构建状态转移矩阵
        for(int i = 2; i <= n; i++){
            for(int j = 2; j <= k; j++){
                tc[i][j] = 65535; //默认值
                for(int x = 1; x <= j; x++){
                    res = 1 + Math.max(tc[i-1][x-1], tc[i][j-x]);
                    if(res < tc[i][j])
                        tc[i][j] = res;
                }
            }
        }
        return tc[n][k];
    }

    /**
     * @Title: main
     * @Description: 测试
     * @param args
     * @return void
     * @throws
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int n = 2;
        int k = 10;
        int m = 36;

        System.out.println("利用递归求解扔鸡蛋问题结果为：" + eggDroppingRecursion(n, k));
        System.out.println("利用动态规划求解扔鸡蛋问题结果为：" + eggDropping(n, k));
        System.out.println("利用动态规划求解扔鸡蛋问题结果为：" + eggDropping(n, m));

    }

}
