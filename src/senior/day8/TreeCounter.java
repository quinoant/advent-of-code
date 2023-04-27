package src.senior.day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TreeCounter {
    private File file;
    private int[][] treeGrove;
    private boolean[][] seenTrees;
    
    /**
     * Sets trees to true in seenTrees if they are able to be seen
     * @param dimension
     */
    public void seeTrees(int dimension){
        //int totalOutside = (2*dimension) - (2*(dimension-2));
        for(int x = 0; x < dimension; x++){
            seenTrees[0][x] = true;
            seenTrees[dimension-1][x] = true;
            seenTrees[x][0] = true;
            seenTrees[x][dimension-1] = true;

        }
        //make an algo that goes in by layer, like an onion
        boolean notFinished = true;
        int round = 1;
        while(notFinished){
            for(int i = round; i < (dimension-(1+round));i++){
                //top
                System.out.println("t row: " + (dimension-(1+round)) + " t column: " + i);
                System.out.println("b row: " + round + "b column: " + i);
                //left
                System.out.println("l row: " + i + "l column: " + round);
                System.out.println("r row: " + i + "r column: " + (dimension-(1+round)));
            }
            round++;
            if(round == (dimension-(1+round))){
                System.out.println("center: " + round + ", " + round);
                notFinished = false;
            }
        }
         /* for(int i = 0; i < dimension-2; i++){ //row
            for(int j = 0; j < dimension-2; j++){ //column
                //if up down left or right is seen and shorter this one is
                if(seenTrees[i+1][j+1]);
            }
        }  */
    }

    /**
     * 
     * @param dimension - 5 and 99
     * @return - an array of the trees
     * @throws FileNotFoundException
     */
    public void treeGroveBuilder(int dimension) throws FileNotFoundException{
        Scanner sc = new Scanner(file);
        this.treeGrove = new int[dimension][dimension];
        this.seenTrees = new boolean[dimension][dimension];
        int row = 4;
        while(sc.hasNextLine()){
            char[] line = sc.nextLine().toCharArray();
            for(int i = 0; i < dimension; i++){
                treeGrove[row][i] = Integer.parseInt(line[i] + "");
                seenTrees[row][i] = false;
            }
            System.out.println();
            row--;
            //System.out.println(treeGrove[row][column]);
        }
        sc.close();
    }

    public int[][] getTreeGrove() {
        return treeGrove;
    }

    public boolean[][] getSeenTrees() {
        return seenTrees;
    }

    public TreeCounter(File file){this.file = file;}
    public TreeCounter(){}
}
