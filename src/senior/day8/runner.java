package src.senior.day8;

import java.io.File;
import java.io.FileNotFoundException;

public class runner {
    public static void main(String[] args) throws FileNotFoundException {
        String x = "012112312021432444002222553400425232521024405364230243502011133453405140031345502304422434041110301";
        System.out.println(x.length());
        TreeCounter toRun = new TreeCounter(new File("/Users/quinoant/Downloads/advent-of-code/src/senior/day8/test.txt"));
        toRun.treeGroveBuilder(5);
        //FileSystemGenerator f = new FileSystemGenerator();
        //f.processor();
    }
}
