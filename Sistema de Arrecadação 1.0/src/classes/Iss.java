package classes;

import java.util.Date;

public class Iss extends Tributo {

    public Iss(float preco, Date vencimento, Date pagamento) {
        super(preco, vencimento, pagamento);
        // TODO Auto-generated constructor stub
        this.setTipoJuros(0.33f);

    }

    @Override
    public void pagar() {
        // TODO Auto-generated method stub

    }

    @Override
    public void pagarAcordo(double porcentagem) {
        // TODO Auto-generated method stub

    }

}
