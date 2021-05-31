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

}
