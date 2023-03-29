import java.util.Arrays;
import java.util.Scanner;
public class missing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();

        int[]arr = new int[n];
        int[]f = new int[n+1];

        Arrays.fill(f, 0);
        for (int i = 0; i < arr.length-1; i++) {
            arr[i] = sc.nextInt();
            f[arr[i]]++;
        }
        for(int i = 1; i<=n;i++){
            if(f[i] ==0 ){
                System.out.println(i);
                break;
            }
        }
        sc.close();
    }
}


