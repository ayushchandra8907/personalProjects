import numpy as np

"""HELPER METHODS"""
def IS_EF1(num_agents, allocation, valuation_matrix):

    # find max values of each agent
    max_chores = []
    for i in range(num_agents):
        most_despised_chore = 0

        for chore_j in allocation[i]:
            most_despised_chore = max(most_despised_chore, valuation_matrix[i][chore_j])

        max_chores.append(most_despised_chore)

    # for each agent, compare with other two agents
    for i in range(num_agents):

        # sum their own utils, minus their max chore
        self_eval = 0
        for chore_j in allocation[i]:
            self_eval += valuation_matrix[i][chore_j]

        self_eval -= max_chores[i]

        # sum the other agents util and compare
        for agent_i in range(num_agents):
            if agent_i != i:
                other_sum = 0

                for chore_j in allocation[agent_i]:
                    other_sum += valuation_matrix[i][chore_j]

                if other_sum < self_eval:
                    # ef1 is broken so return false
                    return False


    return True

def MPB(a, M, prices, valuation_matrix): #returns list of items that are defined as most pain per buck for a given agent
    pains = []

    for j in M:
        if(prices[j] != 0):
            pains.append(valuation_matrix[a][j]/prices[j])

    a_i = min(pains)

    mpb_list = []
    for j in M:
        if prices[j] != 0 and valuation_matrix[a][j]/prices[j] == a_i:
            mpb_list.append(j)

    return mpb_list

def a_i(a, M, prices, valuation_matrix): #returns a_i, defined as minimum pain per buck
    pains = []

    for j in M:
        pains.append(valuation_matrix[a][j] / prices[j])

    return min(pains)

def earnings(allocation, p): # the same as p(x_i) from the paper, returns sum of payments of an agent's allocation
    earning = 0
    for j in allocation:
        earning += p[j]

    return earning


"""ALGORITHM"""
def chores_3agents(num_items, valuation_matrix):
    M = list(range(num_items)) #creates a list that points to indicies of chores

    #define allocation
    allocation = [[],
                  [],
                  []]


    #arbritrarily choose agent
    agent = 0

    #move entire allocation into chosen agent bundle
    allocation[agent] = M

    #prices (lines 2 & 3 in algorithm)
    p = []
    for j in range(num_items):
        p.append(valuation_matrix[agent][j])

    #main alg (lines 4 - 26 in algorithm)
    is_ef1 = False
    while is_ef1 == False:
        total_disutilities = [sum(valuation_matrix[k][j] for j in x_k) for k, x_k in enumerate(allocation)] #creates list of size 3
        b = np.argmax(total_disutilities)
        l = np.argmin(total_disutilities)
        h = 3 - b - l

        #see if a chore can be transferred from big earner to least earner
        mpb_l = MPB(l, M, p, valuation_matrix)
        mpb_h = MPB(h, M, p, valuation_matrix)

        #lines 9 - 10
        if any(item in allocation[b] for item in mpb_l):
            #move chore from big earner to least earner

            for j in range(len(allocation[b])):
                if allocation[b][j] in mpb_l:
                    allocation[l].append(allocation[b].pop(j))
                    break

        elif any(item in allocation[h] for item in mpb_l): #case 2, lines 11 -> 21
            #find j
            j_ind = 0
            for j in range(len(allocation[h])):
                if allocation[h][j] in mpb_l:
                    j_ind = j
                    break

            if earnings(allocation[h], p) - p[j_ind] > earnings(allocation[l], p): #line 12
                #move chore j from middle earner to least earner
                allocation[l].append(allocation[h].pop(j_ind))

            elif any(item in allocation[b] for item in mpb_h): #line 15
                #find chore j'
                for j in range(len(allocation[b])):
                    if allocation[b][j] in mpb_h:
                        j_ind = j
                        break

                #move chore j'
                allocation[h].append(allocation[b].pop(j_ind))

            else: #line 18
                beta = 1

                # find beta
                for i in [l, h]:
                    for j in allocation[b]:
                        ai = a_i(i, M, p, valuation_matrix)
                        beta = max(beta, ai/(valuation_matrix[i][j]/p[j]))

                for j in allocation[b] + allocation[l]:
                    p[j] = p[j] * beta

        else:
            beta = 1

            #find beta
            for j in allocation[b] + allocation[h]:
                al = a_i(l, M, p, valuation_matrix)
                beta = max(beta, al/(valuation_matrix[l][j]/p[j]))

            #lower payments until chore is mpb for l (line 25)
            for j in allocation[l]:
                p[j] = p[j] * beta


        #check if alg is complete
        is_ef1 = IS_EF1(3, allocation, valuation_matrix)

    return allocation




def main():
    # test input data
    valuation_matrix = [
        [0, 0, 30],
        [10, 20, 0],
        [0, 30, 0]
    ]

    print(chores_3agents(3, valuation_matrix))

main()