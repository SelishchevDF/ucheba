from datetime import datetime, timedelta
from django.views import View
from django.http import HttpResponse
from django.shortcuts import render
from django.core.files.storage import FileSystemStorage
from .models import Client, Order, Product
from .forms import UploadPictureToProduct

# Create your views here.

def upload_picture_to_product(request):
    if request.method == 'POST':
        form = UploadPictureToProduct(request.POST, request.FILES)
        if form.is_valid():
            id = form.cleaned_data['id']
            pic = form.cleaned_data['pic']
            fs = FileSystemStorage()
            fs.save(pic.name, pic)
            product = Product.objects.filter(pk=id).first()
            product.picture = pic.name
            product.save()
            return HttpResponse("UPLOADED")
    else:
        form = UploadPictureToProduct()
    return render(request, 't6app/form.html', {'form': form})
            
            

def week(request, id_client):
    return prod_list(request, id_client, days=7 )

def month(request, id_client):
    return prod_list(request, id_client, days=30 )

def year(request, id_client):
    return prod_list(request, id_client, days=365 )

def prod_list(request, id_client, days):
    context = {}
    productList = []
    now = datetime.now()
    before = now - timedelta(days)
    client = Client.objects.filter(pk=id_client).first()
    orders = Order.objects.filter(customer=client, date_ordered__gte=before).all()
    context['name'] = client.name
    for order in orders:
        products=order.products.all()
        for product in products:
            if product not in productList:
                productList.append(product)
    context['products'] = productList
    return render(request, 't6app/orderList.html', context)

class IndexView(View):
    def get(self, request):
        return render(request, 't6app/index.html')
    
