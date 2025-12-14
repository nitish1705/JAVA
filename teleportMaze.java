import java.util.*;
//Atcoder D
public class teleportMaze{
    private static int[][] diff = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();
        HashMap<Character, List<int[]>> map = new HashMap<>();
        char[][] grid = new char[R][C];
        for(int i = 0; i < R; i++){
            String s = sc.nextLine();
            for(int j = 0; j < C; j++){
                grid[i][j] = s.charAt(j);
                if(grid[i][j] >= 'a' && grid[i][j] <= 'z'){
                    if(map.containsKey(grid[i][j])){
                        List<int[]> temp = map.get(grid[i][j]);
                        temp.add(new int[]{i, j});
                        map.put(grid[i][j], temp);
                    }
                    else{
                        List<int[]> temp = new ArrayList<>();
                        temp.add(new int[] {i, j});
                        map.put(grid[i][j], temp);
                    }
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        int count = 0;
        boolean flag = false;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] temp = q.poll();
                int x = temp[0], y = temp[1];
                if (x == R - 1 && y == C - 1) {
                    System.out.println(count);
                    flag = true;
                    return;
                }
                if (grid[x][y] >= 'a' && grid[x][y] <= 'z') {
                    for (int[] val : map.get(grid[x][y])) {
                        if (!visited[val[0]][val[1]]) {
                            visited[val[0]][val[1]] = true;
                            q.add(val);
                        }
                    }
                    map.get(grid[x][y]).clear();
                }
                for (int[] d : diff) {
                    int adjx = x + d[0];
                    int adjy = y + d[1];

                    if (adjx >= 0 && adjy >= 0 && adjx < R && adjy < C &&
                        !visited[adjx][adjy] && grid[adjx][adjy] != '#') {

                        visited[adjx][adjy] = true;
                        q.add(new int[]{adjx, adjy});
                    }
                }
            }
            count++;
        }

        // for(int i = 0; i < R; i++){
        //     for(int j = 0; j < C; j++){
        //         System.out.print(grid[i][j]+ " ");
        //     }
        //     System.out.println();
        // }
        if(!flag) System.out.println(-1);
        sc.close();
    }
}
