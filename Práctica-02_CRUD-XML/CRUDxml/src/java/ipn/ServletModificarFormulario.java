/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipn;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author erick
 */
public class ServletModificarFormulario extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String idProblema = request.getParameter("idProblema");
            request.getSession().setAttribute("idProblema", idProblema);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Principal</title>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<body>");

            out.println("    <form method='get' action='ServletModificar'>\n"
                    + "      <div class=\"container mb-2\">\n"
                    + "        <h2>Ingrese los nuevos datos de la pregunta #" + (Integer.parseInt(idProblema) + 1) + "</h2>\n"
                    + "\n"
                    + "        <div class=\"mb-2\">\n"
                    + "          <label class=\"form-label\">Nombre de la pregunta</label>\n"
                    + "          <input type=\"text\" name=\"nombrePregunta\" class=\"form-control\" />\n"
                    + "        </div>\n"
                    + "        <div class=\"mb-2\">\n"
                    + "          <label class=\"form-label\">Pregunta</label>\n"
                    + "          <input type=\"text\" name=\"pregunta\" class=\"form-control\" />\n"
                    + "        </div>\n"
                    + "        <div class=\"mb-2\">\n"
                    + "          <label class=\"form-label\">Respuesta</label>\n"
                    + "          <input type=\"text\" name=\"respuesta\" class=\"form-control\" />\n"
                    + "        </div>\n"
                    + "        <!-- Drags -->\n"
                    + "        <h3>Drags</h3>\n"
                    + "        <div class=\"mb-2\">\n"
                    + "          <label class=\"form-label\">Drag opción 1</label>\n"
                    + "          <input type=\"text\" name=\"drag1Text\" class=\"form-control\" />\n"
                    + "          <input type=\"file\" name=\"drag1\" class=\"form-control\" />\n"
                    + "        </div>\n"
                    + "        <div class=\"mb-2\">\n"
                    + "          <label class=\"form-label\">Drag opción 2</label>\n"
                    + "          <input type=\"text\" name=\"drag2Text\" class=\"form-control\" />\n"
                    + "          <input type=\"file\" name=\"drag2\" class=\"form-control\" />\n"
                    + "        </div>\n"
                    + "        <div class=\"mb-2\">\n"
                    + "          <label class=\"form-label\">Drag opción 3</label>\n"
                    + "          <input type=\"text\" name=\"drag3Text\" class=\"form-control\" />\n"
                    + "          <input type=\"file\" name=\"drag3\" class=\"form-control\" />\n"
                    + "        </div>\n"
                    + "        <div class=\"mb-2\">\n"
                    + "          <label class=\"form-label\">Drag opción 4</label>\n"
                    + "          <input type=\"text\" name=\"drag4Text\" class=\"form-control\" />\n"
                    + "          <input type=\"file\" name=\"drag4\" class=\"form-control\" />\n"
                    + "        </div>\n"
                    + "        <!-- Targets -->\n"
                    + "\n"
                    + "        <h3>Targets</h3>\n"
                    + "        <div class=\"mb-2\">\n"
                    + "          <label class=\"form-label\">Target opción 1</label>\n"
                    + "          <input type=\"text\" name=\"target1Text\" class=\"form-control\" />\n"
                    + "          <input type=\"file\" name=\"target1\" class=\"form-control\" />\n"
                    + "        </div>\n"
                    + "        <div class=\"mb-2\">\n"
                    + "          <label class=\"form-label\">Target opción 2</label>\n"
                    + "          <input type=\"text\" name=\"target2Text\" class=\"form-control\" />\n"
                    + "          <input type=\"file\" name=\"target2\" class=\"form-control\" />\n"
                    + "        </div>\n"
                    + "        <div class=\"mb-2\">\n"
                    + "          <label class=\"form-label\">Target opción 3</label>\n"
                    + "          <input type=\"text\" name=\"target3Text\" class=\"form-control\" />\n"
                    + "          <input type=\"file\" name=\"target3\" class=\"form-control\" />\n"
                    + "        </div>\n"
                    + "        <div class=\"mb-2\">\n"
                    + "          <label class=\"form-label\">Target opción 4</label>\n"
                    + "          <input type=\"text\" name=\"target4Text\" class=\"form-control\" />\n"
                    + "          <input type=\"file\" name=\"target4\" class=\"form-control\" />\n"
                    + "        </div>\n"
                    + "\n"
                    + "        <button type=\"submit\" class=\"btn btn-primary\">Submit</button>\n"
                    + "    </form>\n"
                    + "</div>");

            out.println("</body>");
            out.println("</html>");

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

}
