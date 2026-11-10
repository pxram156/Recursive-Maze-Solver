# Recursive Maze Solver

A Java coursework project that explores a maze recursively, marks directions with arrows, and reports the step count when it reaches the destination.

## Files

- `RecursiveMaze.java`: maze loading, recursive exploration, and console output.
- `Direction.java`: direction enum used to mark the maze.
- `maze1.txt`, `maze2.txt`, `maze3.txt`: sample maze inputs.
- `maze1u.txt`, `maze2u.txt`, `maze3u.txt`: additional maze inputs.

## Input format

Each input starts with four integers: row count, column count, starting row, and starting column. The remaining characters describe the grid: `*` for walls, spaces for open cells, `A` for the start, and `B` for the destination.

## Requirements

A Java Development Kit and the Brock Java library (`brock.*`) are required. The local project uses `brock-v-1-0-28.jar`; obtain the library separately and add it to your project's classpath.

Open the sources in IntelliJ IDEA, configure the Brock JAR as a dependency, and run `RecursiveMaze.main`. The program uses `ASCIIDataFile` for file selection and prints its results to the console.

## Status

This repository preserves the submitted implementation. It closes the input reader before loading the grid and assumes maze boundaries prevent out-of-range recursion; these are limitations to review before relying on the program with other inputs.