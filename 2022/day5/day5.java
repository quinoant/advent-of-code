import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class day5 {
    /**
     * Turns each stack into a priority queue
     * @param sc - the scanner witht the puzzle input
     * @param totStacks - the number of stacks in this puzzle
     * @return - an array list of Priority Queue stacks
     */
    public static char[][] initialStacksProcessor(Scanner sc, int totStacks,int inputHeight, int maxHeight){
        char[][] stacks = new char[maxHeight][totStacks];
        int row = inputHeight-1;
        
        String currLine = sc.nextLine();
        for(int j = 0; j < inputHeight; j++){
            int i = 1;
            int column = 0;
            while(i < currLine.length()){
                char currChar = currLine.charAt(i);
                if(currChar != ' '){
                    stacks[row][column] = currChar;
                }
                i += 4;
                column += 1;
            }
            currLine = sc.nextLine();
            row -= 1;
            // Look for which columns are used in this row and fill in accordingly
        }
        return stacks;

    }
    public static int[] TopFinder(char[][] stacks){
        int[] tops = new int[stacks[0].length];
        for (int i = 0; i < stacks[0].length; i++) {
            int currTop = 0;
            for(int j = 0; j < stacks.length; j++){
                if(stacks[j][i] != '\0'){
                    currTop++;
                }else{
                    break;
                }
            }
            tops[i] = currTop;
        }
        return tops;
    }
    public static void MoveProcessor(char[][] stacks, Scanner sc){
        sc.nextLine();
        int quantity;
        int origin;
        int destination;
        int[] tops = TopFinder(stacks);
        while(sc.hasNextLine()){
            sc.next();
            quantity = sc.nextInt();
            sc.next();
            origin = sc.nextInt() - 1;
            sc.next();
            destination = sc.nextInt() - 1;
            //now move
            while(quantity > 0){
                /* System.out.println(stacks[tops[destination]][destination]);
                System.out.println(stacks[tops[origin]-1][origin]); */
                //System.out.println(Arrays.deepToString(stacks));
                stacks[tops[destination]][destination] = stacks[tops[origin]-1][origin];
                //System.out.println();
                stacks[tops[origin]-1][origin] = '\0';
                //System.out.println(Arrays.deepToString(stacks));
                tops[origin]--;;
                tops[destination]++;
                quantity--;
            }

        }
    public static void processor(Scanner sc){
        int totStacks = 3; //9
        int inputHeight = 3; //8
        int maxHeight = 6; //50
        char[][] stacks = initialStacksProcessor(sc, totStacks, inputHeight,maxHeight);
        MoveProcessor(stacks, sc);
        //System.out.println(Arrays.deepToString(stacks));

    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("test.txt");
        Scanner sc1 = new Scanner(file);
        processor(sc1);
    }
}
