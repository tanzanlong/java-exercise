package com.tan.leetcode;

public class TwoNunberSum {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int bitCount = 0;
        ListNode currentOne;
        ListNode currentTwo;
        ListNode sumNode = null;
        ListNode firtNode = null;

        // / System.out.println();
        System.out.println(l1.next == null && l2.next == null);
        ListNode currentNode = null;
        for (currentOne = l1, currentTwo = l2;;) {
            // l1=l1.next,l2=l2.next
            int sum = 0;
            if (currentOne != null) {
                sum += currentOne.val;
            }
            if (currentTwo != null) {
                sum += currentTwo.val;
            }
            sum += bitCount;
            int val = sum % 10;
            bitCount = sum / 10;
            currentNode = new ListNode(val);
            if (sumNode == null) {
                firtNode = currentNode;
            } else {
                sumNode.next = currentNode;
            }
            sumNode = currentNode;
            
            if(currentOne != null){
                currentOne = currentOne.next;
            }
            if(currentTwo != null){
                currentTwo = currentTwo.next;
            }
          
            
            if (currentOne == null && currentTwo == null) {
                if (bitCount != 0) {
                    currentNode = new ListNode(bitCount);
                    sumNode.next = currentNode;
                }
                break;
            }
        }

        return firtNode;

    }


    /**
     * Definition for singly-linked list.
     * */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }


    }


    public static void main(String[] args) {
        // System.out.println(13%10);
/*        ListNode A11 = new ListNode(2);
        ListNode A12 = new ListNode(4);
        ListNode A13 = new ListNode(3);
        A11.next = A12;
        A12.next = A13;
        A13.next = null;


        ListNode B11 = new ListNode(5);
        ListNode B12 = new ListNode(6);
        ListNode B13 = new ListNode(4);
        B11.next = B12;
        B12.next = B13;
        B13.next = null;*/
        ListNode A12 = new ListNode(1);
        ListNode A13 = new ListNode(8);
        A12.next = A13;
        
        ListNode B13 = new ListNode(0);

        TwoNunberSum twoNunberSum = new TwoNunberSum();
        ListNode sum = twoNunberSum.addTwoNumbers(A12, B13);
        while (sum != null) {
            System.out.println(sum.val);
            sum = sum.next;
        }

    }
}
