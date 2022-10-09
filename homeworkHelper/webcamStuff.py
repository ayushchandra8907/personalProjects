import time
from datetime import datetime
import cv2
import consequence

#important face stuff (dont delete)
face_cascade = cv2.CascadeClassifier('haarcascade_frontalface_default.xml')

#important webcam stuff (dont delelte)
webcam = cv2.VideoCapture()
webcam.open(0, cv2.CAP_DSHOW)



faceTimer = 0


while True:

    #gets teh image and converts it to grayscale
    ret, frame = webcam.read()
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)

    #finds the faces in the frame
    faces = face_cascade.detectMultiScale(gray, 1.1, 4)



    #draws the rectangle around each face
    for (x, y, w, h) in faces:
        cv2.rectangle(frame, (x, y), (x + w, y + h), (255, 0, 0), 2)
        faceTimer = 0
        print("face found")




    #shows the completed image
    cv2.imshow('frame', frame)



    time.sleep(0.5)
    faceTimer += 0.5

    if faceTimer > 5:
        print("too long")

    #ending
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

#ending stuff
webcam.release()
cv2.destroyAllWindows()
