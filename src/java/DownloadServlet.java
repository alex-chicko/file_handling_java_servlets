/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.MyFileDao;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelMyfile.MyFile;

/**
 *
 * @author ALEX
 */
public class DownloadServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        MyFileDao myFileDao = new MyFileDao();
        MyFile file = myFileDao.getById(Integer.parseInt(request.getParameter("id")));

//        System.out.println(file.getFilename());
        
        InputStream inputStream = null;
        
        
        try {
            //Get inputstream from blob
            inputStream = file.getThefileasblob().getBinaryStream();
        } catch (SQLException ex) {
            Logger.getLogger(DownloadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setHeader("Content-disposition", "attachment; filename="+ file.getFilename());
        ServletContext context = getServletContext();
                  String mimeType = context.getMimeType(file.getFilename());
                if (mimeType == null) {        
                    mimeType = "application/octet-stream";
                }
                OutputStream outStream = response.getOutputStream();
                 response.setContentType(mimeType);
                byte[] buffer = new byte[4096];
                int bytesRead;
                 
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    //send responce to browser
                    outStream.write(buffer, 0, bytesRead);
                }
                 
                inputStream.close();
                outStream.close(); 
        
    

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
