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
    
    		 
    			 /*  // 선택된 목록 가져오기
    			  const query = 'input[name="checkname"]:checked';
    			  const selectedElements =  document.querySelectorAll(query);
    			  
    			  // 선택된 목록의 갯수 세기
    			  const selectedElementsCnt = selectedElements.length;
    			  
    			  // 출력
    			  document.getElementById('result').innerText
    			    = selectedElementsCnt; */
    		 
    		 
    	
    	
		
    	//達成率バー
    	let percent = 0
    	let tasseiritu = document.getElementById('tasseiritu');
    	let tasseirituValue = Number(tasseiritu.value);
    	
    	let timer = setInterval(function() {
    		percent += 1
    		$('.progress-text').text(percent + '%')
    		$('.bar').css('width', percent * 2)
    		
    		if(percent >= tasseirituValue) {
    			clearInterval(timer)
    		}
    	},30 );
    	
    	
    	var checkArr = new Array();
   	 	$('input[name="tasseiritu"]').each(function () {
   	    checkArr.push($(this).val());
      	$('input[name=tasseirituValuee]').attr('value',checkArr[0]);
      	})
    	
    	
    	
    	 //checkbox
    	 $('input:checkbox[name="checkname"]').each(function () {
    		 
    		 
    		 if ($(this).val() == 0) {
    			 $(this).siblings('span').html("<a href='asd'>修正</a>");
    			 
    			 
    			 
			}else if ($(this).val() == 1) {
				$(this).prop('checked',true);
				$(this).siblings('span').text("完了");
			}
    		 
   		  //checkbox click event
        	 $(this).change(function(){
        	 	if($(this).is(":checked")){
        	            $(this).siblings('span').text("完了");
        	            const query = 'input[name="checkname"]:checked';
        	            const selectedElements = document.querySelectorAll(query);
        	            const selectedElementsCnt = selectedElements.length;
        	          
        	          // 출력
        	    		$('input[name=result]').attr('value',selectedElementsCnt);

        	            
        	            
        		}else{
        	 			$(this).siblings('span').text(" ");
        	            $(this).siblings('span').html("<a href='asd'>修正</a>");
        	            $(this).siblings('span').text("完了");
        	            const query = 'input[name="checkname"]:checked';
        	            const selectedElements = document.querySelectorAll(query);
        	            const selectedElementsCnt = selectedElements.length;
        	          
        	          // 출력
        	    		$('input[name=result]').attr('value',selectedElementsCnt);

        	            
        	        }
        	    });
    		
    	})
    	
    	
    	
    });
    
   
	
 /*  //갯수
    const query = 'input[name="checkname"]:checked';
    const selectedElements = 
        document.querySelectorAll(query);
    
    // 선택된 목록의 갯수 세기
    const selectedElementsCnt =
          selectedElements.length;
    
    // 출력
    document.getElementById('result').innerText
      = selectedElementsCnt; */
    
    
    
    
    
    
    
  
    
	</script>
	
	
	
<link href='resources/css/mainlistPage.css' rel='stylesheet' type='text/css'> 
</head>
<body>

	<div class="PageMainDiv">
	<!-- Main div 【上】-->
	<input type="text" value="" name="result"/>
		<div>${simpleDate }の目標<button onclick="">▼</button></div>
	DB달성률<input value="" name="tasseirituValuee">
		<div class="progress-bar">
			<div class="bar">
				<div class="progress-text"></div>
			</div>
		</div>


		<div>${simpleDate }の目標<button　onclick=""　>▼</button></div>
		.progress-text
		<div class="progress-text"></div>
		.progress-bar
		<div class="progress-bar"></div>
		.bar
		<div class="bar"></div>
		
<button onclick="popupAdd()">追加</button>

<script>
function popupAdd() {
    window.open("popupAdd", "Pop-up Window", "width=500,height=500");
}
</script>
		<div>
		
		
		
     <div class="cbox2">
     <table style="border-color: black; border: 1px;">
     	<c:forEach var="k" items="${kadais}">
     	<tr>
     		<td>
     			${k.kadai_naiyou }<input type='checkbox' id="" name='checkname' value='${k.tassei_kahi }'><span></span>
     		</td>
     		<td>
     			<input value="${k.tasseiritu }" type="hidden" id="tasseiritu" name="tasseiritu"> 
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