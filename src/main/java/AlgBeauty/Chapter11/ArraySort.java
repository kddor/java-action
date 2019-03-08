package AlgBeauty.Chapter11;

/**
 * Created by apple on 19/3/1.
 */

import java.util.*;
public class ArraySort {

    //冒泡排序
    public void bubbleSort(int[]a){
        int n =  a.length;
        if(n == 1) return;

        for(int i=0;i<n;++i){
            boolean flag = false;
            for (int j=0;j<n-i-1;++j){
                if(a[j]>a[j+1]){
                    int tmp =a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;
                }
            }
            if(!flag) break;
        }
    }

    /**
     * 插入排序
     * 每一步将一个待排序的记录，按其关键码值的大小插入前面已经排序的文件中适当位置，直到全部插入完为止
     * @param a
     */
    public void insertionSort(int[]a){
        int n = a.length;
        if(n <=1) return;

        for(int i=1;i<n;++i){
            int value = a[i];
            int j = i - 1;
         //查找插入的位置
         for(; j>=0;--j){
             if(a[j]>value){
                 a[j+1] = a[j]; //数据移动
             }
             else {
                 break;
             }
         }

         a[j+1] = value; //插入数据

        }
    }

    /**
     * 选择排序：每一趟从待排序的记录中选取最小的元素，顺序放在已排序的序列最后，直到全部记录排序完毕
     * 给定数组a,第1趟排序，在待排序数据a[1]~a[n]中选取最小的数据，将它与a[1]交换，第2趟，在待排序数据
     * a[2]~a[n]中选择最小的数据，将它与a[2]交换....直到全部排序完成
     * @param a
     */
    public void selectSort(int[] a){
       for(int i = 0;i<a.length-1;i++){
           int k = i;
           for(int j = k+1;j<a.length;j++){//选取最小的记录
               if(a[j]<a[k]){
                   k = j;
               }
           }
           if(i !=k){
               int temp = a[i];
               a[i] = a[k];
               a[k] = temp;
           }
       }
    }

    public static void main(String args[]){

        int[] array = {1,6,2,3,4};
        ArraySort arraysort  = new  ArraySort();
        System.out.println("排序前"+Arrays.toString(array));

        arraysort.bubbleSort(array);
        System.out.println("冒泡排序后"+Arrays.toString(array));

        arraysort.insertionSort(array);
        System.out.println("插入排序后"+Arrays.toString(array));

        arraysort.selectSort(array);
        System.out.println("选择排序后"+Arrays.toString(array));

    }
}
