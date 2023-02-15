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
		
    	let percent = 0
    	let tasseiritu = document.getElementById('tasseiritu');
    	let tasseirituValue = Number(tasseiritu.value);
    	
    	let timer = setInterval(function() {
    		percent += 1
    		$('.progress-text').text(percent + '%')
    		$('.bar').css('width', percent)
    		
    		if(percent >= tasseirituValue) {
    			clearInterval(timer)
    		}
    	}, 30);
    	
    	
    	// 체크박스    https://openlife.tistory.com/381
    	
    	$(".cbox").change(function(){
            if($($(this)).is(":checked")) {
            	$('#asdasd').text("完了")
            	
            } else {
            	$(".asdasd").html("")
            	$(".asdasd").append("<a href='syuuseigamenn'>修正</a>"); // 태그 추가
            }
        });
    	
    	
    	
    	
    });
    
	</script>
<link href='resources/css/mainlistPage.css' rel='stylesheet' type='text/css'> 
</head>
<body>
	

	<div class="PageMainDiv">
	<!-- Main div 【上】-->
		<div>${simpleDate }の目標<button onclick="">▼</button></div>
	DB달성률<input value="38" id="tasseiritu">
		<div class="progress-bar">
			<div class="bar">
				<div class="progress-text"></div>
			</div>
		</div>
		
		<div> <button>追加</button> </div>
		<div>
		<div>
			<div>과제갯수만큼 뿌려주기</div>
		</div>
		</div>
	
	체크여부 값 바꾸기<input type="checkbox" class="cbox">
	<span class="asdasd" id="asdasd"></span>
	
	<!--　Main div 【下】 -->
	</div>
	
	
	
</body>
</html>