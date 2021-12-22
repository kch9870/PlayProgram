<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="project.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table>
	<% ArrayList<Member> list=(ArrayList<Member>)request.getAttribute("list");
			if(!list.isEmpty())
			{
		%>		
				<% for(int i=0; i<list.size(); i++ )
				{
					Member m=list.get(i);%>
					<tr>						
						<td>id: <%=m.getId()%></td>
						<td>password: <%=m.getPasswd()%></td>
						<td>name: <%=m.getName()%></td>
						<td>age: <%=m.getAge()%></td>
					</tr>
				<%}
				}else{
					out.print("There are no saved members");
				}%>
	</table>
	
	<a href="AdminIndex.jsp">Goto AdminIndex</a>
</body>
</html>