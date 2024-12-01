package src.main.senior.day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

import src.main.senior.day7.Folder;

public class FileSystemGenerator {
    private File file;
    private Folder[] toSum = new Folder[200];
    private int toSumSize = 0;

    public Folder cd(String folder,Folder currFolder){
        if(currFolder == null){
            return currFolder;
        }
        Folder newFolder =currFolder.getChildren(folder);
        if(folder.equals("..")){
            //System.out.println("went to : " + currFolder.getParent().getName());
            return currFolder.getParent();
        }else if(newFolder == null){
            return newFolder(folder,currFolder);
        }else{
            //System.out.println("went to : " + newFolder.getName());
            return newFolder;
        }
    }

    public void ls(Folder currFolder, Scanner sc){
        String currString = sc.next();
        int fileSize;
        ////System.out.println(currString);
        while(!currString.equals("$")){
            if(currString.equals("dir")){
                currString = sc.next();
                //System.out.println("dir: " + currString);
                newFolder(currString, currFolder);
            }else{
                fileSize = Integer.parseInt(currString);
                //currFolder.addToTotalSize(fileSize);
                currString = sc.next();
                //System.out.println("file: " + currString);
                newFile(currString, fileSize, currFolder);
            }
            if(sc.hasNext()){
                currString = sc.next();
                //System.out.println("ls: " + currString);
            }else{
                return;
            }
                
        }
    }

    public Folder newFile(String file,int fileSize,Folder parent){
        Folder newFile = new Folder(parent);
        parent.addChildren(newFile);
        parent.addToTotalSize(fileSize);
        Folder elder = parent;
        while(elder.getParent() != null){
            elder = elder.getParent();
            elder.addToTotalSize(fileSize);
        }
        newFile.setName(file);
        newFile.setFileSize(fileSize);
        newFile.setFile(true);
        return newFile;

    }

    public Folder newFolder(String folder,Folder parent){
        Folder newFolder = new Folder(parent);
        parent.addChildren(newFolder);
        //System.out.println("made folder: " + folder);
        newFolder.setName(folder);
        toSum[toSumSize] = newFolder;
        newFolder.setLocation(toSumSize);
        toSumSize++;
        return newFolder;

    }
    public int scorer(){
        int score = 0;
        for(int i = 0; i< toSumSize; i++){
            if(toSum[i].getTotSize() <= 100000){
                score += toSum[i].getTotSize();
            }
        }
        return score;
    }

    /* public int total_scorer(){
        int score = 0;
        for(int i = 0; i< toSumSize; i++){
            score += toSum[i].getTotSize();
        }
        return score;
    } */

    public int toDelete(Folder root){
        int score = root.getTotSize();
        int free = 70000000 - score;
        int toDelete = 30000000 - free;
        Folder toExecute = new Folder();
        toExecute.setTotSize(2000000000);
        for(int i = 1; i< toSumSize; i++){
            System.out.println(toExecute.getTotSize() + " > " + toSum[i].getTotSize() + " > " + toDelete);
            if(toSum[i].getTotSize()> toDelete 
                && toSum[i].getTotSize()<toExecute.getTotSize()){
                    toExecute = toSum[i];
                    System.out.println("to kill: " + toExecute.getTotSize());
            }
            
        }

        return toExecute.getTotSize();
        //return toExecute.getTotSize();
    }

    public Folder processor() throws FileNotFoundException{
        Scanner sc = new Scanner(file);
        Folder root = new Folder();
        Folder currFolder = root;
        String currLine = "";
        currFolder.setName("/");
        sc.nextLine();
        while(sc.hasNextLine()){
            ////System.out.println(currFolder.getName());
            currLine = sc.next();
            //String chooser = sc.next();
            //System.out.println(currLine);
            if(currLine.equals("cd")){
                //System.out.println("\ncd+++++++++\n");
                currFolder = cd(sc.next(), currFolder);
            }
            if(currLine.equals("ls")){
                //System.out.println("\nls++++++++++\n");
                ls(currFolder, sc);
            }
            
            
        }
        toDelete(root);
        sc.close();
        return root;
    }

    public FileSystemGenerator(){}
    public FileSystemGenerator(File file){this.file = file;}

}
