import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class ContaBancaria {
    public static void main(String[] args) {
        // Configurando o formato de moeda para o Brasil
        Locale brasil = new Locale("pt", "BR");
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(brasil);

        Scanner leitura = new Scanner(System.in);

        String nomeDoCliente = "Ricardo Lacerda";
        String tipoConta = "Conta Corrente";
        int operacao;
        double valor;
        double saldoDaConta = 2000.00;

        System.out.println("**************************************");
        System.out.println("*  Nome do cliente: " + nomeDoCliente + "  *");
        System.out.println("*  Tipo da conta: " + tipoConta + "     *");
        System.out.println("**************************************");

    }

}
