import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

/**
 * Board definition for the 8 Puzzle challenge
 */
public class Board {

    private int n;
    public int[][] tiles;

    //TODO
    // Create a 2D array representing the solved board state
    private int[][] goal = {{1,2,3},{4,5,6},{7,8,0}};

    /*
     * Set the global board size and tile state
     */
    public Board(int[][] b) {
        tiles = b;
        n = b.length;
    }

    /*
     * Size of the board 
     (equal to 3 for 8 puzzle, 4 for 15 puzzle, 5 for 24 puzzle, etc)
     */
    private int size() {
        return n;
    }

    /*
     * Sum of the manhattan distances between the tiles and the goal
     */
    public int manhattan() {
        int sum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int val = tiles[i][j];
                if(val != 0) {
                    int tarI = (val-1) / n;
                    int tarJ = (val-1) % n;
                    int di = Math.abs(i-tarI);
                    int dj = Math.abs(j-tarJ);
                    sum += di + dj;
                }
            }
        }
        return sum;
    }

    /*
     * Compare the current state to the goal state
     */
    public boolean isGoal() {
        return manhattan() == 0;
    }

    /*
     * Returns true if the board is solvable
     * Research how to check this without exploring all states
     */
    public boolean solvable() {
        int inversions = 0;
        for(int i = 0; i < n*n; i++) {
            int iy = i / n;
            int ix = i % n;
            int ival = tiles[iy][ix];
            if(ival != 0) {
                for(int j = i+1; j < n*n; j++) {
                    int jy = j / n;
                    int jx = j % n;
                    int jval = tiles[jy][jx];
                    if(jval != 0 && jval > ival) {
                        inversions++;
                    }
                }
            }
        }
        return (inversions % 2 == 0);
    }

    private int[] findEmpty() {
        int[] pos = new int[2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                if(tiles[i][j] == 0) {
                    pos[0] = i;
                    pos[1] = j;
                    return pos;
                }
            }
        }
        return pos;
    }

    private int[][] copyOf(int[][] array) {
        int[][] temp = new int[array.length][array[0].length];
        for(int i = 0; i < temp.length; i++) {
            temp[i] = Arrays.copyOf(array[i],array[i].length);
        }
        return temp;
    }

    /*
     * Return all neighboring boards in the state tree
     */
    public Iterable<Board> neighbors() {
        List<Board> neighbors = new ArrayList<>();
        int[] pos = findEmpty();
        if(pos[0] > 0) {
            int[][] t = copyOf(tiles);
            t[pos[0]][pos[1]] = t[pos[0]-1][pos[1]];
            t[pos[0]-1][pos[1]] = 0;
            neighbors.add(new Board(t));
        }
        if(pos[0] < n-1) {
            int[][] t = copyOf(tiles);
            t[pos[0]][pos[1]] = t[pos[0]+1][pos[1]];
            t[pos[0]+1][pos[1]] = 0;
            neighbors.add(new Board(t));
        }
        if(pos[1] > 0) {
            int[][] t = copyOf(tiles);
            t[pos[0]][pos[1]] = t[pos[0]][pos[1]-1];
            t[pos[0]][pos[1]-1] = 0;
            neighbors.add(new Board(t));
        }
        if(pos[1] < n-1) {
            int[][] t = copyOf(tiles);
            t[pos[0]][pos[1]] = t[pos[0]][pos[1]+1];
            t[pos[0]][pos[1]+1] = 0;
            neighbors.add(new Board(t));
        }
//        for(int k = 0; k < 4; k++) {
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(neighbors.get(k).tiles[i][j] + " ");
//                }
//                System.out.println("");
//            }
//            System.out.println("");
//        }
        return neighbors;
    }

    /*
     * Check if this board equals a given board state
     */
    @Override
    public boolean equals(Object x) {
        // Check if the board equals an input Board object
        if (x == this) return true;
        if (x == null) return false;
        if (!(x instanceof Board)) return false;
        // Check if the same size
        Board y = (Board) x;
        if (y.tiles.length != n || y.tiles[0].length != n) {
            return false;
        }
        // Check if the same tile configuration
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (this.tiles[i][j] != y.tiles[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // DEBUG - Your solution can include whatever output you find useful
        int[][] initState = {{1, 2, 3}, {4, 0, 6}, {7, 8, 5}};
        Board board = new Board(initState);

        System.out.println("Size: " + board.size());
        System.out.println("Solvable: " + board.solvable());
        System.out.println("Manhattan: " + board.manhattan());
        System.out.println("Is goal: " + board.isGoal());
        System.out.println("Neighbors:");
        Iterable<Board> it = board.neighbors();
    }
}
