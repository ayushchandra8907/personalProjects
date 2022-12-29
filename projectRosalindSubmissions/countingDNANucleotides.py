dna = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC" #example case that was given

#solution 1: using built-in python methods to count each letter for me, which does all the heavy lifting
aC, gC, cC, tC = dna.count("A"), dna.count("G"), dna.count("C"), dna.count("T")

print(f"{aC} {gC} {cC} {tC}")

#solution 2: write a loop to iterate through each character in the DNA sequence and adding to a counter

aC, gC, cC, tC = 0, 0, 0, 0 #initializing counters

for i in dna:
    if i == "A":
        aC += 1
    if i == "G":
        gC += 1
    if i == "C":
        cC += 1
    if i == "T":
        tC += 1

print(f"{aC} {gC} {cC} {tC}")