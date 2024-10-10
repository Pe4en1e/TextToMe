
from flask import Flask, render_template, request, redirect, session
import requests as rq

app = Flask(__name__)
app.secret_key = 'adalsdaskda;lsdlasdk;erwq;'

@app.route('/')
def root():
    return render_template('index.html')

@app.route('/chat')
def chat():
    if not "username" in session:
        return redirect('/')

    username = session["username"]

    x = rq.get("http://ttm-back:8080/getAllMessages").json()

    return render_template('chat.html', messages = x, username = username)

@app.route('/login', methods = ['POST'])
def login():
    username = request.form.get("username")
    session['username'] = username
    return redirect('/chat')


@app.route("/test")
def test():
    return 'test'


if __name__ == "__main__":
    app.run(debug=True, port=7070, host='0.0.0.0')