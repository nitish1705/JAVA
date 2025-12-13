import java.util.*;
public class placing_2x2 {
    static int[][] diff = {{-1, -1}, {-1, 0}, {-1, 1},{ 0, -1}, { 0, 0}, { 0, 1},{ 1, -1}, { 1, 0}, { 1, 1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        int M = sc.nextInt();
        HashSet<String> placed = new HashSet<>();
        int count = 0;
        for (int i = 0; i < M; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            boolean ok = true;
            for (int[] d : diff) {
                int nr = r + d[0];
                int nc = c + d[1];
                String key = nr + "," + nc;

                if (placed.contains(key)) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                placed.add(r + "," + c);
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
