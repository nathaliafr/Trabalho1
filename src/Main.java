import java.util.Scanner;

 /* @author Natalia Felix da Rocha
    matricula: 192010010016
  */
/*Classe main utilizada para criar os menus fazendo uso do switch case e do while
 */

public class Main {
    public static void main(String[] args) {

        //chama a classe Pagar()
        Pagar objeto = new Pagar();

        int menu;

        //Menu principal é repetido enquando o usuário não solicita para sair
        do {
        System.out.println("\n1. Incluir produtos?\n" +
                "2. Pagar\n" +
                "0. Sair");
        Scanner scan = new Scanner(System.in);
        menu = scan.nextInt();

            switch (menu) {
                case 1:
                            objeto.somar(objeto.getValorTotal()); //método chamado cada vez que adicionar um valor para realizar a soma
                    break;
                case 2:
                    System.out.println("\n1. Pagamento no dinheiro\n" +
                            "2. Pagamento no cartão de crédito\n" +
                            "3. Pagamento no cheque");
                    Scanner val1 = new Scanner(System.in);
                    menu = val1.nextInt();

                    switch (menu) {

                        case 1:
                            objeto.pagarDinheiro(objeto.getValorTotal(), objeto.getValorRecebido());//método chamado para pagamento em dinheiro
                            break;
                        case 2:
                            objeto.pagarCredito(objeto.getValorTotal());//método chamado para pagamento em catão de credito
                            break;
                        case 3:
                            objeto.pagarCheque(objeto.getValorTotal());//método chamado para pagamento em cheque
                            break;
                    }

                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    break;
            }
        }while (menu != 0);
    }

}
