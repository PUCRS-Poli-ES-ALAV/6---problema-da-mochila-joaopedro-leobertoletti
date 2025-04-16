public class DistanciaEdicao {
    public static int iteracoesForcaBruta = 0;
    public static int iteracoesProgDinamica = 0;

    public static int distanciaForcaBruta(String a, String b) {
        iteracoesForcaBruta++;
        if (a.isEmpty()) return b.length();
        if (b.isEmpty()) return a.length();

        if (a.charAt(0) == b.charAt(0)) {
            return distanciaForcaBruta(a.substring(1), b.substring(1));
        }

        int inserir = distanciaForcaBruta(a, b.substring(1));
        int remover = distanciaForcaBruta(a.substring(1), b);
        int substituir = distanciaForcaBruta(a.substring(1), b.substring(1));

        return 1 + Math.min(inserir, Math.min(remover, substituir));
    }

    public static int distanciaProgramacaoDinamica(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] matriz = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            matriz[i][0] = i;
            iteracoesProgDinamica++;
        }

        for (int j = 0; j <= n; j++) {
            matriz[0][j] = j;
            iteracoesProgDinamica++;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                iteracoesProgDinamica++;
                int custo = (a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : 1;
                matriz[i][j] = Math.min(
                        matriz[i - 1][j] + 1,
                        Math.min(matriz[i][j - 1] + 1, matriz[i - 1][j - 1] + custo)
                );
            }
        }

        return matriz[m][n];
    }

    public static void main(String[] args) {
        String a1 = "Casablanca";
        String b1 = "Portentoso";

        String a2 = "Maven, a Yiddish word meaning accumulator of knowledge, began as an attempt to " +
                "simplify the build processes in the Jakarta Turbine project. There were several" +
                " projects, each with their own Ant build files, that were all slightly different." +
                "JARs were checked into CVS. We wanted a standard way to build the projects, a clear " +
                "definition of what the project consisted of, an easy way to publish project information" +
                "and a way to share JARs across several projects. The result is a tool that can now be" +
                "used for building and managing any Java-based project. We hope that we have created " +
                "something that will make the day-to-day work of Java developers easier and generally help " +
                "with the comprehension of any Java-based project.";

        String b2 = "This post is not about deep learning. But it could be might as well. This is the power of " +
                "kernels. They are universally applicable in any machine learning algorithm. Why you might" +
                "ask? I am going to try to answer this question in this article." + 
                "Go to the profile of Marin Vlastelica Pogančić" + 
                "Marin Vlastelica Pogančić Jun";

        System.out.println("| Caso | Distância (FB) | Iterações (FB) | Distância (PD) | Iterações (PD) |");
        System.out.println("|------|----------------|----------------|----------------|----------------|");

        iteracoesForcaBruta = 0;
        iteracoesProgDinamica = 0;
        int distFB1 = distanciaForcaBruta(a1, b1);
        int distPD1 = distanciaProgramacaoDinamica(a1, b1);
        System.out.printf("| 1    | %-14d | %-14d | %-14d | %-14d |\n", distFB1, iteracoesForcaBruta, distPD1, iteracoesProgDinamica);

        iteracoesForcaBruta = 0;
        iteracoesProgDinamica = 0;
        int distPD2 = distanciaProgramacaoDinamica(a2, b2);
        System.out.printf("| 2    | %-14s | %-14s | %-14d | %-14d |\n", "stackoverflow", "stackoverflow", distPD2, iteracoesProgDinamica);
    }
}
