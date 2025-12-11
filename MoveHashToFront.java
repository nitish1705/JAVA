public class MoveHashToFront {
    static void moveHash(String s, int n) {
        int count = 0;  
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '#') {
                count++;
            } else {
                temp.append(s.charAt(i));
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < count; i++) {
            ans.append('#');
        }
        ans.append(temp);

        System.out.println(ans.toString());
    }
    public static void main(String[] args) {
        String input = "Move#Hash#to#Front";
        moveHash(input, input.length());
    }
}
