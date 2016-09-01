/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorjweb.controltotal.negocio.constantes;

/**
 *
 * @author Lord_Nightmare
 */
public enum EMensajes {
    
    INSERTO(1,"Se insertó correctamente"),
    MODIFICO(1,"Se modificó correctamente"),
    CONSULTO(1,"Se consultó correctamente"),
    ELIMINO(1,"Se eliminó correctamente"),
    NO_RESULTADOS(0,"No se encontraron registros"),
    ERROR_INSERTAR(-1,"Error al insertar el registro"),
    ERROR_MODIFICAR(-1,"Error al modificar el registro"),
    ERROR_CONSULTAR(-1,"Error al consultar el registro"),
    ERROR_ELIMINAR(-1,"Error al eliminar el registro"),
    ERROR_REGISTRO_EXISTE(-1,"El registro ya existe"),
    ERROR_CONEXION_BD(-2,"No hay conexion con la base de datos"),
    ERROR_URL_INVALIDA(404,"El recurso al que intenta acceder no existe"),
    ERROR_LOGIN(-1,"Usuario no encontrado, verifique su usuario y contraseña");
    
    private int codigo;
    private String descripcion;

    private EMensajes(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
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
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    
}
