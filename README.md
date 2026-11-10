# Recursive Maze Solver

A Java coursework project that uses recursive depth-first search and backtracking to find a route through a text-based maze.

## Features

- Reads maze dimensions and grid data from a text file.
- Starts at the first open space and searches for the exit (`E`).
- Marks the route with direction symbols and dead ends with dots.
- Writes the result to `solution.txt`.

## Files

- `Maze.java`: program source.
- `mz1.txt` and `mz2.txt`: sample maze inputs.
- `solution.txt`: example output for the small maze.

## Requirements and running

This project uses the Brock Java library (`brock.*`), including `ASCIIDataFile` and `ASCIIOutputFile`. The library is required and is not included in this repository.

Add your copy of the Brock JAR to an IntelliJ Java project's dependencies, add `Maze.java`, and run its `main` method. Select a sample maze when the input-file chooser opens. The program writes `solution.txt` in the working directory.

Each input begins with the number of rows and columns, followed by the maze grid. `#` represents a wall, a space represents an open cell, and `E` represents the exit.