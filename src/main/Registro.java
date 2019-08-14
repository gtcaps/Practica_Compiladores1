/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.LinkedList;

/**
 *
 * @author aybso
 */
public class Registro {
    
    
    private LinkedList<Valor> valores = new LinkedList();
    
    public Registro(){
        
    }
    
    public Registro(Valor valor){
        this.valores.add(valor);
    }
    
    public Registro(LinkedList<Valor> valores){
        this.valores = valores;
    }
    
    public LinkedList <Valor> getListaValores(){
        return this.valores;
    }
    
    public void addValor(Valor valor){
        this.valores.add(valor);
    }
    
    
}
