package graph;
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
    /**                 Clone graph 
     *  Proposal 
     * 
     * To clone a graph you can either use DFS OR BFS. We use DFS for simplicity. 
     * 
     * 
     * 
     *
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



    private Node cloneUtil(Node node, HashMap<Node, Node> map) {
        // 2
        Node newNode = new Node(node.val);

        // 3 
        map.put(node, newNode)

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

    public static Node cloneGraph(Node node) {
        if(node == null) return null; 

        HashMap<Node, Node> map = new HashMap<>(); 

        return cloneUtil(node, map);

    }

}