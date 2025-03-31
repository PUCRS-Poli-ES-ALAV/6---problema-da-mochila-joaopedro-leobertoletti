public class Fibonacci {

    public static int fiboRec(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fiboRec(n - 1) + fiboRec(n - 2);
        }
    }

    public static int fiboIterativo(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public static int memoizedFibo(int[] f, int n) {
        for (int i = 0; i <= n; i++) {
            f[i] = -1;
        }
        return lookupFibo(f, n);
    }

    private static int lookupFibo(int[] f, int n) {
        if (f[n] >= 0) {
            return f[n];
        }
        if (n <= 1) {
            f[n] = n;
        } else {
            f[n] = lookupFibo(f, n - 1) + lookupFibo(f, n - 2);
        }
        return f[n];
    }

    public static void main(String[] args) {
        int[] testValues = {4, 8, 16, 32 };
        
        for (int n : testValues) {
            System.out.println("Fibonacci para n = " + n);
    
            long startTime = System.nanoTime();
            System.out.println("Fibo Recursivo: " + fiboRec(n));
            long endTime = System.nanoTime();
            System.out.println("Tempo de execução (Recursivo): " + (endTime - startTime) + " nanosegundos");

            startTime = System.nanoTime();
            System.out.println("Fibo Iterativo: " + fiboIterativo(n));
            endTime = System.nanoTime();
            System.out.println("Tempo de execução (Iterativo): " + (endTime - startTime) + " nanosegundos");

            int[] memo = new int[n + 1];
            startTime = System.nanoTime();
            System.out.println("Fibo Memoizado: " + memoizedFibo(memo, n));
            endTime = System.nanoTime();
            System.out.println("Tempo de execução (Memoização): " + (endTime - startTime) + " nanosegundos");

            System.out.println("---------------------------");
        }
    }
}
