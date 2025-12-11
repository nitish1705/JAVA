import java.util.*;
public class countingRooms {
    static int[][] diffs = {{0,1}, {0,-1}, {-1,0}, {1,0}};
    private static void bfs(int R, int C, int row, int col, char[][] grid){
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row, col});
        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            int r = curr[0], c = curr[1];
            if (grid[r][c] != '.') continue;
            grid[r][c] = '#';
            for (int[] diff : diffs) {
                int nr = r + diff[0];
                int nc = c + diff[1];
                if (nr >= 0 && nc >= 0 && nr < R && nc < C && grid[nr][nc] == '.') {
                    stack.push(new int[]{nr, nc});
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();
        char[][] grid = new char[R][C];
        for (int row = 0; row < R; row++) {
            String line = sc.next();
            for (int col = 0; col < C; col++) {
                grid[row][col] = line.charAt(col);
            }
        }
        int count = 0;
        for(int row = 0; row < R; row++){
            for(int col = 0; col < C; col++){
                if(grid[row][col] == '.'){
                    count++;
                    bfs(R, C, row, col, grid);
                }
            }
        }
        System.out.println(count);
    }
}
