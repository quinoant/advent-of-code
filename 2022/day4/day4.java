import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day4 {
    public static int completeOverlapChkr(String[] elf1, String[] elf2){
        int elf1Min = Integer.parseInt(elf1[0]);
        int elf1Max = Integer.parseInt(elf1[1]);
        int elf2Min = Integer.parseInt(elf2[0]);
        int elf2Max = Integer.parseInt(elf2[1]);
        if(((elf1Max - elf1Min) < (elf2Max - elf2Min)) && (elf1Min >= elf2Min) && (elf1Max <= elf2Max)){
            //System.out.println("1");
            return 1;//elf 1 smaller than elf2
        }else if(((elf1Max - elf1Min) > (elf2Max - elf2Min)) && (elf2Min >= elf1Min) && (elf2Max <= elf1Max)){
            //System.out.println("2");
            return 1;//elf 2 smaller than elf1
        }else if((elf1Max - elf1Min) == (elf2Max - elf2Min) && (elf2Min == elf1Min) && (elf2Max == elf1Max)){
            //System.out.println("3");
            return 1;//they are equal
        }
        return 0;
    }

    public static int overlapChkr(String[] elf1, String[] elf2){
        int elf1Min = Integer.parseInt(elf1[0]);
        int elf1Max = Integer.parseInt(elf1[1]);
        int elf2Min = Integer.parseInt(elf2[0]);
        int elf2Max = Integer.parseInt(elf2[1]);
        //1min < 2max and 1max > 2max
        //2min < 1max and 2max > 1min
        //any equal
        //min < max
        if((elf1Min < elf2Max) && (elf1Max > elf2Max)){
            //System.out.println("1");
            return 1;//elf 1 after elf2
        }else if((elf2Min < elf1Max) && (elf2Max > elf1Max)){
            //System.out.println("2");
            return 1;//elf 2 after elf1
        }else if((elf1Min == elf2Min) || (elf2Max == elf1Max) || (elf1Min == elf2Max) || (elf2Min == elf1Max)){
            //System.out.println("3");
            return 1;//they are equal
        }
        //System.out.println(elf1Min + "-" + elf1Max + "," + elf2Min + "-" + elf2Max);
        return 0;
    }

    public static void processor(Scanner sc){
        int total1 = 0;
        int total2 = 1;
        while(sc.hasNextLine()){
            String [] elfs;
            //seperate elves to compare them
            elfs = sc.nextLine().split(",");
            total1 += completeOverlapChkr(elfs[0].split("-"), elfs[1].split("-"));
            total2 += overlapChkr(elfs[0].split("-"), elfs[1].split("-"));
            //determine whether one encompasses the other
            //If elf 1 range is equal to the other with same endpoints for now put as +!
            //if elf 1 range is larger check if elf2 is within range of elf1
            //if elf 1 range is smaller check if elf1 is within range of elf2
        }
        System.out.println("# of complete overlaps: " + total1);
        System.out.println("all overlaps: " + total2);

    }
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner sc1 = new Scanner(file);
        processor(sc1);
    }
}
