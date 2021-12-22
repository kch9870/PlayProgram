<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link href="css/Style.css" rel="stylesheet">
</head>
<body>
   <div id="header1">
      <nav id="nav">
         <ul>
               <div id="clock"></div>
               <li><a href=MyPage.jsp>My page</a></li>
               <li><a href="Login.jsp">Login</a></li>
               <li><a href="Register.jsp">Sign up</a></li>
         </ul>
      </nav>
   </div>

   <div id="header">
		<div id="logo">
			<h1>
				<a href="Index.jsp">PLLY</a>
				<b>
				<form action="search.do" method="get">
					<input type="text" name="searchname" placeholder="Search....">
					<input type="submit" value="search">
				</form></b>
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

   <div id="container1">
      <form action="song.do" method="get">
         <ul>
            <li><label for="a_title" class="field">A_title</label> <input
               type="text" id="a_title" name="a_title"
               placeholder="Enter 4~15 digits in English and number." required></li>


            <li><label for="song" class="field">Song</label> <input
               type="text" id="song" name="song"
               placeholder="Please enter at least 8 digits in English and numerals."
               name="text" required></li>

            <li><label for="singer" class="field">Singer</label> <input
               type="text" id="singer" name="singer" required></li>

            <li><label for="kind" class="field">Kind</label> <input
               type="text" id="kind" name="kind"
               placeholder="Enter in English." required></li>

            <li><label for="audio" class="field">Audio</label> 
            <input type="text" id="audio" name="audio" required></li>
            
            <li><label for="scount" class="field">Scount</label> 
            <input type="text" id="scount" name="scount" required></li>
            
            <input type="submit" name="goto" value="addsong">
         </ul>
      </form>
   </div>

   <script src="js/signup.js"></script>
   <script src="js/clock.js"></script>
</body>
</html>4