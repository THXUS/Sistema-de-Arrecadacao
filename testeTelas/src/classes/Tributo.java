/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author estagio5
 */
public abstract class Tributo implements Pagamento{
    protected float preco;
    protected float multa = 2f;
    protected LocalDate dataPagamento;
    protected LocalDate vencimento;
    protected float juros;
    protected float taxa;
    
    private float getJuros(){
        return this.juros;
    }
    
    protected void setJuros(float juros){
        this.juros = juros;
    }
    
    public float getPreco(){
        return this.preco;
    }
   protected void setPreco(float preco){
       this.preco = preco;
   } 
   public float getTaxa(){
       return this.taxa;
   } 
   
   private void setTaxa(float taxa){
       this.taxa = taxa;
   }
   private LocalDate getDataPagamento(){
       return this.dataPagamento;
   }
   protected void setDataPagamento(LocalDate dataPagamento){
       this.dataPagamento = dataPagamento;
       this.atribuirTaxa();
   }
   
   private LocalDate getVencimento(){
       return this.vencimento;
   }
   
   protected void setVencimento(LocalDate vencimento){
       this.vencimento = vencimento;
   }
   
   
   private float atribuirMulta(){
      return this.getPreco()* this.multa/100;
   }
   
   private float atribuirJuros(){
       long diasAtraso = ChronoUnit.DAYS.between(this.getVencimento(), this.getDataPagamento());
       return this.getPreco() * (diasAtraso*this.getJuros())/100;
   }
   private void atribuirTaxa(){
       if(this.getDataPagamento().isAfter(this.getVencimento())){
            float precoMulta = this.atribuirMulta();
            float precoJuros = this.atribuirJuros();
            this.setTaxa(precoJuros + precoMulta);
        }
    }
  
   
   @Override
   public String valorRefis(JTextField refisField){
       return Float.toString(this.atribuirJuros()+ this.atribuirMulta() * Float.parseFloat(refisField.getText())/100);
   }
 
   @Override
   public String valorTotal(){
       return Float.toString(this.getTaxa()+this.getPreco());  
   }
   
   @Override
   public void fazerAcordo(float porcentagem){
       this.setTaxa(this.getTaxa() - this.getTaxa()* porcentagem/100);
   }
   
   @Override
   public void pagar(JTextField refisField){
       if(refisField.getText().equals("") || Float.parseFloat(refisField.getText()) <= 0
               || Float.parseFloat(refisField.getText()) > 100){
           this.fazerAcordo(0);
           if(this.getTaxa() == 0f){
               JOptionPane.showMessageDialog(null, "Valor Pago: R$" + this.getPreco(), "Sistema de Arrecadação",
                       JOptionPane.PLAIN_MESSAGE);
           }
           else{
               JOptionPane.showMessageDialog(null, "Valor Pago: R$"+this.getPreco() +"\n" + "Valor Multa: R$"+
                       this.atribuirMulta()+"\n" + "Valor Juros: R$"+this.atribuirJuros() + "\n" + "Valor Total: R$"+ 
                       this.valorTotal(),"Sistema de Arrecadação",JOptionPane.PLAIN_MESSAGE);
           }
       }
       else
       {
           this.fazerAcordo(Float.parseFloat(refisField.getText()));
           JOptionPane.showMessageDialog(null, "Valor Pago: R$"+this.getPreco() +"\n" + "Valor Multa: R$"+
                       this.atribuirMulta()+"\n" + "Valor Juros: R$"+this.atribuirJuros() + "\n" + "Desconto Refis: R$"+
                       this.valorRefis(refisField)+"\n"+"Valor Total: R$"+ this.valorTotal(),"Sistema de Arrecadação",
                       JOptionPane.PLAIN_MESSAGE);
       }     
   }
   
}
