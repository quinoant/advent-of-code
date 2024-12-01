package src.main.junior.day4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day4 {
    public static int[][] boardReader(Scanner sc){
        String[] balls = sc.nextLine().split(",");
        int[] ballsArray = new int[balls.length];
        for(int i = 0; i < balls.length;i++){
            ballsArray[i] = Integer.parseInt(balls[i]);
        }
        int[][] currBoard = new int[5][5];
        int[][] bestBoard = new int[5][5];
        int currFastest = 10000;
        int[][] shadowBoard = new int[5][5];
        while(sc.hasNextInt()){
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    currBoard[i][j] = sc.nextInt();
                    //System.out.print((currBoard[i][j] + ", "));
                }
                //System.out.println();
            }
            int best = boardChkr(currBoard, ballsArray, shadowBoard,currFastest);
            if(best > 0){
                bestBoard = currBoard.clone();
                currFastest = best;
            }
            currBoard = new int[5][5];
        }   
        
        //System.out.println();
        return currBoard;
    }

    public static int boardChkr(int[][] board, int[] moves, int[][] shadowBoard, int currFastest){
        boolean got = false;
        int[][] currShadowBoard = {{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1}};
        for(int x = 0; x<moves.length;x++){
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    if(board[i][j] == moves[x]){
                        currShadowBoard[i][j] = 0;
                        got = true;
                        break;
                    }
                }
                if(got){
                    got = false;
                    break;
                }
            }
            if(x > 4){
                if(winChkr(currShadowBoard)){
                    if(currFastest > x){
                        shadowBoard = currShadowBoard.clone();
                        return x;
                    }
                    return -1;
                }
            }
        }
        return -1;
    }
    public static boolean winChkr(int[][] shadowBoard){
        int counterVert = 0;
        int counterHorizon = 0;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                //System.out.println("i: " + Integer.toString(i) + "j: " +  Integer.toString(j));
                if(shadowBoard[i][j] == 0){
                    counterHorizon++;
                }
                if(shadowBoard[j][i] == 0){
                    counterVert++;
                }
                //System.out.println(Integer.toString());
            }
            if(counterHorizon == 5 || counterVert == 5){
                return true;
            }
            counterHorizon = 0;
            counterVert = 0;
        }
        if(shadowBoard[0][0] == 0 && shadowBoard[1][1] == 0 && shadowBoard[2][2] == 0 && shadowBoard[3][3] == 0 && shadowBoard[4][4] == 0){
            return true;
        }
        if(shadowBoard[4][0] == 0 && shadowBoard[3][1] == 0 && shadowBoard[2][2] == 0 && shadowBoard[1][3] == 0 && shadowBoard[0][4] == 0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("test.txt");
        Scanner sc1 = new Scanner(file);
        //boardReader(sc1);
    }
}
