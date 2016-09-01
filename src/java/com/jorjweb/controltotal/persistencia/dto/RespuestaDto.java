/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorjweb.controltotal.persistencia.dto;

import com.jorjweb.controltotal.negocio.constantes.EMensajes;

/**
 *
 * @author Lord_Nightmare
 */
public class RespuestaDto {
    
    private int codigo;
    private String mensaje;
    private Object datos;

    public RespuestaDto() {
    }
    
    public RespuestaDto(EMensajes mensaje) {
        this.codigo = mensaje.getCodigo();
        this.mensaje = mensaje.getDescripcion();
    }
    public RespuestaDto(EMensajes mensaje, Object datos) {
        this.codigo = mensaje.getCodigo();
        this.mensaje = mensaje.getDescripcion();
        this.datos = datos;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the datos
     */
    public Object getDatos() {
        return datos;
    }

    /**
     * @param datos the datos to set
     */
    public void setDatos(Object datos) {
        this.datos = datos;
    }
    
}
