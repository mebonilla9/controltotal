/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorjweb.controltotal.negocio.servlets;

import com.jorjweb.controltotal.negocio.constantes.EAcciones;
import com.jorjweb.controltotal.negocio.constantes.EMensajes;
import com.jorjweb.controltotal.negocio.delegados.UsuarioDelegado;
import com.jorjweb.controltotal.negocio.excepciones.ControlTotalException;
import com.jorjweb.controltotal.negocio.utilidades.UrlUtil;
import com.jorjweb.controltotal.persistencia.entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lord_Nightmare
 */
@WebServlet(name = "UsuarioServlet",
        urlPatterns = {
            "/usuario/insertar",
            "/usuario/editar",
            "/usuario/consultar",
            "/usuario/buscar",
            "/login",
            "/usuario/contrasena"
        }
)
public class UsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // evaluar la Url del servlet recibido desde el cliente
            EAcciones accion = UrlUtil.getAccion(request.getServletPath());
            switch (accion) {
                case LOGIN:
                    iniciarSesion(request, response);
                    break;
                case INSERTAR:
                    break;
                case MODIFICAR:
                    break;
                case CONSULTAR:
                    break;
                case BUSCAR:
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (ControlTotalException e) {

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws ControlTotalException {
        Usuario usuarioLogin = new Usuario();
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        usuarioLogin.setCorreo(correo);
        usuarioLogin.setContrasena(contrasena);
        new UsuarioDelegado().consultarLogin(usuarioLogin);
        if (usuarioLogin.getIdUsuario() > 0) {
            try {
                HttpSession sesion = request.getSession();
                sesion.setAttribute("idusuario", usuarioLogin.getIdUsuario());
                sesion.setAttribute("nombre", usuarioLogin.getNombre());
                response.sendRedirect("home.jsp");
            } catch (IOException ex) {
                throw new ControlTotalException(EMensajes.ERROR_URL_INVALIDA);
            }
            return;
        }
        request.setAttribute("errorlogin", "Usuario no encontrado intente nuevamente");
    }

}
