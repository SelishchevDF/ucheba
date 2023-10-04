from datetime import datetime, timedelta
from django.views import View
from django.http import HttpResponse
from django.shortcuts import render
from .models import Client, Order

# Create your views here.

def week(request, id_client):
    context = {}
    productList = []
    now = datetime.now()
    before = now - timedelta(days=7)
    client = Client.objects.filter(pk=id_client).first()
    orders = Order.objects.filter(customer=client, date_ordered__gte=before).all()
    context['name'] = client.name
    for order in orders:
        products=order.products.all()
        for product in products:
            if product not in productList:
                productList.append(product)
    context['products'] = productList
    return render(request, 't3app/orderList.html', context)

def month(request, id_client):
    context = {}
    productList = []
    now = datetime.now()
    before = now - timedelta(days=30)
    client = Client.objects.filter(pk=id_client).first()
    orders = Order.objects.filter(customer=client, date_ordered__gte=before).all()
    context['name'] = client.name
    for order in orders:
        products=order.products.all()
        for product in products:
            if product not in productList:
                productList.append(product)
    context['products'] = productList
    return render(request, 't3app/orderList.html', context)

def year(request, id_client):
    context = {}
    productList = []
    now = datetime.now()
    before = now - timedelta(days=365)
    client = Client.objects.filter(pk=id_client).first()
    orders = Order.objects.filter(customer=client, date_ordered__gte=before).all()
    context['name'] = client.name
    for order in orders:
        products=order.products.all()
        for product in products:
            if product not in productList:
                productList.append(product)
    context['products'] = productList
    return render(request, 't3app/orderList.html', context)

class IndexView(View):
    def get(self, request):
        return HttpResponse("HI")
    
