package src.senior.day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TreeCounter {
    private File file;
    private int[][] treeGrove;
    private boolean[][] seenTrees;
    private int seen = 0;


    public boolean IsSeen(int row, int column){
        int height = treeGrove[row][column];
        if(row == 0 || row == treeGrove.length-1 || column == 0 || column == treeGrove.length-1){
            seen++;
            return true;
        }

        //up
        for(int i = 1; (i+row)<seenTrees.length;i++){
            if(treeGrove[i+row][column] >= height){
                break;
            }
            if(seenTrees[i+row][column]){
                if(treeGrove[i+row][column] < height){
                    seen++;
                    return true;
                }else{
                    break;
                }
            }
        }
        //down
        for(int i = 1; (row - i) >= 0;i++){
            if(treeGrove[row - i][column] >= height){
                break;
            }
            if(seenTrees[row - i][column]){
                if(treeGrove[row - i][column] < height){
                    seen++;
                    return true;
                }else{
                    break;
                }
            }
        }
        //left
        for(int i = 1; (column - i) >= 0;i++){
            if(treeGrove[row][column - i] >= height){
                break;
            }
            if(seenTrees[row][column - i]){
                if(treeGrove[row][column - i] < height){
                    seen++;
                    return true;
                }else{
                    break;
                }
            }
        }
        //right
        for(int i = 1; (column + i)<seenTrees.length;i++){
            if(treeGrove[row][column + i] >= height){
                break;
            }
            if(seenTrees[row][column + i]){
                if(treeGrove[row][column + i] < height){
                    seen++;
                    return true;
                }else{
                    break;
                }
            }
        }
        return false;
    }
    
    /**
     * Sets trees to true in seenTrees if they are able to be seen
     * @param dimension
     */
    public void SeeTrees(int dimension){
        //int totalOutside = (2*dimension) - (2*(dimension-2));
        // this.seen += (2*dimension) + (2*(dimension-2));
        // for(int x = 0; x < dimension; x++){
        //     seenTrees[0][x] = true;
        //     seenTrees[dimension-1][x] = true;
        //     seenTrees[x][0] = true;
        //     seenTrees[x][dimension-1] = true;
        // }
        //make an algo that goes in by layer, like an onion
        for(int i = 0; i < (dimension/2)+1;i++){
            for(int j = i; j < (dimension-i);j++){
                if(!seenTrees[i][j]){
                    seenTrees[i][j] = IsSeen(i, j);
                }
                if(!seenTrees[dimension-1-i][j]){
                    seenTrees[dimension-1-i][j] = IsSeen(dimension-1-i, j);
                }
                if(!seenTrees[j][i]){
                    seenTrees[j][i] = IsSeen(j, i);
                }
                if(!seenTrees[j][dimension-1-i]){
                    seenTrees[j][dimension-1-i] = IsSeen(j, dimension-1-i);
                }
            }
        }
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
        int row = dimension - 1;
        while(sc.hasNextLine()){
            char[] line = sc.nextLine().toCharArray();
            for(int i = 0; i < dimension; i++){
                treeGrove[row][i] = Integer.parseInt(line[i] + "");
                seenTrees[row][i] = false;
            }
            row--;
        }
        sc.close();
    }

    public int[][] getTreeGrove() {
        return treeGrove;
    }

    public boolean[][] getSeenTrees() {
        return seenTrees;
    }

    public int getSeen() {
        return seen;
    }

    public TreeCounter(File file){this.file = file;}
    public TreeCounter(){}
}
