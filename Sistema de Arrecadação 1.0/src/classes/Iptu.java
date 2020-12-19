package classes;

import java.util.Date;

public class Iptu extends Tributo {

    public Iptu(float preco, Date vencimento, Date pagamento) {
        super(preco, vencimento, pagamento);
        this.setTipoJuros(0.20f);
    }

    @Override
    public void pagar() {

    }

    @Override
    public void pagarAcordo(double porcentagem) {

    }

}
