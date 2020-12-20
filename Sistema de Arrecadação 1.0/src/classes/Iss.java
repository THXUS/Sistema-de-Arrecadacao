package classes;

public class Iss extends Tributo {

    public Iss(float preco, String pagamento, String vencimento) {
        this.setPreco(preco);
        this.juros = 0.33f;
        this.setVencimento(this.converteData(vencimento));
        this.setDataPagamento(this.converteData(pagamento));
    }
}
