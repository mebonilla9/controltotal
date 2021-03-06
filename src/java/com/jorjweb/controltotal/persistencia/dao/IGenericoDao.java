/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorjweb.controltotal.persistencia.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lord_Nightmare
 */
public interface IGenericoDao<T> {
    
    public abstract void insertar(T entidad) throws SQLException;
    public abstract void editar(T entidad) throws SQLException;
    public List<T> consultar() throws SQLException;
    public T consultar(int id) throws SQLException;
    
}
