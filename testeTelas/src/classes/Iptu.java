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
public class Iptu extends Tributo{
    public Iptu(float preco, LocalDate dataPagamento, LocalDate vencimento){
        this.setPreco(preco);
        this.setJuros(0.2f);
        this.setVencimento(vencimento);
        this.setDataPagamento(dataPagamento);
    }
}
