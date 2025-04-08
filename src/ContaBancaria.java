import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class ContaBancaria {
    public static void main(String[] args) {

        Locale brasil = new Locale("pt", "BR");
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(brasil);

        Scanner leitura = new Scanner(System.in);

        String nomeDoCliente = "Ricardo Lacerda";
        String tipoConta = "Conta Corrente";
        int operacao;
        double saldoDaConta = 2000.00;

        do {
            cabecalhoMenu(nomeDoCliente, tipoConta);
            System.out.print("Escolha a operação desejada: ");
            operacao = leitura.nextInt();

            switch (operacao) {
                case 1 -> { System.out.println("O saldo da conta é " + formatoMoeda.format(saldoDaConta)); }
                case 2 -> { saldoDaConta = receberValor(leitura, saldoDaConta, formatoMoeda); }
                case 3 -> { saldoDaConta = sacarValor(leitura, saldoDaConta, formatoMoeda); }
                case 4 -> { break; }
                default -> { System.out.println("Operação inválida. Tente novamente."); }
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

    // MÉTODO RECEBER
    public static double receberValor(Scanner leitura, double saldoDaConta, NumberFormat formatoMoeda) {
        while (true) {
            try {
                System.out.print("Qual valor a receber: ");
                double valor = leitura.nextDouble();
                System.out.println("O saldo da conta é " + formatoMoeda.format((saldoDaConta += valor)));
                return saldoDaConta;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Ao digitar o valor use  ,  para separar as casas decimais..");
                leitura.nextLine();
            }
        }
    }

    // MÉTODO SACAR
    public static double sacarValor(Scanner leitura, double saldoDaConta, NumberFormat formatoMoeda) {
        while (true) {
            try {
                System.out.print("Qual valor deseja sacar: ");
                double valor = leitura.nextDouble();
                if (valor > saldoDaConta) {
                    System.out.println("A conta não tem saldo suficiente para essa operação.");
                    System.out.println("O saldo da conta é " + formatoMoeda.format(saldoDaConta));
                    System.out.print("Deseja tentar novamente? (S = sim / N = não): ");
                    leitura.nextLine();
                    String resposta = leitura.nextLine();
                    if (resposta.equalsIgnoreCase("n")) {
                        System.out.println("Encerrando saque...");
                        break;
                    }
                } else {
                    System.out.println("Saque realizado com sucesso!");
                    System.out.println("O saldo da conta é " + formatoMoeda.format((saldoDaConta -= valor)));
                    break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Ao digitar o valor use  ,  para separar as casas decimais.");
                leitura.nextLine();
            }
        }
        return saldoDaConta;
    }
}