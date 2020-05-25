import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RottingOranges2 {

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int i = new RottingOranges2().orangesRotting(grid);
        System.out.println(i);
    }

    public int orangesRotting(int[][] grid) {
        Set<Coordinate> fresh = new HashSet<>();
        Set<Coordinate> rotten = new HashSet<>();
        getInitialState(grid, fresh, rotten);

        int minutes = 0;
        while (!fresh.isEmpty()) {

            Set<Coordinate> infected = new HashSet<>();
            rotten.forEach(rottenOrange -> {
                Coordinate neighbor = new Coordinate(rottenOrange.row - 1, rottenOrange.col);
                infect(neighbor, fresh, infected);
                neighbor = new Coordinate(rottenOrange.row + 1, rottenOrange.col);
                infect(neighbor, fresh, infected);
                neighbor = new Coordinate(rottenOrange.row, rottenOrange.col - 1);
                infect(neighbor, fresh, infected);
                neighbor = new Coordinate(rottenOrange.row, rottenOrange.col + 1);
                infect(neighbor, fresh, infected);
            });

            if (infected.isEmpty()) {
                return -1;
            }

            rotten = infected;
            minutes++;
        }
        return minutes;
    }

    private void infect(Coordinate neighbor, Set<Coordinate> fresh, Set<Coordinate> infected) {
        if (fresh.contains(neighbor)) {
            fresh.remove(neighbor);
            infected.add(neighbor);
        }
    }

    private void getInitialState(int[][] grid, Set<Coordinate> fresh, Set<Coordinate> rotten) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                int value = grid[row][col];
                if (value == 1) {
                    fresh.add(new Coordinate(row, col));
                } else if (value == 2) {
                    rotten.add(new Coordinate(row, col));
                }
            }
        }
    }

    class Coordinate {
        final int row;
        final int col;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return row == that.row &&
                    col == that.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

}
