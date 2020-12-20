package classes;

public class Iptu extends Tributo {

    public Iptu(float preco, String pagamento, String vencimento) {
        this.setPreco(preco);
        this.juros = 0.2f;
        this.setVencimento(this.converteData(vencimento));
        this.setDataPagamento(this.converteData(pagamento));
    }

}
