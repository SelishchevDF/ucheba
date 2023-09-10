from flask import Flask, render_template, request
from models import db, User
from werkzeug.security import generate_password_hash


app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///mydatabase.db'
db.init_app(app)


@app.cli.command("init-db")
def init_db():
    db.create_all()
    print('---OK---')
    
    
#@app.cli.command("add_user")
def add_user(name, second_name, email, password):
    hash_password = generate_password_hash(password)
    user = User()
    user.name=name 
    user.second_name=second_name 
    user.email=email
    user.password=hash_password
    db.session.add(user)
    db.session.commit()



@app.route('/', methods=['GET', 'POST'])
def index():
    if request.method == 'POST':
        name = request.form.get('name')
        second_name = request.form.get('sec_name')
        email = request.form.get('email')
        password = request.form.get('password')
        add_user(name, second_name, email, password)
        return render_template('greet.html', name=name)
    return render_template('index.html')
    


if __name__ == '__main__':
    init_db()
    app.run(debug=True)