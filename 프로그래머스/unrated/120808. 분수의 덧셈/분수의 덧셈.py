def gcd(a, b):
    while b > 0:
        a, b = b, a % b
    return a


def solution(numer1, denom1, numer2, denom2):
    mul = denom1 * denom2
    mol = numer1 * denom2 + numer2 * denom1
    div = gcd(mul, mol)

    return [mol // div, mul // div]