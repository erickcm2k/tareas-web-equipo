package Api;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> 898181897685becb3c8b4b64e2ac0ee01d6e13df
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author erick
 */
public class Create extends HttpServlet {

    private PrintWriter outter;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
<<<<<<< HEAD

=======
        response.setContentType("text/html;charset=UTF-8");

        /* TODO output your page here. You may use following sample code. */
>>>>>>> 898181897685becb3c8b4b64e2ac0ee01d6e13df
        String path = request.getRealPath("/");
        outter = response.getWriter();
        response.setContentType("application/json");
        response.addHeader("Access-Control-Allow-Origin", "*");

<<<<<<< HEAD
        // Obtención de los parámetros del formulario.
        String nombrePregunta = request.getParameter("questionName");
        String pregunta = request.getParameter("question");
=======
        String preg = request.getParameter("question");
>>>>>>> 898181897685becb3c8b4b64e2ac0ee01d6e13df
        String respuesta = request.getParameter("answer");
        String drag1 = request.getParameter("drag1");
        String drag2 = request.getParameter("drag2");
        String drag3 = request.getParameter("drag3");
        String drag4 = request.getParameter("drag4");
        String target1 = request.getParameter("target1");
        String target2 = request.getParameter("target2");
        String target3 = request.getParameter("target3");
        String target4 = request.getParameter("target4");
<<<<<<< HEAD

        List<String> dragList = new ArrayList<String>() {
            {
                add(drag1);
                add(drag2);
                add(drag3);
                add(drag4);
            }
        };

        List<String> targetList = new ArrayList<String>() {
            {
                add(target1);
                add(target2);
                add(target3);
                add(target4);
            }
        };

        try {

            SAXBuilder builder = new SAXBuilder();
            File xmlFile = new File(path + "preguntas.xml");
            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();

            // Crear nodo de la nueva pregunta.
            Element preguntaNueva = new Element("PREGUNTA");

            preguntaNueva.setAttribute("TEXTO", nombrePregunta);
            preguntaNueva.setAttribute("RESPUESTA", respuesta);
            preguntaNueva.setAttribute("ID", Integer.toString((int) Math.round((Math.random() * (100000 - 5)) + 5)));

            Element drags = new Element("DRAGS");
            for (int i = 0; i < dragList.size(); i++) {
                Element dragOptionElement = new Element("OPCION");
                dragOptionElement.setAttribute("IMAGEN", "https://via.placeholder.com/150");
                dragOptionElement.setText(targetList.get(i));
                drags.addContent(dragOptionElement);
            }

            Element targets = new Element("TARGETS");
            for (int i = 0; i < dragList.size(); i++) {
                Element dragOptionElement = new Element("OPCION");
                dragOptionElement.setAttribute("IMAGEN", "https://via.placeholder.com/150");
                dragOptionElement.setText(targetList.get(i));
                targets.addContent(dragOptionElement);
            }

            preguntaNueva.addContent(drags);
            preguntaNueva.addContent(targets);

            // Se agrega toda la nueva pregunta.
            rootNode.addContent(preguntaNueva);

            // Guardar el documento modificado
            XMLOutputter xmlOutput = new XMLOutputter();
            xmlOutput.setFormat(Format.getPrettyFormat());
            FileWriter writer = new FileWriter(path + "preguntas.xml");
            xmlOutput.output(document, writer);
            outter.write("Se ha creado con exito una nueva pregunta.");
            System.out.println("Se ha creado con exito una nueva pregunta.");

        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
=======
        
        try {
            String ruta = request.getRealPath("/");
            SAXBuilder builder = new SAXBuilder();
            File xmlFile = new File(ruta + "preguntas.xml");
            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List list = rootNode.getChildren("PREGUNTA");
            int ultimovalor = (int) list.get(list.size() -1 );
            Element node = (Element) list.get(ultimovalor);
            int id = (Integer.parseInt(node.getAttributeValue("ID")) + 1);
            Element pregunta = new Element("PREGUNTA");
            pregunta.setAttribute("ID", Integer.toString(id));
            pregunta.setAttribute("TEXTO", preg);
            pregunta.setAttribute("RESPUESTA", respuesta);
            Element drags = new Element("DRAGS");
            Element opc1 = new Element("OPCION");
            opc1.setAttribute("IMAGEN", drag1);
            opc1.setText(drag1);
            drags.addContent(opc1);
            Element opc2 = new Element("OPCION");
            opc2.setAttribute("IMAGEN", drag2);
            opc2.setText(drag2);
            drags.addContent(opc2);
            Element opc3 = new Element("OPCION");
            opc3.setAttribute("IMAGEN", drag3);
            opc3.setText(drag3);
            drags.addContent(opc3);
            Element opc4 = new Element("OPCION");
            opc4.setAttribute("IMAGEN", drag4);
            opc4.setText(drag4);
            drags.addContent(opc4);
            pregunta.addContent(drags);
            Element targets = new Element("TARGETS");
            Element tar1 = new Element("OPCION");
            tar1.setAttribute("IMAGEN", target1);
            tar1.setText(target1);
            targets.addContent(tar1);
            Element tar2 = new Element("OPCION");
            tar2.setAttribute("IMAGEN", target2);
            tar2.setText(target2);
            targets.addContent(tar2);
            Element tar3 = new Element("OPCION");
            tar3.setAttribute("IMAGEN", target3);
            tar3.setText(target3);
            targets.addContent(tar3);
            Element tar4 = new Element("OPCION");
            tar4.setAttribute("IMAGEN", target4);
            tar4.setText(target4);
            targets.addContent(tar4);
            pregunta.addContent(targets);
            rootNode.addContent(pregunta);
            XMLOutputter xmlOutput = new XMLOutputter();
            xmlOutput.setFormat(Format.getPrettyFormat());
            FileWriter writer = new FileWriter(ruta + "preguntas.xml");
            xmlOutput.output(document, writer);
            writer.flush();
            writer.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
>>>>>>> 898181897685becb3c8b4b64e2ac0ee01d6e13df
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

<<<<<<< HEAD
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

=======
>>>>>>> 898181897685becb3c8b4b64e2ac0ee01d6e13df
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
<<<<<<< HEAD

=======
>>>>>>> 898181897685becb3c8b4b64e2ac0ee01d6e13df
}
