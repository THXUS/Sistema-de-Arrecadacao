package classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Iptu extends Tributo {

    private float juros = 0.20f;
    private float taxa;

    private void checarDebito() {
        if (this.getDataPagamento().isAfter(this.vencimento)) {
            int diasAtraso = (int) ChronoUnit.DAYS.between(this.getVencimento(), this.getDataPagamento());
            float precoMulta = this.getPreco() * this.multa / 100;
            float precoJuros = this.getPreco() * (diasAtraso * this.juros) / 100;
            this.setTaxa(precoJuros + precoMulta);
        }
    }

    public float getTaxa() {
        return this.taxa;
    }

    public void setTaxa(float taxa) {
        this.taxa = taxa;
    }

    @Override
    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
        this.checarDebito();
    }

    public Iptu(float preco, String pagamento, String vencimento) {
        this.setPreco(preco);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate vencimentoDate = LocalDate.parse(vencimento, dtf);
        LocalDate pagamentoDate = LocalDate.parse(pagamento, dtf);
        this.setVencimento(vencimentoDate);
        this.setDataPagamento(pagamentoDate);
    }

    @Override
    public void pagar() {
        if (this.getTaxa() > 0) {
            System.out.println("Pagou atrasado arrombado!!!");
            System.out.println("Toma uma taxa de " + this.getTaxa());
        }
    }

    @Override
    public void fazerAcordo(float porcentagem) {
        this.setTaxa(this.getTaxa() * porcentagem / 100);
    }

}
