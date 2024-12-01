package src.main.senior.day7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

public class day7Tester{
    @Test
    public void testGettingANullWhenLookingForAFakeFolder(){
        FileSystemGenerator toTest = new FileSystemGenerator(new File("/Users/quinoant/Downloads/advent-of-code/src/senior/day7/test.txt"));
        Folder root = new Folder();
        root.setName("/");
        Folder returned = toTest.cd("bull", root);
        assertNotNull(returned);
        assertEquals("bull",returned.getName());
    }

    @Test
    public void testGettingChildrenBack(){
        FileSystemGenerator toTest = new FileSystemGenerator(new File("/Users/quinoant/Downloads/advent-of-code/src/senior/day7/test.txt"));
        Folder root = new Folder();
        root.setName("/");
        Folder child = new Folder(root);
        child.setName("bull");
        root.addChildren(child);
        Folder returned = toTest.cd("bull", root);
        assertNotNull("notnull", returned);
        assertEquals("bull",returned.getName());
    }

    @Test
    public void testChangingObj(){
        FileSystemGenerator toTest = new FileSystemGenerator(new File("/Users/quinoant/Downloads/advent-of-code/src/senior/day7/test.txt"));
        Folder root = new Folder();
        root.setName("/");
        Folder returned = toTest.cd("bull", root);
        assertNotNull("notnull", returned);
        assertEquals("bull",root.getChildren("bull").getName());
        assertEquals(1,root.getNumChildren());
    }

    @Test
    public void testGoingInAndOut(){
        FileSystemGenerator toTest = new FileSystemGenerator(new File("/Users/quinoant/Downloads/advent-of-code/src/senior/day7/test.txt"));
        Folder root = new Folder();
        root.setName("/");
        Folder child = new Folder(root);
        child.setName("bull");
        root.addChildren(child);
        Folder returned = toTest.cd("..", child);
        assertEquals("/",returned.getName());
    }

    @Test
    public void testCdChangingDirectory(){
        FileSystemGenerator toTest = new FileSystemGenerator(new File("/Users/quinoant/Downloads/advent-of-code/src/senior/day7/test.txt"));
        Folder root = new Folder();
        root.setName("/");
        Folder returned = toTest.cd("bull", root);
        assertEquals("bull",returned.getName());
        assertEquals(root.getChildren()[0], "bull");
        Scanner sc = new Scanner("dir b\n1234 c\ndir z\n666 hell.txt");
        toTest.ls(root, sc);
        assertEquals(5,root.getNumChildren());
    }

    @Test
    public void testLsDir() throws FileNotFoundException{
        FileSystemGenerator toTest = new FileSystemGenerator(new File("/Users/quinoant/Downloads/advent-of-code/src/senior/day7/test.txt"));
        Folder root = new Folder();
        root.setName("/");
        Scanner sc = new Scanner("dir b\n1234 c\ndir z\n666 hell.txt");
        toTest.ls(root, sc);
        assertEquals(4,root.getNumChildren());
        assertEquals(1234,root.getChildren("c").getFileSize());
    }

    @Test
    public void finalTest() throws FileNotFoundException{
        FileSystemGenerator toTest = new FileSystemGenerator(new File("/Users/quinoant/Downloads/advent-of-code/src/senior/day7/test.txt"));
        Folder root = toTest.processor();
        Folder kidOne = root.getChildren("a");
        Folder kidTwo = root.getChildren("d");
        Folder grandchild = root.getChildren("a").getChildren("e");
        assertNotNull(grandchild );
        assertEquals(584,grandchild.getTotSize());
        assertEquals(94853 ,kidOne.getTotSize());//24933642
        assertEquals(24933642 ,kidTwo.getTotSize());//48381165
        assertEquals(48381165 ,root.getTotSize());//95437
        assertEquals(95437, toTest.scorer());
        assertEquals(24933642,toTest.toDelete(root));
    }

    @Test
    public void challenge() throws FileNotFoundException{ 
        FileSystemGenerator toTest = new FileSystemGenerator(new File("/Users/quinoant/Downloads/advent-of-code/src/senior/day7/input.txt"));
        Folder root = toTest.processor();
        assertEquals(1449447, toTest.scorer());
        assertEquals(8679207,toTest.toDelete(root));

    }
}
