/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorjweb.controltotal.persistencia.conexion;

import com.jorjweb.controltotal.negocio.constantes.EMensajes;
import com.jorjweb.controltotal.negocio.excepciones.ControlTotalException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Lord_Nightmare
 */
public class ConexionBD {
    
    public static Connection conectar() throws ControlTotalException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/control_total", "root", "1234");
            cnn.setAutoCommit(false);
            return cnn;
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace(System.err);
            throw new ControlTotalException(EMensajes.ERROR_CONEXION_BD);
        } 
        
    }
    
    public static void desconectar(Connection cnn){
        desconectar(cnn, null);
    }
    
    public static void desconectar(PreparedStatement ps){
        desconectar(null,ps);
    }
    
    private static void desconectar(Connection cnn, PreparedStatement ps){
        try {
            if (ps != null) {
                ps.close();
            }
            if (cnn != null) {
                cnn.close();
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    
    public static void rollBack(Connection cnn){
        try {
            cnn.rollback();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    
}
