<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="project.vo.Song"%>
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
               <div id="clock"></div>
               <%String logid = (String)request.getAttribute("logid");%>
               <%if(logid == null){%>
                     <li><a href="Login.jsp">로그인</a></li>
                     <li><a href="Register.jsp">회원가입</a></li>
                     <% }else{ %>
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
				<a href="Index.jsp">PLLY</a>
				<form action="search.do" method="get">
					<input type="text" name="searchname" placeholder="Search....">
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
			<li><input type="submit" value="Latest Music"></li>
			<li><input type="submit" value="Play List"></li>
		</ul>

	</div>

  <div id = "menu">
     <ul>
        <form action="song.do">
           <li><input type="submit" value="ballad" name="kind"><input type="hidden" name="goto" value="genrekind"></li>
           <li><input type="submit" value="pop" name="kind"><input type="hidden" name="goto" value="genrekind"></li>
           <li><input type="submit" value="hiphop" name="kind"><input type="hidden" name="goto" value="genrekind"></li>
           <li><input type="submit" value="edm" name="kind"><input type="hidden" name="goto" value="genrekind"></li>
        </form>
     </ul>
  </div>
  <div>
   
   <div id="poptrox">
    <ul id="gallery">
    <%
    	String togo=(String)request.getAttribute("goto");
    	if(togo.equals("genre"))
    	{%>
    	<%}else if(togo.equals("genrekind")){%>
      <%
      	ArrayList<Song> list=(ArrayList<Song>)request.getAttribute("list");
      	String kind=(String)request.getAttribute("kind");
      %>
     <h2><%=kind%></h2>
           <%for(int i=0;i<list.size(); i++ )
         		{
            		Song song=list.get(i);%>
            		<li><a><img src=<%=song.getA_title()%> width="240" alt=""><br>Song: <%=song.getSong() %><br>Singer: <%=song.getSinger() %></a>
            			<form action="playlist.do" method="get">
							<input type="submit" value="play">
							<input type="hidden" name="play" value=<%=song.getAudio()%>>
							<input type="hidden" name="logid" value=<%=logid%>>
							<input type="hidden" name="a_title" value=<%=song.getA_title()%>>
							<input type="hidden" name="song" value=<%=song.getSong()%>>
							<input type="hidden" name="singer" value=<%=song.getSinger()%>>
							<input type="hidden" name="where" value="play">
						</form>
            		</li>
         <%}
         }%>
      </ul>
   </div>
  
   <div id="footer">
      <p>s
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