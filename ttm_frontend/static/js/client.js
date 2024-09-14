// chat.js

// Убедимся, что скрипт выполнится после загрузки DOM
document.addEventListener("DOMContentLoaded", function () {

    // Получаем имя пользователя из localStorage
    const username = "author" // localStorage.getItem('username');

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
    // socket.onmessage = function (event) {
    //     const data = JSON.parse(event.data);

    //     // Обработка полученного сообщения
    //     if (data.type === 'message') {
    //         const chatBox = document.getElementById('chat-box');
    //         const messageElement = document.createElement('div');
    //         messageElement.innerText = `${data.username}: ${data.message}`;
    //         chatBox.appendChild(messageElement);
    //     }
    // };

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
            socket.send(JSON.stringify({ author: username, message: message }));
            messageInput.value = "";  // Очищаем поле ввода
        }
    });

});
