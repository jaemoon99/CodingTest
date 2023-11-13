T = int(input())
for test_case in range(1, T + 1):
    input_data = input()
    length = len(input_data)
    if len(input_data) == 1:
        print("..#..")
        print(".#.#.")
        print(f'#.{input_data}.#')
        print(".#.#.")
        print("..#..")
    else:
        print("..#." * length + ".")
        print(".#.#" * length + ".")
        print(''.join(["#."+ x + "." for x in input_data]) + "#")
        print(".#.#" * length + ".")
        print("..#." * length + ".")