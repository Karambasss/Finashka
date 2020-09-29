from tkinter import *
import math

def click_MyButton():
    height = textHeight.get(1.0,END) # с помощью get получаем инфу
    
    height = (float(height))/100
    
    Weight = textWeight.get(1.0,END)
    Weight = int(Weight)
    
    textBI.delete(1.0,END)#от начала до конца стираем
    
    BI = Weight/(height**2)
    
    textBI.insert(1.0,BI) #вставляем в начало (Записываем)
        
    
    
    
    
window = Tk() #Создалось окно

textWeight = Text(width = 100, height = 2) #Создается окно на форме
textWeight.pack() # СОздать окно!!!!

textHeight = Text(width = 100, height = 2) 
textHeight.pack()

textBI = Text(width = 100,height = 2)
textBI.pack()

myButton = Button(text = "GOOOOO Saya", command = click_MyButton) # объявление, какой туда идет размер объем памяти и тп как в джаве
myButton.pack() # Создали кнопку! ИНИЦИАЛИЗАЦИЯ










mainloop() # Работает с событиями Взаимодействие с пользователем