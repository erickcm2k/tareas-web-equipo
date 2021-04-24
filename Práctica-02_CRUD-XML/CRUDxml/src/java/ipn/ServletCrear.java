package ipn;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom.*;
import org.jdom.output.XMLOutputter;
import java.io.PrintWriter;
import java.io.FileWriter;

public class ServletCrear extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Element raiz = new Element("ROOT");
            Element hoja = new Element("hoja");
            hoja.setAttribute("numerodehojas", "4");
            hoja.setText("VALORDELNODO");
            raiz.addContent(hoja);

            Document newdoc = new Document(raiz);
            XMLOutputter fmt = new XMLOutputter();
            FileWriter writer = new FileWriter("c:\\pregunta2.xml");
            fmt.output(newdoc, writer);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Crear</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hola mundo</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}