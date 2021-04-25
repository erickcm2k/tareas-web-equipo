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


public class ServletBorrar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
            String ruta=request.getRealPath("/");                
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String dato1 = request.getParameter("idProblema");
            int parametro1int = Integer.parseInt(dato1);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Borrar</title>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<body>");
            try 
            {
            SAXBuilder builder = new SAXBuilder();     
            File xmlFile = new File(ruta+"pregunta.xml");                
            Document doc = builder.build(xmlFile);
            Element root=doc.getRootElement();
            root.removeChild("PREGUNTA");
            XMLOutputter xmlOutput = new XMLOutputter();
            xmlOutput.setFormat(Format.getPrettyFormat());
            FileWriter writer = new FileWriter(ruta+"pregunta.xml");                
            xmlOutput.output(doc, writer);
            writer.flush();
            writer.close();out.println("<div class=\"container\">");
            out.println("<hr>");
            out.println("<h2>Elemento eliminado.</h2>");
            out.println("<hr>");
            out.println("<div class=\"alert alert-success\" role=\"alert\">");
            out.println("<h4 class=\"alert-heading\">Problema eliminado!</h4>");
            out.println("<hr>");
            out.println("<p class=\"mb-0\">El problema con ID: "+parametro1int+" fue eliminado satisfactoriamente.</p>");
            out.println("<div class=\"row\">");
            out.println("<a class=\"btn btn-outline-success btn-lg btn-block\" href=\"ServletPrincipal\" role=\"button\">Volver al menú principal.</a>");
            out.println("</div>");
            out.println("</div>");
            out.println("<hr>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");  
            } 
            catch (IOException | JDOMException e) 
            {
            e.printStackTrace();
            }
    }
}
