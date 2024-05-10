package ll;
import java.util.*;


class ListNode {
    int val; 
    ListNode next; 
    ListNode() {}
    ListNode(int val) {
        this.val = val; 
    }

    ListNode(int val, ListNode next) {
        this.val = val; 
        this.next = next; 
    }

}




public class Easy {
    private static void printLinkedList(ListNode head) {
        ListNode current = head;
        while(current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }


        System.out.print("null"); 
        System.out.println();
    }
    /*
    Strategy: Use two pointers to change relationships
    1 - Iterate from head to null 
    2 - Current ptr is head, prev ptr is null,  store next node in tmp variable.
    update pointers: next node is tmp , prev ptr  is current node
    3 - assign head = prev and return head;
    */ 


    private static void reverseLinkedListIterative(ListNode head) {
        if(head == null) return null;
        
        // Strategy
        ListNode current = head;
        ListNode prev = null;

        while(current != null) {
            ListNode tempNext = current.next; // do not break link! we need to assign current
            current.next = prev;
            prev = current;    
            current = tempNext; 
        }

        printLinkedList(prev);

    }


    private static void reverseLinkedListRecursively() {

    }
    public static void reverseLinkedList() {
        // create linked list 

        ListNode node1 = new ListNode(1); 
        ListNode node2 = new ListNode(2); 
        ListNode node3 = new ListNode(3); 
        ListNode node4 = new ListNode(4); 
        ListNode node5 = new ListNode(5); 



        node1.next = node2; 
        node2.next = node3; 
        node3.next = node4; 
        node4.next = node5; 

        printLinkedList(node1);

    
        reverseLinkedListIterative(node1);
    }


    private static void detectCycleLinkedList() {

    }



    private static void mergeTwoSortedLists() {

    }


}