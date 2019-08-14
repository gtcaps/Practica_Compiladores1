/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author aybso
 */
public class Valor {
    
    private String valor;
    private String tipo;

    public Valor(String valor, String tipo){
        this.valor = valor;
        this.tipo = tipo;
    }

    public String getValor(){
        return this.valor;
    }

    public String getTipo(){
        return this.tipo;
    }
    
}
