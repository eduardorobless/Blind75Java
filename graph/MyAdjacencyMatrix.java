package graph; 
import java.util.*;

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
        cities = new LinkedHashMap<String, CityNode>(); 
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
            //System.out.printf("source index: " + srcIndex + "\n");
            dstIndex = getCityIndex(dst); 
            //System.out.printf("dest index: " + dstIndex + "\n");
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

    public void print() {
        //String padded = String.format("")
        System.out.printf("%-20s", "");
         cities.forEach((key, value) -> {
            System.out.printf("%-20s",key);
        });
        
        System.out.println();
        cities.forEach((key, value) -> {
            System.out.printf("%-20s", key);

            cities.forEach((innerKey, innerValue) -> {
                System.out.printf("%-20s", checkEdge(key, innerKey));            
            });

            System.out.println("\n");

        });
    }


}


public class MyAdjacencyMatrix {
    public static void main(String[] args) {
        GraphCities graphCities = new GraphCities(10);  // allocating 10 cities 
        graphCities.addNode("Amsterdam"); 
        graphCities.addNode("Berlin"); 
        graphCities.addNode("Liverpool"); 
        graphCities.addNode("Oslo"); 
        graphCities.addNode("Bergen"); 

        // ADDING CONNECTIONS 
        graphCities.addEdge("Oslo", "Bergen");
        // System.out.println(graphCities.checkEdge("Oslo", "Bergen"));
        // System.out.println(graphCities.checkEdge("Bergen", "Oslo"));

        // Iterate nodes 
        // check edge on each node based
        graphCities.print();
    }
}