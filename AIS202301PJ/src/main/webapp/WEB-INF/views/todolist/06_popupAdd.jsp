<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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

    </style>
</head>
<body>
    <div class="popup">
        <h2>課題追加</h2>
        <input name=addTask id="task-input" placeholder="新規課題入力"
            onfocus="this.placeholder=''" onblur="this.placeholder='新規課題入力'">
        <h4>⚠️登録された課題は削除できません。ご注意ください。</h4>
        <button id="cancel-btn">キャンセル</button>
        <button id="register-btn">登録</button>
        <button id="deadline-btn">達成予定日</button>
    </div>
    
    
    
    <script>
        'use strict';
        
        // 작동 스크립트
        window.addEventListener('load', () => {
            const cancelBtn = document.getElementById('cancel-btn');
            const registerBtn = document.getElementById('register-btn');
            const taskInput = document.getElementById('task-input');
            
            cancelBtn.addEventListener('click', () => {
                window.close();
            });
            
            registerBtn.addEventListener('click', () => {
                const task = taskInput.value;
                try {
                    location.href = 'popupAdd.do?task=' + task;
                    window.close();
                } catch (e) {
                    console.error(e);
                }
            });
        });
    </script>
    
</body>
</html>
