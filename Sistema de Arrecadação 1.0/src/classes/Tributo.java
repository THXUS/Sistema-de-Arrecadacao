package classes;

import java.util.Date;

public abstract class Tributo implements Pagamento {
    protected float preco;
    protected Date vencimento;
    protected Date dataPagamento;
    protected float tipoJuros;

    public float getTipoJuros() {
        return this.tipoJuros;
    }

    public void setTipoJuros(float tipoJuros) {
        this.tipoJuros = tipoJuros;
    }

    public Tributo(float preco, Date vencimento, Date pagamento) {
        this.setPreco(preco);
        this.setVencimento(vencimento);
        this.setDataPagamento(pagamento);

    }

    public float getPreco() {
        return this.preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Date getDataPagamento() {
        return this.dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getVencimento() {
        return this.vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

}
