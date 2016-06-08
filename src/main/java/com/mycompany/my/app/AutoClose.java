/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.app;

/**
 *
 * @author suttipong
 */
public class AutoClose implements AutoCloseable{

    @Override
    public void close() throws Exception {
        System.out.println("Steam is closed");
    }
    
}
