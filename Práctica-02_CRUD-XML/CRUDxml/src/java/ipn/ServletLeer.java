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

public class ServletLeer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ruta = request.getRealPath("/");
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(ruta + "pregunta.xml");
        response.setContentType("text/html;charset=UTF-8");
        String dato1 = request.getParameter("idProblema");
        int parametro1int = Integer.parseInt(dato1);
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
            out.println("<h2>Servlet Leer</h2>");
            out.println("<p>Los datos son los siguientes:</p>");
            out.println("<hr>");
            out.println("<table class=\"table table-hover\">");
            out.println("<thead>");
            out.println("<tr class=\"p-3 mb-2 bg-primary text-white\">");
            int i = parametro1int;
            Element node = (Element) list.get(i);
            out.println("<th>Pregunta: " + node.getAttributeValue("TEXTO") + "</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            out.println("<tr>");
            out.println("<td>");
            out.println("Respuesta: " + node.getAttributeValue("RESPUESTA"));
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr class=\"p-3 mb-2 bg-info text-white\">");
            out.println("<td>");
            out.println("Drags:");
            out.println("</td>");
            out.println("</tr>");
            List lista2 = node.getChildren("DRAGS");
            for (int j = 0; j < lista2.size(); j++) {
                Element nodeDrags = (Element) lista2.get(j);
                List listaOpcion = nodeDrags.getChildren("OPCION");
                for (int k = 0; k < listaOpcion.size(); k++) {
                    Element nodeOpcion = (Element) listaOpcion.get(k);
                    out.println("<tr>");
                    out.println("<td>");
                    out.println(nodeOpcion.getText() + "<br />");
                    out.println("</td>");
                    out.println("</tr>");
                }
            }
            out.println("<tr class=\"p-3 mb-2 bg-info text-white\">");
            out.println("<td>");
            out.println("Targets:");
            out.println("</td>");
            out.println("</tr>");
            List lista3 = node.getChildren("TARGETS");
            for (int j = 0; j < lista3.size(); j++) {
                Element nodeTargets = (Element) lista3.get(j);
                List listaOpcion2 = nodeTargets.getChildren("OPCION");
                for (int k = 0; k < listaOpcion2.size(); k++) {
                    Element nodeOpcion2 = (Element) listaOpcion2.get(k);
                    out.println("<tr>");
                    out.println("<td>");
                    out.println(nodeOpcion2.getText() + "<br />");
                    out.println("</td>");
                    out.println("</tr>");
                }
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
