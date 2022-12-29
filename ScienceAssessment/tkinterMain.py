from tkinter import *
import tkinter.font as font

#font-------------

#font1 = font.Font(family='Bahnschrift Light Condensed')



#main window------
root = Tk()
root.title("Science Assessment")
root.geometry("960x540")



#functions==============================================================================================================


#buttons=====================
#window1_info1
def window1_info1():
    # makes new window
    information_window1 = Toplevel(root)
    information_window1.title("Information 1")
    information_window1.geometry("450x290")

    # displays stuff on the window (Add the widgets)


    infopicture1_canvas = Canvas(information_window1, width = 450, height = 290)
    infopicture1_canvas.pack()

    infopicture1 = PhotoImage(file="window1info1.gif")

    infopicture1_canvas.create_image(20, 20, anchor=NW, image=infopicture1)

    mainloop()




#window1_info2
def window1_info2():
    # makes new window
    information_window1 = Toplevel(root)
    information_window1.title("Information 2")
    information_window1.geometry("470x247")

    # displays stuff on the window (Add the widgets)
    infopicture2_canvas = Canvas(information_window1, width = 456, height = 247)
    infopicture2_canvas.pack()

    infopicture2 = PhotoImage(file="window1info2.gif")

    infopicture2_canvas.create_image(20, 20, anchor=NW, image=infopicture2)

    mainloop()






#side2===================
#window2_info1
def window2_info1():
    # makes new window
    information_window1 = Toplevel(root)
    information_window1.title("Information 3")
    information_window1.geometry("480x325")

    # displays stuff on the window (Add the widgets)
    infopicture3_canvas = Canvas(information_window1, width = 465, height = 325)
    infopicture3_canvas.pack()

    infopicture3 = PhotoImage(file="window1info3.gif")

    infopicture3_canvas.create_image(20, 20, anchor=NW, image=infopicture3)

    mainloop()


#window2_info2
def window2_info2():
    # makes new window
    information_window1 = Toplevel(root)
    information_window1.title("Information 4")
    information_window1.geometry("460x200")

    # displays stuff on the window (Add the widgets)
    infopicture4_canvas = Canvas(information_window1, width = 450, height = 210)
    infopicture4_canvas.pack()

    infopicture4 = PhotoImage(file="window1info4.gif")

    infopicture4_canvas.create_image(20, 20, anchor=NW, image=infopicture4)

    mainloop()



#WINDOW2 SIDE 1=====================================================

#window3_info1
def window3_info1():
    # makes new window
    information_window1 = Toplevel(root)
    information_window1.title("Information 1")
    information_window1.geometry("501x300")

    # displays stuff on the window (Add the widgets)
    infopicture4_canvas = Canvas(information_window1, width = 501, height = 293)
    infopicture4_canvas.pack()

    infopicture4 = PhotoImage(file="window2info1.gif")

    infopicture4_canvas.create_image(20, 20, anchor=NW, image=infopicture4)

    mainloop()




#WINDOW2 SIDE 2=====================================================

#side4===================
#window4_info6
def window4_info1():
    # makes new window
    information_window1 = Toplevel(root)
    information_window1.title("Information 6")
    information_window1.geometry("495x196")

    # displays stuff on the window (Add the widgets)
    infopicture4_canvas = Canvas(information_window1, width = 495, height = 196)
    infopicture4_canvas.pack()

    infopicture4 = PhotoImage(file="window2info2.gif")

    infopicture4_canvas.create_image(20, 20, anchor=NW, image=infopicture4)

    mainloop()




#CLAIM EVIDENCE REASONINGS----------------------
#bottombutton1
def window1_bottom():
    # makes new window
    information_window1 = Toplevel(root)
    information_window1.title("Claim Evidence and Reasoning")
    information_window1.geometry("750x295")

    # displays stuff on the window (Add the widgets)
    cer1_canvas = Canvas(information_window1, width = 750, height = 295)
    cer1_canvas.pack()

    cer1 = PhotoImage(file="window1CER.gif")

    cer1_canvas.create_image(20, 20, anchor=NW, image=cer1)

    mainloop()


#bottobutton2
def window2_bottom():
    # makes new window
    information_window1 = Toplevel(root)
    information_window1.title("Claim Evidence and Reasoning")
    information_window1.geometry("769x205")

    # displays stuff on the window (Add the widgets)
    cer2_canvas = Canvas(information_window1, width = 769, height = 205)
    cer2_canvas.pack()

    cer2 = PhotoImage(file="window2CER.gif")

    cer2_canvas.create_image(20, 20, anchor=NW, image=cer2)

    mainloop()

