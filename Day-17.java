import java.util.*;

public class PrimeFactorization {

    public static List<Long> primeFactors(long n) {
        List<Long> factors = new ArrayList<>();

        while (n % 2 == 0) {
            factors.add(2L);
            n /= 2;
        }

        for (long i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        if (n > 2) {
            factors.add(n);
        }

        return factors;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter positive integer : ");
        long N = sc.nextLong();

        List<Long> result = primeFactors(N);
        System.out.println("Prime factors are : "+result);

        sc.close();
    }
}
