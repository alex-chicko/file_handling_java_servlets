/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelMyfile.MyFile;
import util.DConn;

/**
 *
 * @author ALEX
 */
public class MyFileDao {
    
    public void deleteFile(int id ){
//        MyFile mf = new MyFile();
        String sql = "DELETE FROM files WHERE id=?";
        
        Connection conn = DConn.getConnection();
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MyFileDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conn.close();;
            } catch (SQLException ex) {
                Logger.getLogger(MyFileDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    }
    
    public MyFile getById(int id){
        MyFile myfile = new MyFile();
        String sql = "SELECT * FROM files where id=?";
        
        Connection con = DConn.getConnection();
        
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                myfile.setId(rs.getInt(3));
                myfile.setFilename(rs.getString(1));
                myfile.setThefileasblob(rs.getBlob(2));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MyFileDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();;
            } catch (SQLException ex) {
                Logger.getLogger(MyFileDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        return myfile;
    }
    
   
    
    
    public List<MyFile> getFiles(){
        
        List myfiles = new ArrayList<>();
        
        Connection con = DConn.getConnection();
        
        try {
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery("SELECT * FROM files");
            
            while(rs.next()){
                MyFile f = new MyFile();
                f.setFilename(rs.getNString(1));
                f.setThefileasblob(rs.getBlob(2));
                f.setId(rs.getInt(3));
                myfiles.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyFileDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();;
            } catch (SQLException ex) {
                Logger.getLogger(MyFileDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        return myfiles;
        
    }
    }
}
