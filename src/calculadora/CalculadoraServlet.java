package calculadora;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.DoubleSummaryStatistics;

@WebServlet(
        name = "CalculadoraServlet",
        urlPatterns = {"/CalculadoraServlet"}
)
public class CalculadoraServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("CalculadoraServlet doPost");

        String val1 = request.getParameter("num1").replace(",",".");
        String val2 = request.getParameter("num2").replace(",",".");
        String op = request.getParameter("op");

        String resultContent;
        Double n1 = 0.0;
        Double n2 = 0.0;

        try {
            n1 = Double.parseDouble(val1);
            n2 = Double.parseDouble(val2);

            resultContent = calcula(op,n1,n2);
        } catch (NumberFormatException e) {
            resultContent = "Informe apenas números para o cálculo, como por ex.: 9 ou 10,5";
        }


        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Calculadora</title></head>");
        out.println("<body>");
        out.println("<h1>Resultado da operação</h1>");
        out.println("<h4>"+ val1 +" "+ op +" "+ val2 +"</h4>");
        out.println("<h4>"+ resultContent +"</h4>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    private String calcula(String op, Double n1, Double n2) {
        String resultContent = "";
        Double result = 0.0;

        switch (op) {
            case "soma":
                result = n1 + n2;
                break;
            case "subtracao":
                result = n1 - n2;
                break;
            case "multiplicacao":
                result = n1 * n2;
                break;
            case "divisao":
                result = n1 / n2;
                break;
            case "raiz":
                result = Math.sqrt(n1);
                break;
            default:
                resultContent = "Operação não encontrada!";
                break;
        }

        if (resultContent.length() == 0)
            resultContent = result.toString();

        return resultContent;
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
