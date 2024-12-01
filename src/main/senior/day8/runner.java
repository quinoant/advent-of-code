package src.main.senior.day8;

import java.io.File;
import java.io.FileNotFoundException;

public class runner {
    public static void main(String[] args) throws FileNotFoundException {
        TreeCounter toRun = new TreeCounter(new File("/Users/quinoant/Downloads/advent-of-code/src/senior/day8/test.txt"));
        toRun.treeGroveBuilder(5);
        toRun.SeeTrees(5);
    }
}
