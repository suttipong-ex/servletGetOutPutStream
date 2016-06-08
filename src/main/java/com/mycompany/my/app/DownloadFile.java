/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author suttipong
 */
public class DownloadFile extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("name");
        String pathName = "/home/suttipong/Downloads/"+fileName;// Source path file
        resp.setHeader("Content-disposition","attachment; filename="+"copy_"+fileName);// Dest in Downloads file
        Cookie userCookie = new Cookie("ex","1234");
        resp.addCookie(userCookie);
        resp.addCookie(new Cookie("G6", "bb"));
        
        File file = new File(pathName);
        try(OutputStream out = resp.getOutputStream();
                FileInputStream in = new FileInputStream(file);
                    AutoClose autoClose = new AutoClose()){
                        byte[] buffer = new byte[1024];
                        int length = 0;
                        length = in.read(buffer);
                        while(length != -1){
                            out.write(buffer, 0, length);
                            out.flush();
                            length = in.read(buffer);
                        }
                        //Autoclse here 
        }catch (Exception e){
            System.out.println("An error accured!");
        }finally{
            System.out.println("Finlly try catch");
        }
        
    }
 
}
