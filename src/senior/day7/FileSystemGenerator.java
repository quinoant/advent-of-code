package src.senior.day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import src.senior.day7.Folder;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

public class FileSystemGenerator {
    private File file = new File("/Users/quinoant/Downloads/advent-of-code/src/senior/day7/test.txt");

    public Folder cd(String folder,Folder currFolder){
        Folder newFolder =currFolder.getChildren(folder);
        if(folder.equals("..")){
            return currFolder.getParent();
        }else if(newFolder == null){
            return newFolder(folder,currFolder);
        }else{
            return newFolder;
        }
    }

    public void ls(Folder currFolder, Scanner sc){
        String currString = sc.next();
        int fileSize;
        System.out.println(currString);
        while(!currString.equals("$")){
            if(currString.equals("dir")){
                currString = sc.next();
                newFolder(currString, currFolder);
            }else{
                fileSize = Integer.parseInt(currString);
                currFolder.addToTotalSize(fileSize);
                currString = sc.next();
                newFile(currString, fileSize, currFolder);
            }
            if(sc.hasNext()){
                currString = sc.next();
            }else{
                return;
            }
                
        }
    }

    public Folder newFile(String file,int fileSize,Folder parent){
        Folder newFile = new Folder(parent);
        parent.addChildren(newFile);
        newFile.setName(file);
        newFile.setFileSize(fileSize);
        newFile.setFile(true);
        return newFile;

    }

    public Folder newFolder(String folder,Folder parent){
        Folder newFolder = new Folder(parent);
        parent.addChildren(newFolder);
        newFolder.setName(folder);
        return newFolder;

    }
    public Folder processor() throws FileNotFoundException{
        Scanner sc = new Scanner(file);
        Folder root = new Folder();
        Folder currFolder = root;
        String currLine = "";
        currFolder.setName("/");
        sc.nextLine();
        while(sc.hasNextLine()){
            currLine = sc.next();
            if(currLine.charAt(0) == '$'){
                if(sc.next().equals("cd")){
                    currFolder = cd(sc.next(), currFolder);
                }
                if(sc.next().equals("ls")){
                    ls(currFolder, sc);
                }
            }
            
        }
        sc.close();
        return root;
    }

    public FileSystemGenerator(){}

}
