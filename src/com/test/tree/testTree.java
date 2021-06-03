package com.test.tree;

import java.util.*;

public class testTree {
    public static void main(String[] args) {

    }

    //二叉树的最大深度
    //（DFS）
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> level = new Stack<>();
        int max = 0;
        stack.push(root);
        level.push(1);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            int temp = level.pop();
            max = Math.max(temp, max);
            if (cur.left != null) {
                stack.push(cur.left);
                level.push(temp + 1);
            }
            if (cur.right != null) {
                stack.push(cur.right);
                level.push(temp + 1);
            }
        }
        return max;
    }

    //递归
    public int maxDepth2(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    //BFS
    public int maxDepth3(TreeNode root) {
        if (root == null)
            return 0;
        //创建一个队列
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        int count = 0;
        while (!deque.isEmpty()) {
            //每一层的个数
            int size = deque.size();
            while (size-- > 0) {
                TreeNode cur = deque.pop();
                if (cur.left != null)
                    deque.addLast(cur.left);
                if (cur.right != null)
                    deque.addLast(cur.right);
            }
            count++;
        }
        return count;
    }


    //验证二叉搜索树
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null)
            return true;
        if ((root.val <= minVal) || root.val >= maxVal)
            return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }


    //给定一个二叉树，检查它是否是镜像对称的。
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetricTool(root.left, root.right);
    }

    public boolean isSymmetricTool(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null || left.val != right.val)
            return false;
        return isSymmetricTool(left.left,right.right)&&isSymmetricTool(left.right,right.left);
    }


    //二叉树的层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null)
            return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            //存每层的值
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }


    //给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
    public TreeNode sortedArrayToBST(int[] nums, int start, int end){
        if (start > end)
            return null;
        int mid = (start + end) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid-1);
        root.right = sortedArrayToBST(nums, mid+1, end);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
