<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<h1>게시글 목록</h1>
<ul>
<c:forEach var="item" items="${items}">
    <li>${item.subject}</li> <%-- ${item.getSubject()} --%>
</c:forEach>
</ul>