s = "AGTTGTTATTACGGTTGTTAGGTGTTGTTATAGTTGTTACGTTGTTAGTTGTTAAGGTTGTTAAGGTGTTGTTAAGTTGTTACGTTGTTATAATCCGAGTTGTTAGGTTGTTATGGTTGTTAAGCCGAGTTGTTAGTTGTTAATTCGGGGTCTTGTTGTTATAAGAGTGTTGTTACCAAACGAGTTGTTAGTTGTTAGGTTGTTAGTTGTTACGCGTTGTTAGTAGTTGTTAGTTGTTAGTTGTTAAGTTGTTAATGCGGTTGTTACAGTTGTTATGAGCGTTGTTACGTGTTGTTATATGTTGTTACGTTGTTAACGACCTGTGTTGTTAGTTGTTAATCGTTGTTAGTTGTTACAAGTTGTTAAAATGTTGTTACCCGTTGTTAGGTTGTTAGTGTTGTTAAGTTGTTATGTCAAGGGTTGTTAAAGCGTTGTTAGTTGTTACGTAGTTGTTAGGTTGTTATACTTATCAGGTTGTTAGGAAGTTGTTACCTCGGTCTGTTGTTAAGCGTTGTTACGGAGTTGTTACAACAGTTGTTGTTAGGGTTGTTAGGTTGTTAATGGTTGTTATGTTGTTAAAGTTGTTAGTTGTTAGAAGTTGTTAACGTATGTTGTTAGTTGTTATCATAGTTGTTACCCGCTTTGGGTTGTTAGTTGTTAGTTGTTAGCGTTGTTATATGTTGTTAAAGCGTTGTTAACGTGGTTGTTATGTTGTTAAGGTTGTTAGTTGTTAGTTGTTAGACTCGTTGTTAGTTGTTACGTTGTTAGTTGTTATCACCATAGGCCCGGCACTCTGGCAGATGTTGTTAGGTTGTTATTCGTGTTGTTAGTTGTTAAGAGTTGTTACGCGTTGTTAGTTGTTAGTTGTTAAATGGGAGTTGTTAGCGTTGTTACTGTTGTTACAGGTGCACGTTGTTACGGTTGTTATGTGTTGTTAGTTGTTAACTAAGTTGTTAGTTGTTAAGTTGTTAACACTCAGTTGTTA"
t = "GTTGTTAGT"

#this question was a bit more straightforward than most. My idea was to just iterate through each subsection of s to find t.
#although a faster algorithm does exist which uses the index() method, and I have coded it before in a class, I chose not to
#code it because I couldn't remember the algorithm that well, so since complexity isn't an issue I just left it like this.

indices = []

for i in range(len(s)-len(t)):
    if s[i:i+len(t)] == t:
        indices.append(i+1) #adds 1+index since the indexes are counted differently in this problem.

for i in indices:
    print(i, end = " ") #formats the data