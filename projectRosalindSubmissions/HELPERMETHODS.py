# This file contains many functions that are needed across different problems. They mainly include formatting, since
# lots of problems use different formatting that sometimes is tedious to disect.

def FASTA_TRANSLATE():
    import pyperclip

    text = pyperclip.paste()

    strands = text.split("\r")
    strands[0] = "\n" + strands[0]

    #print(strands)

    formattedStrands = []


    for i in strands:
        if i.startswith("\n>"):
            formattedStrands.append(i + " ")
        else:
            formattedStrands[-1] = formattedStrands[-1] + i

    for i in range(len(formattedStrands)):
        formattedStrands[i] = formattedStrands[i].replace("\n", "")

    return formattedStrands

