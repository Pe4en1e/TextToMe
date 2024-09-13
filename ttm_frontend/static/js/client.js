const WebSocket = require('ws');
const ws = new WebSocket('ws://127.0.0.1:8080/websocket')

ws.onopen = () => {
    console.log('ws openned!')
    ws.send('message')
}

ws.onmessage = (message) => {
    console.log(message)
}