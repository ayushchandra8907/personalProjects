from tkinter import *
import win32api
import consequence
import cv2
import time

#main init=============================================================================================================#
root = Tk()                                                                                                            #
root.title("Homework Helper")                                                                                          #
root.geometry("150x150")                                                                                               #
#======================================================================================================================#

#functions, varibles, and classes======================================================================================#

#functions-------------------------
def getIdleTime():
    return (win32api.GetTickCount() - win32api.GetLastInputInfo()) / 1000.0

face_cascade = cv2.CascadeClassifier('haarcascade_frontalface_default.xml')

#important webcam stuff (dont delelte)
webcam = cv2.VideoCapture()
webcam.open(0, cv2.CAP_DSHOW)



faceTimer = 0

#varibles-------------------------



timePassed = 0
turnOff = False
running = False

minutes, seconds = 1, 0

consequenceChoice = ["Shut down", "YT Video", "Alt f4"]

#classes--------------------------
class Configurations():
    def __init__(self, id, fin, con, cam):
        self.idle = id
        self.finish = fin
        self.consequence = con
        self.webCam = cam

    #getter methdos
    def getIdle(self):
        return self.idle

    def getFinish(self):
        return self.finish

    def getConsequence(self):
        return self.consequence

    def getWebcam(self):
        return self.webCam

    #setter methods
    def updateIdle(self, id):
        self.idle = id

    def updateFinish(self, fin):
        self.finish = fin

    def updateConsequence(self, con):
        self.consequence = con

    def updateWebcam(self, cam):
        self.webCam = cam


config1 = Configurations(5, 10, "Shut down", "No")

#MAIN CODE=================================================================================================================
#RUNNING WINDOW==============================================================
def runWindow():
    #init====================================================
    runWin = Toplevel(root)
    runWin.title("Run")
    runWin.geometry("180x133")

    minutes = config1.getFinish()
    global seconds
    seconds = 0

    #timer label
    time_label = Label(runWin, text = f"{minutes}' if minutes > 9 else f'0{minutes}:{seconds}", font=('Arial', 30))
    time_label.pack()

    #timer init
    minutes = 1

    #functions===============================================
    def update():
        global minutes, seconds

        seconds -= 1

        if seconds < 0:
            minutes -= 1
            seconds = 59

        #format
        minutes_string = f'{minutes}' if minutes > 9 else f'0{minutes}'
        seconds_string = f'{seconds}' if seconds > 9 else f'0{seconds}'

        #update
        time_label.config(text=minutes_string + ':' + seconds_string)
        global update_time
        update_time = time_label.after(1000, update)

        #CONSEQUENCE=====
        if (getIdleTime() > config1.getIdle()):
            if config1.getConsequence() == "Shut down":
                consequence.shutDown()

            if config1.getConsequence() == "YT Video":
                consequence.openYT()

            if config1.getConsequence() == "Alt f4":
                consequence.altF4()


            #================
            pause()



        #ending
        if seconds == 0 and minutes == 0:
            pause()
            print("It's been a while, take a break.")



    global running
    running = True
    if running:
        update()


    def pause():
        global running

        if running:
            time_label.after_cancel(update_time)
            running = False

            pauseButton.config(text="Start", padx=74)
        else:
            time_label.after(1000, update)
            running = True

            pauseButton.config(text="Pause", padx=70)


    #buttons======================================
    pauseButton = Button(runWin, text="Pause", padx= 70, pady = 10, command = pause)
    pauseButton.pack()

    endButton = Button(runWin, text="End", padx=77, pady=10, command = runWin.destroy)
    endButton.pack()




#CONFIG WINDOW==========================================================================================================
def configWindow():
    #init====================================================
    config = Toplevel(root)
    config.title("Config")
    config.geometry("220x70")

    #widgets=================================================
    #labels
    idleButton = Label(config, text="Max Idle Time:")
    breakButton = Label(config, text="Time Until Break:")
    idleButton.grid(row=0, column=0, sticky=W)
    breakButton.grid(row=1, column=0, sticky=W)


    #inputs
    idleEntry = Entry(config)
    idleEntry.grid(row=0, column = 1)
    finishEntry = Entry(config)
    finishEntry.grid(row=1, column=1)

    def submit():
        entryGet = int(finishEntry.get())

        #limits to one hour of work
        if(entryGet > 60):
            entryGet = 60

        config1.updateIdle(int(idleEntry.get()))
        config1.updateFinish(int(entryGet)*60)
        config1.updateConsequence(conMenu.get())

        global minutes
        minutes = entryGet

        print(config1.getIdle())
        print(config1.getFinish())
        print(config1.getConsequence())


    #dropdown menu
    conMenu = StringVar()
    conMenu.set("Shut down")
    conDrop = OptionMenu(config, conMenu, *consequenceChoice)
    conDrop.grid(row=2, column=0)


    #submit
    submitButton = Button(config, text = "Enter", padx = 46, command = submit)
    submitButton.grid(row = 2, column = 1)


#MAIN FRONTEND===================================================================================================================================
mainButton = Button(root, text="Start Study Session", bg = 'blue', fg = 'white', padx = 21, pady = 45, command = runWindow)
mainButton.grid(row=0, column=0)

configButton = Button(root, text="Configure Settings", bg = 'blue', fg = 'white', padx = 23, pady = 7, command = configWindow)
configButton.grid(row=2, column=0)

#end
root.mainloop()