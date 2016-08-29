/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorjweb.controltotal.negocio.utilidades;

import com.jorjweb.controltotal.negocio.constantes.EAcciones;
import java.util.regex.Pattern;

/**
 *
 * @author Lord_Nightmare
 */
public class UrlUtil {
    
    private static String getURLAccion(String url){
        String[] partes = url.split(Pattern.quote("/"));
        String accion = "/" + partes[partes.length-1];
        return accion;
    }
    
    public static EAcciones getAccion(String url){
        return EAcciones.parse(getURLAccion(url));
    }
    
}
