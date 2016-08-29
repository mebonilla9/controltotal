/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorjweb.controltotal.negocio.delegados;

import com.jorjweb.controltotal.negocio.excepciones.ControlTotalException;
import com.jorjweb.controltotal.persistencia.dao.UsuarioDao;
import com.jorjweb.controltotal.persistencia.entidades.Usuario;
import java.sql.Connection;

/**
 *
 * @author Lord_Nightmare
 */
public class UsuarioDelegado extends GenericoDelegado<Usuario>{
    
    private final UsuarioDao usuarioDao;

    public UsuarioDelegado() throws ControlTotalException {
        usuarioDao = new UsuarioDao(cnn);
        genericoDao = usuarioDao;
    }

    public UsuarioDelegado(Connection cnn) {
        super(cnn);
        usuarioDao = new UsuarioDao(cnn);
        genericoDao = usuarioDao;
    }
    
    public void consultarLogin(Usuario usuarioLogin) throws ControlTotalException{
        new UsuarioDao(cnn).consultar(usuarioLogin);
    }
    
    
    
}
