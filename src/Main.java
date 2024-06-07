import java.util.Scanner;
import java.util.function.DoubleToLongFunction;

public class ControleBancario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Iniciando o programa
        System.out.println("***************************************");
        System.out.println("Dados iniciais do Cliente");

        //Pedir nome do usuario
        System.out.println("Digite o seu nome: ");
        String nomeDoCliente = scanner.nextLine();

        //Pedir saldo
        System.out.println("Digite o saldo disponível: ");
        Double saldoDisponivel = scanner.nextDouble();


        // Mostra os dados do cliente
        System.out.println("***************************************");
        System.out.println("Nome: " + nomeDoCliente);
        System.out.println("Tipo da conta: Corrente");
        System.out.println("Saldo disponível: R$ " + saldoDisponivel);

        //Mostra as opções para o usuario
        while (true) {
            System.out.println("""
                    ***************************************
                    Operações dispníveis
                                    
                    1 - Consultar saldo
                    2 - Receber valor
                    3 - Transferir valor
                    4 - Sair do app
                    ***************************************
                    """);
            int operacaoEscolhida = scanner.nextInt();

            //Mostra o saldo
            switch (operacaoEscolhida) {
                case 1:
                    System.out.println("A opção desejada foi Consultar saldo");
                    System.out.println("Seu saldo é R$ " + saldoDisponivel);

                    break;
                //Solicita valor recebido e mostra o saldo atualizado
                case 2:
                    System.out.println("""
                            A opção desejada foi receber dinheiro.
                            Digite o valor recebido: """);
                    Double valorRecebido = scanner.nextDouble();

                    Double novoSaldo = 0.0;
                    novoSaldo = valorRecebido + saldoDisponivel;
                    saldoDisponivel = novoSaldo;
                    System.out.println("Seu novo saldo é R$ " + saldoDisponivel);


                    break;
                //Solicita valor enviado e mostra o saldo atualizado
                case 3:
                    System.out.println("""
                            A opção desejada foi transferir dinheiro.
                            Digite o valor a ser transferido: """);
                    Double valorEnviado = scanner.nextDouble();

                    //Verifica se há saldo disponível na conta
                    if (valorEnviado > saldoDisponivel) {
                        System.out.println("Saldo insuficiente! =(");
                        System.out.println("Tente novamente!");
                    } else {
                        novoSaldo = saldoDisponivel - valorEnviado;
                        saldoDisponivel = novoSaldo;
                        System.out.println("Seu novo saldo é R$ " + saldoDisponivel);
                    }
                    break;

                //Encerra o app
                case 4:
                    System.out.println("Saindo do app");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

    }
}
