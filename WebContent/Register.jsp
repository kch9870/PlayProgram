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
      <form action="register.do" method="get">
         <ul>
            <li><label for="user-id" class="field">ID</label> <input
               type="text" id="user-id" name="id"
               placeholder="Enter 4~15 digits in English and number." required></li>


            <li><label for="user-pw1" class="field">PW</label> <input
               type="password" id="user-pw1"
               placeholder="Please enter at least 8 digits in English and numerals."
               name="passwd" required></li>

            <li><label for="user-pw2" class="field">CHECK PW</label> <input
               type="password" id="user-pw2" required></li>

            <li><label for="name" class="field">NAME</label> <input
               type="text" id="user-name" name="name"
               placeholder="Enter in English." required></li>

            <li><label for="age" class="field">AGE</label> <input
               type="text" id="user-email" name="age" required></li>
         </ul>
         <ul id="buttons">
            <li>
               <button type="submit" class="btn btnBlack">SIGN UP</button>
            </li>

            <li>
               <button onclick="bye();" type="submit" class="btn btnGray">CANCEL</button>
            </li>
         </ul>
      </form>
   </div>

   <script src="js/signup.js"></script>
   <script src="js/clock.js"></script>
</body>
</html>4