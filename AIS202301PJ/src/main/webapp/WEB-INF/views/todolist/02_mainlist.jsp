<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link href="resources/css/todolistMain.css" rel="stylesheet"
	type="text/css">
<link
	href="https://cdn.rawgit.com/mdehoog/Semantic-UI/6e6d051d47b598ebab05857545f242caf2b4b48c/dist/semantic.min.css"
	rel="stylesheet" type="text/css" />
<link href='resources/css/mainlistPage.css' rel='stylesheet'type='text/css'>
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet" type="text/css" />

<link href="https://cdn.rawgit.com/mdehoog/Semantic-UI/6e6d051d47b598ebab05857545f242caf2b4b48c/dist/semantic.min.css" rel="stylesheet" type="text/css" />
<script src="https://cdn.rawgit.com/mdehoog/Semantic-UI/6e6d051d47b598ebab05857545f242caf2b4b48c/dist/semantic.min.js"></script>
<head>
<meta charset="UTF-8">
<title>MAIN LIST UP PAGE</title>
<script type="text/javascript">	
    $(document).ready(function() {	
    	$('#example2').calendar({
    		  type: 'date'
    		}); 
	 	document.getElementById( "yearAndMonthData" ).onblur = function(){	
			/* 인풋창	값 */
	 	 	var yearAndMonthData = document.getElementById("yearAndMonthData").value;
	 	 	var shainn_number = document.getElementById("shainn_numberInput").value;
	 	 	/* 인풋창에서 선택한 날짜 출력 */ 
			console.log(yearAndMonthData);
			console.log(shainn_number);
	 	 	/* =============================================== */
	 	 	
	 	$('#yearAndMonthData').val(yearAndMonthData);
	 	 	location.href = 'selectHidukeDate?yearAndMonthData='+yearAndMonthData+'&shainn_number='+ shainn_number  	
			};	 	
    	 $(window).bind("beforeunload", function (){
    		
    		var kahiArr = new Array();
     		var kadaiArr = new Array();
     		var yoteibiArr = new Array();
     		var shainn_number = new Array();
        	 	$('input[name="checkname"]').each(function (i,e) {
        	 	kahiArr.push($(this).siblings('#changeKahi').val());
        	 	shainn_number.push($(this).siblings('#shainn_number').val());
        	 	kadaiArr.push($(this).siblings('#kadaiNum').val());
        	 	yoteibiArr.push($(this).siblings('#yoteibi').val());
     		
        	 	console.log(kahiArr);
     		
     		$.ajax({
                url: 'update.tassei.kahi',
                data : {
                    "kahiArr": kahiArr[i],
                    "kadaiArr": kadaiArr[i],
                    "yoteibiArr": yoteibiArr[i],
                    "shainn_number": shainn_number[i]
                },
                type: 'get',
                dataType : 'text',
                success : function(getData) {
    				console.log(getData);
    				if (getData == 1) {
    					console.log("成功");
    				}else {
    					console.log("失敗");
    				}
    			}
            })
     		
           	})
    	        
    	    });
    	//達成率バー
    	var checkArr = new Array();
   	 	$('input[name="tasseiritu"]').each(function () {
   	    checkArr.push($(this).val());
      	})
    	var checkArr = new Array();
   		var total = 0;
    	 //checkbox
    	 $('input:checkbox[name="checkname"]').each(function (i, e) {
    		    checkArr.push($(this).val());
    		if (checkArr[i] == 1) {
				total ++;
			} else {
			}
    		

    		// 2
    		 aaa = ((total / checkArr.length) * 100);
    		 if ($(this).val() == 0) {
   			var kadaiNum = $(this).siblings('#kadaiNum').val();
			var kadai_naiyou = $(this).siblings('#kadai_naiyou2').val();
    			 
				$(this).siblings('#span1').html("<a class='content'>修正</a>");
			}else if ($(this).val() == 1) {
				$(this).prop('checked',true);
				$(this).siblings('#span1').text("完了");
			}
			//checkbox click event
			$(this).change(function() {
				if ($(this).is(":checked")) {
					$(this).siblings('#changeKahi').attr("value", "1");
					$(this).siblings('#span1').text("完了");
					
					const query = 'input[name="checkname"]:checked';
					const selectedElements = document.querySelectorAll(query);
					const selectedElementsCnt = selectedElements.length;
					// 출력
					aaa = ((selectedElementsCnt / checkArr.length) * 100)

					let percent = 0
					let tasseiritu = document.getElementById('resultID2');
					let tasseirituValue = Number(tasseiritu.value);

					let timer = setInterval(function() {
						percent += 1
						$('.progress-text').text((aaa).toFixed() + '%')
						/* Bar width */
						$('.bar').css('width', aaa * 4)

						if (percent >= tasseirituValue) {
							clearInterval(timer)
						}
					}, 30);

				} else {
					var kadaiNum = $(this).siblings('#kadaiNum').val();
					var kadai_naiyou = $(this).siblings('#kadai_naiyou2').val();
					

					var link = "popupEdit?kadaiNum="+kadaiNum+"&kadai_naiyou="+kadai_naiyou;

					
					//window.open(link, '_blank', 'width=600,height=400');
				
						//"<a onclick='asd('${k.kadaikannri_number }','${k.kadai_naiyou }')'>修正</a>"
			

					
					$(this).siblings('#changeKahi').attr("value", "0");
					$(this).siblings('#span1').text(" ");
					$(this).siblings('#span1').html("<a class='content' >修正</a>");
					
					const query = 'input[name="checkname"]:checked';
					const selectedElements = document.querySelectorAll(query);
					const selectedElementsCnt = selectedElements.length;

					// 출력
					aaa = ((selectedElementsCnt / checkArr.length) * 100)

					let percent = 0
					let tasseiritu = document.getElementById('resultID2');
					let tasseirituValue = Number(tasseiritu.value);

					let timer = setInterval(function() {
						percent += 1
						$('.progress-text').text((aaa).toFixed() + '%')
						$('.bar').css('width', aaa * 4)

						if (percent >= tasseirituValue) {
							clearInterval(timer)
						}
					}, 30);

				}
			});

		})

		// 4

		$('input[name=result2]').attr('value', (aaa).toFixed());

		let percent = 0
		let tasseiritu = document.getElementById('resultID2');
		let tasseirituValue = Number(tasseiritu.value);

		let timer = setInterval(function() {
			percent += 1
			$('.progress-text').text((aaa).toFixed() + '%')
			$('.bar').css('width', aaa * 4)

			if (percent >= tasseirituValue) {
				clearInterval(timer)
			}
		}, 30);


    
    });
    
    
    
    
    
    
    
    
