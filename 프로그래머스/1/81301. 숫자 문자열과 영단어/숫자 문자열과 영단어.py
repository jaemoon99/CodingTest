def solution(s):
    n_to_e = dict(zip([str(x) for x in range(10)], ["zero","one","two","three","four","five","six","seven","eight","nine"]))
    for x in range(10):
        s = s.replace(n_to_e[str(x)], str(x))
    return int(s)