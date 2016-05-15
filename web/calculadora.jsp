<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <%@ include file="templates/title.jsp"%>
  <style>
    p.error {
      font-weight: bold;
      color: red;
    }
  </style>
</head>
<body>
  <%@ include file="templates/appName.jsp"%>

  <%
    String error = request.getParameter("error");
    if (error != null){
      out.println("<p class='error'>"+ request.getParameter("error") +"</p>");
    }
  %>

  <form action="resultado.jsp" method="get">
    <fieldset>
      <legend>Operação:</legend>
      <select name="op">
        <option value="soma">Soma</option>
        <option value="subtracao">Subtração</option>
        <option value="multiplicacao">Multiplicação</option>
        <option value="divisao">Divisão</option>
        <option value="raiz">Raiz Quadrada</option>
      </select>
      <span>Para Raiz quadrada, use apenas o primeiro número</span>
      <br />
      <br />

      <label>Primeiro Número:</label>
      <input name="num1" type="text" />
      <br />
      <br />

      <label>Segundo Número:</label>
      <input name="num2" type="text" />
    </fieldset>
    <br />

    <input value="Enviar" type="submit" />
  </form>

  <jsp:include page="templates/footer.jsp" />
</body>
</html>
