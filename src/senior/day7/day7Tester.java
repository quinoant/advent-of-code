package src.senior.day7;

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
        FileSystemGenerator toTest = new FileSystemGenerator();
        Folder root = new Folder();
        root.setName("/");
        Folder returned = toTest.cd("bull", root);
        assertNotNull(returned);
        assertEquals("bull",returned.getName());
    }

    @Test
    public void testGettingChildrenBack(){
        FileSystemGenerator toTest = new FileSystemGenerator();
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
        FileSystemGenerator toTest = new FileSystemGenerator();
        Folder root = new Folder();
        root.setName("/");
        Folder returned = toTest.cd("bull", root);
        assertNotNull("notnull", returned);
        assertEquals("bull",root.getChildren("bull").getName());
        assertEquals(1,root.getNumChildren());
    }

    @Test
    public void testGoingInAndOut(){
        FileSystemGenerator toTest = new FileSystemGenerator();
        Folder root = new Folder();
        root.setName("/");
        Folder child = new Folder(root);
        child.setName("bull");
        root.addChildren(child);
        Folder returned = toTest.cd("..", child);
        assertEquals("/",returned.getName());
    }

    @Test
    public void testLsDir() throws FileNotFoundException{
        FileSystemGenerator toTest = new FileSystemGenerator();
        Folder root = new Folder();
        root.setName("/");
        Scanner sc = new Scanner("dir b\n1234 c\ndir z\n666 hell.txt");
        toTest.ls(root, sc);
        assertEquals(4,root.getNumChildren());
        assertEquals(1234,root.getChildren("c").getFileSize());
    }

    @Test
    public void finalTest() throws FileNotFoundException{
        FileSystemGenerator toTest = new FileSystemGenerator();
        Folder root = toTest.processor();
        assertEquals(4,root.getNumChildren());
    }
}
