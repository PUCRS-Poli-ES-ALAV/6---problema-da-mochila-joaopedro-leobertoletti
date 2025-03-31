import java.util.ArrayList;
import java.util.List;

public class Mochila {

    static class Item {
        int peso;
        int valor;

        Item(int peso, int valor) {
            this.peso = peso;
            this.valor = valor;
        }
    }

    public static int mochilaForcaBruta(List<Item> itens, int capacidade) {
        int n = itens.size();
        int melhorValor = 0;

        for (int i = 0; i < (1 << n); i++) {  
            int pesoAtual = 0;
            int valorAtual = 0;

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    pesoAtual += itens.get(j).peso;
                    valorAtual += itens.get(j).valor;
                }
            }

            if (pesoAtual <= capacidade && valorAtual > melhorValor) {
                melhorValor = valorAtual;
            }
        }

        return melhorValor;
    }

    public static void main(String[] args) {
        List<Item> itens = new ArrayList<>();
        itens.add(new Item(2, 3));
        itens.add(new Item(3, 4));
        itens.add(new Item(4, 5));
        itens.add(new Item(5, 8));

        int capacidade = 5;

        System.out.println("Valor máximo que pode ser colocado na mochila: " + mochilaForcaBruta(itens, capacidade));
    }
}
