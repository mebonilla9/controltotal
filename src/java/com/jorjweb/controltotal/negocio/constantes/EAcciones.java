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
public enum EAcciones {
    
    LOGIN("/login"),
    LOGIN_REMOTO("/rmlogin"),
    INSERTAR("/insertar"),
    MODIFICAR("/editar"),
    CONSULTAR("/consultar"),
    BUSCAR("/buscar"),
    NO_EXISTE("La url solicitada no existe");
    
    private String accion;

    private EAcciones(String accion) {
        this.accion = accion;
    }
    
    /**
     * @return the accion
     */
    public String getAccion() {
        return accion;
    }

    /**
     * @param accion the accion to set
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }
    
    public static EAcciones parse(String accion){
        EAcciones[] acciones = values();
        for (EAcciones accione : acciones) {
            if (accione.getAccion().equalsIgnoreCase(accion)) {
                return accione;
            }
        }
        return EAcciones.NO_EXISTE;
    }
    
    
}
