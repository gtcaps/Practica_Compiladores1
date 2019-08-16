/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.JTextArea;

/**
 *
 * @author aybso
 */
public class Archivo {

    private String nombre;
    private String ruta;
    private Valor[][] tablaValores;

    public Archivo(String nombre, String ruta) throws Exception {
        this.nombre = nombre;
        this.ruta = ruta.replace("\"", "");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public void generate() throws Exception {
        LeerArchivo analizador = new LeerArchivo(this.ruta);
        this.tablaValores = analizador.leerArchivo();
    }

    public Valor[][] getTablaValores() {
        return this.tablaValores;
    }

    public String imprimir() {
        String salida = "Claves = [ ";
        for (int x = 0; x < tablaValores[0].length; x++) {
            if ( x == (tablaValores[0].length - 1)){
                salida += tablaValores[0][x].getValor() + " ";
            }else{
                salida += tablaValores[0][x].getValor() + ", ";
            }
        }
        salida += " ]\n";
        salida += "Numero de Registros = " + (tablaValores.length - 1) + "\n";
        return salida;
    }

}
