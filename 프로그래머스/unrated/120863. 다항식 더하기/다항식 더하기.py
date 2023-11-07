def solution(polynomial):
    terms = polynomial.split(" + ")
    x_term, int_term = [], []
    for term in terms:
        if term == "x":
            x_term.append(1)
        elif "x" in term:
            x_term.append(int(term.replace("x", "")))
        else:
            int_term.append(int(term))

    if x_term:
        if sum(x_term) == 1:
            if int_term:
                return f'x + {sum(int_term)}'
            else:
                return f'x'
        elif int_term:
            return f'{sum(x_term)}x + {sum(int_term)}'
        else:
            return f'{sum(x_term)}x'
    else:
        return f'{sum(int_term)}'