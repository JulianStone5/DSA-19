/**
 * Solver definition for the 8 Puzzle challenge
 * Construct a tree of board states using A* to find a path to the goal
 */

import java.util.*;

public class Solver {

    public int minMoves = -1;
    private State solutionState;
    private boolean solved = false;

    /**
     * State class to make the cost calculations simple
     * This class holds a board state and all of its attributes
     */
    private class State implements Comparable<State> {
        // Each state needs to keep track of its cost and the previous state
        private Board board;
        private int moves; // equal to g-cost in A*
        public int cost; // equal to f-cost in A*
        private State prev;

        public State(Board board, int moves, State prev) {
            this.board = board;
            this.moves = moves;
            this.prev = prev;
            cost = this.moves + board.manhattan();
        }

        @Override
        public boolean equals(Object s) {
            if (s == this) return true;
            if (s == null) return false;
            if (!(s instanceof State)) return false;
            return ((State) s).board.equals(this.board);
        }


        public int compareTo(State s) {
            return this.cost - s.cost;
        }
    }

    /*
     * Return the root state of a given state
     */
    private State root(State state) {
        State current = state;
        while(current.prev != null) {
            current = current.prev;
        }
        return current;
    }

    /*
     * A* Solver
     * Find a solution to the initial board using A* to generate the state tree
     * and a identify the shortest path to the the goal state
     */
    public Solver(Board initial) {
        solutionState = new State(initial,0,null);

        HashSet<State> visited = new HashSet<>();
        visited.add(solutionState);
        PriorityQueue<State> queue = new PriorityQueue<>(10);
        queue.add(solutionState);

        if(!isSolvable()) { return; }

        while(!queue.isEmpty()) {
            State current = queue.remove();
            if(current.board.isGoal()) {
                solutionState = current;
                minMoves = solutionState.moves;
                solved = true;
                return;
            }
            Iterable<Board> neighbors = current.board.neighbors();
            for(Board b : neighbors) {
                State s = new State(b,current.moves+1,current);
                if(!visited.contains(s)) {
                    visited.add(s);
                    queue.add(s);
                }
            }
        }
    }

    /*
     * Is the input board a solvable state
     * Research how to check this without exploring all states
     */
    public boolean isSolvable() {
        return solutionState.board.solvable();
    }

    /*
     * Return the sequence of boards in a shortest solution, null if unsolvable
     */
    public Iterable<Board> solution() {
        if(!isSolvable()) { return null; }
        List<Board> sol = new ArrayList<>();
        State current = solutionState;
        while(current.prev != null) {
            current = current.prev;
            sol.add(current.board);
        }
        return sol;
    }

    public State find(Iterable<State> iter, Board b) {
        for (State s : iter) {
            if (s.board.equals(b)) {
                return s;
            }
        }
        return null;
    }

    /*
     * Debugging space
     */
    public static void main(String[] args) {
        int[][] initState = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Board initial = new Board(initState);

        Solver solver = new Solver(initial);
    }


}
