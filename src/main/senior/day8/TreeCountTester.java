package src.main.senior.day8;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

public class TreeCountTester {

    /**
     * Tests whether or not treeGroveBuilder builds the tree
     * grove
     * @throws FileNotFoundException
     */
    @Test
    public void treeBuildTester() throws FileNotFoundException{
        TreeCounter toTest = new TreeCounter(new File("/Users/quinoant/Downloads/advent-of-code/src/senior/day8/test.txt"));
        toTest.treeGroveBuilder(5);
        assertEquals(5,toTest.getTreeGrove()[1][2]);
        assertEquals(1,toTest.getTreeGrove()[3][3]);
        assertEquals(0,toTest.getTreeGrove()[4][1]);
        assertEquals(3,toTest.getTreeGrove()[4][4]);
    }

    /**
     * Tests the seen trees shadow map
     * @throws FileNotFoundException
     */
    @Test
    public void seenTreesTest() throws FileNotFoundException{
        TreeCounter toTest = new TreeCounter(new File("/Users/quinoant/Downloads/advent-of-code/src/senior/day8/test.txt"));
        toTest.treeGroveBuilder(5);
        assertFalse(toTest.getSeenTrees()[1][2]);
        assertFalse(toTest.getSeenTrees()[0][3]);
        assertFalse(toTest.getSeenTrees()[2][4]);
        assertFalse(toTest.getSeenTrees()[3][3]);
        assertFalse(toTest.getSeenTrees()[0][0]);
    }

    /**
     * Tests whether all outside trees are set to seen
     * @throws FileNotFoundException
     */
    @Test
    public void seenOuterTreesTest() throws FileNotFoundException{
        TreeCounter toTest = new TreeCounter(new File("/Users/quinoant/Downloads/advent-of-code/src/senior/day8/test.txt"));
        toTest.treeGroveBuilder(5);
        toTest.SeeTrees(5);
        for(int i = 0; i < 5; i++){ //row
            for(int j = 0; j < 5; j++){ //column
                if(i == 0 || i == 4 || j == 0 || j == 4){
                    assertTrue(toTest.getSeenTrees()[i][j]);
                }
            }
        }
    }

    /**
     * Tests whether all outside trees are set to seen
     * @throws FileNotFoundException
     */
    @Test
    public void seenInnerTreesTest() throws FileNotFoundException{
        TreeCounter toTest = new TreeCounter(new File("/Users/quinoant/Downloads/advent-of-code/src/senior/day8/test.txt"));
        toTest.treeGroveBuilder(5);
        toTest.SeeTrees(5);
        assertTrue(toTest.getSeenTrees()[3][1]);
        assertTrue(toTest.getSeenTrees()[2][1]); //
        assertTrue(toTest.getSeenTrees()[3][2]);
        assertTrue(toTest.getSeenTrees()[1][2]); //
        assertTrue(toTest.getSeenTrees()[2][3]);

        assertFalse(toTest.getSeenTrees()[1][1]);
        assertFalse(toTest.getSeenTrees()[1][3]);
        
    }

    /**
     * Tests whether all outside trees are set to seen
     * @throws FileNotFoundException
     */
    @Test
    public void correctNumSeenTest() throws FileNotFoundException{
        TreeCounter toTest = new TreeCounter(new File("/Users/quinoant/Downloads/advent-of-code/src/senior/day8/test.txt"));
        toTest.treeGroveBuilder(5);
        toTest.SeeTrees(5);
        assertEquals(21,toTest.getSeen());
        
    }

    /**
     * Tests whether all outside trees are set to seen
     * @throws FileNotFoundException
     */
    @Test
    public void partOneTest() throws FileNotFoundException{
        TreeCounter toTest = new TreeCounter(new File("/Users/quinoant/Downloads/advent-of-code/src/senior/day8/input.txt"));
        toTest.treeGroveBuilder(99);
        toTest.SeeTrees(99);
        assertEquals(1767,toTest.getSeen());
        
    }
}
