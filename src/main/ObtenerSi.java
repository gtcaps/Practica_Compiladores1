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
public class ObtenerSi {
    
    
    private String id;
    private String clave;
    private String operador;
    private Valor valor;
    
    public ObtenerSi(String id, String clave, String operador, Valor valor){
        this.id = id;
        this.clave = clave;
        this.operador = operador;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public String getClave() {
        return clave;
    }

    public String getOperador() {
        return operador;
    }

    public Valor getValor() {
        return valor;
    }
    
    
    
}
