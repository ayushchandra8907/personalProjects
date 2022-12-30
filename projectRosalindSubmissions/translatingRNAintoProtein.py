#dictionary I quickly made that contained all the codons and their values
codons = {"UUU": "F", "UUC": "F", "UUA": "L", "UUG": "L", "UCU": "S", "UCC": "S", "UCA": "S", "UCG": "S", "UAU": "Y", "UAC": "Y", "UAA": " STOP ", "UAG": " STOP ", "UGU": "C", "UGC": "C", "UGA": " STOP ", "UGG": "W", "CUU": "L", "CUC": "L", "CUA": "L", "CUG": "L", "CCU": "P", "CCC": "P", "CCA": "P", "CCG": "P", "CAU": "H", "CAC": "H", "CAA": "Q", "CAG": "Q", "CGU": "R", "CGC": "R", "CGA": "R", "CGG": "R", "AUU": "I", "AUC": "I", "AUA": "I", "AUG": "M", "ACU": "T", "ACC": "T", "ACA": "T", "ACG": "T", "AAU": "N", "AAC": "N", "AAA": "K", "AAG": "K", "AGU": "S", "AGC": "S", "AGA": "R", "AGG": "R", "GUU": "V", "GUC": "V", "GUA": "V", "GUG": "V", "GCU": "A", "GCC": "A", "GCA": "A", "GCG": "A", "GAU": "D", "GAC": "D", "GAA": "E", "GAG": "E", "GGU": "G", "GGC": "G", "GGA": "G", "GGG": "G"}

