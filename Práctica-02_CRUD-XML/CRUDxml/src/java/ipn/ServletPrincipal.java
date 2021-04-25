package ipn;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class ServletPrincipal extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ruta = request.getRealPath("/");
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(ruta + "pregunta.xml");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Principal</title>");
        out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6\" crossorigin=\"anonymous\">");
        out.println("</head>");
        out.println("<body>");
        try {
            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List list = rootNode.getChildren("PREGUNTA");
            out.println("<div class=\"container\">");
            out.println("<hr>");
            out.println("<h2>Crear altas, bajas y cambios</h2>");
            out.println("<a href='ServletCrear'>Crear nuevo usuario.</a>");
            out.println("<hr>");
            out.println("<table class=\"table table-hover\">");
            out.println("<thead>");
            out.println("<tr class=\"p-3 mb-2 bg-primary text-white\">");
            out.println("<th>Nombre de la Pregunta</th>");
            out.println("<th>Acciones</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            for (int i = 0; i < list.size(); i++) {
                Element node = (Element) list.get(i);
                out.println("<tr>");
                out.println("<td>");
                out.println(node.getAttributeValue("TEXTO"));
                out.println("</td>");
                out.println("<td>");
                out.println("|<a href=\"ServletLeer?idProblema="+i+"\">Leer usuario</a>|");
                out.println("|<a href=\"ServletUpdate?idProblema="+i+"\">Modificar Usuario</a>|");
                out.println("|<a href=\"ServletBorrar?idProblema="+i+"\" onclick=\"return confirm('Quieres borrar el problema?')\">Borrar Usuario</a>|");
                out.println("</td>");
                out.println("</tr>");
            }
            out.println("</tbody>");
            out.println("</table>");
            out.println("<hr>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } catch (IOException io) {
            out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            out.println(jdomex.getMessage());
        }
    }
}
