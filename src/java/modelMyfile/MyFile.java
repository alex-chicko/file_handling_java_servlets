package modelMyfile;


import java.sql.Blob;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ALEX
 */
public class MyFile {
    
    
    private int id;
    private String filename;
    private byte[] thefile;
    private Blob thefileasblob;

    public MyFile() {
    }

    public MyFile(int id, String filename, byte[] thefile, Blob thefileasblob) {
        this.id = id;
        this.filename = filename;
        this.thefile = thefile;
        this.thefileasblob = thefileasblob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public byte[] getThefile() {
        return thefile;
    }

    public void setThefile(byte[] thefile) {
        this.thefile = thefile;
    }

    public Blob getThefileasblob() {
        return thefileasblob;
    }

    public void setThefileasblob(Blob thefileasblob) {
        this.thefileasblob = thefileasblob;
    }
    
    
    
    
}
