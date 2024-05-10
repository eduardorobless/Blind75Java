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
    2 - use two pointers current and prev. current points to head,  previous to null initially, iterate until current is null
    return prev as the new head
    3 - in each iteartion: 
        store next in temp: temp = current.next
        assign current to previous:  prev =  current  
        update next value: current.next 
    
    Time complexity: 
    O(N)
    Space complexity: 
    O(1)
    */ 


    private static ListNode reverseLinkedListIterative(ListNode head) {
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

        
        return prev;
    }

    /*
    Recursive approach is almost identical except in space complexity. 
    Time Complexity: O(N)
    Space Complexity: O(N)
    */ 


    
    private static  ListNode reverseLinkedListRecursively(ListNode cur, ListNode prev) {
        //base case if cur is null return prev

        if(cur == null) return prev;
        else{
            ListNode tempNext = cur.next; 
            cur.next = prev;
            return reverseLinkedListRecursively(tempNext, cur); 
        }

        
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

    
        // ListNode head = reverseLinkedListIterative(node1);
        // printLinkedList(head);
        
        ListNode head1 = reverseLinkedListRecursively(node1, null);
        printLinkedList(head1);
    }


    private static void detectCycleLinkedList() {

    }



    private static void mergeTwoSortedLists() {

    }


}