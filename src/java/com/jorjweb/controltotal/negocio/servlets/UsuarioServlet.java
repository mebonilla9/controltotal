/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorjweb.controltotal.negocio.servlets;

import com.google.gson.Gson;
import com.jorjweb.controltotal.negocio.constantes.EAcciones;
import com.jorjweb.controltotal.negocio.constantes.EMensajes;
import com.jorjweb.controltotal.negocio.delegados.UsuarioDelegado;
import com.jorjweb.controltotal.negocio.excepciones.ControlTotalException;
import com.jorjweb.controltotal.negocio.utilidades.UrlUtil;
import com.jorjweb.controltotal.persistencia.dto.RespuestaDto;
import com.jorjweb.controltotal.persistencia.entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
            "/home",
            "/usuario/contrasena",
            "/prueba/html"
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
        response.setContentType("application/json");
        response.addHeader("Access-Control-Allow-Origin", "*");
        RespuestaDto respuesta = null;
        try (PrintWriter out = response.getWriter()) {
            try {// evaluar la Url del servlet recibido desde el cliente
                EAcciones accion = UrlUtil.getAccion(request.getServletPath());
                switch (accion) {
                    case LOGIN:
                        iniciarSesion(request, response);
                        respuesta = new RespuestaDto(EMensajes.CONSULTO);
                        break;
                    case INSERTAR:
                        this.insertarUsuario(request);
                        respuesta = new RespuestaDto(EMensajes.INSERTO);
                        break;
                    case MODIFICAR:
                        this.editarUsuario(request);
                        respuesta = new RespuestaDto(EMensajes.MODIFICO);
                        break;
                    case CONSULTAR:
                        respuesta = new RespuestaDto(EMensajes.CONSULTO, this.consultarUsuarios());
                        break;
                    case BUSCAR:
                        respuesta = new RespuestaDto(EMensajes.CONSULTO, this.consultarUsuario(request,response));
                        break;
                    default:
                        response.setContentType("text/html");
                        if (request.getSession().getAttribute("nombre") != null) {
                            request.getRequestDispatcher("/home.jsp").forward(request, response);
                            return;
                        }
                        request.getRequestDispatcher("/").forward(request, response);
                        break;
                }
            } catch (ControlTotalException e) {
                respuesta = new RespuestaDto();
                respuesta.setCodigo(e.getCodigo());
                respuesta.setMensaje(e.getMensaje());
            }
            out.print(new Gson().toJson(respuesta));
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
            HttpSession sesion = request.getSession();
            sesion.setAttribute("idusuario", usuarioLogin.getIdUsuario());
            sesion.setAttribute("nombre", usuarioLogin.getNombre());
            return;
        }
        throw new ControlTotalException(EMensajes.ERROR_LOGIN);
    }

    private void insertarUsuario(HttpServletRequest request) throws ControlTotalException {
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        String estado = request.getParameter("estado");
        Usuario usuarioRegistrar = new Usuario();
        usuarioRegistrar.setNombre(nombre);
        usuarioRegistrar.setCorreo(correo);
        usuarioRegistrar.setContrasena(contrasena);
        usuarioRegistrar.setEstado(Boolean.parseBoolean(estado));
        new UsuarioDelegado().insertar(usuarioRegistrar);
    }

    private List<Usuario> consultarUsuarios() throws ControlTotalException {
        return new UsuarioDelegado().consultar();
    }

    private Usuario consultarUsuario(HttpServletRequest request, HttpServletResponse response) throws ControlTotalException {
        String idUsuario = request.getParameter("idUsuario");
        Usuario usuario = new UsuarioDelegado().consultar(Integer.parseInt(idUsuario));
        return usuario;
    }

    private void editarUsuario(HttpServletRequest request) throws ControlTotalException {
        String idUsuario = request.getParameter("idUsuario");
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        String estado = request.getParameter("estado");
        Usuario usuarioRegistrar = new Usuario();
        usuarioRegistrar.setIdUsuario(Integer.parseInt(idUsuario));
        usuarioRegistrar.setNombre(nombre);
        usuarioRegistrar.setCorreo(correo);
        usuarioRegistrar.setContrasena(contrasena);
        usuarioRegistrar.setEstado(Boolean.parseBoolean(estado));
        new UsuarioDelegado().editar(usuarioRegistrar);
    }

}
