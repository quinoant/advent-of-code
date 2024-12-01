package src.main.senior.day7;

public class Folder {
    private Folder parent;
    private String name;
    private Folder[] children;
    private boolean file;
    private int fileSize;
    private int numChildren;
    private int totSize;
    private int location;
    

    
    

    
    public Folder(){
        this.children = new Folder[30];
        this.file = false;
    }
    public Folder(Folder parent){
        this.parent = parent;
        this.children = new Folder[30];
        this.file = false;
    }

    public String[] getChildren(){
        String[] toRet = new String[numChildren];
        for(int i = 0; i < numChildren; i++){
            toRet[i] = children[i].getName();
        }
        return toRet;
    }

    public Folder getParent() {
        return parent;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setParent(Folder parent) {
        this.parent = parent;
    }

    public void addChildren(Folder child) {
        this.children[numChildren] = child;
        numChildren++;
    }

    /* private boolean equals(Folder toCheck){
        if(this.name.equals(toCheck.name)){
            return true;
        }
        return false;
    } */

    public Folder getChildren(String toChk){
        for(int i = 0; i < numChildren;i++){
            if(children[i].getName().equals(toChk)){
                return children[i];
            }
        }
        return null;
    }
    
    public boolean isFile() {
        return file;
    }

    public void setFile(boolean file) {
        this.file = file;
    }

    
    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
        this.totSize = fileSize;
    }

    public int getNumChildren() {
        return numChildren;
    }
    public void setNumChildren(int numChildren) {
        this.numChildren = numChildren;
    }

    public int getTotSize() {
        return totSize;
    }

    public void setTotSize(int totSize) {
        this.totSize = totSize;
    }

    public void addToTotalSize(int toAdd){
        this.totSize += toAdd;
    }

    public int getLocation() {
        return location;
    }
    
    public void setLocation(int location) {
        this.location = location;
    }
    
}
