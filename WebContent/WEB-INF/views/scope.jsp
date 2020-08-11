<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
pageContext.setAttribute("haha","pageContext");
request.setAttribute("haha","request");
session.setAttribute("haha","session");
application.setAttribute("haha","application");
//크기가 작은것 순서대로 나열해서 저장한 코드
//그냥 ${}으로 출력시 제일 작은 page가 출력됨
//오늘 공부할거 저 위에 4개
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${pageContextScope.haha }
${requestScope.haha }
${sessionScope.haha }
${applicationScope.haha }


</body>
</html>