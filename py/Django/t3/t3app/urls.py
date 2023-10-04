from django.urls import path
from .views import IndexView, week, month, year

urlpatterns = [
    path('week/<int:id_client>', week, name='week'),
    path('month/<int:id_client>', month, name='month'),
    path('year/<int:id_client>', year, name='year'),
    path('index/', IndexView.as_view(), name='index'),
]