#PictureButton!!!-------------------------------------------------------------------------------------------------------
def window1_picture():
    # makes new window
    picture_window1 = Toplevel(root)
    picture_window1.title("Picture")
    picture_window1.geometry("833x649")

    picture1_canvas = Canvas(picture_window1, width = 833, height = 649)
    picture1_canvas.pack()

    picture1 = PhotoImage(file="Question1Science.gif")

    picture1_canvas.create_image(20, 20, anchor=NW, image=picture1)

    mainloop()



# PictureButton2!!!-----------------------------------------------------------------------------------------------------
def window2_picture():
    # makes new window
    information_window1 = Toplevel(root)
    information_window1.title("Picture")
    information_window1.geometry("929x349")

    picture2_canvas = Canvas(information_window1, width = 929, height = 349)
    picture2_canvas.pack()

    picture2 = PhotoImage(file="Question2Science.gif")

    picture2_canvas.create_image(20, 20, anchor=NW, image=picture2)

    mainloop()



#windows================================================================================================================
#button1/WINDOW1======================================================================================================================================================
def buttonClick1_openNewWindow():
    # makes new window
    question1window = Toplevel(root)
    question1window.title("How is the Earth’s Surface Changing?")
    question1window.geometry("1200x675")

    # displays stuff on the window (Add the widgets)
    label1_window1 = Label(question1window, text="How is the Earth’s Surface Changing?")
    label1_window1.pack()

    #PICTURE-----------------------------------------------
    pictureButton_window1 = Button(question1window, text = "Picture", bg = "green", fg = "white", padx =100, pady = 100, command = window1_picture)
    pictureButton_window1.place(x=480, y= 200)

    #buttons-----------------------------------------------
    #side1-------
#butt1
    button1_window1 = Button(question1window, text="1", bg = 'blue', fg = 'white', padx = 100, pady = 80, command = window1_info1)
    button1_window1.place(x = 100, y = 100)
#butt2
    button2_window1 = Button(question1window, text="2", bg = 'blue', fg = 'white', padx = 100, pady = 80, command = window1_info2)
    button2_window1.place(x = 100, y = 350)


    #side2------
#butt1
    button1_window2 = Button(question1window, text="3", bg='blue', fg='white', padx=100, pady=80, command=window2_info1)
    button1_window2.place(x=900, y=100)
#butt2
    button2_window2 = Button(question1window, text="4", bg='blue', fg='white', padx=100, pady=80, command=window2_info2)
    button2_window2.place(x=900, y=350)


    #bottomButton----
    bottomButton_window1 = Button(question1window, text="Claim, evidence, and reasoning", bg='blue', fg='white', padx=100, pady=20, command = window1_bottom)
    bottomButton_window1.place(x=425, y=550)










#button2/WINDOW2======================================================================================================================================================
def buttonClick2_openNewWindow():
    # makes new window
    question2window = Toplevel(root)
    question2window.title("What causes the features on Earth’s Surface?")
    question2window.geometry("1200x675")

    # displays stuff on the window (Add the widgets)
    label1_window2 = Label(question2window, text="What causes the features on Earth’s Surface?")
    label1_window2.pack()


    #PICTURE-----------------------------------------------
    pictureButton_window2 = Button(question2window, text = "Picture", bg = "green", fg = "white", padx =100, pady = 100, command = window2_picture)
    pictureButton_window2.place(x=480, y= 200)


  #buttons-----------------------------------------------
    #side1-------
#butt1
    button1_window1 = Button(question2window, text="1", bg = 'blue', fg = 'white', padx = 100, pady = 100, command = window3_info1)
    button1_window1.place(x = 100, y = 150)




    #side2------
#butt1
    button1_window2 = Button(question2window, text="2", bg='blue', fg='white', padx=100, pady=100, command=window4_info1)
    button1_window2.place(x=900, y=150)



    #the bottom-----

    bottomButton_window2 = Button(question2window, text="Claim evidence reasoning", bg='blue', fg='white', padx=100, pady=20, command=window2_bottom)
    bottomButton_window2.place(x=430, y=600)










#widgets(MAINWINDOW)================================================================================================================

#labels======================
#label1----

#label2----

#buttons=====================
#button1----
button1 = Button(root, text="How is the Earth’s Surface Changing?", bg = 'blue', fg = 'white', padx = 150, pady = 260, command = buttonClick1_openNewWindow)
button1.place(x = 0, y = 0)

#button2----
button2 = Button(root, text="What causes the features on Earth’s Surface?", bg = 'red', fg = 'white', padx = 150, pady = 260, command = buttonClick2_openNewWindow)
button2.place(x=480, y=0)

#button3----


#end====================================================================================================================
root.mainloop()