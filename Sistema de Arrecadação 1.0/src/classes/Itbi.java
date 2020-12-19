package classes;

import java.util.Date;

public class Itbi extends Tributo {

    public Itbi(float preco, Date vencimento, Date pagamento) {
        super(preco, vencimento, pagamento);
        this.setTipoJuros(0.25f);
    }

    @Override
    public void pagar() {
        if (this.getDataPagamento().after(this.getVencimento())) {
            // terminar amanhã!!!
        }
    }

    @Override
    public void pagarAcordo(double porcentagem) {
    }

}
