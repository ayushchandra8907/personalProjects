import re

text = "ACSL,-or-the-American-Computer-Science-League,-is-an-international-computer-science-competition-among-more-than-300-schools.-Originally-founded-in-1978-as-the-Rhode-Island-Computer-Science-League,-it-then-became-the-New-England-Computer-Science-League.-"
message = "American Computer Science League (ACSL) is fun!"




print(text)
print(message)

textIntoSentences = [x for x in re.split("[.!?]", text) if x!=""] #splits into sentences

for s in textIntoSentences:
    print(s)

#remove all fake words from the thing

index = 1
textPos = 0

result = ""

for c in message:
    #c - current char

    if(c.isalnum()):
        totalOccur = text.count(c)
        desiredOccur = index

        while (desiredOccur > totalOccur):
            desiredOccur //= 2

        # then loop thru text until we hit that target occurence
        currOccur = 0

        reached = False

        S = 0
        W = 1
        C = 1


        while(currOccur < desiredOccur):

            #handle sentences
            for sentence in textIntoSentences:
                #print(sentence)

                if (reached == False):
                    S += 1
                    W = 0
                else:
                    break

                badChars = "[-"
                for z in sentence:
                    if z.isalnum() == False and z != ' ':
                        badChars += z
                badChars += "]"

                print(badChars)

                splittedSentence = [x for x in re.split(badChars, sentence) if x != ""]
                newSplittedSentece = []

                for s in splittedSentence:
                    newSplittedSentece.extend(s.split())

                for word in newSplittedSentece:

                    #if word is fake, remove
                    if(len(word) > 1 or word.isalnum() == True):


                        if (reached == False):
                            W += 1
                            C = 1
                        else:
                            break

                        #loop thru cahrs in word
                        for char in word:
                            if(char == c):
                                currOccur += 1

                            if(currOccur == desiredOccur):
                                reached = True
                                break

                            if(reached == False):
                                C += 1

                    else:
                        print(word)





        # located s, w, c, now time for packing
        encrypedChar = str(S) + "." + str(W) + "." + str(C)
        result += encrypedChar

        if message[textPos+1].isalnum():
            result += " "


        index += 1
        textPos += 1

    else: #char isnt alphanumeric
        if(c == ' '):
            result += "_"
        else:
            result += c

        textPos += 1

for i in range(len(textIntoSentences)):
    #print(textIntoSentences[i])
    print(textIntoSentences[i].split())


print()

print(result)
print("1.1.1 1.5.3 1.5.7 1.10.5 1.10.9 1.12.6 1.16.3 1.13.11_2.18.1 1.18.5 1.14.2 1.13.4 2.11.5 2.18.6 2.6.3 2.9.8_2.19.1 2.10.2 2.1.3 2.11.2 1.16.4 2.14.3 2.14.2_2.11.1 2.15.3 2.17.5 2.20.4 2.18.5 2.19.7_(1.1.1 2.9.1 2.19.1 2.20.1)_1.13.9 1.18.7_2.2.1 2.2.3 2.19.5!")