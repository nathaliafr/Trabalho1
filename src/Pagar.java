import java.text.DecimalFormat;
import java.util.Scanner;

 /* @author Natalia Felix da Rocha
    matricula: 192010010016
  */
/*Classe Pagar possui os métodos para adicionar um novo valor, apresentar as formas de pagamentos e realizar o pagamento
 */

public class Pagar {

    //declaração das variáveis globais
    double valor;
    double troco;
    double valorRecebido;
    double valorTotal;
    double valorPrcelado;
    int parcela;

    //neste método ao inserir o valor total do produto o sistema calcula o valor total e apresenta para o usuário
    public double somar(double valorTotal) {
        System.out.println("Qual o valor do produto?");
        Scanner val = new Scanner(System.in);
        valor = val.nextDouble();
        valorTotal = valorTotal+valor; //calculo da soma
        setValorTotal(valorTotal); //armazenagem do valor total
        System.out.println("\nValor total: " + getValorTotal());
        return valorTotal;
    }

    //neste método ao inserir a forma de pagamento como dinheiro, é calculado um desconto de 10% em cima do valor total e apresentado ao usuário todas as informações
    public void pagarDinheiro(double valorTotal, double valorRecebido) {
        System.out.println("Valor total é de R$" + getValorTotal() );
        double desconto = (valorTotal * 10)/100; //calculo do desconto
        System.out.println("Valor do desconto é de R$" + desconto);
        double pagar = valorTotal - desconto; //calculo do valor final
        System.out.println("Valor total com desconto de 10% é de R$" + pagar);
        System.out.println("Valor total recebido ");
        Scanner val = new Scanner(System.in);
        double valor = val.nextDouble();
        setValorRecebido(valor); //armazenando o valor recebido
        troco = valorRecebido-pagar; //calculo do troco
        System.out.println("Troco R$" + troco);
        System.out.println("Pagamento realizado com sucesso");
        zerarCompra(); // o carrinho é zerado apos a finalização da compra
    }

    //neste método ao inserir a forma de pagamento como débito, apresentando o valor das parcelas aceitas
    public double pagarCredito(double valorTotal) {
        int i;
        System.out.println("Valor total é de R$" + getValorTotal());
        System.out.println("Em quantas vezes deseja parcelar?");
        for (i = 1; i <= 10; i++) {
            valorPrcelado = valorTotal / i; // calcula as parcelas
            //cria novo formato de apresentação do valor
            DecimalFormat df = new DecimalFormat("0.00");
            String dx = df.format(valorPrcelado);
            System.out.println("Valor da parcela em " + i + "x é R$" + dx);
        }
        Scanner val = new Scanner(System.in);
        parcela = val.nextInt();
        if (parcela <= 10) {
            System.out.println("Valor total " + getValorTotal());

            valorPrcelado = valorTotal / parcela; // calcula as parcelas
            //cria novo formato de apresentação ddo valor parcelado
            DecimalFormat df = new DecimalFormat("0.00");
            String dx = df.format(valorPrcelado);
            System.out.println("Valor total da parcela R$" + valorPrcelado);
            System.out.println("Pagamento realizado com sucesso");
            zerarCompra(); // o carrinho é zerado apos a finalização da compra
        }else{
            System.out.println("Numero de parcelas invalido");
        }
        return  valorPrcelado;
    }

    //neste método ao inserir a forma de pagamento como débito, apresentando o valor das parcelas aceitas e o desconto que poderá ser aplicado
    public void pagarCheque(double valorTotal){
        String dx;
        System.out.println("Valor total é de R$" + getValorTotal() );
        System.out.println("Em quantas vezes deseja parcelar?");
        for (parcela = 1; parcela <= 3; parcela++) {
            if (parcela==1){
                double desconto = (valorTotal * 5)/100; // calcula o desconto
                valorPrcelado = valorTotal-desconto;
                System.out.println("Valor da parcela em " + parcela + "x é R$" + valorPrcelado);
            }else if (parcela==2 || parcela ==3){
                valorPrcelado = valorTotal / parcela; //calculo do valor parcelado
                //cria novo formato de apresentação do valor parcelado
                DecimalFormat df = new DecimalFormat("0.00");
                dx = df.format(valorPrcelado);
                System.out.println("Valor da parcela em " + parcela + "x é R$" + dx);
            }

        }
        Scanner val = new Scanner(System.in);
        parcela = val.nextInt();
        if (parcela==1){
            double desconto = (valorTotal * 5)/100; //calculo do desconto
            System.out.println("Valor do desconto é de R$" + desconto);
            double pagar = valorTotal - desconto; //calculo do valor a pagar
            //cria novo formato de apresentação do valor a ser pago
            DecimalFormat df = new DecimalFormat("0.00");
            String dp = df.format(pagar);
            System.out.println("Valor total com desconto de 5% é de R$" + dp);
            System.out.println("Pagamento realizado com sucesso");
            zerarCompra(); // o carrinho é zerado apos a finalização da compra
        }else if (parcela == 2 || parcela == 3) {
            System.out.println("Valor total " + getValorTotal());
            valorPrcelado = valorTotal / parcela;
            //cria novo formato de apresentação do valor parcelado
            DecimalFormat df = new DecimalFormat("0.00");
            dx = df.format(valorPrcelado);
            System.out.println("Valor total da parcela R$" + dx);
            System.out.println("Pagamento realizado com sucesso");
            zerarCompra(); // o carrinho é zerado apos a finalização da compra
        }else{
            System.out.println("Numero de parcelas invalido");
        }

    }

    //função utilizada para zerar o carrinho chamada apos cada pagamento
    public double zerarCompra(){
        valorTotal = 0;
        setValorTotal(valorTotal);
        return valorTotal;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(double valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

}
