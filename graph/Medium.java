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

/* Time and space complexity: 
        
Time complexity: O(LOGN)


Space complexity: O(N)

*/ 
class UnionFind {
    private int[] parent; 
    private int[] rank; 


    public UnionFind(int n) {
        parent = new int[n]; 
        rank = new int[n]; 
        for(int i = 0; i < n; i++) {
            parent[i] = i; 
            rank[i] = 0;
        }
    }

    public  int find(int x) {        
            if(parent[x] != x) 
                parent[x] = find(parent[x]);

            return parent[x];
    }


    public void union(int x, int y) {
            int root_x = find(x); 
            int root_y = find(y); 

            if(root_x == root_y) return; 

            if(rank[root_x] < rank[root_y]) 
                parent[root_x] = root_y;
            else if (rank[root_x] > rank[root_y]) 
                parent[root_y] = root_x;
            else   {
                parent[root_y] = root_x; 
                rank[root_x] = rank[root_x] + 1; 
            }

                     
            // path compression for the elements along the path from x to root x; updating their parents to root_x;     
            int temp;
            while(x != root_x) {
                temp = parent[x];  // temp parent of x 
                parent[x] = root_x;
                x = temp;
            }   

            // path compression for the elements along the path from y to root y; updating their parents to root_y; 

            while(y != root_y) {
                temp = parent[y]; 
                parent[y] = root_y; 
                y = temp; 
            }
    }   
    
}

public class Medium {
    /**       Clone  an undirected graph 
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


    /**
     * Course Schedule 
     * 
     * 
     *  Time Complexity
     *      Building the adjacency list: O(E) where E is the number of prerequisites
     *      DFS for detecting cycles: O(V + E) where V is the number of vertices (numCourses) and E is the number of edges(prerequisites)
     *      Iterating over courses: O(V) where is v is the number of vertices (numCourses). 
     * 
     *  So, overal the time complexity is O(V + E)
     *  
     * 
     *  Space Complexity
     *      Adjacency list: O(V + E) where v is the number of vertices (numCourses) and E is the number of edges (prerquisites)
     *      vISITED AND eXPLORED aRRAYS:? 
     *      Boolean and explored boolean arrays: O(V) where V is the number of vertices (numCourses). 
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




    /** Number of Connect Components in a Undirected Graph
     * 
     * 
     * 
     * Strategy 
     *  To solve this challenge we need to use the useful union-find datastructure
     *  which will help us to count the number of connected ccomponents in a undirected graph in a performant 
     *  way, even better that just using DFS, this is for space complexity and is almost as performant than DFS
     *  in time complexity.
     * 
     * 
     * Time Complexity
     * 
     * Space Complexity
     * 
     * Union Operation with Path Compression and Rank
     *  Objective: Develop and operation that allows merging two disjoint components based on the union of two vertices 
     *  belonging to those sets. 
     *  
     *  Aproach: 
     *  1-Start with two elements 'x' and 'y' that need to be united into the same set.
     *  2-Find the root of the set containing element 'x' using the 'Find(x)' function with path compression.
     *  Store the result in 'root_x'
     *  3-Find the root of the set containing element 'y' using the 'Find(y)' function with path compression.
     *  Store the result in 'root_y'
     *  4-If 'root_x' equals 'root_y', the elements 'x' and 'y' are already in the same set. Return from the function 
     *  without performing any further actions.
     *  5-If the rank of 'root_x' is less than the rank of 'root_y', set the parent of 'root_x' to 'root_y'. 
     *  Otherwise, if the rank of 'root_x' is greater than the rank of 'root_y', se the parent of 'root_y' to 'root_x'. 
     *  If the ranks are equal, set the parent of 'root_y' to 'root_x' and increment the rank of 'root_x'
     *  6-Apply path compression for the elements along the path from 'x' to 'root x' by updating their parents to 'root_x'
     *  7-Apply path compression for the elements along the path from 'y' to 'root y' by updating their parents to 'root y'
     *  8-The union operation is now complete
     * 
     * Find Operation with Path Compression and Rank
     *  Objective: Find the root of a given vertice.
     * 
     *  Approach: 
     *  1-Start with an element 'x' for which the root needs to be found.
     *  2-Check if the parent of 'x' is equal to 'x'. If true, 'x' is the root of its set, and the find operation is complete.
     *  3-If the parent of 'x' is not equal to 'x', indicating that 'x' is not the root of its set, recursiveltyy call the 'Find'
     *  function on the parent of 'x'. 
     *  4-During the recursive call, update the parent of each node on the path from 'x' to the root to point directly to the root.
     *  5-Once the root is found, return the root element,, indicating the representative of the set to which 'x' belongs
     * 
    */  



