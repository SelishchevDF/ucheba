from django.contrib import admin
from .models import Client, Product, Order


@admin.action(description="reset quantity")
def reset_quantity(modeladmin, request, queryset):
    queryset.update(quantity=0)
    
class ClientAdmin(admin.ModelAdmin):
    list_display = ['name', 'email']
    ordering = ['name']
    search_fields = ['name']
    search_help_text = "name"
    fields = ['id', 'name', 'email', 'address', 'phone', 'registration_date']
    readonly_fields = ['id', 'registration_date']
    
class ProductAdmin(admin.ModelAdmin):
    list_display = ['name', 'price', 'quantity']
    ordering = ['name']
    list_filter = ['quantity']
    search_fields = ['name']
    search_help_text = "name"
    actions = [reset_quantity]
    
# Register your models here.
admin.site.register(Client, ClientAdmin)
admin.site.register(Product, ProductAdmin)
admin.site.register(Order)
