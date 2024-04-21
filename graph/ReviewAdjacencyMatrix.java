package graph; 
import java.util.*;
/* An adejacency matrix is a matrix. where each intersection 
represents interconnectivy between vertices.
*/
/* Time complexity: O(1)
    Soace complexity: O(V^2)*/

class Node {
    char data; 
    Node(char data) {
        this.data = data; 
    }    
}

class Graph {

    ArrayList<Node> nodes;
    int[][] matrix; 


    Graph(int size) {
        matrix = new int[size][size];
        nodes = new ArrayList<>();
    }



    public void addNode(Node node) {
        nodes.add(node);
    }


    public void addEdge(int src, int dst) {
        matrix[src][dst] = 1;
    }


    public boolean checkEdge(int src, int dst) {
        return matrix[src][dst] == 1 ? true : false; 
    }


    public void print() {
        System.out.printf("\t");
        for(Node node: nodes) {
            System.out.print(node.data + " ");
        }

        System.out.println();

        for(int i=0; i < matrix.length; i++) {
            System.out.print(nodes.get(i).data);
            System.out.printf("\t");
            for(int j=0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}



public class ReviewAdjacencyMatrix {

    public static void main(String[] args) {
        Graph graph = new Graph(5); 

        graph.addNode(new Node('A'));
        graph.addNode(new Node('B'));
        graph.addNode(new Node('C'));
        graph.addNode(new Node('D'));
        graph.addNode(new Node('E'));



        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 0);
        graph.addEdge(4, 2);


        graph.print();


        System.out.println(graph.checkEdge(3, 2));


    }
}