package AlgBeauty.Rank;

import java.util.Arrays;

/**
 * Created by kddor on 2019/6/7.
 * 各种排序算法
 */
public class rankAlg {
    /**
     * 冒泡排序
     * @param a
     * 原地排序算法，稳定的排序算法，最好情况O(n)，最差情况O(n的平方）
     */
    public void buble_sort(int[] a){
        if(a.length == 0){
            return;
        }
        for(int i =0;i<a.length;i++){
            boolean flag = false; //提前退出冒泡循环的标志位
            for(int j=0;j<a.length-i-1;++j){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true; //表示有数据交换
                }
            }
            if(!flag) break; //没有数据交换，提前退出
        }
    }

    /**
     * 插入排序
     * @param a
     */
    public void InsertSort(int[] a)
    {
        int i, j;
        int n = a.length;
        int target;

        //假定第一个元素被放到了正确的位置上
        //这样，仅需遍历1 - n-1
        for (i = 1; i < n; i++)
        {
            j = i;
            target = a[i];

            while (j > 0 && target < a[j - 1])
            {
                a[j] = a[j - 1];
                j--;
            }

            a[j] = target;
        }
    }

    /**
     * 两路归并算法
     * @param a
     * @param left
     * @param mid
     * @param right
     */
    //两路归并算法，两个排好序的子序列合并为一个子序列
    public void merge(int []a,int left,int mid,int right){
        int []tmp=new int[a.length];//辅助数组
        int p1=left,p2=mid+1,k=left;//p1、p2是检测指针，k是存放指针

        while(p1<=mid && p2<=right){
            if(a[p1]<=a[p2])
                tmp[k++]=a[p1++];
            else
                tmp[k++]=a[p2++];
        }

        while(p1<=mid) tmp[k++]=a[p1++];//如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        while(p2<=right) tmp[k++]=a[p2++];//同上

        //复制回原素组
        for (int i = left; i <=right; i++)
            a[i]=tmp[i];
    }

    /**
     * 归并排序
     * @param a
     * @param start
     * @param end
     */
    public void mergeSort(int [] a,int start,int end){
        if(start<end){//当子序列中只有一个元素时结束递归
            int mid=(start+end)/2;//划分子序列
            mergeSort(a, start, mid);//对左侧子序列进行递归排序
            mergeSort(a, mid+1, end);//对右侧子序列进行递归排序
            merge(a, start, mid, end);//合并
        }
    }
    /**
     * 快速排序（递归）
     *
     * ①. 从数列中挑出一个元素，称为"基准"（pivot）。
     * ②. 重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任一边）。在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
     * ③. 递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * @param arr   待排序数组
     * @param low   左边界
     * @param high  右边界
    */

    public static void quickSort(int[] arr, int low, int high){
        if(arr.length <= 0) return;
        if(low >= high) return;
        int left = low;
        int right = high;

        int temp = arr[left];   //挖坑1：保存基准的值
        while (left < right){
            while(left < right && arr[right] >= temp){  //坑2：从后向前找到比基准小的元素，插入到基准位置坑1中
                right--;
            }
            arr[left] = arr[right];
            while(left < right && arr[left] <= temp){   //坑3：从前往后找到比基准大的元素，放到刚才挖的坑2中
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;   //基准值填补到坑3中，准备分治递归快排
        System.out.println("Sorting: " + Arrays.toString(arr));
        quickSort(arr, low, left-1);
        quickSort(arr, left+1, high);
    }

    public static void main(String args[]){
        int[] data = {1,3,5,7,2,4};
        System.out.println("原始数据排序前："+Arrays.toString(data));
        rankAlg rank = new rankAlg();
//        rank.buble_sort(data);
//        System.out.println("冒泡排序："+Arrays.toString(data));
//        rank.InsertSort(data);
//        System.out.println("插入排序："+Arrays.toString(data));
//        rank.mergeSort(data,0, data.length-1);
//        System.out.println("归并排序："+Arrays.toString(data));
        rank.quickSort(data,0, data.length-1);
        System.out.println("快速排序："+Arrays.toString(data));
    }
}
