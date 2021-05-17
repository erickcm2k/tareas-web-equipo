/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class Create extends HttpServlet {
    private PrintWriter outter;
    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 50 * 1024 * 1024;
    private int maxMemSize = 4 * 1024;
    private File file;
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String pre = "";
            String res = "";
            String drg1 = "";
            String drg2 = "";
            String drg3 = "";
            String drg4 = "";
            String target1= "";
            String target2 = "";
            String target3 = "";
            String target4 = "";
            filePath = request.getRealPath("/");//Convierte una ruta virtual del proyecto, directorio de archivos
            isMultipart = ServletFileUpload.isMultipartContent(request);
            if (!isMultipart) {
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet upload</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<p>Error en la encriptacion..</p>");
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
            
            // Parse the request to get file items.
            List fileItems = upload.parseRequest(request);

            // Process the uploaded file items
            Iterator i = fileItems.iterator();
            while (i.hasNext()) {
                FileItem item = (FileItem) i.next();
                if (item.isFormField()) {
                    
                    String nom= item.getFieldName();
                    switch (nom) {
                        case "pre":
                            pre = item.getString();
                            break;    
                        case "res":
                            res = item.getString();
                            break;   
                    }

                }else{
                    // Get the uploaded file parameters
                    String fieldName = item.getFieldName();
                    String fileName = item.getName();
                    String contentType = item.getContentType();
                    boolean isInMemory = item.isInMemory();
                    long sizeInBytes = item.getSize();

                    // Write the file
                    if (fileName.lastIndexOf("\\") >= 0 ) {

                        file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));
                    } else {
                        file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
                    }
                    item.write(file);
                    switch(fieldName){
                        case "drg1":
                            drg1 = fileName;
                            break;
                        case "drg2":
                            drg2 = fileName;
                            break;
                        case "drg3":
                            drg3 = fileName;
                            break;
                        case "drg4":
                            drg4 = fileName;
                            break;
                        case "target1":
                            target1 = fileName;
                            break;
                        case "target2":
                            target2 = fileName;
                            break;
                        case "target3":
                            target3 = fileName;
                            break;
                        case "target4":
                            target4 = fileName;
                            break;
                    }
                }
            }
            String ruta=request.getRealPath("/");                
            SAXBuilder builder = new SAXBuilder();
            File xmlFile = new File(ruta+"documento.xml");
            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            Element pregunta = new Element("PREGUNTA");
            pregunta.setAttribute("TEXTO",pre);
            pregunta.setAttribute("RESPUESTA",res);
            Element drags = new Element("DRAGS");
            Element opc1 = new Element("OPCION");
            opc1.setAttribute("IMAGEN",drg1);
            opc1.setText(drg1);
            drags.addContent(opc1);
            Element opc2 = new Element("OPCION");
            opc2.setAttribute("IMAGEN",drg2);
            opc2.setText(drg2);
            drags.addContent(opc2);
            Element opc3 = new Element("OPCION");
            opc3.setAttribute("IMAGEN",drg3);
            opc3.setText(drg3);
            drags.addContent(opc3);
            Element opc4 = new Element("OPCION");
            opc4.setAttribute("IMAGEN",drg4);
            opc4.setText(drg4);
            drags.addContent(opc4);
            pregunta.addContent(drags);
            
            Element targets = new Element("TARGETS");
            Element tar1 = new Element("OPCION");
            tar1.setAttribute("IMAGEN",target1);
            tar1.setText(target1);
            targets.addContent(tar1);
            Element tar2 = new Element("OPCION");
            tar2.setAttribute("IMAGEN",target2);
            tar2.setText(target2);
            targets.addContent(tar2);
            Element tar3 = new Element("OPCION");
            tar3.setAttribute("IMAGEN",target3);
            tar3.setText(target3);
            targets.addContent(tar3);
            Element tar4 = new Element("OPCION");
            tar4.setAttribute("IMAGEN",target4);
            tar4.setText(target4);
            targets.addContent(tar4);
            pregunta.addContent(targets);
            rootNode.addContent(pregunta);
            
            XMLOutputter xmlOutput = new XMLOutputter();

		xmlOutput.setFormat(Format.getPrettyFormat());
                FileWriter writer = new FileWriter(ruta+"documento.xml");                
		xmlOutput.output(document, writer);
                writer.flush();
                writer.close();    
            response.sendRedirect("./inicio");
        } catch (FileUploadException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
