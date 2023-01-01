#using the formula for expected value, what I did was multply the probability, which was found through punnet squares,
#and multiplied it by the corrosponding dataset value. I used a list because the first time solving, I entered one of the
#numbers incorrectly, and having a list ensures that wont happen again. I also multiplied by 2 since each parent makes
#2 offspring.


def computeExpectedOffspring(a, b, c, d, e, f):
    return 2*(a+b+c+.75*d+.5*e + 0*f)

dataset = [17218, 18991, 16609, 16824, 17573, 19378]


print(computeExpectedOffspring(dataset[0], dataset[1], dataset[2], dataset[3], dataset[4], dataset[5]))

