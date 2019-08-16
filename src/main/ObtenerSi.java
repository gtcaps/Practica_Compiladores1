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
    private String cadenaSalida = "";

    public ObtenerSi(String id, String clave, String operador, Valor valor) {
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

    public String obtenerResultado() {
        return this.cadenaSalida;
    }

    public void funcionObtenerSi(Archivo archivo, String clave, String operador, Valor condicion) {

        String registros = "[\n";
        int indice = -1;

        Valor[][] lista_datos = archivo.getTablaValores();

        //1. BUSCANDO LA CLAVE
        for (int i = 0; i < lista_datos[0].length; i++) {
            System.out.println("FuncionObtenerSi ---> " + lista_datos[0][i].getValor() + " <...> " + clave);

            if (lista_datos[0][i].getValor().trim().equalsIgnoreCase(clave.trim())) {
                if (lista_datos[0][i].getTipo().trim().equalsIgnoreCase("numerico") && (operador.trim().equalsIgnoreCase(">") || operador.trim().equalsIgnoreCase("<")
                        || operador.trim().equalsIgnoreCase(">=") || operador.trim().equalsIgnoreCase("<=") || operador.trim().equalsIgnoreCase("==") || operador.trim().equalsIgnoreCase("!="))) {
                    indice = i;
                    System.out.println("    FuncionObtenerSi ---> " + lista_datos[0][i].getValor() + " <...> " + clave + " MATCH EN " + i);
                } else if (lista_datos[0][i].getTipo().trim().equalsIgnoreCase("cadena") && (operador.trim().equalsIgnoreCase("==") || operador.trim().equalsIgnoreCase("!="))) {
                    indice = i;
                    System.out.println("    FuncionObtenerSi ---> " + lista_datos[0][i].getValor() + " <...> " + clave + " MATCH EN " + i);
                } else {
                    main.Main_Interfaz.lista_errores.add(new Errores("Error Semantico en la función contarSi, una clave cadena no puede usar el simbolo " + operador, operador, 0, 0));
                }
                break;
            }
            
            if (!lista_datos[0][i].getValor().trim().equalsIgnoreCase(clave.trim()) && i == (lista_datos[0].length - 1) ){             
                main.Main_Interfaz.lista_errores.add(new Errores("Error Semantico en la función obtenerSi, no se encontro la clave " + clave, clave, 0, 0));             
                return;
            }

        }

        System.out.println("\n\n\n");
        
        //2. OBTENIENDO LOS VALORES DE DICHA CLAVE
        for (int i = 1; i < lista_datos.length; i++) {
            if(operador.trim().equalsIgnoreCase(">")){
                double num = Double.parseDouble(lista_datos[i][indice].getValor());
                double cond = Double.parseDouble(condicion.getValor());
                if(num > cond){
                    String aux = "{ ";
                    for(int j = 0; j < lista_datos[i].length; j++){
                        aux += lista_datos[i][j].getValor() + " , ";
                    }
                    aux += " }\n";
                    System.out.println("---->" + aux);
                    registros += aux;
                }
            }else if(operador.trim().equalsIgnoreCase("<")){
                double num = Double.parseDouble(lista_datos[i][indice].getValor());
                double cond = Double.parseDouble(condicion.getValor());
                if(num < cond){
                    String aux = "{ ";
                    for(int j = 0; j < lista_datos[i].length; j++){
                        aux += lista_datos[i][j].getValor() + " , ";
                    }
                    aux += " }\n";
                    System.out.println("---->" + aux);
                    registros += aux;
                }
            }else if(operador.trim().equalsIgnoreCase(">=")){
                double num = Double.parseDouble(lista_datos[i][indice].getValor());
                double cond = Double.parseDouble(condicion.getValor());
                if(num >= cond){
                    String aux = "{ ";
                    for(int j = 0; j < lista_datos[i].length; j++){
                        aux += lista_datos[i][j].getValor() + " , ";
                    }
                    aux += " }\n";
                    System.out.println("---->" + aux);
                    registros += aux;
                }
            }else if(operador.trim().equalsIgnoreCase("<=")){
                double num = Double.parseDouble(lista_datos[i][indice].getValor());
                double cond = Double.parseDouble(condicion.getValor());
                if(num <= cond){
                    String aux = "{ ";
                    for(int j = 0; j < lista_datos[i].length; j++){
                        aux += lista_datos[i][j].getValor() + " , ";
                    }
                    aux += " }\n";
                    System.out.println("---->" + aux);
                    registros += aux;
                }
            }else if(operador.trim().equalsIgnoreCase("==")){
                if(lista_datos[i][indice].getValor().trim().equalsIgnoreCase(condicion.getValor())){
                    String aux = "{ ";
                    for(int j = 0; j < lista_datos[i].length; j++){
                        aux += lista_datos[i][j].getValor() + " , ";
                    }
                    aux += " }\n";
                    System.out.println("---->" + aux);
                    registros += aux;
                }
            }else if(operador.trim().equalsIgnoreCase("!=")){
                if(!lista_datos[i][indice].getValor().trim().equalsIgnoreCase(condicion.getValor())){
                    String aux = "{ ";
                    for(int j = 0; j < lista_datos[i].length; j++){
                        aux += lista_datos[i][j].getValor() + " , ";
                    }
                    aux += " }\n";
                    System.out.println("---->" + aux);
                    registros += aux;
                }
            }
        }
        
        registros += "]\n\n";
        
        this.cadenaSalida = registros;
    }

}
