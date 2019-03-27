package edu.sctu.leetcode.test02;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> opOne = new Stack<>();
        Stack<Integer> opTwo = new Stack<>();

        ListNode head;

        head = l1;
        while (head != null) {

            opOne.push(head.val);
            head = head.next;
        }

        head = l2;
        while (head != null) {
            opTwo.push(head.val);
            head = head.next;
        }

        head = null;
        ListNode current = null;
        // 进位
        int carry = 0;
        while (!opOne.empty() && !opTwo.empty()) {

            int sum = opOne.pop() + opTwo.pop() + carry;

            if (sum >= 10) {
                carry = 1;
                sum -= 10;

            } else {
                carry = 0;
            }

            ListNode tmpNode = new ListNode(sum);
            tmpNode.next = null;

            if (head == null) {
                head = tmpNode;
                current = tmpNode;
            } else {

                current.next = tmpNode;
                current = tmpNode;
            }

        }

        while (!opOne.empty()) {

            int num = opOne.pop();

            ListNode tmpNode = new ListNode(num);
            tmpNode.next = null;

            if (carry == 1) {

                tmpNode.val += 1;
                carry = 0;
            }

            current.next = tmpNode;
            current = tmpNode;

        }

        while (!opTwo.empty()) {
            int num = opTwo.pop();

            ListNode tmpNode = new ListNode(num);
            tmpNode.next = null;

            if (carry == 1) {

                tmpNode.val += 1;
                carry = 0;
            }

            current.next = tmpNode;
            current = tmpNode;
        }

        if (carry == 1) {

            ListNode tmpNode = new ListNode(1);
            tmpNode.next = null;

            current.next = tmpNode;
            current = tmpNode;
        }


        return head;
    }

    public void print(ListNode head){

        while(head != null){
            System.out.print(String.format("%4d -> ", head.val));
            head = head.next;
        }

    }
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(8);
//        ListNode l12 = new ListNode(3);

        l1.next = l11;
        l11.next = null;
//        l12.next = null;

        ListNode l2 = new ListNode(0);
//        ListNode l21 = new ListNode(6);
//        ListNode l22 = new ListNode(4);

        l2.next = null;
//        l21.next = l22;
//        l22.next = null;

        Solution solution = new Solution();
        ListNode head = solution.addTwoNumbers(l1, l2);
        solution.print(head);
    }
}