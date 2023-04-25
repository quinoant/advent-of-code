package src.senior.day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TreeCounter {
    private File file;
    private int[][] treeGrove;
    /**
     * 
     * @param dimension - 5 and 99
     * @return - an array of the trees
     * @throws FileNotFoundException
     */
    public int[][] treeGroveBuilder(int dimension) throws FileNotFoundException{
        Scanner sc = new Scanner(file);
        int[][] treeGrove = new int[5][5];
        int row = 4;
        while(sc.hasNextLine()){
            char[] line = sc.nextLine().toCharArray();
            for(int i = 0; i < dimension; i++){
                treeGrove[row][i] = Integer.parseInt(line[i] + "");
                System.out.print(treeGrove[row][i]);
            }
            System.out.println();
            row--;
            //System.out.println(treeGrove[row][column]);
        }
        sc.close();
        return treeGrove;
    }

    public TreeCounter(File file){this.file = file;}
    public TreeCounter(){}
}
