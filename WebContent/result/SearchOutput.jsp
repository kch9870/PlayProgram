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
	%>
	<%for(int i=0;i<list.size(); i++ )
         		{
            		Song song=list.get(i);%>
            		<li><a><img src=<%=song.getA_title()%> width="240" alt=""><br>Song: <%=song.getSong() %><br>Singer: <%=song.getSinger() %></a>
            		</li>
         <%}%>
	
</body>
</html>