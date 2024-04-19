package graph; 

import java.util.*;


class Node {
    char data; 
    Node(char data) {
        this.data = data; 
    }    
}


class CityNode {
    String name; 
    static int value = 0; 
    int index;
    CityNode(String name) {
        this.name = name; 
        this.index = value++;
    }
}


class GraphCities {
    // to be able to add strings, use a counter for values in a hashmap
    Map<String, CityNode> cities;
    int[][] matrix;
    int value = 1;

    GraphCities(int size) {
        matrix = new int[size][size]; 
        cities = new HashMap<String, CityNode>(); 
    }


    public void addNode(String city) {
        if (!cities.containsKey(city)) 
            cities.put(city, new CityNode(city));
    }



    public int getCityIndex(String city) {
        if (cities.containsKey(city)) { 
            return cities.get(city).index;
        } else {
            return -1;
        }
    }


    public void addEdge(String src, String dst) { // get index of cities by name 
        int srcIndex; 
        int dstIndex;


        if(! src.isEmpty() && ! dst.isEmpty()) {
            srcIndex = getCityIndex(src); 
            dstIndex = getCityIndex(dst); 
        } else {
            System.out.println("cannot form link from missing data");
            return;
        }


        if (srcIndex != -1 && dstIndex != -1) {
            matrix[srcIndex][dstIndex] = 1;            
        } else {
            System.out.println("cannot form link from invalid data");
        }

    }



    public boolean checkEdge(String src, String  dst) {
        int srcIndex; 
        int dstIndex;


        if(!src.isEmpty() && !dst.isEmpty()) {
            srcIndex = getCityIndex(src); 
            System.out.printf("source index: " + srcIndex + "\n");
            dstIndex = getCityIndex(dst); 
            System.out.printf("dest index: " + dstIndex + "\n");
        } else {
            System.out.println("Provide citie's names"); 
            return false;
        }


        if (srcIndex != -1 && dstIndex != -1) {
            return matrix[srcIndex][dstIndex] == 1 ? true : false;            
        } else {
            System.out.println("cannot form link from invalid data");
            return false;
        }

    }




    // public void print() {
    //     System.out.printf("\t");
    //     for(Cities node: nodes) {
    //         System.out.print(node.data + " ");
    //     }

    //     System.out.println();

    //     for(int i=0; i < matrix.length; i++) {
    //         System.out.print(nodes.get(i).data);
    //         System.out.printf("\t");
    //         for(int j=0; j < matrix[i].length; j++) {
    //             System.out.print(matrix[i][j] + " ");
    //         }
    //         System.out.println();
    //     }
    // }



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



public class Review {
    public static void AdjacencyMatrix() {

    }


    public static void main(String[] args) {
        // Graph graph = new Graph(5); 



        // graph.addNode(new Node('A'));
        // graph.addNode(new Node('B'));
        // graph.addNode(new Node('C'));
        // graph.addNode(new Node('D'));
        // graph.addNode(new Node('E'));



        // graph.addEdge(0, 1);
        // graph.addEdge(1, 2);
        // graph.addEdge(2, 3);
        // graph.addEdge(2, 4);
        // graph.addEdge(4, 0);
        // graph.addEdge(4, 2);


        // graph.print();


        // System.out.println(graph.checkEdge(3, 2));



        GraphCities graphCities = new GraphCities(10);  // allocating 10 cities 
        graphCities.addNode("Amsterdam"); 
        graphCities.addNode("Berlin"); 
        graphCities.addNode("Liverpool"); 
        graphCities.addNode("Oslo"); 
        graphCities.addNode("Bergen"); 



        // ADDING CONNECTIONS 


        graphCities.addEdge("Oslo", "Bergen");

        System.out.println(graphCities.checkEdge("Oslo", "Bergen"));
        System.out.println(graphCities.checkEdge("Bergen", "Oslo"));

    }
}