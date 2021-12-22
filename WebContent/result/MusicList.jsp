<%@page import="project.vo.Song"%>
<%@page import="java.util.ArrayList"%>
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
		ArrayList<Song> list=(ArrayList<Song>)request.getAttribute("list");
		
	if(!list.isEmpty())
	{
%>		
		<% for(int i=0; i<list.size(); i++ )
		{
			Song s=list.get(i);%>
			<tr>						
				<td><img src=<%=s.getA_title()%>></td>
				<td>Song: <%=s.getSong()%></td>
				<td>Singer: <%=s.getSinger()%></td>
				<td>Kind: <%=s.getKind()%></td>
			</tr>
		<%}
		}else{
			out.print("There are no saved songs");
		}%>

</body>
</html>