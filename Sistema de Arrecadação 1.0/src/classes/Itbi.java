package classes;

public class Itbi extends Tributo {

    public Itbi(float preco, String pagamento, String vencimento) {
        this.setPreco(preco);
        this.juros = 0.25f;
        this.setVencimento(this.converteData(vencimento));
        this.setDataPagamento(this.converteData(pagamento));
    }
}
