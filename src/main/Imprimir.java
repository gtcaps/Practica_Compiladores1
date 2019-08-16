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
public class Imprimir {
    
    private LinkedList<Expresion> lista_expresiones;
    
    
    public Imprimir(LinkedList<Expresion> lista){
        this.lista_expresiones = lista;
    }

    public LinkedList<Expresion> getLista_expresiones() {
        return lista_expresiones;
    }

    public void setLista_expresiones(LinkedList<Expresion> lista_expresiones) {
        this.lista_expresiones = lista_expresiones;
    }
    
    
    
}
