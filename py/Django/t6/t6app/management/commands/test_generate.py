import random
from django.core.management.base import BaseCommand
from t6app.models import Client, Product, Order


class Command(BaseCommand):
    help = "Generate fake Clients, Products and Orders."

    def add_arguments(self, parser):
        parser.add_argument('count', type=int, help='Client ID')
        

    def handle(self, *args, **kwargs):
        count = kwargs['count']
        client_list = []
        product_list = []

        for j in range (1, count + 1):
            product = Product(name=f'PName{j}', price=f'{j+1}0', description=f'text-{j}', quantity=f'{j}')
            product.save()
            product_list.append(product)

        for i in range(1, count + 1):
            client = Client(name=f'Name{i}', email=f'mail{i}.mail.ru', phone=f'123-{i}',address=f'address{i}')
            client.save()
            client_list.append(client)

        for k in range (1, count + 1): 

            rnd = random.randint(0, count-1) 

            order = Order(customer=client_list[rnd])
            total_price = 0
            for l in range (0, count):
                if random.randint(0,1) == 1:
                    total_price += float(product_list[l].price)
                    order.total_price = total_price
                    order.save()
                    order.products.add(product_list[l])