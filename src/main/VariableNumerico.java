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
public class VariableNumerico {
    
    private String nombre;
    private FuncionNumerica funcion;
    
    public VariableNumerico(String nombre, FuncionNumerica funcion){
        this.nombre = nombre;
        this.funcion = funcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public FuncionNumerica getFuncion() {
        return funcion;
    }

    public void setFuncion(FuncionNumerica funcion) {
        this.funcion = funcion;
    }
    
    
    
}
