package leetcode;


import java.util.Arrays;


/**
 * Created by apple on 19/3/30.
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 输出: [5,6,7,1,2,3,4]
 解释:
 向右旋转 1 步: [7,1,2,3,4,5,6]
 向右旋转 2 步: [6,7,1,2,3,4,5]
 向右旋转 3 步: [5,6,7,1,2,3,4]
 */
public class item189 {
        /**
         * 双重循环
         * 时间复杂度：O(kn)
         * 空间复杂度：O(1)
         */
        public void rotate_1(int[] nums, int k) {
            int n = nums.length;
            k %= n;
            for (int i = 0; i < k; i++) {
                int temp = nums[n - 1];    //获取末尾的值
                for (int j = n - 1; j > 0; j--) {
                    nums[j] = nums[j - 1]; //往后移动一位
                }
                nums[0] = temp;  //将末尾的值赋给开头
            }
        }

        /**
         * 翻转
         * 时间复杂度：O(n)
         * 空间复杂度：O(1)
         */
        public void rotate_2(int[] nums, int k) {
            int n = nums.length;
            k %= n;
            reverse(nums, 0, n - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, n - 1);
        }

        private void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start++] = nums[end];
                nums[end--] = temp;
            }
        }

        /**
         * 循环交换
         * 时间复杂度：O(n)
         * 空间复杂度：O(1)
         */
        public void rotate_3(int[] nums, int k) {
            int n = nums.length;
            k %= n;
            // 第一次交换完毕后，前 k 位数字位置正确，后 n-k 位数字中最后 k 位数字顺序错误，继续交换
            for (int start = 0; start < nums.length && k != 0; n -= k, start += k, k %= n) {
                for (int i = 0; i < k; i++) {
                    swap(nums, start + i, nums.length - k + i);
                }
            }
        }

        /**
         * 递归交换
         * 时间复杂度：O(n)
         * 空间复杂度：O(n/k)
         */
        public void rotate(int[] nums, int k) {
            // 原理同上
            recursiveSwap(nums, k, 0, nums.length);
        }

        private void recursiveSwap(int[] nums, int k, int start, int length) {
            k %= length;
            if (k != 0) {
                for (int i = 0; i < k; i++) {
                    swap(nums, start + i, nums.length - k + i);
                }
                recursiveSwap(nums, k, start + k, length - k);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }



        public static void main(String args[]){
            int nums[] ={1,2,3,4,5,6,7};
            int k =3;
            System.out.println(Arrays.toString(nums));
            item189 rotate = new item189();
            rotate.rotate_2(nums,k);
            System.out.println(Arrays.toString(nums));
        }
}
