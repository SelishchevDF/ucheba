from flask import Flask, make_response, render_template, request, redirect, url_for


app = Flask(__name__)


@app.route('/', methods=['GET', 'POST'])
def index():
    if request.method == 'POST':
        name = request.form.get('name')
        email = request.form.get('email')
        response = make_response(redirect(url_for('greet')))
        response.set_cookie('name', str(name))
        response.set_cookie('email', str(email))
        return response
    return render_template('index.html')
    

@app.route('/greet')
def greet():
    name = request.cookies.get('name')
    if name:
        return render_template('greet.html', name=name)
    return redirect(url_for('index_get'))


@app.route('/logout')
def logout():
    response = make_response(redirect('/'))
    response.delete_cookie('name')  
    response.delete_cookie('email')
    return response


if __name__ == '__main__':
    app.run(debug=True)
