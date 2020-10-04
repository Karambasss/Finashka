# -*- coding: utf-8 -*-
"""
Created on Wed Sep 30 17:52:24 2020

@author: Александр
"""

from tkinter import *

import math

# СОЗДАЕМ ОКНО

def Operation_Plus():
    val = text.get(1.0,END)# 1.0 с какого элемента считаем и до какого
    value1 = int(val)
    
    val2 = text2.get(1.0, END) # Получаем все что было записано в текстовое поле get_text
    value2 = int(val2) # И ВМЕСТО СТРОКОВГО ТИПА ПРИСВАИВАЕМ ЦЕЛЫЙ
    
    math_operation = value1 + value2
    
    text3.delete(1.0 , END) # Удаляем последнее значение (удаляется вся строка от начала и до конца )
    
    text3.insert(chars = math_operation, index = END) # ВВодим наши значения до указанного индекса

def Operation_Minus():
    val = text.get(1.0,END) #получаем в val то, что находится от начала текстового окна до конца текстового окна     
    value1 = int(val)
    
    val2 = text2.get(1.0,END)
    value2 = int(val2)
    
    math_operation = value1 - value2
    
    text3.delete(1.0, END) # Удаляем содержимое, чтобы в текстовом окне удалилась последняя строка (от 1 до последнего жлемента)
    
    text3.insert(chars = math_operation, index = END)

def Operation_Multiplucation():
    val = text.get(1.0,END)
    value1 = int(val)
    
    val1 = text2.get(1.0,END)
    value2 = int(val1)
    
    math_operation = (value1 * value2)
      
    text3.delete(1.0,END)
    
    text3.insert(chars = math_operation, index = END) # Вставляем в начало нашу переменную
    

def Operation_Division():
    val = text.get(1.0,END)
    value1 = int(val)
    
    val2 = text2.get(1.0,END)
    value2 = int(val2)
    
    math_operation = (value1 / value2)
    
    text3.delete(1.0,END)
    
    text3.insert(chars = math_operation, index = END)
    

window = Tk()

# Создали 3 поля для текста

text = Text(width = 40, height = 7) # Объявили и задали размер
text.pack() # ИНИЦИАЛИЗИРОВАЛИ

text2 = Text(width = 40, height = 7) # Объявили и задали размер текстового поля
text2.pack()# Инициализировали, то есть сказали этому текстовому полю - СОЗДАВАЙСЯ

text3 = Text(width = 40, height = 7) 
text3.pack()

# Создали Кнопки
plus_button = Button(text = "Push Plus",command = Operation_Plus)
plus_button.pack() # Создавайся

minus_button = Button(text = "Push Minus", command = Operation_Minus) 
minus_button.pack()

multip_button = Button(text = "Push Multiplication", command = Operation_Multiplucation)
multip_button.pack()

div_button = Button(text = "Push Division", command = Operation_Division) 
div_button.pack()

mainloop()