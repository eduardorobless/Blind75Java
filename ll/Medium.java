package ll; 
import java.util.*;


public class Medium {


    /*
    Remove Nth Node from end of the list
    Strategy: 

        1-Keep a dummy node to point the head of a linked list 
        2-point two pointers at dummy
        3-Move second pointer n spaces
        4-itearte first and second pointer till next of second pointer is null 
        5-move next of first pointer
        6-return dummy next


        Time Complexity O(N)
        Space Complexity O(1)
    */


    private static ListNode removeNthNodeFromEndOfTheListHelper(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode ptr1 = dummy; 
        ListNode ptr2 = dummy; 

        for(int i = 0 ; i < n; i++) {
            ptr2 = ptr2.next;
        }


        while(ptr2.next != null) {
            ptr1 = ptr1.next; 
            ptr2 = ptr2.next;
        }

        ptr1.next = ptr1.next.next; // deleting nth node

        return dummy.next; 
    }   

    public static void removeNthNodeFromEndOfList() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2); 
        ListNode l3 = new ListNode(3); 
        ListNode l4 = new ListNode(4); 
        ListNode l5 = new ListNode(5); 



        l1.next = l2; 
        l2.next = l3; 
        l3.next = l4; 
        l4.next = l5;
        ListNode.printLinkedList(removeNthNodeFromEndOfTheListHelper(l1, 2));
        

    }


    private static void reorderList() {
        
    }
    

}