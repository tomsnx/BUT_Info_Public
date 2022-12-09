def matrix_product(ma, mb):
    m = []

    for i in range(len(ma)):
        m.append([])

        for j in range(len(mb[0])):
            m[-1].append(0)

            for k in range(len(ma[i])):
                l = i
                if l >= len(mb[0]): # ou mb[k]
                    l = len(mb[0]) - 1
                m[-1][-1] += ma[i][k] * mb[k][l]

    return m

matrix = matrix_product(
    [
        [1, 2],
        [4, 5],
        [8, 2],
        [8, 9]
    ],
    [
        [8, 9, 2],
        [4, 8, 7],
    ]
)

for row in matrix:
    print(row)