rna = "AUGCGCCAGCGAGUGCUAGAGAUCGCUCCGUGGGAACCUGCAAUUUUGUACGCGCUUGGGACCAUCUGGCGGUCAUGCGCGAAGGCAUUUUGUCUCAUGGUAACCGUCCCCUUUAAUGGACCGGAGUGGUUCGAGCCGCGCGAUACACAGUCAGAAGGCACACCCCUUACUGGUUCCCCAACGCACGCCCCGUCGUACUCCCCGCAACGUCUACCUUGUCGGUACGGCCUCAUCAGAUUCAGCAGUAUGCGGGGGGUUUUAAUCCGUUUGCGACGACACGAUUUGCAUCCUAAUUUAGAUCGGUUCGUGCGGCUAAUACCCUCCCCCACAGAACACACACUAAUCCGACAAGGUGUAGACGGCGCACGAUGGACAAGCGCAGAGAUUUUUGUUCCUGGAGAAUCAGCGACCCUUAAACUCUUCAUCCAAAAACUGGAUACGACGCGUAUCAUUCGACCUCACCAGUCUUGUCUCCGCCACGUCAUCUGCCGCUUUACUGGCUUCACGCGUUUUCUUGUCCAGCCCACAGCUCGUAUUCGAAAACCCAAAUCUGAACACUAUUCCUGGGAAUCCAGCCACUCACUAUUUGCUGAAUGCGACAUGCGUCUCGCGAAUGGCAGUGUACCACACCCCCAGUCUGAGGGCGCCCAAAAGAUGCUCGAUACUUGGUUAAGAUACCAGUGCAUUACCCUAAAUAGUUAUCCGAUCCUGAGGUAUACUAUGAUCCGGUCGAAGAGAUCACGACCCGUAGGUUUUAAAACACUAGAAAGGUUAUUAACUCAGAUUCCCGACAGUCCACAGUGCAUACAGCUUACUUCCAGAGGUGAAAGCCAACCCAGAAGGCACUCAGCUCGUGGAUACCUCAACGAAGGUAUAGCCGAGUCCGAUCUCAUAAGAAACCCGGACAGAAACACGCGCCGGAAGACAUACAGGCGGCUAAGCUCUCCGCCUAUAACAACUUUUGUAGUUCAAGCGGCCAUCAUCGGUAACUUUGAUAGCCGCUUAAAAGCAGCGUACGAUACUGUUAACGUAUCCGAUUCAAGCGCUCUGACCACGGAUGCAAGGCUUUACUGGAUUGUCUACGUUUGCAGCUUGGCGUUGCUCACUCUACUAAUCAGGCUCCCCGGGACCCUUCUGUACGGAUCACCGCUGGGGAGACACGCUGUACUAAGCCGUACUUUGGUUCGUUUUGCACAUAUAAGUCCCAGAAAGUCCACUGUGGGUAAAUCACCACGAUUAGUAUCCACUUACGGCGGUCAUCGUCUACCGCUCUCUGGUGCCGGCCGAUUCAUUUCGGGCUCAGGAUAUUUCGUUUGCAUAAUGCAGUCCAAUGCAAGGCGGUCCAGAUCUUGCUCUCGACCUCAUCGUGGUUCGAGUAUACUAAAGACCUUGGGCACAUGUGACUCCAUUAAGGCCAGUGGGAAGAGCACAACGGGCCCUAGCGAGUAUGUGCUAUGGAAGCCCUUACGUAACAGGGUUUGGCCUAGAGAAGAGUGUCUCCGGCAACAGAAGCCAACGUACGUACUAAUAAGCCUAGGUGUUAGAACGAGUACCUACUCUUGGAGAUUCAAAACAAACGCCCAGACUUGGUCCACGGGGAGAGCCACUCUUGUGUACUGUCAGACAUCGAUCUCGUACCACUUUAUACCAGGUCACUGGGGGAGGCGUGCCAGACGUCAUGAUGGCUUACCAUCACCAGCACAGGAACGACUAUGUCGCGUUUGUACGGCGUGGCUCGGCGUGCCCAGUUACGUCAGGAUGGGCCGGGCGCAAGUCACGAUAUCUCUCAAAACACAAAGUCCUAGGGGUAACCUGGCCAGAUCUUACCGCGUCGAGUCCAAAGCUAAACACCGGCCCCUGAUGCUCGUGAAUAAGGUGAUAAGGCCCAUGGCCUGUCGGCAUCCCUUGCGCCAAUAUCUUGUUAAGACUGUGAUUCUCAUGACCGACGGUCCGCGGGACUGUGAAGGCCGCGCUAGUCCCCGCGCUAAAAUCGCCGAAAGUCGUACUUCCUGUGGUGCUGUUACGCCCCUGGGGAGCACCAGAAACGAACUUACGCCGCGUGAUAUAAGGAAGGACAAUUACCACCGCCCGGUUGUCCCUGCUUUUGUCUCAGCCCUAAGCUGUAAAUUCUGUCUCAUGCCUUACGGACCUAGCCGGGUCUCAUGUUCACGGCGUUAUCAAAAGCCGUUGAUUCAUACAAUAACACUACCUCACAACGGAAGGUGGCACCACAGGAUGCACUGCCAGAAAUACCGGCGGCAGUCGUCCACCGCUCCACGGCCACCGUUCACUAGCCGCGGAAAACAUGCUCUAUGUAUCACGCUGCCAGUAGUUCUCCCACGUUCAUUAAUCAACCAGCAAUGUAAGAGAUCCAUACCUCUAUCUGCCCUCAUUAUGGUGAGCCCGUUAAAAGGCGACUGGGUCGACAGCACCGUAGGAAGUCCGACCCCAUUCCGGCGCUAUAUGGGUGAUAAUCGACGAAGUGGGAUCAACGAAAUAAGACGAAUUAACAAGUCCGUUCAAGAUGUCUUUAAGAUCUAUUUAGGGAAUGUAGGCAUUGUGUUUUCCCCGGUAAUCCUAGAACCAGUGGCAGCGCAGCACCGACUCGACCUAAACGAGAGUUUGAGACUGCACUCCACACUAUGGCGCUAUAUACGCCUGGCGAUCAGAACACAGUCCGAUAAUCCGGAUUCGUCUCAAGUAGGAAAGGACACGAUAGGAUGCUCAAUACUAGACUCAGUCGCUGCAUGUACUACUGUACGGUGCCUAUGGAAAAGACUAGCAGCUCUUUUUUGUACAGUUGGUGACAGUAGAGGAUACCCACUGGUCGAAGCAACGACAGAUGGAUCCUGUCAAGACGCUGGCCUGGAUCUUGGGGAGAGGCUAAACGGAAGUAGAUUUGUAGCCAGAGGACGCGUAAGUGCUCAGUAUACUACAUGUGUUUCCACACCAUUACAAUGCCAUGCGUGCUCGUUGAAUGCUCUCGGGGCUGAGGUUGCUUUUGAUAGUACGUCCGGAGGACGGUUUGCGUGUGCGCUGAAGGUCGGAGACUACAUACACAUUCUGAUGCAAUUCCCCCGCGCAAUUUUGACACACCAGACGGGGUGUACAGAUAGUGCAUACUCCCAUAACCGAGGGGGUUCUGACCCGUCUAGGCCCAGCCUAAAAAUCCAUUAUGCGCACACAGAAGGGUGGGUUCAACGAUCUACUUUGAUAGAGCGCCCUGGAUUUGCUUUCCAUCAAGAUGGACUAGUGCAGAUUCCACAUCAAGACAGGAGUCGCAGGUCAUAUACGAUGAAUGAUAUCCGUACAAAAAACGGCGGGGGUGCUGUUUGCCGGGUCACGCUUAGGGCGUUACAAUGUCCGUACCGAAUCACACAGCUGAGGUUCAGAUACAGAAUCACCAAAGGUUCGUUAUCAUCCCACGCCAUGGAGGCCUAUAUGUCUAGUCUCUACGUGUACUCCACUCAUAGUACGUUCCGCCAUCCACGGGGAAUAAUUUGCCGUACUAAAUUGCCUCGGCUAACUAGACGCGAAUUGGAACUUUGGCACAAAAGGUAUAGGGGCUUGAUUCCUGUUUCUUCCAAUCCUCAAUUUCCAACUACCCUUAGGAUCUCCCCUGGGAAAGGGUUCUUACCUCAGAUAGCUUGUGUGUCAGUACGUUGGAUUCGCUUACGCCUCGCUGGUGCGAAACGGCGUUACCUUUUGAAGCGCGUAUGUCCCGGAAUGACCCAAUCGAUAGGCAGAAGACGUAACACCGUUAUUAAAGCGGACUCAGCUUCCAACGUUAUAGGGACCUGUCGCUAUGCACCUUAUUGGCCUGCAAAAGGCCUUAGUGCUGUCCCAGGGUUCGAGCUAGCAAUUGCUCACCCAAAGACCACGCACAGGAUAAUGCACCUCUCGUUCACCACCCGACGGUGCAUAGGUCUCGCGCCUGCUUGGCUUCCUAAAUUCAAGCGCUGCUUGUACCCGGGUAGUCUCACAAGGGGUUUAAGGGGAGGUAGGAAGACCACUAGUGGGGACGUAAUAUGUGUUGCAUUUAUGAACAUAGCUAUUACACCUCUUUGCCAGUCCGUGCCUCUGAGCGUAACAGAACGGCAGACCCAUGUGUGCCAGGGCAUAGUUGCCGCCGGGGAUACGCACCACAUCCCACCGGUGCUUCUAAGAGCACGGAUUCGCACAGCUUACAGAGCACCACUACCAACGACCUCAAAGUAUCGCUGGCGAUAUCAGAACGUGUCGGAGGGCGGUUCAUAUGCUGUGACUAUCUCACCUCAUCCUAAACAGGGUGAUAGAGACCGAAAUGCCAUGGUUAGAUCUUUCCUGUCGAACUCUACGACAGCGAAGCGCUGCCAUUCGCCGCUACUUGUAAUCGCGCGCCGUCUUUGUACCGAAACUUGUCAGACAAGGGUUAACUUUCACUCCAUUGGAAAAGUUUUGCAAUUGGUUCCGACUACGAGCGGUACGGGCGGCAUUCAGAGUUCCUCCGAGAUUCAACAUGUAUAUCCCGUAGACUUCAUUGAGGAAAUGCUGCCUGCAAUUUACCUAUCGAGGAGCCAUAGAAACCUGCCCUAUGGGGAAAUCUCGCAGACUCAAGGCAUUACCCUGCUUGCGCCGCCUACAGAACUUGGCCUGGUGCCGUCGGCGUCUGGAAGCAUAUACGAAUCCCGAUAUCCUGUUACGCACCAACAGAAACUCCACAGCCUUGCCAGCAUUGUUAACGCGCAGCGACAGAGUGCAGUCGUCCGCAGUUGCCCUGCCACCUCGAAAGCGACUCCCUUAACGCGCGUGAUGAGGGUCCACACGGCUUAUAUACUGCUGCAUCGUCCAACCGCUGCUCCUAGUCGUCAAAACGGCUCGCGACACCGCGCGGAUGCCUGUCUCAUCGUACUUAAGUCUACCGAAACUACCAGUCCUCGAUUACUAAACAUGGGAAAUGGCCGGACGCUAAAAGAGGAAGGAGUAUCAAUGACUAUGUUAAGGAAUGAUAAUUGGAGGCGUUGGCCGUCCCGUGUUGCAGAAGUCAACCUGUGCCACGCUUCCUCCGCACGUUUCAAGUCACCGUGCCCCUGGGAAUUGAGUGGUUACCCCCCCUGUAUGCUUCGGCUAGUAAAUGUAAUACCGCACUUCAGUCAUGAACCAGAGCAGGCGAUCUGCAUCCGAAAAGCCAACACGAGGAAUCUGGGUGCGAUAUUUUGGGCGUUUACCAGGGGGGGUCGCUUUUUUUCUGAUGAAUGUGUCAGGAAACUGAUCCGUAAUGUGCUUUGGGUCGGUCAGCCUAUAAGUUUGACAGCACAUUGCGGAACGAGCCCCUGUCUACUUCUCCGUUAUGAAUCACUGUAUCGUUAUAUGGCAGAUUGUUGGCACCCGACACGAUGCCGUGACUUCCAAUUUCGCAAGUCCGGACGAUGCCUAGCUUCAAAUAGGGGCGAGCAACAAAGUUCGCCGGCUGCCAUGAAUUAUAGGAUUCAUGCUAACCACUACGUUCCCUACGCGUGUAAGCUUGUCCAACGAGCUAGCCAGUGGGGGGAUCUGAACGAUUGCUGUGUUCUAAACGAAAAGUUCGCCUGUCCUUGCACACGAGCCGUUCUGCCUUCGACUUGGUUUUUCUGCUCCGACUUCGGUACUCAACGUGUACCGGAACAUGCGGAGGCACUCUCGUACGUAGCGGCAGUUAAGAUCUGCCUACAUGGGACGAGAGGACUUGCGUCUCAAGGCCAACACCUCCCUCUAGUGACGCCCGUCCAUGCCACCUUCUCCGCAAUCUUUUUAUCCGUUAGCGCUCAACAUACCCACUCUCGUCUUCUAAUCUUGUGUACUUAUGCCUCACGGCUCCUGUCUAAUGUGUUUGCUCUUUUCGCACUGGCACUGUCCUAUUUGAGCUCACCGCUUCUCGUUCCCGUGACAACUUAUUAUCCCGAAUCCUCGAAACCCAUAUAUGGUUUCGAUCCUGGGCAGCAGCUCAGUCAAGAAAGACUGUGUACAUCUAGCUCAAGCCAUCGCCCCAGCGAUUAUCUUGAAGAAGGUCGCUUGAUGUAUCGCAUAUCUGGAUGGGUCCGGAAGGGAGAUUCACAUAGGUUUAAAAGAUUUGGAGUUGGCAAGACGAAACACUAUAUGUUCGGGUAUGGGCUAUUUGUAGGGUCGAAGAGCGUACGUAAUGAACCGUGUACCCGAAAGCUUUUACGACUAUACCGAACAAAAGCUCGCGCGAAGGUCAUUGUCGGACUGUGGCCGCUUCGUACCCAAUAUGAGCCCCUACGGGGGACUGCCUAUGAUUCCGACUUUGGCAACCGCACCCUUGGUUGGUUACGUUUGGGUCAGCGGUAUGCCUCUGGCGCUGUUGAAAAAUACAGUGAAGGGGCAGACUGUUGGAUGGUACCAGUCUGGUUUAAGUCCAUCCUGGGGGCUUAUUUUUUCUACGGUAGGGGACGUUCCUGUCCUUGGAUCUCAGCAACCGCGUUGAUGAAGAUAGUUGUACUUCAGUAUCUAAAUGAUCACAGCAUAGCCACAAUCCCCUCUCCAGGUUCCCGGUCCACUCUCAAUGGCGCGGUUUAUGUCAUCUCUAAGUUGCGGAGACUGGAAUUGAUCGGAGAUCGCCUUCUUGAGGGCUACGUAUUGUUAAUUCAACGCACCAGGUACACGUCAUCGAAUAAGUCAAUGAGGGAAUAUGAUCGGACUGGAAUCGCUGGAUGGUGGACACAGUCCAACGCUAGAUAUGAUAAUAGGCACAUCGUGGGGAAGCUGACUGUGGCCAAAGUUGGUCCCACAUACGGAAUCACACCUGUGGCGAUACCAUUAACCGUACGCCCUUUGAGGAAAGACAAAAGGUUAACCCGACCCUCACCUCGGUCUGCAAUGCUAAAAGGUAUUGCUUCUGCCGGUCACUUGCAUGACUGCUGUGGCGCGACCAACAUGAGUCCAUGUCUCGCACCCUGGGACGCUAUCAAUCCUCUCGGUAACUACCGGUCCACAAAGGGGGGCAAACCCUUUACGCACAUUCGCUGCUUGGUAGAAUCUCUAAGGUAUAAGCCGAUUAUUCGACACCACUUAACGGUUUACCUUUUACAGUACGUGACUCAAAAUGGAUAUCAUCGAGCGGUUGAAUCGCCUCACUGCCCAAAUCUGUGGCGCAGCCUAUCCCUAAUCUCCUUUGUGCAGUUACAGUGCAGCUACCAAAUGCCGAGGUGGAAGCGGACCCGGUGUCGGUCAGGAUCAACUGCCUACGGAGACUUAGUUCCCCAUUGGGACGGGUACUCUCCAUUCGGUGCCUUUUAUCUAGUUUGUGUUGUUCCACUACUCGUACCACAAGAAUAUUGCUUGAGCGGCAUAGAUGUUCUUCGACAGCAGACAAGAAUAGGGCACCAAGGGGCUCAACGGUUAGCGUGUACGAGCCAAAUAAUAUGGACCUACAGAAGCGAAACCGCACUCUACCAUUACGGGCCUGGGCGUGGGAUUGGAAGAGAAAAAAUGGCGACGGCCACACGCGAGGAUUUGUUUAUCCUACCGCUGAUUCGAAGAAAUUGCACAUAUACGAAGAAACUAUUGGCGGUUUACAAUGUCUGGCUAUACGCCUGUAGACUCUCACGCGAUCCGGCCCCAGUAGCCACUACGGUCCUAUCUGCGUACCAAGGUUUAUCACAUGAUGGGCAUUCAACGGACCGUUGGCGAACAACCAGUCAAGAAUCUGACCUGCUUUUUAUUACCCCUAGGAAAGCAAUAUGUCGUGGGCUCACCCAUAACGCUUUUCCAACAAGUUGGCAAUUGUUGAAGUACCAGUGUACACAACGGAAGUUAGGAACAAACACCACUCGGUCCUGCUCCUACAUCGAGUUUCAGGACGGUCAUAUGGUGAUCGACUCAUCCCCUGGGUUAAACCCAGCGUGGCACCUGUUAAGUGCAACAUUACUUAUUGGUCUAGCGUUGACAAAUUACCUUAAAGGCUACAUCACCAAACAACUGACAUACACUCCAACUUCUACAAGUAUAGUAGACCUCUAUCUGUCAUGUAAUAUAUGGGGCUGCUGGAUGGGUAUCCGAGCGAGAGGCGUACCGACCGUGCGACGCAUUGAGACACGUACGGGUACCCAUCGAACAUGUGUCAUAUGCCGGGCGUUGCGCAUAGUCCGGAUAAAAAUUGUUAAUAAGACCCCGAGUAGUAGACGGAAGCUAUCCACCUGCAUGAGGAGCCCAAUGCGCACCUGGAUCGUUCAUCUCACCUGCUCGGAUGUGUUCAGCUCAGUAGAACCUACGACGGAGGGCCUUGGCAUUCGAUCUAGAACACUAAUCGACGUAGGUUUGAAUGUAAUGGCGCCUUGCGGACAGCGUUUGCCGCGUCGUCUCCUCCGUGUCUAUAGGACCACAGAUGAGUUUCGGUUAUUUAUACGUGUCCUAUCCCCUUACCAUUUACUUGAGGCUAGACUAUGGCGUUACAGUGAGUUCGGCUCAUUUCAUAGCAUUCAUCCUCCCUGCAACCGUAGUCUGUCGAGAAUAUGUCGACUGGACCUUAUCGGGAGGAGGAAUCCGUCACUUUUUGUAACCUAUAAACUACCAGAGAGGCGAGCAGGGUGGGCAAAAAACACAAGUGGACACAGAGGCAGGUUCCUAGCGGGCCCGAGGCCACCACACCACCAAUCGUCGGCGCGAUUGGUCAACAUCCCCGCAAUAAUUCUGUUACGGGUCUGCCUCUCGCCCAAAAUGCAAUAG"
protein = ""

#start codon index (All the datasets started with the start codon, so it was fine to have this value at 0, but this is a good
#precaution to have.

ind = rna.index("AUG")

stopCodonFound = False

#loop to add proteins to the protein chain
while not stopCodonFound:
    codon = rna[ind:ind+3]

    if codon == "UAA" or codon == "UAG" or codon == "UGA": #stop codon logic
        stopCodonFound = True
    else:
        protein += codons[codon]
    ind += 3

#prints the final protein
print(protein)