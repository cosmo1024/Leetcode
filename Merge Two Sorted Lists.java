/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode cur_merged = null;
        ListNode cur_l1 = l1;
        ListNode cur_l2 = l2;
        
        //To deal with situtaion where any of the linked list is null
        if(l1==null && l2==null) return head;
        else if(l1 == null) return l2;
        else if(l2 == null) return l1;
        
        if(l1.val < l2.val){
            head = l1;
            cur_merged = head;
            cur_l1 = l1.next;
        }
        else{
            head = l2;
            cur_merged = head;
            cur_l2 = l2.next;
        }
        
        while(cur_l1!=null && cur_l2!=null){
            if(cur_l1.val < cur_l2.val ){
                cur_merged.next = cur_l1;
                cur_merged = cur_l1;
                cur_l1 = cur_l1.next;
            }
            else{
                cur_merged.next = cur_l2;
                cur_merged = cur_l2;
                cur_l2 = cur_l2.next;
            }
        }
        
        if(cur_l1 != null){
            cur_merged.next = cur_l1;
        }
        else if(cur_l2 != null){
            cur_merged.next = cur_l2;
        }
        
        return head;
    }
}