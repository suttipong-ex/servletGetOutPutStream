/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 

/**
 *
 * @author suttipong
 */
public class HomeWorkServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
        int b;
        String str;
        String name = req.getParameter("name");
        String pathStr = "/home/suttipong/Downloads/"+name;
        File file = new File(pathStr);   
        InputStream input = new FileInputStream(file);
        InputStreamReader inRead = new InputStreamReader(input);
        BufferedReader is = new BufferedReader(inRead);
//        while((b = inRead.read()) != -1){
//               // resp.getWriter().append((char)b);  
//               // resp.getOutputStream().print(b);
//               resp.getOutputStream().print(str);
//        }
        while((str = is.readLine()) != null){
                resp.getOutputStream().print(str);
        }
        OutputStream out = resp.getOutputStream();
        byte[] buffer = new byte[4096];
        int length;
        while((length = input.read(buffer)) > 0){
            out.write(buffer,0,length);
        }
        input.close();
        out.flush();        
    }
    
}
