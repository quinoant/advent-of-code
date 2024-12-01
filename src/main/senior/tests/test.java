package src.main.senior.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/quinoant/Downloads/advent-of-code/src/senior/tests/input.txt");
        Scanner sc1 = new Scanner(file);
        while(sc1.hasNext()){
            System.out.println(sc1.next());
        }
    }
}
