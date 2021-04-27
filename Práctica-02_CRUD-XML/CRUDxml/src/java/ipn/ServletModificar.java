/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipn;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author erick
 */
public class ServletModificar extends HttpServlet {

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

            String path = request.getRealPath("/");

            // Obtener el id de la pregunta y los parámetros del formulario.            
            int idPregunta = Integer.parseInt((String) request.getSession().getAttribute("idProblema"));

            String nombrePregunta = request.getParameter("nombrePregunta");
            String pregunta = request.getParameter("pregunta");
            String respuesta = request.getParameter("respuesta");

            String drag1 = request.getParameter("drag1");
            String drag2 = request.getParameter("drag2");
            String drag3 = request.getParameter("drag3");
            String drag4 = request.getParameter("drag4");

            List<String> dragList = new ArrayList<String>() {
                {
                    add(drag1);
                    add(drag2);
                    add(drag3);
                    add(drag4);
                }
            };
            
            String drag1Text = request.getParameter("drag1Text");
            String drag2Text = request.getParameter("drag2Text");
            String drag3Text = request.getParameter("drag3Text");
            String drag4Text = request.getParameter("drag4Text");

            List<String> dragTextList = new ArrayList<String>() {
                {
                    add(drag1Text);
                    add(drag2Text);
                    add(drag3Text);
                    add(drag4Text);
                }
            };            

            String target1 = request.getParameter("target1");
            String target2 = request.getParameter("target2");
            String target3 = request.getParameter("target3");
            String target4 = request.getParameter("target4");

            List<String> targetList = new ArrayList<String>() {
                {
                    add(target1);
                    add(target2);
                    add(target3);
                    add(target4);
                }
            };            
            
            String target1Text = request.getParameter("target1Text");
            String target2Text = request.getParameter("target2Text");
            String target3Text = request.getParameter("target3Text");
            String target4Text = request.getParameter("target4Text");

            List<String> targetTextList = new ArrayList<String>() {
                {
                    add(target1Text);
                    add(target2Text);
                    add(target3Text);
                    add(target4Text);
                }
            };

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Principal</title>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container p-2'>");

            try {
                SAXBuilder builder = new SAXBuilder();
                File xmlFile = new File(path + "pregunta.xml");
                Document doc = (Document) builder.build(xmlFile);
                Element rootNode = doc.getRootElement();

                List listaPreguntas = rootNode.getChildren("PREGUNTA");

                Element elementPregunta = (Element) listaPreguntas.get(idPregunta);

                // Reemplazar TEXTO y RESPUESTA
                elementPregunta.getAttribute("TEXTO").setValue(nombrePregunta);
                elementPregunta.getAttribute("RESPUESTA").setValue(respuesta);

                System.out.println(elementPregunta.getAttributeValue("TEXTO"));

                Element drag = elementPregunta.getChild("DRAGS");
                List dragOptionList = drag.getChildren("OPCION");

                for (int j = 0; j < dragOptionList.size(); j++) {
                    Element dragOptionElement = (Element) dragOptionList.get(j);
                    dragOptionElement.getAttribute("IMAGEN").setValue(dragList.get(j));
                    dragOptionElement.setText(dragTextList.get(j));
                }

                Element target = elementPregunta.getChild("TARGETS");
                List targetOptionList = target.getChildren("OPCION");
                for (int k = 0; k < dragOptionList.size(); k++) {
                    Element targetOptionElement = (Element) targetOptionList.get(k);
                    targetOptionElement.getAttribute("IMAGEN").setValue(dragList.get(k));
                    targetOptionElement.setText(targetTextList.get(k));
                }

                // Save the updated document.
                XMLOutputter xml = new XMLOutputter();
                xml.setFormat(Format.getPrettyFormat());
                FileWriter fw = new FileWriter(path + "pregunta.xml");
                xml.output(doc, fw);

                out.println("<button class=\"btn \"><a href='ServletPrincipal'>Volver al inicio</a></button>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            } catch (IOException io) {
                System.out.println(io.getMessage());
            } catch (JDOMException jdomex) {
                System.out.println(jdomex.getMessage());
            }

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
