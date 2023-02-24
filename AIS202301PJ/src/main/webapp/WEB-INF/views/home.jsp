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
				<li><a href="login">001</a></li>
				<li><a href="#">002</a></li>
				<li><a href="#">003</a></li>
				<li><a href="#" onclick="">004</a></li>
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
