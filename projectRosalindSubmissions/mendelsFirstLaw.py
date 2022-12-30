k = 15
m = 17
n = 19
s = k+m+n

# instead of trying to code a simulation, like the problem suggests to, I realized that this problem could be solved using math.
# Since we know all the probabilities, this is just a bunch of algebra and probability logic. On paper, I managed to simplify the
# math to one formula, which will be used to determine the probability. While solving this problem for the first time, I didn't
# use code at all; rather I typed the formula on my TI-84 and solved from there to get my answer.

#forumla:
p = (k/s)*((k-1+m+n)/(s-1)) + (m/s)*((k+.75*(m-1)+.5*n)/(s-1)) + (n/s)*((k+0.5*m)/(s-1))

#derivation of formula:
# Most of this comes from tree diagrams. The probability for choosing any one of the populations will be that specific type divided
# by the total population. For example, choosing k would just be k/(k+m+n). I call k+m+n as "s" in my formula to make typing it a bit
# easier. An important insight is that a member of any population cannot mate with itself. Hence, the second "branch" of the tree diagram
# involves subtracting 1 from both the subpopulation and the whole population. This is the main issue I had, since at first I didn't realize
# this, meaning my probabilities were all wrong. The second and third parts of the formula involve the use of decimals. This is because
# since we are dealing with punnet squares, there are several subcases we must consider. For example, if a member of the "m" population and
# the "n" mate, because of Mendelian Inheritance laws, there is a 1/2 chance that it will contain a dominant allele. Factoring these in
# are the key parts of the formula, and make the last part shorter since the case of n*n never should be considered since it will always
# result in a hh phenotype. This formula works perfectly, and is far simpler than coding a simulation, at least in my opinion. The only
# regret I have is that halfway through, I realized that it would be quicker to calculate the complement, which is any case involving a
# hh phenotype result. I could then do 1 - complement, making the formula much simpler and less of a burden to type.

#prints the calculated probability.
print(p)