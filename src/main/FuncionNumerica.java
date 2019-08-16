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
public class FuncionNumerica {

    private String nombreFuncion;
    private String id;
    private String cadena;
    private String operador;
    private Valor valor;
    private double resultadoFuncion;

    public FuncionNumerica(String nombreFuncion, String id) {
        this.nombreFuncion = nombreFuncion;
        this.id = id;
        this.cadena = "";
        this.operador = "";
        this.valor = null;
        resultadoFuncion = 0;
    }

    public String getNombreFuncion() {
        return nombreFuncion;
    }

    public void setNombreFuncion(String nombreFuncion) {
        this.nombreFuncion = nombreFuncion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public Valor getValor() {
        return valor;
    }

    public void setValor(Valor valor) {
        this.valor = valor;
    }

    public double getResultadoFuncion() {
        return this.resultadoFuncion;
    }

    public void funcionSumar(Archivo archivo, String clave) {
        int suma = 0;
        int indice = -1;

        Valor[][] lista_datos = archivo.getTablaValores();

        //1. BUSCANDO LA CLAVE
        for (int i = 0; i < lista_datos[0].length; i++) {
            if (lista_datos[0][i].getValor().trim().equalsIgnoreCase(clave.trim())) {
                if (lista_datos[0][i].getTipo().trim().equalsIgnoreCase("numerico")) {
                    indice = i;
                } else {
                    main.Main_Interfaz.lista_errores.add(new Errores("Error Semantico en la función sumar, la clave no es de tipo numerico", clave, 0, 0));
                }
                break;
            }
        }

        //2. OBTENIENDO LOS VALORES DE DICHA CLAVE
        for (int i = 1; i < lista_datos.length; i++) {
            suma += Integer.parseInt(lista_datos[i][indice].getValor());
        }

        this.resultadoFuncion = suma;

    }

    public void funcionContar(Archivo archivo) {
        this.resultadoFuncion = archivo.getTablaValores().length - 1;
    }

    public void funcionPromedio(Archivo archivo, String clave) {

        double suma = 0;
        int indice = -1;

        Valor[][] lista_datos = archivo.getTablaValores();

        //1. BUSCANDO LA CLAVE
        for (int i = 0; i < lista_datos[0].length; i++) {
            if (lista_datos[0][i].getValor().trim().equalsIgnoreCase(clave.trim())) {
                if (lista_datos[0][i].getTipo().trim().equalsIgnoreCase("numerico")) {
                    indice = i;
                } else {
                    main.Main_Interfaz.lista_errores.add(new Errores("Error Semantico en la función promedio, la clave no es de tipo numerico", clave, 0, 0));
                }
                break;
            }
        }

        //2. OBTENIENDO LOS VALORES DE DICHA CLAVE
        for (int i = 1; i < lista_datos.length; i++) {
            suma += Double.parseDouble(lista_datos[i][indice].getValor());
        }

        this.resultadoFuncion = (suma / (lista_datos.length - 1));

    }

    public void funcionContarSi(Archivo archivo, String clave, String operador, Valor condicion) {

        int cuantos = 0;
        int indice = -1;

        Valor[][] lista_datos = archivo.getTablaValores();

        //1. BUSCANDO LA CLAVE
        for (int i = 0; i < lista_datos[0].length; i++) {
            /*if (lista_datos[0][i].getValor().trim().equalsIgnoreCase(clave.trim())) {             
                indice = i;              
                break;
            }*/
            
            if (lista_datos[0][i].getValor().trim().equalsIgnoreCase(clave.trim())) {
                if (lista_datos[0][i].getTipo().trim().equalsIgnoreCase("numerico") && (operador.trim().equalsIgnoreCase(">") || operador.trim().equalsIgnoreCase("<")
                        || operador.trim().equalsIgnoreCase(">=") || operador.trim().equalsIgnoreCase("<=") || operador.trim().equalsIgnoreCase("==") || operador.trim().equalsIgnoreCase("!="))) {
                    indice = i;
                } else if (lista_datos[0][i].getTipo().trim().equalsIgnoreCase("cadena") && (operador.trim().equalsIgnoreCase("==") || operador.trim().equalsIgnoreCase("!="))){
                   indice = i;
                }else{
                     main.Main_Interfaz.lista_errores.add(new Errores("Error Semantico en la función contarSi, una clave cadena no puede usar el simbolo " + operador, operador, 0, 0));
                }
                break;
            }
            
            if (!lista_datos[0][i].getValor().trim().equalsIgnoreCase(clave.trim()) && i == (lista_datos[0].length - 1) ){             
                main.Main_Interfaz.lista_errores.add(new Errores("Error Semantico en la función contarSi, no se encontro la clave " + clave, clave, 0, 0));             
                return;
            }
        }
        
        //2. OBTENIENDO LOS VALORES DE DICHA CLAVE
        for (int i = 1; i < lista_datos.length; i++) {
            if(operador.trim().equalsIgnoreCase(">")){
                double num = Double.parseDouble(lista_datos[i][indice].getValor());
                double cond = Double.parseDouble(condicion.getValor());
                if(num > cond){
                    cuantos++;
                }
            }else if(operador.trim().equalsIgnoreCase("<")){
                double num = Double.parseDouble(lista_datos[i][indice].getValor());
                double cond = Double.parseDouble(condicion.getValor());
                if(num < cond){
                    cuantos++;
                }
            }else if(operador.trim().equalsIgnoreCase(">=")){
                double num = Double.parseDouble(lista_datos[i][indice].getValor());
                double cond = Double.parseDouble(condicion.getValor());
                if(num >= cond){
                    cuantos++;
                }
            }else if(operador.trim().equalsIgnoreCase("<=")){
                double num = Double.parseDouble(lista_datos[i][indice].getValor());
                double cond = Double.parseDouble(condicion.getValor());
                if(num <= cond){
                    cuantos++;
                }
            }else if(operador.trim().equalsIgnoreCase("==")){
                if(lista_datos[i][indice].getValor().trim().equalsIgnoreCase(condicion.getValor())){
                    cuantos++;
                }
            }else if(operador.trim().equalsIgnoreCase("!=")){
                if(!lista_datos[i][indice].getValor().trim().equalsIgnoreCase(condicion.getValor())){
                    cuantos++;
                }
            }
        }
        
        this.resultadoFuncion = cuantos;

    }

}
