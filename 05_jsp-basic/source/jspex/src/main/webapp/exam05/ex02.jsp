<%@ page contentType="text/html; charset=UTF-8" %>
<%
    pageContext.setAttribute("num", 100);
    request.setAttribute("num", 200);
    session.setAttribute("num", 300);
    application.setAttribute("num", 400);
%>
num: ${num}<br>
pageScope: ${pageScope.num}<br>
requestScope: ${requestScope.num}<br>
sessionScope: ${sessionScope.num}<br>
applicationScope: ${applicationScope.num}<br>