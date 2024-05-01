import pyautogui
import keyboard
import time
import random

keyboard.wait(' ')
time.sleep(1)
keyboard.write("\n")

text_file = open("text.txt", "r")


for line in text_file.readlines():

    for i in line.split():
        ran = random.randint(1, 10) / 100.0
        print(ran)
        pyautogui.write(i, interval=ran)





        # random pause
        pause = random.randint(1, 100)

        if(pause <= 5):
            time.sleep(random.randint(1,5)/2)

        pyautogui.write(" ")

    pyautogui.write("\n")

    '''
    keyboard.wait("`")
    pyautogui.press('backspace')
    '''

