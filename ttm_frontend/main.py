
from flask import Flask, render_template, request, redirect
import requests as rq

app = Flask(__name__)

@app.route('/')
def root():
    return render_template('index.html')

@app.route('/chat', methods = ['GET', 'POST'])
def chat():
    if request.method == "GET":
        return redirect('/')

    username = request.form.get("username")

    x = rq.get("http://127.0.0.1:8080/getAllMessages").json()
    print(x)

    return render_template('chat.html', messages = x, username = username)

if __name__ == "__main__":
    app.run(debug=True, port=7070, host='0.0.0.0')