import webbrowser as wb
import os
import pywhatkit

#opens youtube video
def openYT():
    wb.open("https://www.youtube.com/watch?v=dQw4w9WgXcQ")

def messageWhatsapp():
    pywhatkit.sendwhatmsg_instantly("+13313858988", "bing bong", 5, True)

def shutDown():
    os.system("Rundll32.exe Powrprof.dll,SetSuspendState Sleep")
