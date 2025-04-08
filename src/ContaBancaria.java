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

        do {
            cabecalhoMenu(nomeDoCliente, tipoConta);
            System.out.print("Escolha a operação desejada: ");
            operacao = leitura.nextInt();

            switch (operacao) {
                case 1 -> { System.out.println("O saldo da conta é " + formatoMoeda.format(saldoDaConta)); }
                case 2 -> {
                    System.out.print("Qual valor a receber: ");
                    valor = leitura.nextDouble();
                    saldoDaConta += valor;
                    System.out.println("O saldo da conta é " + formatoMoeda.format(saldoDaConta));
                }
                case 3 -> {
                    System.out.println("Operação de transferência ainda não implementada.");
                }
                case 4 -> {
                    System.out.println("Encerrando o programa...");
                }
                default -> {
                    System.out.println("Operação inválida. Tente novamente.");
                }
            }
            System.out.println();
        } while (operacao != 4);
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