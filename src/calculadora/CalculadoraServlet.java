package calculadora;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "CalculadoraServlet",
        urlPatterns = {"/CalculadoraServlet"}
)
public class CalculadoraServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("CalculadoraServlet doPost");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Calculadora</title></head>");
        out.println("<body>");
        out.println("<h1>doPost CalculadoraServlet</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("CalculadoraServlet doGet");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Calculadora</title></head>");
        out.println("<body>");
        out.println("<h1>doGet CalculadoraServlet</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
