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
               <div id="clock"></div>
               <li>Welcome Admin</li>
               <li><a href="Logout.jsp">Logout</a></li>
               <li><a href="MyPage.jsp">My page</a></li>
         </ul>
      </nav>
   </div>

   <div id="header">
      <div id="logo">
         <h1>
            <a href="AdminIndex.jsp">PLLY</a>
            <form action="search.do" method="get">
					<input type="text" name="searchname" placeholder="Search....">
					<input type="submit" value="search">
			</form>
         </h1>
      </div>

   </div>

   <div id="admin">
      <ul>
      
  		<form action="member.do" method="get">
			<li><input type="submit" value="View Member List"><input type="hidden" name="goto" value="memberlist"></li>
		</form>
			<li><a href="AddSong.jsp"><input type="submit" value="Add Music"></a></li>

		<form action="song.do" method="get">
			<li><input type="submit" value="Music List"><input type="hidden" name="goto" value="songlist"></li>
		</form>
      
         <li>
            <button type="submit" class = "afield">View Member List</button>
         </li>
         <li>
            <button type="submit" class = "afield">Add Music</button>
         </li>
         <li>
            <button type="submit" class = "afield">Music List</button>
         </li>
      </ul>
   </div>