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

#print(formattedStrands)


#main question logic
def computeContent(str):
    return 100*(str.count("G")+str.count("C"))/(len(str))

contents = []

for i in formattedStrands:
    contents.append(computeContent(i[15:]))

max = 0
maxInd = 0

shit = []

for i in range(len(contents)):
    if contents[i] > max:
        maxInd = i
        max = contents[i]

for i in formattedStrands:
    shit.append(i[1:14])

#print(contents)

#final answer---------
print(formattedStrands[maxInd][1:14])
print(max)
