import java.util.HashMap;
import java.util.Scanner;

public class DistinctNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // int t = sc.nextInt();
        // while(t-->0){
        int n = sc.nextInt();
        HashMap<Long, Long> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long num = sc.nextLong();
            map.put(num, map.getOrDefault(num, 0l) + 1l);
        }
        System.out.println(map.size());
        // }
    }
}
