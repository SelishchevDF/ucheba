from flask import Flask
from flask import render_template
import t1_CONSTANT


app = Flask(__name__)


@app.route('/')
@app.route('/index/')
def index():
    context = {'title': 'Главная'}
    return render_template('index.html', **context)


@app.route('/categories/')
def categories():
    tit = {'title': 'Категории товаров'}
    context = t1_CONSTANT.product_categories
    return render_template('categories.html', **tit, context=context)


@app.route('/categories/<string:category>/')
def prod_in_cat(category):
    # тут стоило бы собрать класс категория_товара и собрать их в список
    if category == 'shoes':
        context = t1_CONSTANT.shoes
    if category == 'clothes':
        context = t1_CONSTANT.clothes
    if category == 'food':
        context = t1_CONSTANT.food
    tit = {'title': category}
    return render_template('prod_in_cat.html', **tit, context=context)

# тут стоило бы собрать класс товар (((
@app.route('/categories/<string:category>/<string:prod>/')
def prod(category, prod):
    if category == 'shoes':
        dict = t1_CONSTANT.shoes
        context = print(next(x for x in dict if x["name"] == prod))
    if category == 'clothes':
        dict = t1_CONSTANT.clothes
        context = print(next(x for x in dict if x["name"] == prod))
    if category == 'food':
        dict = t1_CONSTANT.food
        context = print(next(x for x in dict if x["name"] == prod))
    tit = {'title': prod}
    return render_template('prod.html', **tit, context=context)
    
        
        
        
    


if __name__ == '__main__':
    app.run()
