package com.test.array;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        //1.删除排序数组中的重复项
//        int nums[] = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int len = removeDuplicates(nums);
//        for (int i = 0; i < len; i++) {
//            System.out.print(nums[i]);
//        }

        //2.买股票的最佳时机
//        int prices[] = {7,6,4,3,1};
//        System.out.println("Profit = " + maxProfit(prices));

        //3.旋转数组
//        int nums[] = {1, 2, 3, 4, 5, 6, 7}, k = 3;
//        rotate(nums, k);
//        System.out.println(Arrays.toString(nums));

    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[++p] = nums[q++];
            } else {
                q++;
            }
        }
        return p + 1;
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int index = 0, profit = 0, buy = 0, sell = 0;
        while (index != prices.length) {
            while (index != prices.length - 1 && prices[index] > prices[index + 1]) {
                index++;
            }
            buy = prices[index];
            while (index != prices.length - 1 && prices[index] < prices[index + 1]) {
                index++;
            }
            sell = prices[index];
            index++;
            profit = profit + (sell - buy);
        }
        return profit;
    }

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        //1.
//        int[] num1 = new int[len];
//        for (int i = 0; i < len; i++) {
//            num1[(i+k)%len] = nums[i];
//        }
//        System.arraycopy(num1,0,nums,0,len);
        //2.
        k %= len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, len - 1);
    }
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}

