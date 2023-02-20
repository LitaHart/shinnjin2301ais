<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="https://cdn.rawgit.com/mdehoog/Semantic-UI/6e6d051d47b598ebab05857545f242caf2b4b48c/dist/semantic.min.css" rel="stylesheet" type="text/css" />
<script src="https://code.jquery.com/jquery-2.1.4.js"></script>
<script src="https://cdn.rawgit.com/mdehoog/Semantic-UI/6e6d051d47b598ebab05857545f242caf2b4b48c/dist/semantic.min.js"></script>
 <!-- https://codepen.io/SaadRegal/pen/ezVBJL -->
 
 
 <script type="text/javascript">
	$(function() { 
	
			
		/* 년도와 달이 선택 가능한 캘린더 */
		 $('#csvCalendar').calendar({
			type: 'month'
		 });
	 		 
	 	/* 오늘 날짜 불러오기 */
	 	 var today = new Date().toLocaleDateString("en-us", { year: "numeric", month: "short" }); 
		/* 오늘 연도,달 출력 */
	 	console.log(today);
		$('#yearAndMonthData').val(today);
		
		/* 선택한 달 가져오기 */
		document.getElementById( "yearAndMonthData" ).onblur = function(){
		/* 인풋창	값 */
 	 	var yearAndMonthData = document.getElementById("yearAndMonthData").value;
 	 	/* 인풋창에서 선택한 날짜 출력 */ 
		console.log(yearAndMonthData);
 		};
	});
 </script>
 
 
 
<meta charset="UTF-8">
<title>CSV DOWNLOAD PAG</title>
</head>
<body>

	
	<div class="PageMainDiv">
	<!-- Main div 【上】-->
		<div>
			<input value="csvMonth" type="checkbox">月別
			<input value="csvAll" type="checkbox">すべて
		</div>
		<div>
			<input value="csvInclude" type="checkbox">　未達成課題を含む
		</div>
		<div>
			 <h3>Month and year</h3>
  				<div class="ui calendar" id="csvCalendar">
   				<div class="ui input left icon">
      			<i class="time icon"></i>
     				<input id="yearAndMonthData" type="text" placeholder="Time">
    			</div>
  				</div>
  			<br/>
		</div>
		<div>
			<button onclick="location.href='csvdownload.test.csv'">csvダウンロード</button>
			<button onclick="location.href='csvdownload.test.excel'">excelダウンロード</button>
		</div>
	<!--　Main div 【下】 -->
	</div>
		



</body>
</html>