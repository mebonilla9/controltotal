/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorjweb.controltotal.negocio.delegados;

import com.jorjweb.controltotal.negocio.constantes.EMensajes;
import com.jorjweb.controltotal.negocio.excepciones.ControlTotalException;
import com.jorjweb.controltotal.persistencia.conexion.ConexionBD;
import com.jorjweb.controltotal.persistencia.dao.IGenericoDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lord_Nightmare
 */
public abstract class GenericoDelegado<T> {
    
    protected Connection cnn;
    protected IGenericoDao genericoDao;
    protected boolean confirmar = true;
    
    public GenericoDelegado() throws ControlTotalException{
        this.cnn = ConexionBD.conectar();
    }
    
    public GenericoDelegado(Connection cnn){
        this.cnn = cnn;
        this.confirmar = false;
    }
    
    public void insertar(T entidad) throws ControlTotalException{
        try {
            genericoDao.insertar(entidad);
            this.confirmar();
        } catch (Exception e) {
            ConexionBD.rollBack(cnn);
            e.printStackTrace(System.err);
            throw new ControlTotalException(EMensajes.ERROR_INSERTAR);
        } finally {
            this.desconectar();
        }
    }
    
    public void editar(T entidad) throws ControlTotalException{
        try {
            genericoDao.editar(entidad);
            this.confirmar();
        } catch (Exception e) {
            ConexionBD.rollBack(cnn);
            e.printStackTrace(System.err);
            throw new ControlTotalException(EMensajes.ERROR_MODIFICAR);
        } finally {
            this.desconectar();
        }
    }
    
    public List<T> consultar() throws ControlTotalException{
        try {
            return genericoDao.consultar();
        } catch (Exception e) {
            ConexionBD.rollBack(cnn);
            e.printStackTrace(System.err);
            throw new ControlTotalException(EMensajes.ERROR_CONSULTAR);
        } finally {
            this.desconectar();
        }
    }
    
    public T consultar(int id) throws ControlTotalException{
        try {
            return (T) genericoDao.consultar(id);
        } catch (Exception e) {
            ConexionBD.rollBack(cnn);
            e.printStackTrace(System.err);
            throw new ControlTotalException(EMensajes.ERROR_CONSULTAR);
        } finally {
            this.desconectar();
        }
    }

    protected void confirmar() throws SQLException {
        if (this.confirmar) {
            cnn.commit();
        }
    }
    
    protected void desconectar(){
        if (this.confirmar) {
            ConexionBD.desconectar(cnn);
        }
    }
    
}
