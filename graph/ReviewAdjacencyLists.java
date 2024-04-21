package graph;

import java.util.*;
/* An adejacency list is a list/arraylist of linkedlist: 
Each node gets a linked list and is added at the head. 
Connectitvy to other node happens at the tail of that arraylist
*/
/* Time complexity: O(V)
Space complexity: O(V + E) */
class Node {
    char data; 

    Node(char data) {
        this.data = data;
    }
}

class Graph {
    ArrayList<LinkedList<Node>> alist; 
     
     Graph(){
        alist = new ArrayList<>();
     }


     void addNode(Node node){
        // create new linked list
        LinkedList<Node> currentList = new LinkedList<>();
        // add node that head of said linked list 
        currentList.add(node);
        // add linked list to arraylist 
        alist.add(currentList); 
     }


     void addEdge(int src, int dest) {
        // get linked list from arrraylist where source node is located at 
        LinkedList<Node> currentList = alist.get(src);
        // get node from linked list inside arraylist where destination node is located at
        Node destNode = alist.get(dest).get(0); 
        // point destination node to source node linked list
        currentList.add(destNode);


     }

     boolean checkNode(int src, int dest) {
        // get linked list from arraylist where src node is located at 
        LinkedList<Node> currentList = alist.get(src);
        // get node from linked list inside arraylist where dest node is located at
        Node destNode = alist.get(dest).get(0); 
        // iterate nodes in current list to check if they match dest node address 
        for(Node node: currentList) { 
            if (node == destNode) {
                return true;
            }
        }

        return false;          
     }


    // nested foor lop
     void print(){
            // itearate all linkedlist in array list 
            for(LinkedList<Node> myList: alist) {
                // itearte all nodes inside each linked list 
                for(Node node: myList) {
                    // add arrow for formatting 
                    System.out.print(node.data + "->");
                }   

                // add new line 
                System.out.println(); 
            }
     }
}


public class ReviewAdjacencyLists {
    public static void main(String []args) {  
        Graph graph = new Graph();
        graph.addNode(new Node('A')); 
        graph.addNode(new Node('B'));
        graph.addNode(new Node('C'));
        graph.addNode(new Node('D'));
        graph.addNode(new Node('E'));



        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(4,0);
        graph.addEdge(4,2);

        graph.print();        
    }
}