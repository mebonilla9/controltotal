/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorjweb.controltotal.persistencia.dao;

import com.jorjweb.controltotal.negocio.constantes.EMensajes;
import com.jorjweb.controltotal.negocio.excepciones.ControlTotalException;
import com.jorjweb.controltotal.persistencia.conexion.ConexionBD;
import com.jorjweb.controltotal.persistencia.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lord_Nightmare
 */
public class UsuarioDao implements IGenericoDao<Usuario> {

    private final int ID = 1;
    private final Connection cnn;

    public UsuarioDao(Connection cnn) {
        this.cnn = cnn;
    }

    @Override
    public void insertar(Usuario entidad) throws SQLException {
        PreparedStatement sentencia = null;
        try {
            String sql = "INSERT INTO usuario (nombre,correo,estado,contrasena) VALUES(?,?,?,?);";
            sentencia = cnn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            sentencia.setString(1, entidad.getNombre());
            sentencia.setString(2, entidad.getCorreo());
            sentencia.setBoolean(3, entidad.isEstado());
            sentencia.setString(4, entidad.getContrasena());
            sentencia.executeUpdate();
            ResultSet resultado = sentencia.getGeneratedKeys();
            if (resultado.next()) {
                entidad.setIdUsuario(resultado.getInt(ID));
            }
        } finally {
            ConexionBD.desconectar(sentencia);
        }
    }

    @Override
    public void editar(Usuario entidad) throws SQLException {
        PreparedStatement sentencia = null;
        try {
            String sql = "UPDATE usuario SET nombre = ?, correo = ?, estado = ?, contrasena = ? WHERE id_usuario = ?;";
            sentencia = cnn.prepareStatement(sql);
            sentencia.setString(1, entidad.getNombre());
            sentencia.setString(2, entidad.getCorreo());
            sentencia.setBoolean(3, entidad.isEstado());
            sentencia.setString(4, entidad.getContrasena());
            sentencia.setInt(5, entidad.getIdUsuario());
            sentencia.executeUpdate();
        } finally {
            ConexionBD.desconectar(sentencia);
        }
    }

    @Override
    public List<Usuario> consultar() throws SQLException {
        List<Usuario> listaUsuarios = new ArrayList<>();
        PreparedStatement sentencia = null;
        try {
            String sql = "SELECT * FROM usuario;";
            sentencia = cnn.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                Usuario usuarioRecibido = new Usuario();
                usuarioRecibido.setIdUsuario(resultado.getInt("id_usuario"));
                usuarioRecibido.setNombre(resultado.getString("nombre"));
                usuarioRecibido.setCorreo(resultado.getString("correo"));
                usuarioRecibido.setContrasena(resultado.getString("contrasena"));
                usuarioRecibido.setEstado(resultado.getBoolean("estado"));
                listaUsuarios.add(usuarioRecibido);
            }
        } finally {
            ConexionBD.desconectar(sentencia);
        }
        return listaUsuarios;
    }

    @Override
    public Usuario consultar(int id) throws SQLException {
        Usuario usuarioRecibido = new Usuario();
        PreparedStatement sentencia = null;
        try {
            String sql = "SELECT * FROM usuario WHERE id_usuario = ?;";
            sentencia = cnn.prepareStatement(sql);
            sentencia.setInt(1, id);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                usuarioRecibido.setIdUsuario(resultado.getInt("id_usuario"));
                usuarioRecibido.setNombre(resultado.getString("nombre"));
                usuarioRecibido.setCorreo(resultado.getString("correo"));
                usuarioRecibido.setContrasena(resultado.getString("contrasena"));
                usuarioRecibido.setEstado(resultado.getBoolean("estado"));
            }
        } finally {
            ConexionBD.desconectar(sentencia);
        }
        return usuarioRecibido;
    }

    public void consultar(Usuario entidad) throws ControlTotalException {
        PreparedStatement sentencia = null;
        try {
            String sql = "SELECT * FROM usuario WHERE nombre = ? AND contrasena = ?;";
            sentencia = cnn.prepareStatement(sql);
            sentencia.setString(1, entidad.getNombre());
            sentencia.setString(2, entidad.getContrasena());
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                entidad.setIdUsuario(resultado.getInt("id_usuario"));
                entidad.setNombre(resultado.getString("nombre"));
                entidad.setCorreo(resultado.getString("correo"));
                entidad.setContrasena(resultado.getString("contrasena"));
                entidad.setEstado(resultado.getBoolean("estado"));
            }
        } catch (Exception e) {
            throw new ControlTotalException(EMensajes.ERROR_CONSULTAR);

        } finally {
            ConexionBD.desconectar(sentencia);
        }
    }

}
