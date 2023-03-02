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
        <h2>課題修正</h2>
        <input type="text" id="kadaiNum" value="${kadaiNum}" readonly>
        <input type="text" id="task-input" value="${kadai_naiyou}"
            onfocus="this.placeholder=''" onblur="this.placeholder='新規課題入力'"
            required>
        <div id="warning">必ず一文字以上書いてください。</div>
        <button id="cancel-btn">キャンセル</button>
        <button id="modify-btn">修正</button>
    </div>
    <script>
        'use strict';

        window.addEventListener('load', () => {
            const cancelBtn = document.getElementById('cancel-btn');
            const modifyBtn = document.getElementById('modify-btn');
            const taskInput = document.getElementById('task-input');
            const kadaiNumInput = document.getElementById('kadaiNum');

            modifyBtn.addEventListener('click', () => {
                const kadaiNum = kadaiNumInput.value.trim();
                const task = taskInput.value.trim();
                if (task.length < 1) {
                    const warning = document.getElementById('warning');
                    warning.style.display = 'block';
                } else {
                    const url = 'popupEdit.do?kadaikannri_number=' + kadaiNum + '&kadai_naiyou=' + task;
                    fetch(url)
                        .then(response => {
                            if (!response.ok) {
                                throw new Error('課題修正に失敗しました。');
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