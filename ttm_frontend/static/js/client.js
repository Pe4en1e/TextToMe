// chat.js

// Убедимся, что скрипт выполнится после загрузки DOM
document.addEventListener("DOMContentLoaded", function () {

    // Получаем имя пользователя из localStorage
    const username =  localStorage.getItem('author');

    // if (!username) {
    //     alert("Username is missing");
    //     return;
    // }

    // Устанавливаем соединение с WebSocket сервером
    const socket = new WebSocket("ws://localhost:8080/websocket"); // Укажи свой WebSocket URL

    // Событие открытия соединения
    socket.onopen = function (event) {
        console.log("Connected to WebSocket server");
    };

    // Событие получения сообщения
    socket.onmessage = function (event) {
        const data = JSON.parse(event.data);

        // Обработка полученного сообщения
        const chatBox = document.getElementById('chatBlock');
        const messageElement = document.createElement('div');
        messageElement.className = "messageBubble"
        messageElement.innerHTML = `<h1 class="messageBubbleAuthor">${data.author}</h1><h1 class="messageBubbleContent">${data.message}</h1>`
        chatBox.appendChild(messageElement);


        const scrollToEnd = () => {
            chatBox.scrollTop = chatBox.scrollHeight;
        }

        new MutationObserver(scrollToEnd).observe(chatBox, {childList: true})

    };

    // Событие закрытия соединения
    socket.onclose = function (event) {
        console.log("WebSocket connection closed");
    };

    // Обработка ошибок
    socket.onerror = function (error) {
        console.log("WebSocket error:", error);
    };

    // Отправка сообщения в чат при отправке формы
    document.getElementById("send").addEventListener("click", function (event) {
        event.preventDefault();
        const messageInput = document.getElementById("text");
        const message = messageInput.value;

        if (message) {
            socket.send(JSON.stringify({ "author": username, "message": message }));
            messageInput.value = "";  // Очищаем поле ввода
        }
    });

    document.getElementById('text').onkeypress = function(e) {
        if (e.keyCode === 13) {
          document.getElementById('send').click();
        }
      };

});



