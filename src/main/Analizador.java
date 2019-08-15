/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import analizadores.LexerReportes;
import analizadores.ParserReportes;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;

/**
 *
 * @author aybso
 */
public class Analizador {
    
    
    private String path;
    private LinkedList <Object> listaInstrucciones;
    
    
    public Analizador(String path) throws Exception{
        this.path = path;
        analizar(path);
    }
    
    private void analizar(String path) throws FileNotFoundException, Exception{
        
        BufferedReader buffer = new BufferedReader(new FileReader(path));
        LexerReportes analizadorLexicoReportes = new LexerReportes(buffer);
            
        ParserReportes analizadorSintacticoReportes = new ParserReportes(analizadorLexicoReportes);
        analizadorSintacticoReportes.parse();
        
        listaInstrucciones = analizadorSintacticoReportes.lista_instrucciones;
        
    }
    
    public LinkedList<Object> getLista(){
        return this.listaInstrucciones;
    }
    
    
    
    
    
}
