from django.db import models

# Create your models here.
class Client(models.Model):
    name = models.CharField(max_length=100)
    email = models.EmailField()
    phone = models.CharField(max_length=100)
    address = models.TextField()
    registration_date = models.DateField(auto_now_add=True)
    
    def __str__(self):
        return f'Clientname: {self.name}, email: {self.email},  phone: {self.phone}, address: {self.address}'
    
    
class Product(models.Model):
    name = models.CharField(max_length=100)
    description = models.TextField()
    price = models.DecimalField(max_digits=8,decimal_places=2)
    quantity = models.IntegerField()
    added_at = models.DateTimeField(auto_now_add=True)
    picture = models.ImageField(null=True)

    def __str__(self):
        return f'Product name: {self.name}, price: {self.price},  description: {self.description}, quantity: {self.quantity}'
    
    def total_price(self):
        return self.price


class Order(models.Model):
    customer = models.ForeignKey(Client, on_delete=models.CASCADE)
    products = models.ManyToManyField(Product)
    total_price = models.DecimalField(max_digits=8,decimal_places=2)
    date_ordered = models.DateField(auto_now_add=True)
    

    def __str__(self):
        return f'Customer: {self.customer.name}, products: {self.products},  date_ordered: {self.date_ordered}, total_price: {self.total_price}'