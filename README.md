# Rubik's Cube
Starting with a completed RubiksCube, you randomize it using x number of moves, then start solving it.

### BreadthFirstSearch
Takes in a cube to solve and compares it to a given target cube, most likely a solved cube.
Use method Start() to start solving for the cube.

### A*
Takes in a cube to solve.
Use method startSearch() to solve for the given cube.

### Note
A* is faster than BreadthFirstSearch, as it goes through its choices with a heuristic. However, going beyond 7 for the randomization function can lead to solving for the cube in an unreasonable amount of time.
