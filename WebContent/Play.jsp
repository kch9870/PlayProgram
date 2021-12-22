<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
 <%
 	String play=(String)request.getAttribute("play");
 	String a_title=(String)request.getAttribute("a_title");
 	String song=(String)request.getAttribute("song");
 	String singer=(String)request.getAttribute("singer");
 %>
 	<img src=<%=a_title %>>
 	<table>
 		<tr>
 			<td>title: <%=song %></td><br>
 			<td>singer: <%=singer %></td>
 		</tr>
 	</table>
	<audio src="<%=play %>" autoplay controls>
	</audio>
</body>
</html>