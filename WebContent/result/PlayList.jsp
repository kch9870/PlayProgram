<%@page import="project.vo.Song"%>
<%@page import="project.vo.PlayList"%>
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
	<table>
	<% ArrayList<PlayList> list=(ArrayList<PlayList>)request.getAttribute("list");
	   String logid=(String)request.getAttribute("logid");
			if(!list.isEmpty())
			{
		%>		
				<% for(int i=0; i<list.size(); i++ )
				{
					Song song=list.get(i).getSong();%>
					<tr>
						<td><img src=<%=song.getA_title()%>></td>
						<td>Song: <%=song.getSong() %></td>
						<td>Song: <%=song.getSinger() %></td>
						<form action="playlistdelete.do" method="get">
						<td>
						<input type="submit" name="delete" value="delete">
						<input type="hidden" name="logid" value=<%=logid %>>
						<input type="hidden" name="where" value="gotodelete">
						<input type="hidden" name="p_code" value="<%=list.get(i).getP_code()%>">
						</td></form>
					</tr>
				<%}
				}%>
	</table>
</body>
</html>