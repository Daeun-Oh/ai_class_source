<%@ page contentType="text/html; charset=UTF-8" %>
<form method="POST" action="board_ps.jsp">
    제목: <input type="text" name="subject"><br> <%-- br은 줄개행 --%>
    내용: <textarea name="content"></textarea><br>
    <button type="submit">작성하기</button>
</form>