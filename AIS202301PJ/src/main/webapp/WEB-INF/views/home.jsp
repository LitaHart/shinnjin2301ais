<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>TODO LIST</title>
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

		<div class="container_home">
			<div class="PageMainDiv_home">
				<jsp:include page="${innerPageData}" />
			</div>
			<!-- menu bar -->
			<div class="wrapper">
				<ul class="menu">
					<!-- <li><a href="loginPage">ログイン</a></li> -->
					<li id="l1"><a href="mainlist">目標</a></li>
					<li id="l2"><a href="monthlylist">月間</a></li>
					<li id="l3"><a href="csvdownload">　一覧　</a></li>
				</ul>
			</div>
		</div>

</body>
</html>
