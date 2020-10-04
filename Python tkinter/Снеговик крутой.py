from tkinter import *
import math

width1 = 600
height1 = 600 

def GO(): # Создаем движение
    global width1,height1
    
    x0 = width1/2 # Центр по x = 300
    
    y0 = height1/2 # Центр по у = 300
    
    R = x0/2 # РАДИУС
    
    x1 = 300 -25 #275
    y1 = 300 - 25#275
    
    x2 = 300 + 25# 325
    y2 = 300 + 25  #325
    
    centr = my_canvas.create_oval(x1,y1,x2,y2)
    
    x_n1 = 300
    y_n1 = 300 + 25 + 40
    
    x_n0 = x_n1 - 40
    y_n0 = y_n1 - 40
    
    x_n11 = x_n1 + 40
    y_n11 = y_n1 + 40
    
    centr6 = my_canvas.create_oval(x_n0,y_n0,x_n11,y_n11)
    
    
    x = 300 - 25 - 6
    y = 300
    
    
    x01 = x - 5
    y01 = y - 3
    
    x10 = x + 5
    y10 = y + 2

    centr4 = my_canvas.create_oval(x01,y01,x10,y10)
  
    x_n = 300 + 25 + 6
    y_n = 300
    
    x001 = x_n - 5
    y001 = y_n - 3
    
    x100 = x_n + 5
    y100 = y_n + 3
    
    centr5 = my_canvas.create_oval(x001,y001,x100,y100)
    
    
    x00 = 300 #300
    y00 = 300 - 25 - 15
    
    x11 = x00 - 15
    y11 = y00 - 15
    
    x22 = x00 + 15
    y22 = y00 + 15
    
    centr1 = my_canvas.create_oval(x11,y11,x22,y22)
    
    x000 = 300 - 5
    y000 = 300 - 25 - 15
    
    x111 = x000 - 3
    y111 = y000 - 3
    
    x222 = x000 + 3
    y222 = y000 + 3
    centr2 = my_canvas.create_oval(x111,y111,x222,y222)


    x0000 = 300 + 5
    y0000 = 300 - 25 - 15
    
    x1111 = x0000 - 3
    y1111 = y0000 - 3
    
    x2222 = x0000 + 3
    y2222 = y0000 + 3
    centr_3 = my_canvas.create_oval(x1111,y1111,x2222,y2222)
    
def deL():
    my_canvas.delete(ALL)
        
window = Tk() # ФОрма

my_canvas = Canvas(window,width = width1, height = height1, bg = "White")
my_canvas.pack()

go_button = Button(text = "НАЖММИ НА МЕНЯ!" , command = GO)
go_button.pack()

#del_button = Button(text = "Удали МЕНЯ", command = DEL)
#del_button.pack()

del_button = Button(text = "УДАЛИИИ" , command = deL)
del_button.pack()

mainloop()