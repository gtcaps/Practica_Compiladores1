/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import analizadores.LexerDatos;
import analizadores.ParserDatos;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;

/**
 *
 * @author aybso
 */
public class LeerArchivo {

    private String path;
    private LinkedList<String> claves;
    private LinkedList<Registro> registros;

    public LeerArchivo(String path) throws Exception {
        this.path = path;
        analizar(path);
    }

    private void analizar(String path) throws FileNotFoundException, Exception {

        BufferedReader buffer = new BufferedReader(new FileReader(path));
        LexerDatos analizadorLexicoDatos = new LexerDatos(buffer);

        ParserDatos analizadorSintacticoDatos = new ParserDatos(analizadorLexicoDatos);
        analizadorSintacticoDatos.parse();

        claves = analizadorSintacticoDatos.raizClaves;
        registros = analizadorSintacticoDatos.raizRegistros;

    }


    public Valor[][] leerArchivo() {

        //OBTENGO EL PRIMER REGISTRO Y DEFINO LOS TIPOS DE CLAVE
        LinkedList<String> tipoClave = new LinkedList();
        Registro primero = registros.getFirst();

        for (Valor val : primero.getListaValores()) {
            if (val.getTipo().equalsIgnoreCase("numerico")) {
                tipoClave.add("numerico");
                System.out.println("numerico");
            } else {
                tipoClave.add("cadena");
                System.out.println("cadena");
            }
        }

        //1.DESCARTAR LOS REGISTROS QUE NO TENGAN TODAS LAS CLAVES
        int cantidadClaves = claves.size();
        LinkedList<Registro> pos = new LinkedList();

        for (int i = 0; i < registros.size(); i++) {
            Registro r = registros.get(i);
            if (r.getListaValores().size() != cantidadClaves) {
                Main_Interfaz.lista_errores.add(new Errores("Error Semantico Cantidad de Claves", r.getRegistro(), 0, 0));
                pos.add(r);
            }
        }
        
        //1.1. ELIMINAR LOS REGISTROS QUE NO CUMPLEN

        for (Registro p : pos) {
            registros.remove(p);
        }
        
        

        //2. DESCAARTAR LOS REGISTROS QUE NO TIENEN EL TIPO DE DATOS
        LinkedList<Registro> r_del = new LinkedList();
        for (int j = 0; j < registros.size(); j++) {
            Registro r = registros.get(j);
            LinkedList<Valor> l_valores = r.getListaValores();
            
            for (int n = 0; n < l_valores.size(); n++) {
                Valor value = l_valores.get(n);
                String tipo = tipoClave.get(n);
                               
                if (value.getTipo() != tipo) {
                    r_del.add(r);
                    Main_Interfaz.lista_errores.add(new Errores("Error Semantico en valor " + value.getValor() + " no tiene el tipo de dato de la clave", r.getRegistro(), 0, 0));
                    break;
                }
            }
        }
        
        
        //2.2. ELIMINAR LOS REGISTROS QUE NO CUMPLEN
        for (Registro r: r_del){
            registros.remove(r);
        }
        
        
        //3.FORMAR LA TABLA DE DATOS
        Valor[][] tablaDatos = new Valor[registros.size() + 1][claves.size()];

        //3.1. ASIGNANDO CABECERAS DE LA TABLA Y EL TIPO DE DATO A ALMACENAR
        for (int i = 0; i < claves.size(); i++) {
            tablaDatos[0][i] = new Valor(claves.get(i), tipoClave.get(i));
        }

        //3.2 POBLAR LA TABLA CON LOS REGISTROS
        for (int i = 1; i < tablaDatos.length; i++) {
            Registro r = registros.get(i - 1);
            LinkedList<Valor> v = r.getListaValores();
            
            for(int j = 0; j < tablaDatos[i].length; j++){
                Valor value = v.get(j);
                tablaDatos[i][j] = value;
                
            }
        }
        
        return tablaDatos;

    }

}
