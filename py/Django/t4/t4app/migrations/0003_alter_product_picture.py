# Generated by Django 4.2.5 on 2023-10-09 06:36

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('t4app', '0002_product_picture'),
    ]

    operations = [
        migrations.AlterField(
            model_name='product',
            name='picture',
            field=models.ImageField(default='../../media/images/default.jpg', upload_to=''),
        ),
    ]