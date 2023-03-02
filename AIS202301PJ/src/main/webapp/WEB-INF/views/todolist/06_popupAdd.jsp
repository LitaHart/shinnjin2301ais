<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-2.1.4.js"></script>
<script
	src="https://cdn.rawgit.com/mdehoog/Semantic-UI/6e6d051d47b598ebab05857545f242caf2b4b48c/dist/semantic.min.js"></script>
<link
	href="https://cdn.rawgit.com/mdehoog/Semantic-UI/6e6d051d47b598ebab05857545f242caf2b4b48c/dist/semantic.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>課題追加</title>
<style>
.popup {
	position: fixed;
	top: 0;
	left: 0;
	bottom: 0;
	right: 0;
	background-color: white;
	padding: 20px;
	border-radius: 10px;
	width: 500px;
	height: 300px;
	margin: auto;
	text-align: center;
}

.popup h2 {
	text-align: left;
}

.popup h4 {
	color: red;
	text-align: left;
}

.popup input {
	width: 100%;
	padding: 10px;
	font-size: 18px;
	margin-top: 20px;
}

.popup #deadline-btn {
	position: absolute;
	top: 10px;
	right: 10px;
}

.popup #warning {
	display: none;
	color: red;
	font-size: 14px;
	margin-top: 5px;
}


</style>
</head>
<body>
	<div class="popup">
		<h2>課題追加</h2>
		<input type="text" value="${sessionScope.loginShainn.shainn_number }"id="shainn_number">
		
		<input name=addTask id="task-input" placeholder="新規課題入力"
			onfocus="this.placeholder=''" onblur="this.placeholder='新規課題入力'"
			required>
		<div id="warning">必ず一文字以上書いてください。</div>
		<h4>⚠️登録された課題は削除できません。ご注意ください。</h4>
		<button id="cancel-btn">キャンセル</button>
		<button id="register-btn">登録</button>
	</div>

<script>
  const taskInput = document.getElementById('task-input');
  const warning = document.getElementById('warning');

  taskInput.addEventListener('input', (event) => {
    const inputRegex = /^[\uAC00-\uD7AF\u1100-\u11FF\u3130-\u318F\uA960-\uA97F\uD7B0-\uD7FF\u3040-\u30ff\uff01-\uff5e\u4e00-\u9faf\w\s]*$/;
    if (!inputRegex.test(taskInput.value)) {
      alert('ハングル、英語、日本語(全角、半角)以外は入力できません。');
      event.preventDefault();
      taskInput.value = taskInput.value.replace(/[^\uAC00-\uD7AF\u1100-\u11FF\u3130-\u318F\uA960-\uA97F\uD7B0-\uD7FF\u3040-\u30ff\uff01-\uff5e\u4e00-\u9faf\w\s]/g, '');
    }
  });

  'use strict';

//작동 스크립트
  window.addEventListener('load', () => {
  const cancelBtn = document.getElementById('cancel-btn');
  const registerBtn = document.getElementById('register-btn');
  const taskInput = document.getElementById('task-input');
  const yearAndMonthData = '<%= request.getParameter("yearAndMonthData") %>';
   
    
    
  registerBtn.addEventListener('click', () => {
	  var shainn_number = document.getElementById('shainn_number').value;
	  const task = taskInput.value.trim();
	  if (task.length < 1) {
	    warning.style.display = 'block';
	  } else {
	    const url = 'popupAdd.do?kadai_naiyou=' + task + '&tassei_yoteibi=' + yearAndMonthData + '&shainn_number=' + shainn_number;
	    fetch(url)
	      .then(response => {
	        if (!response.ok) {
	          throw new Error('課題数は最大10個まで登録できます。');
	        }
	        window.close();
	      })
	      .catch(error => {
	        alert(error.message);
	      });
	  }
	});

    	cancelBtn.addEventListener('click', () => {
    	  window.close();
    	});

    });
</script>

</body>
</html>