/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Utility;

import com.mycompany.model.VentaDAO;

/**
 *
 * @author krate
 */
public class Demo {
    private VentaDAO dao;
    public Demo(){
        dao=new VentaDAO();
    }
    public boolean verificarRegistros(){
        int reg=dao.obtenerTotalRegistros();
        if(reg<5){
            return true;
        }
        return false;
    }
}
