package com.test.array;

import java.util.*;

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

        //4.存在重复元素
//        int nums[] = {1, 2, 3, 1};
//        System.out.println(containsDuplicate(nums));

        //5.只出现一次的数字
//        int nums[] = {2, 1, 2};
//        System.out.println(singleNumber(nums));

        //两个数组交集
//        int nums1[] = {4,9,5};
//        int nums2[] = {9,4,9,8,4};
//        System.out.println(Arrays.toString(intersect(nums1,nums2)));

        //整数加一
//        int nums[] = {1, 2, 9};
//        System.out.println(Arrays.toString(plusOne(nums)));

        //移动0到最后 保持非0次序不变
//        int nums[] = {0, 1, 6, 3, 12, 0};
//        moveZeroes(nums);
//        System.out.println(Arrays.toString(nums));

        //两数之和(返回目标值下标)
        int nums[] = {2, 3, 3, 15};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
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
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static int singleNumber(int[] nums) {
//        1.
//        Arrays.sort(nums);
//        int len = nums.length;
//        for (int i = 0; i < len - 1; i++) {
//            if (nums[i] == nums[i + 1]) {
//                i++;
//            } else {
//                return nums[i];
//            }
//        }
//        return nums[len - 1];
        //2.
        int reduce = 0;
        for (int i : nums) {
            reduce ^= i;
        }
        return reduce;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else {
                i++;
            }
        }
        int[] res = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newDigit = new int[len + 1];
        newDigit[0] = 1;
        return newDigit;
    }

    public static void moveZeroes(int[] nums) {
//        int len = nums.length - 1;
//        for (int i = len; i >= 0; i--) {
//            if (nums[i] == 0) {
//                reverse(nums, i, len);
//                reverse(nums, i, len-1);
//            }
//        }

        //2.
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
//        for (int i = 0; i < len; i++) {
//            for (int j = i+1; j < len; j++){
//                if (nums[i] + nums[j] == target){
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return new int[]{-1, -1};
        //2.
//        int i = 0, j = 1;
//        while (nums[i] + nums[j] != target) {
//            if (j == len - 1) {
//                i++;
//                j = i;
//            }
//            j++;
//        }
//        return new int[]{i, j};

        //3.哈斯表 差值查找
        Map<Integer, Integer> map = new HashMap<>();
        int[] index = new int[2];
        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - nums[i])) {
                index[0] = map.get(target - nums[i]);
                index[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return index;
    }
}

