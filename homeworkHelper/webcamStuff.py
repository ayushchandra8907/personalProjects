import time
import cv2
import consequence
from tkinter import *

#important face stuff (dont delete)
face_cascade = cv2.CascadeClassifier('haarcascade_frontalface_default.xml')

#important webcam stuff (dont delelte)
webcam = cv2.VideoCapture()
webcam.open(0, cv2.CAP_DSHOW)

faceTimer = 0

#timer for detecting delay
#seconds = input("Max delay?")
submit = False
updateFace = True
con = ""
consequenceChoice = ["Shut down", "YT  Video", " Alt  f4 "]
idle = 0

def enactConsequence():
    if con == "Shut down":
        consequence.shutDown()

    if con == "YT  Video":
        consequence.openYT()

    if con == " Alt  f4 ":
        consequence.altF4()

def submitButtonEnter():
    global submit
    global idle
    global con

    con = conMenu.get()
    idle = idleEntry.get()

    print(con)
    print(idle)
    submit = True

##CONFIG WINDW==========================================================================================================
root = Tk()                                                                                                            #
root.title("Homework Helper - Webcam")                                                                                 #
root.geometry("220x50")                                                                                               #

#labels
breakButton = Label(root, text="Max idle time:")
breakButton.grid(row=0, column=0, sticky=W)

#inputs
idleEntry = Entry(root)
idleEntry.grid(row=0, column = 1)

#conseuqnce
conMenu = StringVar()
conMenu.set("Shut down")
conDrop = OptionMenu(root, conMenu, *consequenceChoice)
conDrop.grid(row=1, column=0)


#submitting
submitButton = Button(root, text="Submit", padx = 40, pady = 3, command=submitButtonEnter)
submitButton.grid(row = 1, column=1)

root.mainloop()


while submit:

    #gets teh image and converts it to grayscale
    ret, frame = webcam.read()
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    #finds the faces in the frame
    faces = face_cascade.detectMultiScale(gray, 1.1, 4)

    #draws the rectangle around each face
    for (x, y, w, h) in faces:
        cv2.rectangle(frame, (x, y), (x + w, y + h), (255, 0, 0), 2)
        faceTimer = 0
        updateFace = True

    #shows the completed image
    cv2.imshow('frame', frame)
    #delay timer
    time.sleep(0.1)

    if updateFace:
        faceTimer += 0.1

    print(faceTimer)

    if faceTimer > int(idle):
        print("too long")

        updateFace = False
        faceTimer = 0

        if con == "Shut down":
            consequence.shutDown()

        if con == "YT  Video":
            consequence.openYT()

        if con == " Alt  f4 ":
            consequence.altF4()



    #ending
    if cv2.waitKey(1) & 0xFF == ord('/'):
        break

#ending stuff
webcam.release()
cv2.destroyAllWindows()
