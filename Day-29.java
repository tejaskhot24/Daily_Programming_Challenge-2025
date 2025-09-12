import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciDP {

    public static BigInteger fibonacci(int n) {
      
        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;

        BigInteger[] dp = new BigInteger[n + 1];

        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;

     
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]); 
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.println("F(" + n + ") = " + fibonacci(n));
        
        sc.close();
    }
}
