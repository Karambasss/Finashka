# -*- coding: utf-8 -*-
"""
Created on Sun Oct  4 20:57:42 2020

@author: Александр
"""

from tkinter import *

def GO_R():
    my_canvas.move(centr1,1,0)         
    my_canvas.move(centr2,1,0)
    my_canvas.move(centr3,1,0)
    
    window.after(10,GO_R) # Рекурсивно вызови эту функцию каждые 10 милисекунд
    
    
def GO_D():
    my_canvas.move(centr1,0,1)
    my_canvas.move(centr2,0,1)
    my_canvas.move(centr3,0,1)

    window.after(10,GO_D)    

def deL():
    my_canvas.delete(ALL)
    my_canvas.create_oval(26,27,86,53)
    my_canvas.create_oval(13,43,33,63)
    my_canvas.create_oval(79,43,99,63)

    # Тут один вопросик, я тут сделал возврат в начальное значение, но как продолжить работу, чтобы опять спокойно можно было вызывать эту прошлую функцию, чтобы машинка двигалась\
    
    
window = Tk()

my_canvas = Canvas(window,width = 600, height = 600, bg = "White")
my_canvas.pack()

right_button = Button(text = "Движение вправо", command = GO_R )
right_button.pack()

down_button = Button(text = "Движение вниз", command = GO_D)
down_button.pack()

del_button = Button(text = "УДАЛИМ?", command = deL)
del_button.pack()

x = 56 # Центр
y = 40

x1 = x - 30
y1 = y - 13

x2 = x + 30
y2 = y + 13

centr1 = my_canvas.create_oval(x1,y1,x2,y2)


xx = x - 30 - 3  # 23
yy = 40 + 13 # 53

x11 = xx - 10
y11 = yy - 10

x22 = xx + 10
y22 = yy + 10

centr2 = my_canvas.create_oval(x11,y11,x22,y22)
 

xx1 = x + 30 + 3 # 89
yy1 = y + 13 # 53

x111 = xx1 - 10
y111 = yy1 - 10

x222 = xx1 + 10
y222 = yy1 + 10

centr3 = my_canvas.create_oval(x111,y111,x222,y222)


mainloop()