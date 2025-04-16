public class Fibonacci {

    static int iteracoesRec = 0;
    static int instrucoesRec = 0;

    public static int fiboRec(int n) {
        iteracoesRec++;
        instrucoesRec++; 
        if (n <= 1) {
            return n;
        } else {
            instrucoesRec++; 
            return fiboRec(n - 1) + fiboRec(n - 2);
        }
    }

    public static int fiboIterativo(int n) {
        int[] f = new int[n + 1];
        int iteracoes = 0;
        int instrucoes = 0;

        f[0] = 0; instrucoes++;
        f[1] = 1; instrucoes++;

        for (int i = 2; i <= n; i++) {
            iteracoes++;
            instrucoes += 4; 
            f[i] = f[i - 1] + f[i - 2];
        }

        System.out.println("Iterações (Iterativo): " + iteracoes);
        System.out.println("Instruções (Iterativo): " + instrucoes);

        return f[n];
    }

    public static int memoizedFibo(int[] f, int n) {
        int instrucoes = 0;
        int iteracoes = 0;

        for (int i = 0; i <= n; i++) {
            f[i] = -1;
            iteracoes++;
            instrucoes += 2; 
        }

        int resultado = lookupFibo(f, n);

        System.out.println("Iterações (Memoização): " + iteracoesMemo);
        System.out.println("Instruções (Memoização): " + instrucoesMemo);

        return resultado;
    }

    static int instrucoesMemo = 0;
    static int iteracoesMemo = 0;

    private static int lookupFibo(int[] f, int n) {
        iteracoesMemo++;
        instrucoesMemo++; 

        if (f[n] >= 0) return f[n];

        instrucoesMemo++; 
        if (n <= 1) {
            f[n] = n;
            instrucoesMemo++;
        } else {
            f[n] = lookupFibo(f, n - 1) + lookupFibo(f, n - 2);
            instrucoesMemo += 3; 
        }

        return f[n];
    }

    public static void main(String[] args) {
        int[] testValues = {4, 8, 16};

        for (int n : testValues) {
            System.out.println("Fibonacci para n = " + n);

            // Recursivo
            iteracoesRec = 0;
            instrucoesRec = 0;
            long startTime = System.nanoTime();
            int resultadoRec = fiboRec(n);
            long endTime = System.nanoTime();
            System.out.println("Fibo Recursivo: " + resultadoRec);
            System.out.println("Iterações (Recursivo): " + iteracoesRec);
            System.out.println("Instruções (Recursivo): " + instrucoesRec);
            System.out.println("Tempo (Recursivo): " + (endTime - startTime) + " ns");

            // Iterativo
            startTime = System.nanoTime();
            int resultadoIt = fiboIterativo(n);
            endTime = System.nanoTime();
            System.out.println("Fibo Iterativo: " + resultadoIt);
            System.out.println("Tempo (Iterativo): " + (endTime - startTime) + " ns");

            // Memoização
            instrucoesMemo = 0;
            iteracoesMemo = 0;
            int[] memo = new int[n + 1];
            startTime = System.nanoTime();
            int resultadoMemo = memoizedFibo(memo, n);
            endTime = System.nanoTime();
            System.out.println("Fibo Memoizado: " + resultadoMemo);
            System.out.println("Tempo (Memoização): " + (endTime - startTime) + " ns");

            System.out.println("---------------------------");
        }
    }
}
