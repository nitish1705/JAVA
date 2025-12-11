public class StringCompression {
    public static String compress(String s) {
        StringBuilder ans = new StringBuilder();
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                ans.append(s.charAt(i - 1));
                if (count > 1) ans.append(count);
                count = 1;
            }
        }
        ans.append(s.charAt(s.length() - 1));
        if (count > 1) ans.append(count);

        return ans.toString();
    }
    public static void main(String[] args) {
        System.out.println(compress("aabbbbeeeeffggg"));
        System.out.println(compress("abbccccc"));
    }
}
