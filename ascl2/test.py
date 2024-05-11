import re

#sentence = ['We', 'are', 'met', 'on', 'a', 'great', 'battle-field', 'of', 'that', 'war']
sentence = "Four score and seven years ago our fathers brought forth on this continent, a new nation, conceived in Liberty, and dedicated to the proposition that all men are created equal."

badChars = "["
for z in sentence:
    if z.isalnum() == False and z != ' ':
        badChars += z
badChars += "]"

print(badChars)

splittedSentence = [x for x in re.split("[--]", sentence) if x!=""] #splits into sentences

newSplittedSentece = []

for s in splittedSentence:
    newSplittedSentece.extend(s.split())

print(splittedSentence)
print(newSplittedSentece)
