import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day2 {
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
        Scanner sc1 = new Scanner(file);
        Scanner sc2 = new Scanner(file);
        int[] sol1 = chkr1(sc1);
        System.out.print("1: ");
        System.out.println(sol1[1]*sol1[0]);
        int[] sol2 = chkr2(sc2);
        System.out.print("2: ");
        System.out.println(sol2[1]*sol2[0]);
    }
}
