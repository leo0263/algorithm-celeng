// ref: https://leetcode.com/problems/add-two-numbers/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode last = null;
        int carryOver = 0;
        int l1Num, l2Num = 0;

        while ((l1 != null) || (l2 != null)) {
            if (l1 != null ) {
                l1Num = l1.val;
                l1 = l1.next;
            } else l1Num = 0;

            if (l2 != null ) {
                l2Num = l2.val;
                l2 = l2.next;
            } else l2Num = 0;

            int total = l1Num + l2Num + carryOver;
            if (total >= 10) carryOver = 1;
            else carryOver = 0;

            ListNode newNode = new ListNode(total % 10);
            if (head == null) {
                head = newNode;
                last = newNode;
            } else {
                last.next = newNode;
                last = newNode;
            }
        }

        if (carryOver == 1) {
            ListNode newNode = new ListNode(1);
            last.next = newNode;
            last = newNode;
        } 

        return head;
    }
} 
// time: O(1)  space:O(n)
// Runtime 1ms Beats 100.00% of users with Java
// Memory 44.25MB Beats 61.09% of users with Java



/**
  [2,4,9]
  [5,6,4,9]
  [7,0,4,0,1]

  [2,4,3]
  [5,6,4]
  [7,0,8]

  [9,9,9,9,9,9,9]
  [9,9,9,9]
  [8,9,9,9,0,0,0,1]
*/