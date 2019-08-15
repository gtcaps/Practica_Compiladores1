/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.LinkedList;
import analizadores.*;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author aybso
 */
public class Main {
    
    public static LinkedList<Errores> lista_errores = new LinkedList();
    public static LinkedList<String> lista_claves;
    public static LinkedList<Registro> lista_registros;
    
    public static LinkedList<Variable> lista_variables = new LinkedList();
    
    public static void main(String[] args) {
     
        
        String ruta = "C:/Users/aybso/Downloads/Ejemplo_Entrada_Práctica1/reporte_articulos.rep";
        
        try{
            /*ANALIZADORES DE EL ARCHIVO DE DATOS
            //Analizador Lexico
            BufferedReader buffer = new BufferedReader(new FileReader(ruta));
            LexerDatos analizadorLexicoDatos = new LexerDatos(buffer);
            
            //Analizador Sintactico
            ParserDatos analizadorSintacticoDatos = new ParserDatos(analizadorLexicoDatos);
            analizadorSintacticoDatos.parse();
            lista_claves = analizadorSintacticoDatos.raizClaves;
            lista_registros = analizadorSintacticoDatos.raizRegistros;
            
            
            for(String clave: lista_claves){
                System.out.println("---->"+clave);
            }
            
            for(Registro r : lista_registros){
                LinkedList<Valor> valores_r = r.getListaValores();
                for(Valor valor: valores_r){
                    System.out.println("REGISTRO ---> " + valor.getTipo() + " ---- " + valor.getValor());
                }
                System.out.println("-----------FIN REGISTRO-------------");
            }
            
            System.out.println("--->TAMAÑO" + lista_errores.size());
            
            for(Errores error: lista_errores){
                System.out.println("Error: " + error.getDescripcion() + " ----- " + error.getValor() + " Linea: " + error.getLinea() + " Columna: " + error.getColumna());
            }
            */
            
            BufferedReader buffer = new BufferedReader(new FileReader(ruta));
            LexerReportes analizadorLexicoReportes = new LexerReportes(buffer);
            
            ParserReportes analizadorSintacticoReportes = new ParserReportes(analizadorLexicoReportes);
            analizadorSintacticoReportes.parse();
            LinkedList<Object> lista = analizadorSintacticoReportes.lista_instrucciones;
            LinkedList<Variable> l_vars = analizadorSintacticoReportes.lista_declaracion;
            
            /*
            System.out.println("----> Tamaño: " + l_vars.size() + " ----- " + l_vars.getClass());
            for (Variable v: l_vars){
                System.out.println("Tipo: " + v.getTipo() + " Nombre: " + v.getNombre() + " -----> " + v.getClass() + " ---- " + v.getVariable().getClass());
            }
            */
            for(Object l: lista){
                //System.out.println("----> " + l.getClass());
                if (l instanceof Variable){
                    System.out.println("-------->VARIABLE");
                    Variable v = (Variable) l;
                    System.out.println("-> " + v.getNombre() + " Tipo: " + v.getTipo());
                    System.out.println("");
                }else if(l instanceof Imprimir){
                    System.out.println("------------->IMPRIMIR");
                    Imprimir i = (Imprimir) l;
                    System.out.println("->" + i.getClass());
                    System.out.println("");
                }else{
                    System.out.println("------------------->GRAFICAR");
                    Grafica g = (Grafica) l;
                    System.out.println("->" + g.nombre);
                    System.out.println("");
                }
                
            }
            
            
            
        }catch(Exception ex){
            System.out.println("Error fatal en la compilación");
        }
        
        
        
    }
    
}
