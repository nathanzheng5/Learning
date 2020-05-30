import java.util.*;

public class RottingOranges2 {

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int i = new RottingOranges2().orangesRotting(grid);
        System.out.println(i);
    }

    public int orangesRotting(int[][] grid) {
        int MAX_I = grid.length;
        int MAX_J = grid.length > 0 ? grid[0].length : 0;
        Set<Coordinate> fresh = new HashSet<>();
        Set<Coordinate> rotten = new HashSet<>();
        getInitialState(grid, fresh, rotten);

        int minutes = 0;
        while (!fresh.isEmpty()) {
            Set<Coordinate> newRotten = new HashSet<>();
            rotten.forEach(rottenOrange -> {
                rottenOrange.getNeighbors(MAX_I, MAX_J)
                        .forEach(neighbor -> infect(neighbor, fresh, newRotten));
            });

            if (newRotten.isEmpty()) {
                return -1;
            }

            rotten = newRotten;
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

    private class Coordinate {
        private final int i;
        private final int j;

        public Coordinate(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof Coordinate) {
                Coordinate that = (Coordinate) o;
                return this.i == that.i && this.j == that.j;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }

        List<Coordinate> getNeighbors(int MAX_I, int MAX_J) {
            List<Coordinate> retVal = new ArrayList<>();
            if (i - 1 >= 0) {
                retVal.add(new Coordinate(i - 1, j));
            }
            if (i + 1 <= MAX_I) {
                retVal.add(new Coordinate(i + 1, j));
            }
            if (j - 1 >= 0) {
                retVal.add(new Coordinate(i, j - 1));
            }
            if (j + 1 < MAX_J) {
                retVal.add(new Coordinate(i, j + 1));
            }
            return retVal;
        }
    }
}
