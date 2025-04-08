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

        cabecalhoMenu(nomeDoCliente, tipoConta);

        System.out.print("Escolha a operação desejada: ");
        operacao = leitura.nextInt();

        while (operacao != 4) {
            if (operacao == 1) {
                System.out.println("O saldo da conta é " + formatoMoeda.format(saldoDaConta));
                System.out.println();
            }
            cabecalhoMenu(nomeDoCliente, tipoConta);
            System.out.println("Escolha a operação desejada: ");
            operacao = leitura.nextInt();
        }
    }

    public static void cabecalhoMenu(String nomeDoCliente, String tipoConta) {
        String cabecalho = String.format("""
                **************************************
                *  Nome do cliente: %s  *
                *  Tipo da conta: %s     *
                **************************************
                
                1 - Consultar Saldo
                2 - Receber Valor
                3 - Transferir Valor
                4 - Sair
                """, nomeDoCliente, tipoConta);
        System.out.println(cabecalho);
    }
}
