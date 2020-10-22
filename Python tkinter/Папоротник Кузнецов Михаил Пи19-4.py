# -*- coding: utf-8 -*-
"""
Created on Tue Oct 20 17:40:42 2020

@author: Александр
"""
from tkinter import *
from random import *


def Go():
    global x
    global y
    
    r = random()
    
    r = r * 100 # случайное число от 0 до 100
    
    xn = 0
    
    yn = 0
    
    if r < 1:
        xn = 0
        yn = 0.16 * y

    elif r >= 1 and  r < 86:
        xn = 0.85 * x + 0.04 * y
        yn = - 0.04 * x + 0.85 * y + 1.6
    
    elif r >= 86 and r < 93:
        xn = 0.20 * x - 0.26 * y
        yn = 0.23 * x + 0.22 * y + 1.6
    
    else: # r >= 93
        xn = -0.15 * x + 0.28 * y
        yn = 0.26 * x + 0.24 *y + 0.44
    
    
    x = xn
    y = yn
    
    R = 1
    
    # РАстяжение сделали  (умножили на 80) и сдвинули вправо(+400)
    x1 = x * 150 - R + 400
    y1 = y * 80 - R
    x2 = x * 150 + R + 400
    y2 = y * 80 + R
    
    
    
    # сделали переворот координат, те , что стояли в начале, стоят в конце
    y1 = 800 - y1
    y2 = 800 - y2
    
    my_canvas.create_oval(x1 , y1 , x2 , y2, fill = "White")
    
    window.after(1,Go) # Рекурсивно вызываем эту функцию запускать

     


window = Tk()

my_canvas = Canvas(window,width = 800, height = 800, bg = "Black")
my_canvas.pack()

go_button = Button(text = "Запустить", command = Go)
go_button.pack()

#del_button = Button(text = "Удалить", command = Del)
#del_button.pack()


# Координаты первой точки 

x = 0
y = 0


mainloop()