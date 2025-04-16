public class BackPack {

    public static int backPackPD(int N, int C, int[][] itens) {
        int[][] maxTab = new int[N + 1][C + 1];
        int iteracoes = 0;
        int instrucoes = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= C; j++) {
                iteracoes++;
                instrucoes++; 

                if (itens[i - 1][0] <= j) {
                    instrucoes += 5; 
                    maxTab[i][j] = Math.max(
                        maxTab[i - 1][j], 
                        itens[i - 1][1] + maxTab[i - 1][j - itens[i - 1][0]]
                    );
                } else {
                    instrucoes += 2; 
                    maxTab[i][j] = maxTab[i - 1][j];
                }
            }
        }

        System.out.println("Iterações: " + iteracoes);
        System.out.println("Instruções: " + instrucoes);

        return maxTab[N][C];
    }

    public static void main(String[] args) {
        int[][] itens = {
            {2, 3},
            {3, 4},
            {4, 5},
            {5, 6}
        };

        int N = 4;
        int C = 5;

        long startTime = System.nanoTime();
        int resultado = backPackPD(N, C, itens);
        long endTime = System.nanoTime();

        System.out.println("Valor máximo: " + resultado);
        System.out.println("Tempo de execução: " + (endTime - startTime) + " ns");
    }
}
