package ipn;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletCrear2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nombre = request.getParameter("nombre");
        String pregunta = request.getParameter("pregunta");
        String respuesta = request.getParameter("respuesta");
        String drag1 = request.getParameter("drag1");
        String drag2 = request.getParameter("drag2");
        String drag3 = request.getParameter("drag3");
        String drag4 = request.getParameter("drag4");
        String target1 = request.getParameter("tar1");
        String target2 = request.getParameter("tar2");
        String target3 = request.getParameter("tar3");
        String target4 = request.getParameter("tar4");
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
        out.println("<hr>");
        out.println("<p>Complete el siguiente formulario:</p>");
        out.println("<div class=\"row\">");
        out.println("<form action = \"UploadServlet\" method = \"post\" enctype = \"multipart/form-data\" >");
        out.println("<center>");
        out.println("<h5>Fase 2 - Formulario de subida de archivos</h5>");
        out.println("<label>Pregunta:  "+pregunta+"</label><br />");
        out.println("<label>Respuesta:  "+respuesta+"</label><br />");
        out.println("<label>Drag 1:"+drag1+"</label>");
        out.println("<input type = \"file\" name = \"file\" size = \"45\" />");
        out.println("<br />");
        out.println("<label>Drag 2:"+drag2+"</label>");
        out.println("<input type = \"file\" name = \"file\" size = \"45\" />");
        out.println("<br />");
        out.println("<label>Drag 3:"+drag3+"</label>");
        out.println("<input type = \"file\" name = \"file\" size = \"45\" />");
        out.println("<br />");
        out.println("<label>Drag 4:"+drag4+"</label>");
        out.println("<input type = \"file\" name = \"file\" size = \"45\" />");
        out.println("<br />");
        out.println("<label>Target 1:"+target1+"</label>");
        out.println("<input type = \"file\" name = \"file\" size = \"45\" />");
        out.println("<br />");
        out.println("<label>Target 2:"+target2+"</label>");
        out.println("<input type = \"file\" name = \"file\" size = \"45\" />");
        out.println("<br />");
        out.println("<label>Target 3:"+target3+"</label>");
        out.println("<input type = \"file\" name = \"file\" size = \"45\" />");
        out.println("<br />");
        out.println("<label>Target 4:"+target4+"</label>");
        out.println("<input type = \"file\" name = \"file\" size = \"45\" />");
        out.println("<br />");
        out.println("<br />");
        out.println("<input type = \"submit\" value = \"Aceptar\" />");
        out.println("</center>");
        out.println("</form>");
        out.println("</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        HttpSession session = request.getSession();
        session.setAttribute("nombreatributo", nombre);
        session.setAttribute("preguntaatributo", pregunta);
        session.setAttribute("respuestaatributo", respuesta);
        session.setAttribute("drag1atributo", drag1);
        session.setAttribute("drag2atributo", drag2);
        session.setAttribute("drag3atributo", drag3);
        session.setAttribute("drag4atributo", drag4);
        session.setAttribute("target1atributo", target1);
        session.setAttribute("target2atributo", target2);
        session.setAttribute("target3atributo", target3);
        session.setAttribute("target4atributo", target4);
    }
}
