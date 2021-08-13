# SearchAlgorithms

Implemented four tree search algorithms to find the solution to moving blocks in a four by four grid. Moving a block in any direction (up, down, left, right) will add a new node to the tree and the algorithms will search the generated tree to find the soultion.

The algorithms implemented are breadth first search, depth first search, iterative deepning search and A* search. A* search uses the manhatten distance as its heuristic. I compared the time taken by each of the algorithms and found that A* is the fastest followed by iterative deepning and both give the optimal soultion while deapth first search is faster than breadth first search it gives a random soultion instead of the optimal solution(soultion which takes the least number of moves).

