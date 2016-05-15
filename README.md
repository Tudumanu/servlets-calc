Utilização de Servlets simples e JSP

```jsp
<% //tags script(scriptlets), necessita de out.println para exibição %>
<%! //declarações de variáveis e métodos %>
<%= //expressões, o resultado do código java é convertido em .toString() %>

//diretivas, executadas em tempo de compilação
<%@ page //diretiva usada para especificar dependências da página %>
<%@ include file="" //diretiva de inclusão de outra página %>
<%@ taglib //diretiva para mapear as custom tags no xhtml %>

//ações, executadas em tempo de execução (runtime)
<jsp:include page="" /> //inclusão de outra página

//redirecionamento para outra página
<jsp:forward page="">
  <jsp:param name="" value="" />
</jsp:forward>
```