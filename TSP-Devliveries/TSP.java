import java.io.*;
import java.net.URI;
import java.util.Scanner;

public class TSP {
    public static void main(String[] args) {
        String[] addresses = new String[100];
        int[][] distances = new int[100][100];
        try {
            //3 lines below make sure to grab a file from TSP directory
            URI uri = TSP.class.getResource("/").toURI();
            File dir = new File(uri);
            File file = new File(dir, "deliveries.csv");

            //Check if the file exists in the current directory
            if(!file.exists()){
                System.err.println("Error: deliveries.csv not found in the current directory.");
                return; // Exit the program if the file is not found
            }

            Scanner scan = new Scanner(file);
            for(int i = 0; i < 100; i++) {
                String line = scan.nextLine();
                String[] parts = line.split(","); // Split the line by commas
                addresses[i] = parts[0]; //get the address
                for (int j = 0; j < 100; j++) {  //get the distances
                    distances[i][j] = Integer.parseInt(parts[j+1].trim());
                }

            }
            scan.close();

        }catch(Exception e) {
            System.err.println(e);
        }

        int[] distancePath = nearestNeighbor(distances);

        for(int i = 0; i < distancePath.length; i++) {
            System.out.println(addresses[distancePath[i]]);
        }

        int addedDistance = 0;
        for (int i = 0; i < distancePath.length - 1; i++) {
            int currentHouse = distancePath[i];  
            int nextHouse = distancePath[i+1];
            addedDistance += distances[currentHouse][nextHouse];
        }
        addedDistance += distances[distancePath[distancePath.length-1]][distancePath[0]];
        System.out.println("Shortest Path: " + addedDistance + " meters");
    }

    public static int[] nearestNeighbor(int[][] distances){
        int[] distancePath = new int[distances.length];
        boolean[] visited = new boolean[distances.length];
        int currentHouse = 0;
        visited[currentHouse] = true;

        for(int i = 1; i < distances.length; i++){
            int nextHouse = Integer.MIN_VALUE;
            int shortestDistance = Integer.MAX_VALUE;
            for(int j = 0; j < distances.length; j++){
                if(!visited[j] && distances[currentHouse][j] < shortestDistance){
                    shortestDistance = distances[currentHouse][j];
                    nextHouse = j;
                    System.out.println(shortestDistance);
                }
            }

            distancePath[i] = nextHouse;
            visited[nextHouse] = true;
            currentHouse = nextHouse;
        }

        return distancePath;
    }
}
