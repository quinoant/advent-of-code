package src.senior.day8;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

public class TreeCountTester {

    /**
     * Tests whether or not treeGroveBuilder returns a null
     * It should not return a null
     * @throws FileNotFoundException
     */
    @Test
    public void nullTester() throws FileNotFoundException{
        TreeCounter toTest = new TreeCounter(new File("/Users/quinoant/Downloads/advent-of-code/src/senior/day8/test.txt"));
        assertNotNull(toTest.treeGroveBuilder(5));

    }

    @Test
    public void inputReadTest(){
        TreeCounter toTest = new TreeCounter(new File("/Users/quinoant/Downloads/advent-of-code/src/senior/day8/test.txt"));

    }
}
