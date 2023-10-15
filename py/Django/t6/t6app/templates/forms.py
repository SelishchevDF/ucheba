from django import forms

class UploadPictureToProduct(forms.Form):
    id = forms.IntegerField(required=True)
    pic = forms.ImageField(required=True)
    