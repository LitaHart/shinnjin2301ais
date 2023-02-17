<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CSV DOWNLOAD PAG</title>
</head>
<body>

	
	<div class="PageMainDiv">
	<!-- Main div 【上】-->
		<div>
			<input type="checkbox">月別
			<input type="checkbox">すべて
		</div>
		<div>
			<input type="checkbox">　未達成課題を含む
		</div>
		
		<div>
			月を選択(ドロップボックス)
		</div>
		
		<div>
			<button onclick="location.href='csvdownload.test.csv'">csvダウンロード</button>
			<button onclick="location.href='csvdownload.test.excel'">excelダウンロード</button>
		</div>
	<!--　Main div 【下】 -->
	</div>
		



</body>
</html>