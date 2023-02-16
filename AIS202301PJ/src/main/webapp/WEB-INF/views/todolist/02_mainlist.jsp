<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
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
    	},30 );
    	
    	
    	
    	   
    	 $('input:checkbox[name="aaa"]').each(function () {
   		  
        	 $(this).change(function(){
        	        if($(this).is(":checked")){
        	            $(this).siblings('span').text("完了");
        	            
        	        }else{
        	            $(this).siblings('span').text(" ");
        	            $(this).siblings('span').html("<a href='asd'>修正</a>");
        	            
        	            
        	        }
        	    });
    		
    	})

    		
    	
    	
    	
    	
    	
    });
    
   
	
  
    
	</script>
	
	
	
<link href='resources/css/mainlistPage.css' rel='stylesheet' type='text/css'> 
</head>
<body>
	

	<div class="PageMainDiv">
	<!-- Main div 【上】-->
		<div>${simpleDate }の目標<button onclick="">▼</button></div>
	DB달성률<input value="27" id="tasseiritu">
		<div class="progress-bar">
			<div class="bar">
				<div class="progress-text"></div>
			</div>
		</div>
		
		<div> <button>追加</button> </div>
		<div>
		
		
		
     <div class="cbox2">
     <table style="border-color: black; border: 1px;">
     	<c:forEach var="k" items="${kadais}">
     	<tr>
     		<td>
     			${k.kadai_naiyou }<input type='checkbox' id="bbb" name='aaa' value='${k.kadaikannri_number }'><span class="asdasd" name="spanname" id="result"></span>
     		</td>
     	</tr>
      	</c:forEach>
     </table>
     </div>
		
		
		
		</div>
	
	
	<!--　Main div 【下】 -->
	</div>
	
	
	
</body>
</html>