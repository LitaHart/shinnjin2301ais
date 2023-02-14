<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Home</title>
<!-- js link -->
<script type="text/javascript" src="resources/js/jquery.js"></script>
</head>
<body>
<h1 style="color:red;">USE JSP_INCLUDE ON THIS PAGE</h1>
<h1>
	Hello world!  
</h1>
<P>  The time on the server is ${serverTime}. </P>

<form action="mainlist">
	<button onclick="">Mainlist</button>
</form>

</body>
</html>
