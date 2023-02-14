<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MAIN LIST UP PAGE</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
	<script type="text/javascript">
    $(document).ready(function() {
    	console.clear();

    	let percent = 0

    	let timer = setInterval(function() {
    		percent += 1
    		$('.progress-text').text(`${percent} %`)
    		$('.bar').css('width', `${percent}%`)
    		
    		if(percent >= 38.8) {
    			clearInterval(timer)
    		}
    	}, 30)
    });
	</script>
<link href='resources/css/mainlistPage.css' rel='stylesheet' type='text/css'> 
</head>
<body>
	
	
	<div class="PageMainDiv">
	<!-- Main div 【上】-->
		
		<div>${simpleDate }の目標<button　onclick=""　>▼</button></div>
		.progress-text
		<div class="progress-text"></div>
		.progress-bar
		<div class="progress-bar"></div>
		.bar
		<div class="bar"></div>
		<div> <button>追加</button> </div>
		<div>
		<!-- table あります。 【下】-->
			<table border="1">
			<tr>
				<td>課題</td>
				<td><input type="checkbox">︎</td>
				<td>完了or修正</td>
			</tr>
			</table>
		<!-- table あります。 【上】-->
		</div>
	
	
	
	
	<!--　Main div 【下】 -->
	</div>
	
	
	
</body>
</html>