package com.test.dProgram;

public class testDynamic {
    public static void main(String[] args) {

    }


    //假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    //每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    public int climbStairs(int n) {
        return Fibonacci(n, 1, 1);
    }

    public static int Fibonacci(int n, int a, int b) {
        if (n <= 1)
            return b;
        return Fibonacci(n - 1, b, a + b);
    }

    //买卖股票的最佳时机（一次买入卖出）
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int maxPro = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            maxPro = Math.max(prices[i] - min, maxPro);
        }
        return maxPro;
    }

    //最大子序和
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            //    if(dp[i-1]>0){
            //        dp[i] = dp[i-1] + nums[i];
            //   }else{
            //        dp[i] = nums[i];
            //    }
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    //你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

    public int rob(int[] nums) {
        int len =  nums.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i = 1; i<len; i++){
            dp[i][0] = Math.max(dp[i-1][0] , dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[len-1][0], dp[len-1][1]);
    }

}
