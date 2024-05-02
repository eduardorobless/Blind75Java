package graph;
import java.util.*;
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class Medium {
    /**       Clone graph 
     *  Proposal 
     * 
     * To clone a graph you can either use DFS OR BFS. We use DFS for simplicity. 
     *  Edge cases: 
     * 
     * If first node is null there is nothing to copy, return null ASAP.
     * 
     *  Strategy 
     *
     * Keep a hash to store memory of new created nodes instead of a boolean visited value as 
     * you will need it to adding new edges between new nodes
     * 
     * 1 - Use a hashtable data structure to store visited nodes and use it in a new 
     * helper function wich is gonna be used to make recursive calls to copy all nodes (DFS).
     * 2 - Create new node based on the first original node. (Original node -> New node)
     * 3 - Add new node to map.
     * 4 - Iterate original first node neighbours and check if the nodes are cloned (are in the map). 
     * If they are in the map, then add it to the current node's neighbours relationship. Otherwise 
     * crete node recursively and add it to the map
     * 5 - Return new first node
     */
    private static Node cloneUtil(Node node, HashMap<Node, Node> map) {
        // 2
        Node newNode = new Node(node.val);

        // 3 
        map.put(node, newNode); 

        // 4
        for(Node neighbor: node.neighbors) {
            //  not cloned
            if(!map.containsKey(neighbor)) {
                // clone it 
                newNode.neighbors.add(cloneUtil(neighbor, map));
            } else {
                // get it from the map
                newNode.neighbors.add(map.get(neighbor)); 
            }
        }



        return newNode;
    }

    /* from an adjacecncy list get a list of nodes with its relationships*/
    private static List<Node> buildGraph(List<List<Integer>> adjacencyList) {
        List<Node> graph = new ArrayList<>(); 

        // Create nodes 

        for(int i = 0; i < adjacencyList.size(); i++) {
            graph.add(new Node(i+1)); 
        }

        // connect neighbors 
        for(int i = 0; i < adjacencyList.size(); i++) {
            List<Integer> neighbors = adjacencyList.get(i); 
            Node node = graph.get(i); 
            for(int neighborVal : neighbors) {
                node.neighbors.add(graph.get(neighborVal - 1));
            }
        }

        return graph; 

    }

    private static void printGraph(List<Node> graph) {
        for (Node node: graph) {
            System.out.print(node.val + " -> "); 
            for(Node neighbor : node.neighbors) {
                System.out.print(neighbor.val + " ") ; 
            }
            System.out.println();
        }
    }



    private static Node cloneGraph(Node node) {
        if (node == null)
            return null;  
         

         HashMap<Node, Node> map = new HashMap<>(); 

         return cloneUtil(node, map);

    }

    private static void traverseNodes(Node node, Set<Node> visited) {
        if (node == null || visited.contains(node))  return; 

        visited.add(node);
        System.out.print(node.val + " -> "); 

        for(Node neighbor : node.neighbors) {            
            System.out.print(neighbor.val + " ");
        } 
        System.out.println(); 


        for(Node neighbor : node.neighbors) {
            traverseNodes(neighbor, visited);
        }
        
    }



    public static void cloneGraphSetup() {
       System.out.println("Cloning graph");
        //if(node == null) return null; 
        // Create adjacency List 

        List<List<Integer>> adjacencyList = new ArrayList<>(); 
        adjacencyList.add(Arrays.asList(2, 4)); 
        adjacencyList.add(Arrays.asList(1, 3)); 
        adjacencyList.add(Arrays.asList(2, 4)); 
        adjacencyList.add(Arrays.asList(1, 3)); 


        // Convert the graph represented as an adjacency list to a graph of nodes 
        List<Node> graph  = buildGraph(adjacencyList); 

        // print graph
        printGraph(graph);

        // cloning grpah

        Node clonedGraph  = cloneGraph(graph.get(0));

        traverseNodes(clonedGraph, new HashSet<>() );



    }

}