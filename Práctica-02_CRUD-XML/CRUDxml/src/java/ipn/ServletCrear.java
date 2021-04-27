package ipn;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCrear extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Crear</title>");
        out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6\" crossorigin=\"anonymous\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        out.println("<hr>");
        out.println("<h2>Crear nueva pregunta.</h2>");
        out.println("<p>Dividimos la creación de preguntas en 2 fases:</p>");
        out.println("<center>");
        out.println("<p>*Fase 1 : Formulario de texto.  *Fase 2 : Formulario de subida de archivos.</p>");
        out.println("<hr>");
        out.println("<div class=\"row\">");
        out.println("<form action = \"ServletCrear2\" method ='get' >");
        out.println("<center>");
        out.println("<h5>Fase 1 - Formulario de texto.</h5>");
        out.println("<p>Complete el siguiente formulario:</p>");
        out.println("<input type=\"text\" name=\"pregunta\" placeholder=\"Pregunta\">");
        out.println("<br />");
        out.println("<br />");
        out.println("<input type=\"text\" name=\"respuesta\" placeholder=\"Respuesta\">");
        out.println("<br />");
        out.println("<br />");
        out.println("<input type=\"text\" name=\"drag1\" placeholder=\"Drag Option1\">");
        out.println("<br />");
        out.println("<br />");
        out.println("<input type=\"text\" name=\"drag2\" placeholder=\"Drag Option2\">");
        out.println("<br />");
        out.println("<br />");
        out.println("<input type=\"text\" name=\"drag3\" placeholder=\"Drag Option3\">");
        out.println("<br />");
        out.println("<br />");
        out.println("<input type=\"text\" name=\"drag4\" placeholder=\"Drag Option4\">");
        out.println("<br />");
        out.println("<br />");
        out.println("<input type=\"text\" name=\"tar1\" placeholder=\"Target Option1\">");
        out.println("<br />");
        out.println("<br />");
        out.println("<input type=\"text\" name=\"tar2\" placeholder=\"Target Option2\">");
        out.println("<br />");
        out.println("<br />");
        out.println("<input type=\"text\" name=\"tar3\" placeholder=\"Target Option3\">");
        out.println("<br />");
        out.println("<br />");
        out.println("<input type=\"text\" name=\"tar4\" placeholder=\"Target Option4\">");
        out.println("<br />");
        out.println("<br />");
        out.println("<input type = \"submit\" value = \"Aceptar\" />");
        out.println("<hr>");
        out.println("</center>");
        out.println("</form>");
        out.println("</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
