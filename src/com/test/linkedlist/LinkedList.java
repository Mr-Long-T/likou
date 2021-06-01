package com.test.linkedlist;

import java.util.Stack;

public class LinkedList {
    public static void main(String[] args) {

    }

    //删除链表中的节点
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    //删除链表的倒数第N个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int length = 0;
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        if(n>length)
            return null;
        if(length - n == 0)
            return head.next;
        ListNode temp2 = head;
        for(int i = 0; i < (length - n -1); i++){
            temp2 = temp2.next;
        }
        temp2.next = temp2.next.next;
        return head;
    }

    //反转单链表
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        Stack<ListNode> stack = new Stack<>();
        while(head!=null){
            stack.push(head);
            head = head.next;
        }
        ListNode temp = stack.pop();
        ListNode Head = temp;
        while(!stack.isEmpty()){
            ListNode tp =  stack.pop();
            temp.next = tp;
            temp = tp;
        }
        temp.next = null;
        return Head;

    }

    //合并两个有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }
        ListNode newNode = new ListNode(0);
        ListNode temp = newNode;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null? l2:l1;
        return newNode.next;
    }

    // 回文链表
    public boolean isPalindrome(ListNode head) {
        ListNode tp = head;
        Stack<ListNode> stack = new Stack<>();
        while(tp!=null){
            stack.push(tp);
            tp = tp.next;
        }
        while(head!=null){
            if(head!=stack.pop())
                return false;
            head = head.next;
        }
        return true;
    }

    //给定一个链表，判断链表中是否有环。
    public boolean hasCycle(ListNode head) {
        //慢指针，慢指针针每次走一步，快指针每次走两步，如果相遇就说明有环，如果有一个为空说明没有环。
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast)
                return true;
        }
        return false;
    }
}
