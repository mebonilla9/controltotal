/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorjweb.controltotal.negocio.filtros;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Lord_Nightmare
 */
@WebFilter(filterName = "/filtrovisitas", urlPatterns = "/*")
public class FiltroVisitas implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest peticion = (HttpServletRequest) request;
        // objeto almacenamiento de valores Application
        ServletContext contexto = peticion.getServletContext();
        HashMap<String, Integer> urls;

        if (contexto.getAttribute("visitas") == null) {
            urls = new HashMap<>();
            urls.put(peticion.getRequestURL().toString(), 1);
            contexto.setAttribute("visitas", urls);
        }

        if (contexto.getAttribute("visitas") != null) {
            urls = (HashMap<String, Integer>) contexto.getAttribute("visitas");

            if (urls.get(peticion.getRequestURL().toString()) == null) {
                urls.put(peticion.getRequestURL().toString(), 1);
            } else {
                urls.put(peticion.getRequestURL().toString(), urls.get(peticion.getRequestURL().toString())+1);
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
