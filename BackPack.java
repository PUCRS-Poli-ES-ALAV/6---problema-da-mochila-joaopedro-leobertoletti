public class BackPack {

    public static int backPackPD(int N, int C, int[][] itens) {
        int[][] maxTab = new int[N + 1][C + 1];
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= C; j++) {
                if (itens[i - 1][0] <= j) {
                    maxTab[i][j] = Math.max(
                        maxTab[i - 1][j], 
                        itens[i - 1][1] + maxTab[i - 1][j - itens[i - 1][0]]
                    );
                } else {
                    maxTab[i][j] = maxTab[i - 1][j];
                }
            }
        }

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
        
        System.out.println(backPackPD(N, C, itens));
    }
}
