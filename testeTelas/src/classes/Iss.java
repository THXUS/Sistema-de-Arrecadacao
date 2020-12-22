/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.time.LocalDate;

/**
 *
 * @author estagio5
 */
public class Iss extends Tributo{
    public Iss(float preco, LocalDate dataPagamento, LocalDate vencimento){
        this.setPreco(preco);
        this.setJuros(0.33f);
        this.setVencimento(vencimento);
        this.setDataPagamento(dataPagamento);
    }
}
