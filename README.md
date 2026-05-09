# The Parallel XO State Space Explorer

A Java-based project that explores the complete Tic-Tac-Toe (XO) game state space using:

- Single Threading
- Fixed Thread Pool Parallelism
- Virtual Threads (Project Loom)

The project compares execution performance between different concurrency models while calculating all possible game outcomes.

---

# Features

- Full Tic-Tac-Toe state-space exploration
- Recursive DFS game tree traversal
- Single-thread implementation
- Multi-threaded implementation using `ExecutorService`
- Virtual Threads implementation
- Execution time comparison
- GUI built with Java Swing
- Dark UI using FlatLaf

---

# Technologies Used

- Java
- Java Swing
- ExecutorService
- Futures
- Virtual Threads (Java Loom)
- FlatLaf UI

---

# Project Structure

```text
src/
│
├── Board.java
├── Explorer.java
├── Result.java
├── Compare.java
├── GUI.java
└── main.java
```

---

# How It Works

The program recursively explores every possible Tic-Tac-Toe game state.

For each possible move:

1. Copy the board
2. Apply the move
3. Switch player
4. Continue recursion
5. Count:
   - X Wins
   - O Wins
   - Draws
   - Total Endings

---

# Algorithms

## 1. Single Thread

Uses recursive Depth-First Search (DFS) without parallelism.

```java
Result result = single(board, player);
```

---

## 2. Fixed Thread Pool

Uses a fixed-size thread pool based on available CPU cores.

```java
ExecutorService pool =
Executors.newFixedThreadPool(threads);
```

Each first-level move is processed in parallel.

---

## 3. Virtual Threads

Uses Java Virtual Threads for lightweight concurrency.

```java
ExecutorService vpool =
Executors.newVirtualThreadPerTaskExecutor();
```

---

# Performance Notes

Tic-Tac-Toe has a relatively small state space.

Because of this:

- Single-thread execution may sometimes be faster
- Thread management overhead can exceed computation time
- Virtual Threads are more beneficial for large-scale or blocking tasks

This project is intended primarily for learning and comparing concurrency models.

---

# Example Output

```text
Repeated = 1000 Times
=================================

Single Thread
Total Endings = 255168
X Wins = 131184
O Wins = 77904
Draws = 46080
Time = 120 ms

=================================

Parallel
Total Endings = 255168
X Wins = 131184
O Wins = 77904
Draws = 46080
Time = 95 ms

=================================

Virtual Threads
Total Endings = 255168
X Wins = 131184
O Wins = 77904
Draws = 46080
Time = 105 ms
```

---

# Requirements

- Java 21 or newer (required for Virtual Threads)
- NetBeans IDE (recommended)

---

# Running the Project

## Clone Repository

```bash
git clone https://github.com/AhmedML-Prog/The_Parallel_XO_State_Space_Explorer.git
```

## Open in NetBeans

1. Open NetBeans
2. Click:
   - File → Open Project
3. Select the project folder

## Run

Run:

```text
main.java
```

---

# Educational Concepts

This project demonstrates:

- Recursion
- DFS Search
- Game State Space Exploration
- Parallel Computing
- Multithreading
- Virtual Threads
- Futures
- Performance Benchmarking

---

# Author

Ahmed Saleh

Computer Science Student  
Robotics & AI Enthusiast

---

# License

This project is for educational purposes.
