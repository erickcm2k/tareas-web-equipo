package ipn;

import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class UploadServlet extends HttpServlet {

    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 50 * 1024 * 1024;
    private int maxMemSize = 4 * 1024;
    private File file;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        // Check that we have a file upload request
        filePath = request.getRealPath("/");
        isMultipart = ServletFileUpload.isMultipartContent(request);
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        String nombre = (String) session.getAttribute("nombreatributo");
        String preg = (String) session.getAttribute("preguntaatributo");
        String respuesta = (String) session.getAttribute("respuestaatributo");
        String drag1 = (String) session.getAttribute("drag1atributo");
        String drag2 = (String) session.getAttribute("drag2atributo");
        String drag3 = (String) session.getAttribute("drag3atributo");
        String drag4 = (String) session.getAttribute("drag4atributo");
        String target1 = (String) session.getAttribute("target1atributo");
        String target2 = (String) session.getAttribute("target2atributo");
        String target3 = (String) session.getAttribute("target3atributo");
        String target4 = (String) session.getAttribute("target4atributo");
        java.io.PrintWriter out = response.getWriter();

        if (!isMultipart) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Error</title>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>No se subio el archivo</p>");
            out.println("</body>");
            out.println("</html>");
            return;
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();

        // maximum size that will be stored in memory
        factory.setSizeThreshold(maxMemSize);

        // Location to save data that is larger than maxMemSize.
        factory.setRepository(new File(filePath));

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // maximum file size to be uploaded.
        upload.setSizeMax(maxFileSize);
        /////////////////////////////////////////////////
        try {
            // Parse the request to get file items.
            List fileItems = upload.parseRequest(request);
            // Process the uploaded file items
            Iterator i = fileItems.iterator();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Creado</title>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\">");
            out.println("<hr>");
            out.println("<h2>Crear nueva pregunta.</h2>");
            out.println("<p>Datos agregados al xml</>");
            out.println("<br /><a href=\"ServletPrincipal\">Regresar al menú principal.</a><br />");
            out.println("<hr>");
            out.println("<div class=\"container\">");
            out.println("<div class=\"row\">");
            out.println("<center>");
            out.println("<label>Nombre:  " + nombre + "</label><br />");
            out.println("<label>Pregunta:  " + preg + "</label><br />");
            out.println("<label>Respuesta:  " + respuesta + "</label><br />");
            out.println("<label>drag1:  " + drag1 + "</label><br />");
            out.println("<label>drag2:  " + drag2 + "</label><br />");
            out.println("<label>drag3:  " + drag3 + "</label><br />");
            out.println("<label>drag4:  " + drag4 + "</label><br />");
            out.println("<label>target1:  " + target1 + "</label><br />");
            out.println("<label>target2:  " + target2 + "</label><br />");
            out.println("<label>target3:  " + target3 + "</label><br />");
            out.println("<label>target4:  " + target4 + "</label><br />");
            out.println("<label>Archivos:</label><br />");
            while (i.hasNext()) {
                FileItem fi = (FileItem) i.next();
                if (!fi.isFormField()) {
                    // Get the uploaded file parameters
                    String fieldName = fi.getFieldName();
                    String fileName = fi.getName();
                    String contentType = fi.getContentType();
                    boolean isInMemory = fi.isInMemory();
                    long sizeInBytes = fi.getSize();

                    // Write the file
                    if (fileName.lastIndexOf("\\") >= 0) {
                        file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));
                    } else {
                        file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
                    }
                    fi.write(file);
                    out.println("<label>Archivo subido::  " + fileName + "</label><br />");
                }
            }
            out.println("<hr>");
            out.println("<a href=\"ServletPrincipal\">Regresar al menú principal.</a>");
            out.println("</div>");
            out.println("</div>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        } catch (FileUploadException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            String ruta = request.getRealPath("/");
            SAXBuilder builder = new SAXBuilder();
            File xmlFile = new File(ruta + "pregunta.xml");
            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            Element pregunta = new Element("PREGUNTA");
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
            FileWriter writer = new FileWriter(ruta + "pregunta.xml");
            xmlOutput.output(document, writer);
            writer.flush();
            writer.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        throw new ServletException("GET method used with "
                + getClass().getName() + ": POST method required.");
    }
}
