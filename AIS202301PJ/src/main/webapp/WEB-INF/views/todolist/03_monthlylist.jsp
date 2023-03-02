<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MONTHLY LIST UP PAGE</title>
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="https://cdn.rawgit.com/mdehoog/Semantic-UI/6e6d051d47b598ebab05857545f242caf2b4b48c/dist/semantic.min.css" rel="stylesheet" type="text/css" />
<script src="https://cdn.rawgit.com/mdehoog/Semantic-UI/6e6d051d47b598ebab05857545f242caf2b4b48c/dist/semantic.min.js"></script>
<script type="text/javascript">
<<<<<<< HEAD
$(document).ready(function(){
   	var simpleDateVal = document.getElementById("simpleDateInput").value;
	var simpleDateSub = simpleDateVal.substr(0, 3);
	$("#simpleDateSpan").text(simpleDateSub);
	
	
	
	
	 $('#csvCalendar').calendar({
			type: 'month'
		 });
	
	
	 /* 오늘 날짜 불러오기 */
	 	var today = new Date();
	 	var todayEN = today.toLocaleDateString("en-us", { 
	 		year: "numeric", 
	 		month: "short" 
	 		}); 
		/* 오늘 연도,달 출력 */
		$('#yearAndMonthData').val(todayEN);
	 	console.log(todayEN);
	 	/* =============================================== */ 	
		
	 	function getYmd10() {
 	//yyyy-mm-dd 포맷 날짜 생성
 		var d = new Date();
 		return d.getFullYear() + "-" + ((d.getMonth() + 1) > 9 ? (d.getMonth() + 1).toString() : "0" + (d.getMonth() + 1)) + "-" + (d.getDate() > 9 ? d.getDate().toString() : "0" + d.getDate().toString());
		}; // max날짜 정하고싶은데 진행중
	 	/* =============================================== */ 	
		/* 선택한 달 가져오기 */
		document.getElementById( "yearAndMonthData" ).onblur = function(){
		var shainn_number = document.getElementById("shainn_numberInput").value;
		/* 인풋창	값 */
	 	var yearAndMonthData = document.getElementById("yearAndMonthData").value;
	 	/* 인풋창에서 선택한 날짜 출력 */ 
		console.log(yearAndMonthData);
	 	//yearAndMonthData 보내고 if로 바꾸기
	 	$('#yearAndMonthData').val(yearAndMonthData);
	 	
		location.href='monthlylist?yearAndMonthData='+yearAndMonthData;
	 	/* =============================================== */ 	 
	 	
	 	
	 	
	 	
	 	
		};
	
		
		
		
		
    
});



=======
	$(document)
			.ready(
					function() {
						var simpleDateVal = document
								.getElementById("simpleDateInput").value;
						var simpleDateSub = simpleDateVal.substr(0, 3);
						$("#simpleDateSpan").text(simpleDateSub);
						$('#csvCalendar').calendar({
							type : 'month'
						});
						/* 오늘 날짜 불러오기 */
						var today = new Date();
						var todayEN = today.toLocaleDateString("en-us", {
							year : "numeric",
							month : "short"
						});
						/* 오늘 연도,달 출력 */
						$('#yearAndMonthData').val(todayEN);
						console.log(todayEN);
						/* =============================================== */

						function getYmd10() {
							//yyyy-mm-dd 포맷 날짜 생성
							var d = new Date();
							return d.getFullYear()
									+ "-"
									+ ((d.getMonth() + 1) > 9 ? (d.getMonth() + 1)
											.toString()
											: "0" + (d.getMonth() + 1))
									+ "-"
									+ (d.getDate() > 9 ? d.getDate().toString()
											: "0" + d.getDate().toString());
						}
						; // max날짜 정하고싶은데 진행중
						/* =============================================== */
						/* 선택한 달 가져오기 */
						document.getElementById("yearAndMonthData").onblur = function() {
							var shainn_number = document
									.getElementById("shainn_numberInput").value;
							/* 인풋창	값 */
							var yearAndMonthData = document
									.getElementById("yearAndMonthData").value;
							/* 인풋창에서 선택한 날짜 출력 */
							console.log(yearAndMonthData);
							//yearAndMonthData 보내고 if로 바꾸기
							$('#yearAndMonthData').val(yearAndMonthData);

							location.href = 'monthlylist?yearAndMonthData='
									+ yearAndMonthData;
							/* =============================================== */
						};
					});
>>>>>>> d8bdb89f5c9a8ec3aa83cdd2e21d447736acca53
</script>
</head>
<body>

		
	<div class="PageMainDiv">
	<!-- Main div 【上】-->
		<div><input type="hidden" value="${sessionScope.loginShainn.shainn_number }" id="shainn_numberInput"></div>
		<div><input value="${simpleDate }" id="simpleDateInput" type="hidden"></div>
		<div><span id="simpleDateSpan"></span>月</div>
	<!-- Calendar-->
	
	<div class="PageMainDiv">
		<!--  ==================	임시 데이터 출력 -->
		<table border="1">
			<c:forEach items="${forRequest}" var="fr" varStatus="frstatus">
				<c:forEach items="${fr}" var="fa" varStatus="faStatus">
				<tr>
						<td>${fa.key}</td>
						<td>${fa.value}</td>
				</tr>
				</c:forEach>
			</c:forEach>
			
		</table>
	<!-- ========================= -->
	<div id="mainlist_header">
		<!-- sankaku button -->
		
			<div class="ui calendar" id="csvCalendar">
				<label for="yearAndMonthData"> <input style="opacity: 0;"
					type="checkbox" id="yearAndMonthData" class="calendarClass"
					value="${simpleDate}"> ▼
				</label>
			</div>
			<div class="user_name"><span>${sessionScope.loginShainn.shainn_name }様</span></div>
	</div>
		
	<!-- ================================= -->
		<!-- Main div 【上】-->
		<div>
			<input value="${simpleDate }" id="simpleDateInput" type="hidden">
		</div>
		<div>
			<span id="simpleDateSpan"></span>月
		</div>
		
		
		<!-- Calendar-->
		<div>
			<br>
			<div class="ui calendar" id="csvCalendar" style="visibility: hidden;">
				<div class="ui input left icon">
					<i class="time icon"></i> <input name="selectedMonth"
						id="yearAndMonthData" type="text" value="${simpleDate }" />
				</div>
			</div>
		</div>

		<div>
			<input type="checkbox"> 未達成課題を含む
		</div>
		
		<div>
		<!-- table あります。 【下】-->
			<table border="1">
			<c:forEach items="${kadais }" var="k">
			<tr>
				<td>${k.kadai_naiyou }</td>
				<td><fmt:formatDate value="${k.tassei_yoteibi }" pattern="dd日"/></td>
				<td>✔︎︎</td>
			</tr>
			</c:forEach>
			</table>
		<!-- table あります。 【上】-->
		</div>
		
	<!--　Main div 【下】 -->
	</div>
		

</body>
</html>