<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if(session!=null){
		session.invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
		rd.forward(request, response);
	}
%>
</body>
</html>