</script>

<!-- HONG JS -->
<script type="text/javascript">

function popupAdd() {	//팝업 추가창
    var yearAndMonthData = document.getElementById("yearAndMonthData").value;
    var url = "popupAdd?yearAndMonthData=" + yearAndMonthData;
    var popup = window.open(url, "Pop-up Window", "width=500,height=500");
    popup.opener = window;
	}

	//팝업 수정창 불러내는 JSP
	
	//function asd (a,b) {
	//	alert(a);
	//	alert(b);
	//	var kadaiNum = $(this).siblings('#kadaiNum').val();
	//	var kadai_naiyou = $(this).siblings('#kadai_naiyou2').val();
	//
	  //var popupWindow = window.open('popupEdit?kadaiNum='+kadaiNum+'&kadai_naiyou='+kadai_naiyou, '_blank', 'width=600,height=400');
	
	//}
		
		});
		
		
	 

	$(document).ready(function() {
						let percent = 0
						let tasseiritu = document.getElementById('tasseiritu');
						let tasseirituValue = Number(tasseiritu.value);

							$('.progress-text').text(percent + '%')
							$('.bar').css('width', percent)

						
					});
	
	
	
</script>
</head>
<body>
	<div class="PageMainDiv">
		<!-- Main div 【上】-->
		<input type="hidden" value="" name="result2" id="resultID2" />
		<div id="mainlist_header">
			<div>
				<span name="datespan">${simpleDate }</span>の目標 <input type="hidden"
					value="${sessionScope.loginShainn.shainn_number }"
					id="shainn_numberInput">
			</div>

			<input type="hidden"
				value="${sessionScope.loginShainn.shainn_number }"
				id="shainn_numberInput">

			<!-- sankaku button -->
			<div class="ui calendar" id="example2">
				<label for="yearAndMonthData"> <input style="opacity: 0;"
					type="checkbox" id="yearAndMonthData" class="calendarClass"
					value="${simpleDate}"> ▼
				</label>
			</div>
			<div class="user_name"><span　>${sessionScope.loginShainn.shainn_name }様</span></div>
		</div>
		<!-- =========================== -->
		<div class="ui calendar" id="example2" style="visibility: hidden;">
			<div class="ui input left icon">
				<i class="calendar icon"></i> <input name="selectedMonth"
					id="yearAndMonthData" class="calendarClass" type="text"
					placeholder="" value="${simpleDate }">
			</div>
		</div>
		<!-- =========================== -->
		<div class="progress_bar_div">
			<div class="progress-bar">
				<div class="bar">
					<div class="progress-text"></div>
				</div>
			</div>
		</div>
		<!-- =========================== -->

		<div class="second_header">
			<div id="box_image">
				<img style="width: 40px; height: 40px;" alt="box_image"
					src="resources/img/tasksInBox.png">
			</div>
			<div id="addBtn">
				<button onclick="popupAdd()">追加</button>
			</div>
		</div>







		<c:if test="${empty kadais}">
			<div class="empty_txt">
				<div class="emptyTxt">目標の履歴がありません。</div>
			</div>
		</c:if>
		
		<div>
		<!-- here to sub -->
			<div class="touroku_kadai_table">
				<table>
					<c:forEach var="k" items="${kadais}">
						<tr>
							<td id="kadai_list"><span id="kadai_naiyou">${k.kadai_naiyou }</span></td>
							<td id="kadai_tassei">
							<input type='checkbox' id="checknameId" name='checkname' value='${k.tassei_kahi }'>
							<span id="span1"></span>
							<input type="hidden" id="kadai_naiyou2" value='${k.kadai_naiyou }'>
							<input type="hidden" id="kadaiNum" value='${k.kadaikannri_number }'>
							<input type="hidden" id="yoteibi" value='${k.tassei_yoteibi }'>
							<input type="hidden" value="${k.tassei_kahi }" id="changeKahi">
							<input type="hidden" value="${k.shainn_number }" id="shainn_number">
							</td>
							<td>
							<input value="${k.tasseiritu }" type="hidden" id="tasseiritu" name="tasseiritu">
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<!-- Main div 【下】-->
	</div>

</body>

<script type="text/javascript">
$(document).ready(function() {
	$('#asd123').click(function funcA() {
		alert('assadasdasdd');
		
		var kadaiNum = $(this).siblings('#kadaiNum').val();
	var kadai_naiyou = $(this).siblings('#kadai_naiyou2').val();
		

		//var link = "popupEdit?kadaiNum="+kadaiNum+"&kadai_naiyou="+kadai_naiyou;

		
		//window.open(link, '_blank', 'width=600,height=400');
		
	})
	
	
	
});


$(document).ready(function () {
	$('.content').click(function(){
		
		alert('asdaasd12');
	
	
	});



</script>
</html>

