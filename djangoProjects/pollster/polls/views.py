from django.shortcuts import render

# Create your views here.
from .models import Question, Choice

# get questions and display them

def index(request):
    render(request, './templates/polls/index.html')
