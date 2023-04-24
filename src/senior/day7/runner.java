package src.senior.day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class runner {
    public static void main(String[] args) throws FileNotFoundException {
        FileSystemGenerator f = new FileSystemGenerator();
        f.processor();
    }
}
