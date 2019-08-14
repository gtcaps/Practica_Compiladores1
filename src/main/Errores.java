
package main;

public class Errores {

    private String descripcion, valor, linea, columna;
    
    
    public Errores(String descripcion,Object valor,Object linea,Object columna){
        this.descripcion = descripcion;
        this.valor = valor.toString();
        this.linea = linea.toString();
        this.columna = columna.toString();
    }
    
    
    public String getDescripcion(){
        return this.descripcion;
    }
    
    public String getValor(){
        return this.valor;
    }
    
    public String getLinea(){
        return this.linea;
    }
    
    public String getColumna(){
        return this.columna;
    }
    
    
}
