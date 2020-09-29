"""
Количество мужчин а в другом женщин
сколько надо куить еды на мужчину 1кг а на женщину 700 гр

"""

from tkinter import *

def createFeminizm():
    man = text_man.get(1.0,END)
    man = int(man)
    
    woman = text_woman.get(1.0,END)
    woman = int(woman)
    
    food = (man*1) + (woman*0.7)
    
    text_food.delete(1.0,END)
    
    text_food.insert(1.0,food)  
    # insert -  запись в начало
    
    
main1 = Tk() # Создали окно

text_man = Text(width = 50, height = 5)# Объявление
text_man.pack() # ИНИЦИАЛИЗАЦИЯ

text_woman = Text(width = 50, height = 5)
text_woman.pack()

text_food = Text(width = 50, height = 5)
text_food.pack()

my_button = Button(text = "GOO SAYA", command = createFeminizm) # command - передавание имени функции (связываем кнопку с функцией но не вызывая функци)
my_button.pack()






mainloop()
