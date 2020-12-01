from django.contrib import admin

# Register your models here.
from .models import Question, Choice

class ChoiceInLine(admin.TabularInline):
    model = Choice
    extra = 3

class QuestionAdmin(admin.ModelAdmin):
    fieldSets = [(None, {'fields':['question_test']}), ('Date Information', {'fields': ['pub_date'] , 'classes': ['collapse']})],
    inlines = [ChoiceInLine]

# admin.site.register(Question)
# admin.site.register(Choice)
admin.site.register(Question, QuestionAdmin)