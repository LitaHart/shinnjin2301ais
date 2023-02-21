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
    	
    	$('#example2').calendar({
    		  type: 'date'
    		});
    	
    	
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
    			 $(this).siblings('span').html("<a href='asd'>修正</a>");
    			 
    			 
    			 
			}else if ($(this).val() == 1) {
				$(this).prop('checked',true);
				$(this).siblings('span').text("完了");
			}
    		 
   		  //checkbox click event
        	 $(this).change(function(){
        	 	if($(this).is(":checked")){
        	            $(this).siblings('#changeKahi').attr("value","1");
        	            $(this).siblings('#span1').text("完了");
        	            const query = 'input[name="checkname"]:checked';
        	            const selectedElements = document.querySelectorAll(query);
        	            const selectedElementsCnt = selectedElements.length;
        	          
        	          // 출력
        	          aaa = ((selectedElementsCnt / checkArr.length) * 100 )
        	          
					        	          
        	        let percent = 0
        	      	let tasseiritu = document.getElementById('resultID2');
        	      	let tasseirituValue = Number(tasseiritu.value);
        	      	
        	      	let timer = setInterval(function() {
        	      		percent += 1
        	      		$('.progress-text').text((aaa).toFixed() + '%')
        	      		$('.bar').css('width', aaa * 2)
        	      		
        	      		if(percent >= tasseirituValue) {
        	      			clearInterval(timer)
        	      		}
        	      	},30 );
        	          
        	          

        	            
        	            
        		}else{
        			$(this).siblings('#changeKahi').attr("value","0");
        	 			$(this).siblings('#span1').text(" ");
        	            $(this).siblings('#span1').html("<a href='asd'>修正</a>");
        	            const query = 'input[name="checkname"]:checked';
        	            const selectedElements = document.querySelectorAll(query);
        	            const selectedElementsCnt = selectedElements.length;
        	          
        	          // 출력
          	          aaa = ((selectedElementsCnt / checkArr.length) * 100 )
          	    		

          	        let percent = 0
          	    	let tasseiritu = document.getElementById('resultID2');
          	    	let tasseirituValue = Number(tasseiritu.value);
          	    	
          	    	let timer = setInterval(function() {
          	    		percent += 1
          	    		$('.progress-text').text((aaa).toFixed() + '%')
          	    		$('.bar').css('width', aaa * 2)
          	    		
          	    		if(percent >= tasseirituValue) {
          	    			clearInterval(timer)
          	    		}
          	    	},30 );
        	          
        	          
        	            
        	        }
        	    });
    		
    	})
    	
    	
    	// 4
 		
    	$('input[name=result2]').attr('value',(aaa).toFixed());
    	
 		
 		let percent = 0
    	let tasseiritu = document.getElementById('resultID2');
    	let tasseirituValue = Number(tasseiritu.value);
    	
    	let timer = setInterval(function() {
    		percent += 1
    		$('.progress-text').text((aaa).toFixed() + '%')
    		$('.bar').css('width', aaa * 2)
    		
    		if(percent >= tasseirituValue) {
    			clearInterval(timer)
    		}
    	},30 );
 		
 		

 		
    });
  

    
    
    
	</script>
	
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="https://cdn.rawgit.com/mdehoog/Semantic-UI/6e6d051d47b598ebab05857545f242caf2b4b48c/dist/semantic.min.css" rel="stylesheet" type="text/css" />
<script src="https://code.jquery.com/jquery-2.1.4.js"></script>
<script src="https://cdn.rawgit.com/mdehoog/Semantic-UI/6e6d051d47b598ebab05857545f242caf2b4b48c/dist/semantic.min.js"></script>
<link href='resources/css/mainlistPage.css' rel='stylesheet' type='text/css'> 
</head>
<body>


	<div class="PageMainDiv">
	<!-- Main div 【上】-->
	
	<input type="hidden" value="" name="result2" id="resultID2"/>
		<div><span name="datespan" >${simpleDate }</span>の目標<button onclick="">▼</button></div>
		<input id="testInput">
		
		
  <div class="ui calendar" id="example2">
    <div class="ui input left icon">
      <i class="calendar icon"></i>
      <input id="calendarId" class="calendarClass" type="text" onchange="valueCheck()" placeholder="${simpleDate }" value="${simpleDate }">
    </div>
  </div>
  <br/>
		
		
		
		
		
		
		
		
		
		
		
		
		<div class="progress-bar">
			<div class="bar">
				<div class="progress-text"></div>
			</div>
		</div>
		
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
     			${k.kadai_naiyou }<input type='checkbox' id="" name='checkname' value='${k.tassei_kahi }'><span id="span1"></span>
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
	
	
	<!--　Main div 【下】 -->
	</div>
	
	
	
</body>
</html>