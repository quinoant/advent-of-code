package ;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day2{
    public static int[] chkr2(Scanner sc){
        int[] toRet = {0,0};
        int aim = 0;
        String[] currLine;
        while(sc.hasNextLine()){
            currLine = sc.nextLine().split(" ");
            switch (currLine[0]){
                case "forward":
                    toRet[0] += Integer.parseInt(currLine[1]);
                    toRet[1] += (Integer.parseInt(currLine[1]) * aim);
                    //System.out.println("forward");
                    break;
                case "down":
                    aim += Integer.parseInt(currLine[1]);
                    //System.out.println("down");
                    break;
                case "up":
                    aim -= Integer.parseInt(currLine[1]);
                    //System.out.println("up");
                    break;
            }
        }
        return toRet;
    }
    
    public static int[] chkr1(Scanner sc){
        int[] toRet = {0,0};
        String[] currLine;
        while(sc.hasNextLine()){
            currLine = sc.nextLine().split(" ");
            switch (currLine[0]){
                case "forward":
                    toRet[0] += Integer.parseInt(currLine[1]);
                    //System.out.println("forward");
                    break;
                case "down":
                    toRet[1] += Integer.parseInt(currLine[1]);
                    //System.out.println("down");
                    break;
                case "up":
                    toRet[1] -= Integer.parseInt(currLine[1]);
                    //System.out.println("up");
                    break;
            }
        }
        return toRet;
    }
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);
        int[] sol = chkr2(sc);
        System.out.println(sol[0]);
        System.out.println(sol[1]);
        System.out.println(sol[1]*sol[0]);
    }
}