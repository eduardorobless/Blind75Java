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

    


    /** 
     * Reorder list
     * 
     * Strategy: 
     * 
     * 1 - Find middle element in linked list
     * 2 - Order after middle element  
     * 3 - rejoin all elements
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    private static ListNode middle(ListNode head) {
        ListNode p1 = head; 
        ListNode p2 = head;

        while(p2.next != null && p2.next.next != null) {
            p1 = p1.next; 
            p2 = p2.next.next;
        }


        return p1;

    }

    private static void reverseHalfMiddle(ListNode middle) {
        ListNode preCurrent = middle.next;
        while(preCurrent.next != null) {
            ListNode current = preCurrent.next; 
            preCurrent.next = current.next;
            current.next = middle.next;
            middle.next =  current;
        }
        
    } 


    private static ListNode reorder(ListNode head, ListNode middle) {
        ListNode p1 = head; 
        ListNode p2 = middle.next; 
        while(p1 != middle) {
            middle.next = p2.next; 
            p2.next = p1.next; 
            p1.next = p2; 
            p1 = p2.next; 
            p2 = middle.next;
        }


        return head;
    }   

    private static void reorderListHelper(ListNode head) {
        if(head.next  == null || head == null) 
            return;
        
        ListNode middle = middle(head);       
        reverseHalfMiddle(middle);
        head = reorder(head, middle);

        ListNode.printLinkedList(head);

    }


    public static void reorderList() {
        ListNode l1 = new ListNode(4); 
        ListNode l2 = new ListNode(8); 
        ListNode l3 = new ListNode(15); 
        ListNode l4 = new ListNode(16); 
        ListNode l5 = new ListNode(23); 

        l1.next = l2; 
        l2.next = l3; 
        l3.next = l4; 
        l4.next = l5; 
    
        reorderListHelper(l1);
    }


    



    

}