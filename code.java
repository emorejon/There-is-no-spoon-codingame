import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        if (in.hasNextLine()) {
            in.nextLine();
        }
        char grid[][] = new char[width][height]; //two dimensional array to store the coordinates
        for (int i = 0; i < height; i++) {
            String line = in.nextLine(); // width characters, each either 0 or .
            for(int j = 0; j < width; j++){
                grid[j][i] = line.charAt(j);
            }
        }
        //Loop while Y of node being searched is less than height
        
        for(int i = 0; i <= height-1; i++){
            for (int j = 0; j <= width-1; j++){
                
                /*If the node is at the end of both the horizontal and vertical axis
                print x and y plus a harcoded set of coordinates.*/
                if(grid[j][i] == '0'  && j >= (width - 1) && i >= (height - 1)){
                    System.out.println(j + " " + i + " -1 -1 -1 -1");
                }
                
                /*This is the case of where X axis reaches an end
                at which point it will start searching down to find a valid node
                if it doesn't it prints the negative coordiates.*/
                else if(grid[j][i] == '0' && j >= (width - 1)){
                    System.out.print(j + " " + i + " -1 -1 ");
                    for(int x = i+1; x < height; x++){
                        if(grid[j][x] == '0'){
                            System.out.print(j + " " + (x) + " ");
                            break;
                        }
                        else if(grid[j][x] == '.' && x >= height - 1){
                            System.out.print("-1 -1 ");
                        }
                    }
                    System.out.println();
                }
                
                /*This is the case of where Y axis reaches an end
                at which point it will start searching down to find a valid node
                if it doesn't it prints the negative coordiates.*/
                else if(grid[j][i] == '0' && i >= (height - 1)){
                    System.out.print(j + " " + i + " ");
                    for(int z = j+1; z < width; z++){
                        if(grid[z][i] == '0'){
                            System.out.print(z + " " + i + " ");
                            break;
                        }
                        else if(grid[z][i] == '.' && z >= width - 1){
                            System.out.print("-1 -1 ");
                        }
                        
                    }
                    System.out.print("-1 -1 ");
                    System.out.println();
                }
                /*This is the general case. I put it at the end to make sure that the other 
                cases are tested first. For each node that is active, it will search left and down
                until it either finds another one to print it's coordinates or reaches the end of the
                axis and prints the negative coordinates.*/
                else if(grid[j][i] == '0'){
                    System.out.print(j + " " + i + " ");
                    for(int z = j+1; z < width; z++){
                        if(grid[z][i] == '0'){
                            System.out.print(z + " " + i + " ");
                            break;
                        }
                        else if(grid[z][i] == '.' && z >= width - 1){
                            System.out.print("-1 -1 ");
                        }
                    }
                    for(int x = i+1; x < height; x++){
                        if(grid[j][x] == '0'){
                            System.out.print(j + " " + (x) + " ");
                            break;
                        }                     
                        else if(grid[j][x] == '.' && x >= height - 1){
                            System.out.print("-1 -1 ");
                        }
                    }
                    System.out.println(); //Print an empty line to jump to the next set.
                }
            }
        }
    }
}
