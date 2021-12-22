<%@page import="java.util.ArrayList"%>
<%@page import="project.vo.Song"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link href="css/Style.css" rel="stylesheet">
<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
	<div id="header1">
		<nav id="nav">
			<ul>
				<body
					onload="window.open('img/K-010.jpg','','width=420px, height=540px, left=100px, top=100px, toolbar=0, status=yes, menubars=0, scrollbars=0, resizable=0, location=0, directories=0');startTime()">
					<div id="clock"></div>
					 <%String logid = (String)request.getAttribute("logid");%>
					 <% if(logid==null){%>
              		 <li><a href="Login.jsp">로그인</a></li>
             		  <li><a href="Register.jsp">회원가입</a></li>
              		 <% }
					 else{ %>
              		 <li><%=logid %>님 어서오세요</li>
               		 <li><a href="Logout.jsp">로그아웃</a></li>
              		 <li><a href="MyPage.jsp">마이페이지</a></li>
              		 <% } %>
			</ul>
		</nav>
	</div>

	<div id="header">
		<div id="logo">
			<h1>
				<a href="Open.jsp">PLLY</a>
				<form action="search.do" method="get">
					<input type="text" placeholder="Search...." name="searchname">
					<input type="submit" value="search">
				</form>
			</h1>
		</div>

	</div>
	
	
	<div id="menu">
		<ul>
			<form action="song.do" method="get">
			<li><input type="submit" value="Genre Music"><input type="hidden" name="goto" value="genre"></li>
			</form>
			<form action="song.do" method="get">
			<li><input type="submit" value="Latest Music"><input type="hidden" name="goto" value="latest"></li>
			</form>
			<li><input type="submit" value="Play List"></li>
		</ul>

	</div>

	<div id="poptrox">
		<h2>POPULAR ALBUM ></h2>
		<ul id="gallery">
			<%ArrayList<Song> alist=(ArrayList<Song>)request.getAttribute("list");
			  for(int i=0;i<8; i++ )
			{
				Song song=alist.get(i);%>
				<li><a><img src=<%=song.getA_title() %> width="240" alt=""><br>Singer: <%=song.getSinger() %></a></li>
			<%}%>
		</ul>
	</div>

	<div id="poptrox">
	<h2>POPULAR CHART ></h2>
	<div>
		<table>
			<%ArrayList<Song> blist=(ArrayList<Song>)request.getAttribute("list");
			if(!blist.isEmpty()){
				for(int i=0; i<blist.size(); i++ )
				{
					Song song=blist.get(i);%>
					<tr>
						<td><img src=<%=song.getA_title()%> width="50" alt=""></td>
						<td>Song:<%=song.getSong()%></td>
						<td> Singer:<%=song.getSinger()%></td>
					<form action="playlist.do" method="get">
						<td><input type="submit" name="add" value="add"></td>
						<input type="hidden" name="logid" value=<%=logid%>>
						<input type="hidden" name="s_code" value=<%=song.getS_code()%>>
						<input type="hidden" name="where" value="plist">
					</form>
					<form action="playlist.do" method="get">
						<td><input type="submit" value="play">
						<input type="hidden" name="play" value=<%=song.getAudio()%>>
						<input type="hidden" name="logid" value=<%=logid%>>
						<input type="hidden" name="a_title" value=<%=song.getA_title()%>>
						<input type="hidden" name="song" value=<%=song.getSong()%>>
						<input type="hidden" name="singer" value=<%=song.getSinger()%>>
						<input type="hidden" name="where" value="play">
						</td>
					</form>
					</tr>
				<%}
			}%>
		</table>
	</div>
	</div>

	<div id="footer">
		<p>
			Mutual name: Alex |, Inc. representative: Kim Seo-hyun |
			Representative Phone: 1544-0000 ᅵ Fax : 032-724-0000 <br>
			Personal Show Room : 1216 1st floor (T.031-8016-000000) <br>Silshroom:
			Songpa-gu, Seoul <br> Business registration number: 130-86-00000
			ᅵ104 1F (T.02-653-000000) < Communication Sales Business Report:
			"2017-Seoul Lounge-02831 <br> Personal Information Protection
			Management Officer: Kim Seo-hyun<br> <br>Copyright©2007
			ALEX All right reserved. Design by ALEX TEMPLATED.
		</p>
	</div>
	<script src="js/clock.js"></script>
</body>
</html>
