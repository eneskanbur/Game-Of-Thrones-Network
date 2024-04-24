
package gameofthronesnetwork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class GameOfThronesNetwork {


    public static void main(String[] args) throws FileNotFoundException {
        
        LinearProbingHash<String> hashTable = new LinearProbingHash(107);
        FileInputStream got = new FileInputStream("GameOfThrones.txt");
        Scanner scn = new Scanner(got);
        GraphMatrix graph = new GraphMatrix(107);
        boolean marked[] = new boolean[107];
        ArrayList<String> abc = new ArrayList<>();
        
        while(scn.hasNext()){
            String a = scn.nextLine();
            String[] textParts = a.split(",");
            String name1 = textParts[0];
           // System.out.println(name1);
            hashTable.insert2(name1);
            String name2 = textParts[1];
           // System.out.println(name2);
            hashTable.insert2(name2);
            int weight = Integer.parseInt(textParts[2]);
            int hash1 =hashTable.contains(name1);
            int hash2 =hashTable.contains(name2);
            graph.addEdge(hash1, hash2, weight);
        }
        
        scn.close();
        System.out.println(graph.toString());
       /* FileInputStream got2 = new FileInputStream("GameOfThrones.txt");
        Scanner scn2 = new Scanner(got2);
        while(scn2.hasNext()){
            String name1 = textParts[0];
           
            String name2 = textParts[1];
            
            int weight = Integer.parseInt(textParts[2]);
            
            //graph.addEdge(hash1, hash2, weight);
        }
        System.out.println(graph.toString());
        scn2.close();*/
        
        
        //System.out.println(graph.isThereAPath("Ygritte", "Rattleshirt"));//Eddard - Jon, 
        Scanner input1 = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        boolean loop = true;
        while(loop) {
            System.out.print(
                    "\nWhich task you want to do? \n"
                    + "1. İs There A Path.\n"
                    + "2. AllPathsShorterThanEqualTo\n"
                    + "3. ShortestPathLengthFromTo.\n"
                    + "4. NoOfPathsFromTo\n"
                    + "5. BFSfromTo(\n"
                    + "6. DFSfromTo.\n"
                    + "7. NoOfVerticesInComponent\n"
                    + "8. Quit\n"
                    + "----------------------------------\n"
            );
            
            int seçim = input.nextInt();
            String name1;
            String name2;
            switch (seçim) {
                case 1:
                    System.out.println("Please Enter Two Name: ");
                     name1 = input1.nextLine();
                     name2 = input1.nextLine();
                    if(hashTable.contains(name1)==-1 || hashTable.contains(name2)==-1){
                        System.out.println(false);
                        break;
                    }
                    System.out.println(graph.isThereAPath(name1, name2, hashTable));
                    break;
                case 2:
                    System.out.println("Please Enter int pathLen, int VertexNo, string name1: ");
                     int pathlen = input.nextInt();
                     int vertexNo = input.nextInt();
                     name1 = input1.nextLine();
                    if(!hashTable.names.contains(name1) || !hashTable.names.contains(name2)){
                        System.out.println(false);
                        break;
                    }
                    System.out.println(graph.isThereAPath(name1, name2, hashTable));
                    break;
                case 3:
                    System.out.println("Please Enter Two Name: ");
                     name1 = input1.next();
                     name2 = input1.next();
                    if(!hashTable.names.contains(name1) || !hashTable.names.contains(name2)){
                        System.out.println(false);
                        break;
                    }
                    System.out.println(graph.isThereAPath(name1, name2, hashTable));
                    break;
                case 4:
                    System.out.println("Please Enter Two Name: ");
                     name1 = input1.next();
                     name2 = input1.next();
                    if(!hashTable.names.contains(name1) || !hashTable.names.contains(name2)){
                        System.out.println(false);
                        break;
                    }
                    System.out.println(graph.isThereAPath(name1, name2, hashTable));
                    break;
                case 5:
                    System.out.println("Please Enter Two Name: ");
                     name1 = input1.next();
                     name2 = input1.next();
                    if(!hashTable.names.contains(name1) || !hashTable.names.contains(name2)){
                        System.out.println(false);
                        break;
                    }
                    System.out.println(graph.isThereAPath(name1, name2, hashTable));
                    break;
                case 6:
                    System.out.println("Please Enter Two Name:");
                     name1 = input1.nextLine();
                     name2 = input1.nextLine();
                     System.out.println("----------------------------------------");
                     graph.dfs(name1,name2, hashTable,marked,abc);
                    break;
                    case 8:
                    loop = false;
                    break;
            }
        }
    }
}

