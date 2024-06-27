import random

M = []
n = 10

for i in range(n):
    M.append(i)

allocation = []
valuation_matrix = []
num_agents = 3

for i in range(num_agents):
    allocation.append([])
    valuation_matrix.append([])


#randomly allocate objects
for i in M:
    agent = random.randint(0, num_agents-1)

    allocation[agent].append(i)

    #allocate valuations
    for i in range(num_agents):
        valuation_matrix[i].append(random.randint(1, 10))


print(allocation)
print(valuation_matrix)