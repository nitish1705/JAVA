import java.util.*;

public class detectiveChu {
    static HashMap<Character, char[]> changedDirect;
    static HashMap<Character, int[]> getDirect;
    static HashSet<String> set;

    private static void populateDirections() {
        changedDirect = new HashMap<>();
        getDirect = new HashMap<>();

        getDirect.put('N', new int[]{-1, 0});
        getDirect.put('S', new int[]{1, 0});
        getDirect.put('W', new int[]{0, -1});
        getDirect.put('E', new int[]{0, 1});

        changedDirect.put('N', new char[]{'W', 'E'});
        changedDirect.put('S', new char[]{'E', 'W'});
        changedDirect.put('E', new char[]{'N', 'S'});
        changedDirect.put('W', new char[]{'S', 'N'});
    }

    private static void dfs(char[][] grid, int row, int col, int R, int C, char dir, String s, int ind, int n) {
        if (ind == n) {
            set.add(row + "," + col);
            return;
        }

        if (s.charAt(ind) == 'S') {
            int adjr = row + getDirect.get(dir)[0];
            int adjc = col + getDirect.get(dir)[1];

            if (!isValid(adjr, adjc, R, C) || grid[adjr][adjc] == '#') {
                return;
            }
            dfs(grid, adjr, adjc, R, C, dir, s, ind + 1, n);
        } else {
            dfs(grid, row, col, R, C, changeDirection(dir, s.charAt(ind)), s, ind + 1, n);
        }
    }

    private static char changeDirection(char currDir, char turn) {
        int index = (turn == 'L') ? 0 : 1;
        return changedDirect.get(currDir)[index];
    }

    private static boolean isValid(int r, int c, int R, int C) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] grid = new char[n][m];
        for (int r = 0; r < n; r++) {
            String line = sc.next();
            for (int c = 0; c < m; c++) {
                grid[r][c] = line.charAt(c);
            }
        }

        String s = sc.next();
        populateDirections();
        set = new HashSet<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == '.') {
                    for (char dir : changedDirect.keySet()) {
                        dfs(grid, r, c, n, m, dir, s, 0, s.length());
                    }
                }
            }
        }

        System.out.println(set.size());
        sc.close();
    }
}
