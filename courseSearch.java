import java.util.Scanner;

public class courseSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of course: ");
        int course = sc.nextInt();
        sc.nextLine();
        if(course == 0){
            System.out.println("invalid range");
            return;
        }
        String[] arr = new String[course];
        System.out.println("Enter the course name: ");
        for(int i = 0; i < course; i++){
            arr[i] = sc.nextLine();
        }
        System.out.println("Enter the course needed to be searched: ");
        String res = sc.nextLine();
        for(String i : arr){
            if(i.equals(res)){
                System.out.println(i + " course is available");
                return;
            }
        }
        System.out.println(res + " Course is not available");
    }
}
