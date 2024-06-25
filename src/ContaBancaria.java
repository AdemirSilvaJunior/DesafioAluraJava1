import java.util.Scanner;

public class ContaBancaria {
    private String nome;
    private String tipoConta;
    private double saldo;

    // Construtor para inicializar os dados do cliente
    public ContaBancaria(String nome, String tipoConta, double saldoInicial) {
        this.nome = nome;
        this.tipoConta = tipoConta;
        this.saldo = saldoInicial;
    }

    // Método para consultar saldo
    public void consultarSaldo() {
        System.out.println("Saldo atual: R$ " + saldo);
    }

    // Método para receber valor
    public void receberValor(double valor) {
        saldo += valor;
        System.out.println("Saldo atualizado: R$ " + saldo);
    }

    // Método para transferir valor
    public void transferirValor(double valor) {
        if (valor > saldo) {
            System.out.println("Não há saldo suficiente para fazer essa transferência.");
        } else {
            saldo -= valor;
            System.out.println("Saldo atualizado: R$ " + saldo);
        }
    }

    // Método principal para exibir o menu e processar as operações
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria("Ademir Silva Junior", "Corrente", 2500.0);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("***********************");
            System.out.println("Dados iniciais do cliente:");
            System.out.println("Nome: " + conta.nome);
            System.out.println("Tipo conta: " + conta.tipoConta);
            System.out.println("Saldo inicial: R$ " + conta.saldo);
            System.out.println("***********************");
            System.out.println("Operações");
            System.out.println("1- Consultar saldos");
            System.out.println("2- Receber valor");
            System.out.println("3- Transferir valor");
            System.out.println("4- Sair");
            System.out.print("Digite a opção desejada: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    conta.consultarSaldo();
                    break;
                case 2:
                    System.out.print("Informe o valor a receber: ");
                    double valorReceber = scanner.nextDouble();
                    conta.receberValor(valorReceber);
                    break;
                case 3:
                    System.out.print("Informe o valor que deseja transferir: ");
                    double valorTransferir = scanner.nextDouble();
                    conta.transferirValor(valorTransferir);
                    break;
                case 4:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
