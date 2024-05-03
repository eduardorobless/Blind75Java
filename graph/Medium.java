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
     * 
     * 
     * 
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
     * 
     * Time Complexity:

        Building the Graph: O(V + E)
        Cloning the Graph (DFS): O(V + E)
        Traversing Nodes (DFS): O(V + E)
        Space Complexity:

        Building the Graph: O(V + E)
        Cloning the Graph (DFS): O(V + E)
        Traversing Nodes (DFS): O(V)
        Overall Complexity:

        Time Complexity: O(V + E)
        Space Complexity: O(V + E)


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

    /**
     *  Leetcode 207 - Course Schedule 
     * 
     *  Proposal
     * 
     *      To determine if we can finish all courses you need to determine if we have a cycle in our graph,
     *      in that case we can affirme that is impossible to finish all courses, otherwise we affirme that, 
     *      we can finish all the courses.
     *      
     *      How to determine if we have cycle in a directed graph? 
     * 
     *      Lets first answer the following questions.
     *          What is a cycle in a graph? 
     *          
     *              A cycle in a graph is a sequence of vertices and eges that starts and ends at the same vertex. 
     *              In other words, it's a closed path where you can traverse from a vertex back to itself by 
     *              following a series of edges without visiting any vertex more than once (except for the starting
     *              and ending vertex).
     * 
     *          What is a cycle in a directed graph?
     *              
     *              In a directed graph a cycle is similar but must follow the direction of the edges. So, in a directed
     *              graph, a cycle is a sequence of vertices and directed edges that forms a closed loop, starting and 
     *              ending at the same vertex.
     * 
     *       Having clear what is a cycle in a directed graph, we can develop an algorithm for it. 
     *      
     *         
     *      Algorithm to determine cycles in a directed graph
     *      
     *          We will perform a DFS over the graph while mantaininng 2 boolean arrays "visited" and "explored". We will
     *          mark a vertex "visited" when we visit it and we will mark it "explored" once all of its neighbouring vertex
     *          are explored. In case we visit any vertex which is already visited before (i.e, visited is "true") and it is
     *          still not explored yet(i.e. explored is "false"), then in that case we can sayt that we have found one more 
     * |        path to this vertex and thus we  have found one cycle.
     */     





    private static boolean isCyclic(int i, List<Integer>[] adj, boolean[] visited, boolean[] explored) {
        // mark node as visited 
        visited[i] = true; 
        // explore all neigbors relationships to determine if a cycle exists
        for(Integer j : adj[i]) {
            
            if(!visited[j]) {
                if(isCyclic(j, adj, visited, explored)) {
                    return true;
                }
            }

            else if (!explored[j]) {
                    return true; 
                }

            }
        


        explored[i] = true;
        return false; 
    }
    public static boolean courseSchedule(int numCourses, int[][] prerequisites) {
            List<Integer>[] adj; 
            boolean[] visited; 
            boolean[] explored; 

            
            // allocating space for the adjacency list
            adj = new ArrayList[numCourses];
            for(int i = 0; i < numCourses; i++) {
                // allocating space for each individual list
                adj[i] = new ArrayList<>(); 
            }


            // intializing boolean arrays to keep track of visited and explored vertices
            visited = new boolean[numCourses]; 
            explored = new boolean[numCourses];

            // adding graph relationships based on dependecies array 
            for(int i = 0; i < prerequisites.length; i++) {
                adj[prerequisites[i][0]].add(prerequisites[i][1]);
            }

            // traverse all node relationships
            for(int i = 0; i < numCourses; i++) {
                if(isCyclic(i, adj, visited, explored)) 
                    return false; 
            }


            return true;
    }
    public static boolean courseScheduleSetup()  {
        // int[][] arr = new int[2][2];
        // arr[0][0] = 1; 
        // arr[0][1] = 0;
        // arr[1][0] = 0; 
        // arr[1][1] = 1;


        int[][] arr = new int[1][2]; 
        arr[0][0] = 1; 
        arr[0][1] = 0;




        // Represent graph using adjacency list because it gives us flexibilty in case we have a sparse graph
        return courseSchedule(2, arr);      
    }
}