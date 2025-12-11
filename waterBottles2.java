public class waterBottles2 {
    public static int maxBottlesDrunk(int N, int E) {
        int num = N;
        int emp = 0;
        int count = 0;
        while(num > 0){
            count += num;
            emp += num;
            num = 0;
            while(emp >= E){
                num++;
                emp = emp - E;
                E++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(maxBottlesDrunk(10, 3));
    }
}
