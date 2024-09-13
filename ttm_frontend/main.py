
from flask import Flask, render_template, request, redirect

app = Flask(__name__)

@app.route('/')
def root():
    return render_template('index.html')

@app.route('/chat', methods = ['GET', 'POST'])
def chat():
    if request.method == "GET":
        return redirect('/')
    return render_template('chat.html')

if __name__ == "__main__":
    app.run(debug=True, port=7070)