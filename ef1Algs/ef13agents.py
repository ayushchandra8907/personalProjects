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

        # analyze sums. If the index of the smallest value is not i, then an agent is envious so EF1 is failed

    return True

valuation_matrix = [[6, 6, 2, 2, 10, 5, 4, 1, 2, 4],
                    [5, 6, 9, 2, 4, 5, 8, 5, 9, 5],
                    [10, 9, 9, 10, 3, 6, 1, 4, 1, 7]]

allocation = [[1, 3, 7, 8],
              [0, 2, 9],
              [4, 5, 6]]

sums = [0] * 3

for agent in range(3):
    for chore in allocation[agent]:
        sums[agent] += valuation_matrix[agent][chore]

print(f"Sums: {sums}")

print(IS_EF1(3, allocation, valuation_matrix))