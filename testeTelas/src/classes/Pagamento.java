/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;


import javax.swing.JTextField;

/**
 *
 * @author estagio5
 */
public interface Pagamento {
    public String valorTotal();
    public String valorRefis(JTextField refisField);
    public void fazerAcordo(float porcentagem);
    public void pagar(JTextField refisField);
}
