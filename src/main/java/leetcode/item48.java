package leetcode;

/**
 * Created by apple on 19/4/5.
 * 给定一个 n × n 的二维矩阵表示一个图像。
 将图像顺时针旋转 90 度。
 */
public class item48 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len / 2; i++) {
            int start = i;
            int end = len - i - 1;
            for (int j = 0; j < end - start; j++) {
                int temp = matrix[start][start + j];
                matrix[start][start + j] = matrix[end - j][start];
                matrix[end - j][start] = matrix[end][end - j];
                matrix[end][end - j] = matrix[start + j][end];
                matrix[start + j][end] = temp;
            }
        }
    }

    public static void main(String args[]){
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        item48 rote = new item48();
        rote.rotate(a);
        for(int i=0;i<a.length;i++)
            for(int j=0;j<a.length;j++){
                System.out.println(a[i][j]);
            }
    }
}
