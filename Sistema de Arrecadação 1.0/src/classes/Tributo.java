package classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public abstract class Tributo implements Pagamento {

    protected float preco;
    protected float multa = 2f;
    protected LocalDate dataPagamento;
    protected LocalDate vencimento;
    protected float juros;
    protected float taxa;

    protected LocalDate converteData(String data) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataConvertida = LocalDate.parse(data, dtf);
        return dataConvertida;
    }

    public float getTaxa() {
        return this.taxa;
    }

    private void setTaxa(float taxa) {
        this.taxa = taxa;
    }

    private LocalDate getDataPagamento() {
        return this.dataPagamento;
    }

    protected void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
        this.atribuirTaxa();
    }

    private LocalDate getVencimento() {
        return this.vencimento;
    }

    protected void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    private void atribuirTaxa() {
        if (this.getDataPagamento().isAfter(this.vencimento)) {
            int diasAtraso = (int) ChronoUnit.DAYS.between(this.getVencimento(), this.getDataPagamento());
            float precoMulta = this.getPreco() * this.multa / 100;
            float precoJuros = this.getPreco() * (diasAtraso * this.juros) / 100;
            this.setTaxa(precoJuros + precoMulta);
        }
    }

    public float getPreco() {
        return this.preco;
    }

    protected void setPreco(float preco) {
        this.preco = preco;

    }

    @Override
    public void pagar() {
        if (this.getTaxa() > 0) {
            System.out.println("Pagou atrasado arrombado!!!");
            System.out.println("Toma uma taxa de " + this.getTaxa());
        } else {
            System.out.println("Pago!!!");
        }
    }

    @Override
    public void fazerAcordo(float porcentagem) {
        this.setTaxa(this.getTaxa() * porcentagem / 100);
    }
}
