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
#selected-date {
  display: inline-block;
  margin-right: 10px;
  position: absolute;
  top: 47px;
  right: 17px;
}



</style>
</head>
<body>
	<div class="popup">
		<p id="selected-date"></p>
		<p>社員番号: ${employee.shainn_number}</p>
		<p>社員名: ${employee.shainn_name}</p>
		<p>日付: <input type="text" id="datepicker" value="<%= new java.util.Date() %>"></p>
		
		<h2>課題追加</h2>
		<input name=addTask id="task-input" placeholder="新規課題入力"
			onfocus="this.placeholder=''" onblur="this.placeholder='新規課題入力'"
			required>
		<div id="warning">必ず一文字以上書いてください。</div>
		<h4>⚠️登録された課題は削除できません。ご注意ください。</h4>
		<button id="cancel-btn">キャンセル</button>
		<button id="register-btn">登録</button>
		<div class="ui calendar" id="deadline-calendar">
			<button id="deadline-btn" class="ui button">達成予定日</button>
		</div>
	</div>

<script>
    $(document).ready(function() {
        $("#datepicker").datepicker();
    });

    $("#popupAddForm").submit(function(event) {
        event.preventDefault();

        var formData = {
            shainn_number: "${employee.shainn_number}",
            kadaikannri_number: $("#kadaikannri_number").val(),
            tassei_yoteibi: $("#datepicker").val(),
            kadai_naiyou: $("#kadai_naiyou").val(),
            tassei_kahi: false
        };

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/mainLogin/popupAdd.do",
            data: JSON.stringify(formData),
            dataType: "json",
            success: function(data) {
                alert("Registration successful.");
            },
            error: function() {
                alert("Registration failed.");
            }
        });
    });

    $(document).ready(function() {
        $('#deadline-calendar').calendar({
            type: 'date',
            onChange: function(date, text, mode) {
                const japaneseDate = date.toLocaleDateString('ja-JP', { year: 'numeric', month: 'long', day: 'numeric' });
                console.log('Selected date: ' + japaneseDate);
                document.getElementById("selected-date").textContent = japaneseDate;
            }
        });
    });

    const deadlineBtn = document.getElementById('deadline-btn');
    deadlineBtn.addEventListener('click', () => {
        $('#deadline-calendar').calendar('show');
    });

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

    // 작동 스크립트
    window.addEventListener('load', () => {
        const cancelBtn = document.getElementById('cancel-btn');
        const registerBtn = document.getElementById('register-btn');
        const taskInput = document.getElementById('task-input');
        registerBtn.addEventListener('click', () => {
            const task = taskInput.value;
            if (task.trim().length < 1) {
                warning.style.display = 'block';
            } else {
                try {
                    location.href = 'popupAdd.do?task=' + task;
                    window.close();
                } catch (e) {
                    console.error(e);
                }
            }
        });

        cancelBtn.addEventListener('click', () => {
            window.close();
        });

    });
</script>


</body>
</html>
