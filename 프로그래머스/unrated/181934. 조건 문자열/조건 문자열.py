def solution(ineq, eq, n, m):
    if eq == "!":
        return int(eval(str(n) + ineq + str(m)))
    else:
        return int(eval(str(n) + ineq + eq + str(m)))