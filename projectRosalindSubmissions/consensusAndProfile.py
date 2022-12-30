import HELPERMETHODS #custom made library containing useful formatting stuff

strings = HELPERMETHODS.FASTA_TRANSLATE()

for i in range(len(strings)):
    strings[i] = strings[i][12:]

profile = [[], [], [], []]

for i in range(len(strings[0])):
    aCt, cCt, gCt, tCt, = 0, 0, 0, 0

    for k in strings:
        curr = k[i]

        if curr == "A":
            aCt += 1
        if curr == "C":
            cCt += 1
        if curr == "G":
            gCt += 1
        if curr == "T":
            tCt += 1

    profile[0].append(aCt)
    profile[1].append(cCt)
    profile[2].append(gCt)
    profile[3].append(tCt)

consensusIndices = []

for i in range(len(profile[0])):
    max = 0
    ind = 0

    for k in range(len(profile)):
        if profile[k][i] > max:
            max = profile[k][i]
            ind = k

    consensusIndices.append(ind)


#print(profile)
#print(consensusIndices)

consensus = ""

for i in consensusIndices:
    if i == 0:
        consensus += "A"
    if i == 1:
        consensus += "C"
    if i == 2:
        consensus += "G"
    if i == 3:
        consensus += "T"

#prints final consensus dna string
print(consensus)

#prints the dna stuff
print("A: ", end ="")
for x in profile[0]:
    print(x, end = " ")
print()

print("C: ", end ="")
for x in profile[1]:
    print(x, end = " ")
print()

print("G: ", end ="")
for x in profile[2]:
    print(x, end = " ")
print()

print("T: ", end ="")
for x in profile[3]:
    print(x, end = " ")
print()

#finished!! :))