from django.shortcuts import render
from django.http import HttpResponse

import logging
from datetime import datetime

logger = logging.getLogger(__name__)

# Create your views here.

def index(request):
    HTML = """<!DOCTYPE html>
    <html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title></title>
</head>
<body>
    <header>
      <div class="hdr">МАГАЗИН ВЕЩЕЙ</div>  
    </header>
    <nav>
        <a href="http://127.0.0.1:8000/">Главная</a>
        <a href="http://127.0.0.1:8000/about/">Категории товаров</a>
    </nav>
    <section>
        lorem ipsum dolor sit amet, consectetur adip
    </section>
    <footer>
        <div class="ftr">КОНТАКТЫ</div>
    </footer>
</body>
</html>"""
    logger.info(f'посещение страницы index в: {datetime.now()}')
    return HttpResponse(HTML)

def about(request):
    HTML = """<!DOCTYPE html>
    <html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title></title>
</head>
<body>
    <header>
      <div class="hdr">МАГАЗИН ВЕЩЕЙ</div>  
    </header>
    <nav>
        <a href="http://127.0.0.1:8000/">Главная</a>
        <a href="http://127.0.0.1:8000/about/">Категории товаров</a>
    </nav>
    <section>
        lorem ipsum dolor sit amet, consectetur adip
        lorem ipsum dolor sit amet, consectetur adip
        lorem ipsum dolor sit amet, consectetur adip
        lorem ipsum dolor sit amet, consectetur adip
        lorem ipsum dolor sit amet, consectetur adip
    </section>
    <footer>
        <div class="ftr">КОНТАКТЫ</div>
    </footer>
</body>
</html>"""
    logger.info(f'посещение страницы about в: {datetime.now()}')
    return HttpResponse(HTML)