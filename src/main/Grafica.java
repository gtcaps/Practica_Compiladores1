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
public class Grafica {
    
    
    public String nombre, titulo, variable, titulo_x, titulo_y;
    
    public Grafica(String nombre, String titulo, String variable, String titulo_x, String titulo_y){
        this.nombre = nombre;
        this.titulo = titulo;
        this.variable = variable;
        this.titulo_x = titulo_x;
        this.titulo_y = titulo_y;
    }
    
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getTitulo(){
        return this.titulo;
    }
    
    public String getNombreVariable(){
        return this.variable;
    }
    
    public String getTituloX(){
        return this.titulo_x;
    }
    
    public String getTituloY(){
        return this.titulo_y;
    }
    
    
    
}
