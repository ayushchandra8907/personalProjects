from datetime import datetime
from threading import Timer
import webbrowser
import time
import pyautogui
import os

#times------------------------------------------------------------------------
print("What time do you want to launch class? (Use 24 hour time!)")

#hour
print("Hour:")
user_hour = input()
int(user_hour)

#minute
print("minute:")
user_minute = input()
int(user_minute)

#second
print("second:")
user_second = input()
int(user_second)

#time stuff-------------------------------
x=datetime.today()
y=x.replace(hour=int(user_hour), minute=int(user_minute), second=int(user_second))
delta_t=y-x

secs=delta_t.seconds+1

#program started----------
print("Timer started")
print("")
print("")

print("Which class?")
userClass = input()
print("")

if int(userClass) == 1:
    if int(user_hour) > 12:
        print(f"Class {userClass} will launch at {int(user_hour) - 12}:{user_minute}:{user_second} P.M.")

    else:
        print(f"Class {userClass} will launch at {user_hour}:{user_minute}:{user_second} A.M.")

elif int(userClass) == 2:
    if int(user_hour) > 12:
        print(f"Class {userClass} will launch at {int(user_hour) - 12}:{user_minute}:{user_second} P.M.")

    else:
        print(f"Class {userClass} will launch at {user_hour}:{user_minute}:{user_second} A.M.")

elif int(userClass) == 3:
    if int(user_hour) > 12:
        print(f"Class {userClass} will launch at {int(user_hour) - 12}:{user_minute}:{user_second} P.M.")

    else:
        print(f"Class {userClass} will launch at {user_hour}:{user_minute}:{user_second} A.M.")

elif int(userClass) == 4:
    if int(user_hour) > 12:
        print(f"Class {userClass} will launch at {int(user_hour) - 12}:{user_minute}:{user_second} P.M.")

    else:
        print(f"Class {userClass} will launch at {user_hour}:{user_minute}:{user_second} A.M.")

elif int(userClass) == 5:
    if int(user_hour) > 12:
        print(f"Class {userClass} will launch at {int(user_hour) - 12}:{user_minute}:{user_second} P.M.")

    else:
        print(f"Class {userClass} will launch at {user_hour}:{user_minute}:{user_second} A.M.")

else:
    print("Class doesn't exist, and won't launch.")


#time function!!!!!
def joinZoom():

    #studentvue login
    print("launching website...")
    webbrowser.open('https://il-ipsd-psv.edupoint.com/PXP2_Login_Student.aspx?regenerateSessionId=True')
    time.sleep(5)
    pyautogui.click(939, 614)
    time.sleep(3)

    #deciding which class.

    if int(userClass) == 1:
        pyautogui.click(1568, 508)

        time.sleep(4)
        pyautogui.click(932, 337)

        time.sleep(3)
        pyautogui.typewrite(os.environ.get('school_username'))
        pyautogui.press('enter')
        time.sleep(3)
        pyautogui.press('enter')


    elif int(userClass) == 2:
        pyautogui.click(1568, 559)

    elif int(userClass) == 3:
        pyautogui.click(1568, 616)

    elif int(userClass) == 4:
        pyautogui.click(1568, 663)

    elif int(userClass) == 5:
        pyautogui.click(1568, 735)


#init
t = Timer(secs, joinZoom)
t.start()
