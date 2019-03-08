package AlgBeauty.Array;

/**
 * Created by apple on 19/3/8.
 * desc：给定一个排序数组，你需要原地删除重复出现的元素，使得每个元素只出现一次，返回移除后的新长度
 * {1,1,3,4,4,5,5,7,7,7}
 * return 4
 * 题解思路：数组的原地插入等操作，常用方法是快慢指针法，慢指针维持插入位置，快指针寻找插入位置
 */

public class Solution1 {
    public int removeDupliArray(int[] array){
     if(array.length==0) return 0;
     int slow = 0;
     for(int fast = 0;fast<array.length;++fast){
         if(fast == array.length-1 || array[fast]!=array[fast+1]){ //快指针已经到达数组末尾，则要判断结束
             array[slow] = array[fast];
             ++slow;
         }
        }
     return slow; //slow为返回的新数组长度
    }

    public static void main(String args[]){
        Solution1 sol = new Solution1();
        int array[] = {1,1,3,4,4,5,5,7,7,7};
        int slow = sol.removeDupliArray(array);
        System.out.println(slow);

    }

}
