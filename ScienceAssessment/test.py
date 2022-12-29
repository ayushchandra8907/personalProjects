from tkinter import *
root = Tk()
canvas = Canvas(root, width = 833, height = 649)
canvas.pack()
img = PhotoImage(file="Question1Science.gif")
canvas.create_image(20,20, anchor=NW, image=img)
mainloop()