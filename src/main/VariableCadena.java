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
public class VariableCadena {
    
    
    private String nombre;
    private ObtenerSi valor;
    
    public VariableCadena(String nombre, ObtenerSi valor){
        this.nombre = nombre;
        this.valor = valor;
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ObtenerSi getValor() {
        return valor;
    }

    public void setValor(ObtenerSi valor) {
        this.valor = valor;
    }
    
    
}
