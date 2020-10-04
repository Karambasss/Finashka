from tkinter import *
import math

i = 0
def GO():
    global i
    i = i + 0.01
    xn = 100  + 100 - math.cos(i) * 100 # НАчальное значение x маленького круга  + ( чтобы сдвинуть ) 100(радиус ) - сos(i) (косинус угла i) *100 = к координате середины x мы прибавляем чтобы сдвинуть в
    yn = 200 - math.sin(i) * 100
    r = 2
    my_canvas.coords(o,xn - r, yn - r, xn + r, yn + r) #назначает новые координаты o
    #my_canvas.move(o,1,0) # 0 пойдет в Y 1 полетит в X 
    window.after(10,GO) # Автоматически вызоыви функцию GO через 10 милисекунд      
def DEL():
    global o
    my_canvas.delete(ALL)
    o = my_canvas.create_oval(20,20,70,70)

window = Tk() # Создали форму 

my_canvas = Canvas(window, width = 400, height = 400, bg = "White") # Создали холст
my_canvas.pack()

Button_go = Button(text = "ВВод рисунка", command = GO)
Button_go.pack()

Button_del = Button(text = "Удаление рисунка", command = DEL)
Button_del.pack()


O = my_canvas.create_oval(100,100,300,300)

o = my_canvas.create_oval(98,198,102,202) # КОординаты по x1 y1 x2 y2

#o = my_canvas.create_oval(20,20,70,70)

mainloop()