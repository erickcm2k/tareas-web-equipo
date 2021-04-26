package ipn;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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


public class ServletCrear extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        
          String ruta=request.getRealPath("/");                
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletModifyXML</title>");            
            out.println("</head>");
            out.println("<body>");             
        /*El servlet está como lo tiene el profesor, solo hay que sustituir por nuestros valores*/
            try {
                
                /*Recibir los datos del formulario*/
                
                
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(ruta+"preguntas.xml");
                Document doc = (Document) builder.build(xmlFile);
                /*
                
		-- Añadir aquí los datos al XML, dejé los del profesor como un ejemplo --
                
		Element rootNode = doc.getRootElement();

		Element alumno = rootNode.getChild("alumno");
		alumno.getAttribute("id").setValue("0");

		Element boleta = new Element("boleta").setText("20201709");
		alumno.addContent(boleta);

		Element grupo = rootNode.getChild("grupo");                
		grupo.setText("MATEMATICAS");

		alumno.removeChild("nombre");
                
                */
                
		XMLOutputter xmlOutput = new XMLOutputter();
		xmlOutput.setFormat(Format.getPrettyFormat());
                FileWriter writer = new FileWriter(ruta+"preguntas.xml");                
		xmlOutput.output(doc, writer);
                writer.flush();
                writer.close();                

                out.println("Pregunta creada");
                out.println("<a href='mainServlet'>Volver</a>");
                out.println("</body>");
                out.println("</html>");  
                } 
                catch (IOException e) 
                {
		e.printStackTrace();
                } 
                catch (JDOMException e) 
                {
		e.printStackTrace();
                }

    }
}
