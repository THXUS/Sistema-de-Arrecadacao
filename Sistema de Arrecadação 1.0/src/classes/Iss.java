package classes;

import java.util.Date;

public class Iss extends Tributo {

    public Iss(float preco, Date vencimento, Date pagamento) {
        super(preco, vencimento, pagamento);
        this.setTipoJuros(0.33f);

    }

    @Override
    public void pagar() {

    }

    @Override
    public void pagarAcordo(double porcentagem) {

    }

}
