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

    //插入排序
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

    //选择排序
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
