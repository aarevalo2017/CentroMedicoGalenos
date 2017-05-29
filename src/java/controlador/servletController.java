/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ejb.PacienteFacade;
import modelo.entity.Paciente;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author aleja
 */
public class servletController extends HttpServlet {

    @EJB
    private PacienteFacade pacienteFacade;

    private String url;
    private String msg;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("max-age", 0);
        response.setDateHeader("Expires", 0);
        String accion = request.getParameter("accion").toLowerCase();
        switch (accion) {
            case "autpaciente":
                loginPaciente(request, response);
                break;
            case "logout":
                cerrarSesion(request, response);
                break;
            default:
                break;
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

    private void loginPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String rut = request.getParameter("rut");
            String pass = DigestUtils.md5Hex(request.getParameter("pass"));
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            Character dv = rut.charAt(rut.length() - 1);
            rut = rut.substring(0, rut.length() - 1);
            Paciente p = pacienteFacade.getByRut(Integer.parseInt(rut));
            if (p != null && p.getDv().equals(dv.toString()) && p.getHashPass().equals(pass)) {
                url = "homePaciente.jsp";
                request.getSession().setAttribute("nombre", p.getNombres() + " " + p.getApePaterno() + " " + p.getApeMaterno());
                request.getSession().setAttribute("rut", p.getRut() + "-" + p.getDv());
            } else {
                url = "loginPaciente.jsp";
                msg = "Rut o Contraseña incorrectos.";
            }
        } catch (NumberFormatException e) {
            url = "loginPaciente.jsp";
            msg = "Error : " + e.getMessage();
        } finally {
            request.setAttribute("msg", msg);
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("nombre");
        request.getSession().removeAttribute("rut");
        request.getSession().invalidate();
        response.sendRedirect("loginPaciente.jsp");
    }

}