    /* Time and space complexity: 
        
    Time complexity: O(E + N)11111111111111


    Space complexity: O(N)

    */ 
    
    public static int numberOfConnectedComponentsUndirectedGraph(int n, int[][] edges) {
        if(n == 0 ||  edges.length == 0) return 0;

        UnionFind uf = new UnionFind(n); 


        // Union opeartion on each edge 
        for(int[] edge: edges) {
            uf.union(edge[0], edge[1]); 
        }   


        // Count distinct roots (connected components) 
        Set<Integer> components = new HashSet<>(); 
        for(int i = 0; i < n; i++) {
            components.add(uf.find(i)); 
        }

        return components.size(); 

    }



    
    /* Time and space complexity: 
        
    Time complexity: O(E + N)


    Space complexity: O(N)

    */ 

    public static int numberOfConnectedComponentsUndirectedGraphSetup() {

        int n = 6; 
        int [][] edges = {
            {0, 1}, 
            {1, 2}, 
            {3, 4}, 
            {5, 5}
        };

        return numberOfConnectedComponentsUndirectedGraph(n, edges); 

    }



    /** Graph Valid Tree 
     * 
     * 
     * 
     * Proposal: Given a undirected graph determine if it is a valid tree
     * Strategy: Trees accomplish the following: 
     * 
     * 1 - Are not allowed to have cycles. 
     * 2 - Its elements must be connected.
     * 
     * Algorithm: 
     * 
     * 
     * 1-Start DFS traversal from any node in the graph
     * 2-Keep track of visited nodes to avoid revisiting them
     * 3-For each visited node: 
     *  Mark it as visited.
     *  Visit all its enighbors 
     *  If a neighbor is already visited, then there is a cycle, and the graph is not a tree.
     * 
     * 4-Afte traversal: 
     * 
     * If all nodes are visited and there are no cycles, chek if the number of vertices visited is equal to n return true
     * as the grap is valid otherwise return false. 
     * 
     * 
     * 
     * Time Complexity: 
     * O(V+E)
     * Space Complexity: 
     * O(V+R)
    */


    private static boolean visitNodeUndirectedGraph(int i, int prev, Set<Integer> visited, List<Integer>[] adj) { 
        if (visited.contains(i)) return false; // loop detected

        visited.add(i); 
        // visit all neighbors 
        for(int j: adj[i]) {
            // skip parent
            if(j == prev) continue;

            if(!visitNodeUndirectedGraph(j, i, visited, adj)) return false;
        }


        return true;
        
    }

    public static boolean graphValidTree(int n, int [][] edges) { 

       if (Integer.valueOf(n) == null) return true;

       // allocate space for adjacency list
      //List<Integer>[] adj; you dont;

        // adj = new ArrayList[numCourses];


       List<Integer>[] adj = new ArrayList[n];// setting reference type, AND allocating memory :) 


       for (int i = 0 ; i < n ; i++) {
        adj[i] = new ArrayList<>();
       }

       for(int[] edge: edges ) {
        adj[edge[0]].add(edge[1]); 
        adj[edge[1]].add(edge[0]);
       }

        Set<Integer> visited= new HashSet<>(); 

        return visitNodeUndirectedGraph(0, -1, visited, adj) && visited.size() == n; 
    }

    public static boolean graphValidTreeSetup() {

        int n = 5; 
        int [][] edges = 
        {
            {0, 1}, 
            {0, 2},
            {0, 3},
            {1, 4}        
        }; 

        return graphValidTree(n, edges);

    }
}


