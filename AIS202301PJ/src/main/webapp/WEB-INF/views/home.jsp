<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<!-- FONT -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=DotGothic16&display=swap"
	rel="stylesheet">
<!-- JS -->
<script type="text/javascript" src="resources/js/jquery.js"></script>
<link href="resources/css/todolistMain.css" rel="stylesheet"
	type="text/css">
<link href="resources/css/loginPage.css" rel="stylesheet"
	type="text/css">
<link href="resources/css/csvdownloadPage.css" rel="stylesheet"
	type="text/css">
<script src="https://code.jquery.com/jquery-2.1.4.js"></script>
<script
	src="https://cdn.rawgit.com/mdehoog/Semantic-UI/6e6d051d47b598ebab05857545f242caf2b4b48c/dist/semantic.min.js"></script>
<!-- https://codepen.io/SaadRegal/pen/ezVBJL -->
</head>
<!-- Move Pages -->
<script type="text/javascript"></script>
<body>

	<div>
		<div class="container_home">
			<div class="PageMainDiv_home">
				<jsp:include page="${innerPageData}" />
			</div>
			<!-- menu bar -->
			<div class="wrapper">
				<ul class="menu">
					<li><a href="loginPage">ログイン</a></li>
					<li><a href="mainlist">目標</a></li>
					<li><a href="monthlylist">月間</a></li>
					<li><a href="csvdownload">　一覧　</a></li>
					<li><a href="#">005</a></li>
				</ul>
			</div>

		</div>
	</div>


	<h1 style="color: red;">USE JSP_INCLUDE ON THIS PAGE</h1>
	<h1>Hello world!</h1>
	<P>The time on the server is ${serverTime}.</P>

	<!-- 臨時JUMP -->
	<form action="loginPage">
		<button onclick="">LoginPage</button>
	</form>

	<form action="mainlist">
		<button onclick="">Mainlist</button>
	</form>

	<form action="monthlylist">
		<button onclick="">MonthlyDownloadList</button>
	</form>

	<form action="csvdownload">
		<button onclick="">CSVDownloadPage</button>
	</form>




</body>
</html>
