import java.io.*;
import java.util.StringTokenizer;

public class staticRangeMinimum2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int lg = 1;
        while ((1 << lg) <= n) lg++;

        int[][] arr = new int[lg][n];
        int[] log = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[0][i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < lg; i++) {
            int len = 1 << (i - 1);
            for (int j = 0; j + (1 << i) <= n; j++) {
                arr[i][j] = Math.min(arr[i - 1][j], arr[i - 1][j + len]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < t; q++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            int len = end - start + 1;
            int pow = log[len];
            int res = Math.min(arr[pow][start], arr[pow][end - (1 << pow) + 1]);
            sb.append(res).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
