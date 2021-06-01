package com.test.sort;

import java.util.Arrays;

public class testSort {
    public static void main(String[] args) {
        int nums1[] = {1,2,3,0,0,0},  nums2[] = {2,5,6};
        int m = 3, n = 3;
        merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        for (int i = 0; i < n; i++) {
//            nums1[m + i] = nums2[i];
//        }
//        Arrays.sort(nums1);
        int newNum[] = new int[m+n];
        int index = 0;
        int i = 0, j = 0;
        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
                newNum[index++] = nums1[i++];
            }else{
                newNum[index++] = nums2[j++];
            }
        }
        for(;i < m; i++){
            newNum[index++] = nums1[i];
        }
        for(;j < n; j++){
            newNum[index++] = nums2[j];
        }
        for (int k = 0; k < m + n; k++) {
            nums1[k] = newNum[k];
        }
    }

}
