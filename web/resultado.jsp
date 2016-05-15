<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <%@ include file="templates/title.jsp"%>
</head>
<body>
  <%@ include file="templates/appName.jsp"%>

  <%!
    //methods
    public Double getNumber(String num) {
      String tmp = num.replace(",",".");
      Double val = new Double("0");

      try {
        val = Double.parseDouble(tmp);
      } catch (Exception e) {}

      return val;
    }

    private String calcula(String op, Double n1, Double n2) {
      String resultContent = "";
      Double result = 0.0;

      op = op.toLowerCase();
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
  %>

  <%
    //verify params
    String num1 = request.getParameter("num1");
    String num2 = request.getParameter("num2");
    String op = request.getParameter("op");
    if(num1 == null || num2 == null || op == null) {
  %>
    <jsp:forward page="calculadora.jsp">
      <jsp:param name="error" value="Faltou passar parametros!!!" />
    </jsp:forward>
  <%
    } else {
      //got params
  %>
    <h2>Resultado da operação</h2>
    <%
      if (op.equalsIgnoreCase("raiz")) {
    %>
      <h4><%= op %> de <%= getNumber(num1) %> = <%= calcula(op,getNumber(num1),getNumber(num2)) %></h4>
    <%
      } else {
    %>
      <h4><%= getNumber(num1) %> <%= op %> <%= getNumber(num2) %> = <%= calcula(op,getNumber(num1),getNumber(num2)) %></h4>
    <%
      }
    %>
  <%
    }
  %>

  <p><a href="calculadora.jsp">Clique aqui</a> para fazer outro cálculo</p>

  <jsp:include page="templates/footer.jsp" />
</body>
</html>
