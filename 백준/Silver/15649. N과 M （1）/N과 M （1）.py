from itertools import permutations


N, M = map(int, input().split())
n_list = [x for x in range(1, N + 1)]
n_list = permutations(n_list, M)
for x in n_list:
    print(str(x).replace(",", "").replace("(", "").replace(")", ""))