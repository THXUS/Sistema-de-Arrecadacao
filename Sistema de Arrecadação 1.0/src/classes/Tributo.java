package classes;

import java.time.LocalDate;

public abstract class Tributo implements Pagamento {
    protected float preco;
    protected float multa = 2f;
    protected LocalDate dataPagamento;
    protected LocalDate vencimento;

    public LocalDate getDataPagamento() {
        return this.dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public LocalDate getVencimento() {
        return this.vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    /*
     * private void checagemDebito(LocalDate pagamento, LocalDate vencimento) { if
     * (pagamento.isAfter(vencimento)) { // int diasAtraso = (int)
     * ChronoUnit.DAYS.between(pagamento, vencimento);
     * this.setValorTaxaMulta(this.multa); } else {
     * System.out.println("Não está vencido!!"); }
     * 
     */

    public float getPreco() {
        return this.preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

}
