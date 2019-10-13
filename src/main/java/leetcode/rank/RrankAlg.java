package leetcode.rank;

import java.util.Arrays;

/**
 * Created by apple on 2019/10/10.
 */
public class RrankAlg {
    public static void sort(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1-i;j++){

            }
        }
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertSort(int arr[]){
        for(int i= 1;i<arr.length;i++){

            int value = arr[i]; //待插入的数据
            int j = 0;//每一次外循环，插入的位置的下标置为0
            for(j = i-1;j>=0;j--){
                if(arr[j] > value){
                    arr[j+1] = arr[j];//移动数据
                } else {
                    break;
                }
            }
            arr[j+1] = value; //插入数据
            System.out.println("第"+i+"层外循环："+Arrays.toString(arr));
        }

    }


    public static void mergeSort(int arr[]){
        int[] temparr = new int[arr.length];
        sortfun(arr,temparr,0,arr.length-1);
    }
    private static void sortfun(int[] arr,int[] temparr,int startIndex,int endIndex){
        if (endIndex <= startIndex){
            return;
        }
        int midIndex = startIndex + (endIndex-startIndex)/2;
        //分解
        sortfun(arr,temparr,startIndex,midIndex);
        sortfun(arr,temparr,midIndex+1,endIndex);
        //归并
        mergefun(arr,temparr,startIndex,midIndex,endIndex);
    }

    private static void mergefun(int[] arr,int[] temparr,int startIndex,int midIndex,int endIndex){
        //复制要合并的数据
        for (int s = startIndex; s <= endIndex; s++) {
            temparr[s] = arr[s];
        }

        int left = startIndex;//左边首位下标
        int right = midIndex + 1;//右边首位下标
        for (int k = startIndex; k <= endIndex; k++) {
            if(left > midIndex){
                //如果左边的首位下标大于中部下标，证明左边的数据已经排完了。
                arr[k] = temparr[right++];
            } else if (right > endIndex){
                //如果右边的首位下标大于了数组长度，证明右边的数据已经排完了。
                arr[k] = temparr[left++];
            } else if (temparr[right] < temparr[left]){
                arr[k] = temparr[right++];//将右边的首位排入，然后右边的下标指针+1。
            } else {
                arr[k] = temparr[left++];//将左边的首位排入，然后左边的下标指针+1。
            }
        }
    }


    public static void main(String args[]){
        int arr[] = {8,2,5,9,7};
        System.out.println("排序前"+ Arrays.toString(arr));
        insertSort(arr);
        System.out.println("排序后"+ Arrays.toString(arr));

    }

}
