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

class Graph {
    ArrayList<LinkedList<CityNode>> alist; 
    Map<String, CityNode> cities;

     Graph(){
        alist = new ArrayList<>();
        cities = new LinkedHashMap<String, CityNode>(); 
     }

    public int getCityIndex(String city) {
        if (cities.containsKey(city)) { 
            return cities.get(city).index;
        } else {
            return -1;
        }
    }

     void addNode(String city){

        if (!cities.containsKey(city)) {
            CityNode node = new CityNode(city);
            cities.put(city, node);
        // create new linked list
            LinkedList<CityNode> currentList = new LinkedList<>();
            // add node that head of said linked list 
            currentList.add(node);
            // add linked list to arraylist 
            alist.add(currentList); 
        } else {
            System.out.print("Cannot add city, is already there!");
        }

     }


     void addEdge(String src, String dst) { 

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
            // get linked list from arrraylist where source node is located at 
            LinkedList<CityNode> currentList = alist.get(srcIndex);
            // get node from linked list inside arraylist where destination node is located at
            CityNode destNode = alist.get(dstIndex).get(0); 
            // point destination node to source node linked list
            currentList.add(destNode);
        }  else {
            System.out.println("cannot form link from invalid data");
        }



     }

     boolean checkNode(String src, String dst) {

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

            // get linked list from arraylist where src node is located at 
            LinkedList<CityNode> currentList = alist.get(srcIndex);
            // get node from linked list inside arraylist where dest node is located at
            CityNode destNode = alist.get(dstIndex).get(0); 
            // iterate nodes in current list to check if they match dest node address 
            for(CityNode node: currentList) { 
                if (node == destNode) {
                    return true;
                }
            }

     

        } else {
            System.out.println("cannot form link from invalid data");
        }
        
        return false;  
     }


    // nested foor lop
     void print(){
            // itearate all linkedlist in array list 
            for(LinkedList<CityNode> myList: alist) {
                // itearte all nodes inside each linked list 
                for(CityNode node: myList) {
                    // add arrow for formatting 
                    System.out.print(node.name + "->");
                }   

                // add new line 
                System.out.println(); 
            }
     }
}

public class MyAdjacencyLists {
    public static void main(String[] args) {
        Graph graphCities = new Graph();  // allocating 10 cities 
        graphCities.addNode("Amsterdam"); 
        graphCities.addNode("Berlin"); 
        graphCities.addNode("Liverpool"); 
        graphCities.addNode("Oslo"); 
        graphCities.addNode("Bergen"); 

        // ADDING CONNECTIONS 
        graphCities.addEdge("Oslo", "Bergen");
        graphCities.addEdge("Berlin", "Oslo");
        // System.out.println(graphCities.checkEdge("Oslo", "Bergen"));
        // System.out.println(graphCities.checkEdge("Bergen", "Oslo"));

        // Iterate nodes 
        // check edge on each node based
        graphCities.print();            
    }
}