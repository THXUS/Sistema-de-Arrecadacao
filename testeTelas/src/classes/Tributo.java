/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
   
   private void atribuirTaxa(){
       if(this.getDataPagamento().isAfter(this.getVencimento())){
            int diasAtraso = (int) ChronoUnit.DAYS.between(this.getVencimento(),this.getDataPagamento());
            float precoMulta = this.getPreco() * this.multa /100;
            float precoJuros = this.getPreco() * (diasAtraso * this.juros)/100;
            this.setTaxa(precoJuros + precoMulta);
        }
    }
   
   
  @Override
  public String simularAcordo(float porcentagem){
      return Float.toString(this.getTaxa()*porcentagem/100 + this.getPreco());
  }
   
   @Override
   public String valorTotal(){
       return Float.toString(this.getTaxa()+this.getPreco());
   }
   
   @Override
   public void fazerAcordo(float porcentagem){
       this.setTaxa(this.getTaxa()* porcentagem/100);
   }
   
}
