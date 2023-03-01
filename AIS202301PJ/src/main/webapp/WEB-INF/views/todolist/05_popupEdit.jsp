<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>課題編集</title>
<style>
.popup {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	background-color: white;
	padding: 20px;
	border-radius: 10px;
	width: 500px;
	text-align: center;
}

.popup h2 {
	text-align: left;
}

.popup input {
	width: 100%;
	padding: 10px;
	font-size: 18px;
	margin-top: 20px;
}
</style>
</head>
<body>
	<div class="popup">
		<h2>課題編集</h2>
		<input name="editTask" id="task-input" value="${requestScope.task}"
			onfocus="this.placeholder=''" onblur="this.placeholder='新規課題入力'">
		<button id="cancel-btn" style="font-size: 18px; padding: 10px 20px;">キャンセル</button>
		<button id="update-btn" style="font-size: 18px; padding: 10px 20px;">修正</button>

	</div>

	<script>
        'use strict';
        
        // 작동 스크립트
        window.addEventListener('load', () => {
            const cancelBtn = document.getElementById('cancel-btn');
            const updateBtn = document.getElementById('update-btn');
            const taskInput = document.getElementById('task-input');
            
            cancelBtn.addEventListener('click', () => {
                window.close();
            });
            
            updateBtn.addEventListener('click', () => {
                const task = taskInput.value;
                try {
                    location.href = 'popupEdit.do?id=<%= request.getParameter("id") %>&task=' + task;
                    window.close();
                } catch (e) {
                   console.error(e);
                }
            });

        });
    </script>

</body>
</html>
