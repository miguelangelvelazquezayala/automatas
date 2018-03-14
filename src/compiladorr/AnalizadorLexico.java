/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladorr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 * *************************************************************************************************
 * Clase del analizador lexico 
 * @param 
 * @return1 
    ************************************************************************************************
 */
public class AnalizadorLexico {

    static int contador = 1;
    boolean tokenValido = false;
    

    int posTablaSimbolos = 0;
    TablaSimbolos ts;
    PilaErrores pe;
    int linea=0;
    int identificador=0;
    int tipoError;
    

    ArrayList<TablaSimbolos> tablaSimbolos = new ArrayList<>();
    ArrayList<PilaErrores> pilaErrores = new ArrayList<>();

    /**
     * *************************************************************************************************
     * Metodo para leer el definir el tipo de tokens
     *
     * @param token es la palabra a analizar
     * @param linea es la linea en la que se encuentra la palabra a analizar
     * ***********************************************************************************************
     */
    public void definir(String token, int linea) {
        tokenValido = false;
        tipoError=0;
        this.linea=linea;
//        System.out.println("" + token);
//  System.out.println(""+AutomataPalabrasReservadas(token));
        if (!tokenValido && AutomataComentarios(token)) {
            tokenValido = true;
           
        }
        if (!tokenValido && AutomataPalabrasReservadas(token)) {
            tokenValido = true;
        }
        if (!tokenValido && AutomataOperadoresAritmeticos(token)) {
            tokenValido = true;
        }
        if (!tokenValido && AutomataOperadoresRelacionales(token)) {
            tokenValido = true;
        }
        if (!tokenValido && AutomataSignosAgrupacion(token)) {
            tokenValido = true;
        }
        if (!tokenValido && AutomataValorInt(token)) {
            tokenValido = true;
        }
        if (!tokenValido && AutomataValorDouble(token)) {
            tokenValido = true;
        }
        if (!tokenValido && AutomataValorString(token)) {
            tokenValido = true;
        }
        if (!tokenValido && AutomataIdentificador(token)) {
            tokenValido = true;
        }
        if (!tokenValido && AutomataDelimitador(token)) {
            tokenValido = true;
        }
        //      System.out.println("" + tokenValido);
        if (tokenValido == false) {
            if (!token.equals("")) {
                JOptionPane.showMessageDialog(null, "Error léxico en linea " + linea + "cerca del token " +token);
//                InsertarTablaSimbolos("1", token, "No Válido", contador);
                String error = "Error cerca de " + token + " en la linea " + linea;
                pushPila(new PilaErrores(error,1));
            }
        }
    }

    /**
     * *************************************************************************************************
     * Metodo para que define el automata de las palabras doservadas
     *
     * @param cadena es la cadena a analizar
     * @return aceptado boolean
     * ***********************************************************************************************
     */
    public boolean AutomataPalabrasReservadas(String cadena) {
        int estado = 0;
        int i = 0;
        int caracter;

        boolean aceptado = false;

        while (i < cadena.length()) {
            caracter = (int) (cadena.charAt(i));
            switch (estado) {
                //PALABRA RESERVADA IF
                case 0:
                    if (caracter == 105) {
                        estado = 1;
                    } else {
                        if (caracter == 83) {
                            estado = 5;
                        } else {
                            if (caracter == 101) {
                                estado = 30;
                            } else {
                                if (caracter == 100) {
                                    estado = 11;
                                } else {
                                    if (caracter == 102) {
                                        estado = 17;
                                    } else {
                                        if (caracter == 119) {
                                            estado = 20;
                                        } else {
                                            if (caracter == 98) {
                                                estado = 25;
                                            } else {
                                                estado = 99;
                                            }
                                        }
                                    }
                                }
                            }
                        }

                    }
                    break;
                case 1:
                    if (caracter == 102) {
                        estado = 4;
                    } else {
                        if (caracter == 110) {
                            estado = 2;
                        } else {
                            estado = 99;
                        }
                    }
                    break;
                case 2:
                    if (caracter == 116) {
                        estado = 3;
                    } else {
                        estado = 99;
                    }
                    break;

                //PALABRA RESERVADA IF
                case 5:
                    if (caracter == 116) {
                        estado = 6;
                    } else {
                        estado = 99;
                    }
                    break;

                case 6:
                    if (caracter == 114) {
                        estado = 7;
                    } else {
                        estado = 99;
                    }
                    break;

                case 7:
                    if (caracter == 105) {
                        estado = 8;
                    } else {
                        estado = 99;
                    }
                    break;
                case 8:
                    if (caracter == 110) {
                        estado = 9;
                    } else {
                        estado = 99;
                    }
                    break;

                case 9:
                    if (caracter == 103) {
                        estado = 10;
                    } else {
                        estado = 99;
                    }
                    break;

                case 11:
                    if (caracter == 111) {
                        estado = 12;
                    } else {
                        estado = 99;
                    }
                    break;

                case 12:
                    if (caracter == 117) {
                        estado = 13;
                    } else {
                        estado = 99;
                    }
                    break;

                case 13:
                    if (caracter == 98) {
                        estado = 14;
                    } else {
                        estado = 99;
                    }
                    break;
                case 14:
                    if (caracter == 108) {
                        estado = 15;
                    } else {
                        estado = 99;
                    }
                    break;

                case 15:
                    if (caracter == 101) {
                        estado = 16;
                    } else {
                        estado = 99;
                    }
                    break;

                case 17:
                    if (caracter == 111) {
                        estado = 18;
                    } else {
                        estado = 99;
                    }
                    break;

                case 18:
                    if (caracter == 114) {
                        estado = 19;
                    } else {
                        estado = 99;
                    }
                    break;

                case 20:
                    if (caracter == 104) {
                        estado = 21;
                    } else {
                        estado = 99;
                    }
                    break;

                case 21:
                    if (caracter == 105) {
                        estado = 22;
                    } else {
                        estado = 99;
                    }
                    break;

                case 22:
                    if (caracter == 108) {
                        estado = 23;
                    } else {
                        estado = 99;
                    }

                    break;

                case 23:
                    if (caracter == 101) {
                        estado = 24;
                    } else {
                        estado = 99;
                    }
                    break;

                case 25:
                    if (caracter == 101) {
                        estado = 26;
                    } else {
                        estado = 99;
                    }
                    break;
                case 26:
                    if (caracter == 103) {
                        estado = 27;
                    } else {
                        estado = 99;
                    }
                    break;

                case 27:
                    if (caracter == 105) {
                        estado = 28;
                    } else {
                        estado = 99;
                    }
                    break;

                case 28:
                    if (caracter == 110) {
                        estado = 29;
                    } else {
                        estado = 99;
                    }
                    break;

                case 30:
                    if (caracter == 108) {
                        estado = 31;
                    } else {
                        if (caracter == 110) {
                            estado = 34;
                        } else {
                            estado = 99;
                        }
                    }
                    break;
                case 31:
                    if (caracter == 115) {
                        estado = 32;
                    } else {
                        estado = 99;
                    }
                    break;

                case 32:
                    if (caracter == 101) {
                        estado = 33;
                    } else {
                        estado = 99;
                    }
                    break;

                case 34:
                    if (caracter == 100) {
                        estado = 35;
                    } else {
                        
                        estado = 99;
                    }
                    break;

                case 100:
            }

            i++;
        }
        switch (estado) {
            case 3:
                int tamano=cadena.length();
                caracter=(int) (cadena.charAt(i-1));
                if(caracter==116 && tamano==3){Insertar(new TablaSimbolos("int", 100, 110,"#",linea));
                aceptado = true;}else{aceptado=false;}
                
                break;
            case 4:
                tamano=cadena.length();
                caracter=(int) (cadena.charAt(i-1));
                if(caracter==102 && tamano==2){Insertar(new TablaSimbolos("if", 100, 130,"# ",linea));
                aceptado = true;}else{aceptado=false; }
                
                break;
            case 10:
                 tamano=cadena.length();
                caracter=(int) (cadena.charAt(i-1));
                if(caracter==103 && tamano==6){Insertar(new TablaSimbolos("String", 100, 111,"# ",linea));
                aceptado = true;}else{aceptado=false;}
                break;
            case 16:
                 tamano=cadena.length();
                caracter=(int) (cadena.charAt(i-1));
                if(caracter==101 && tamano==6){Insertar(new TablaSimbolos("double", 100, 112,"# ",linea));
                aceptado = true;}else{aceptado=false;}
                break;
            case 19:
                tamano=cadena.length();
                caracter=(int) (cadena.charAt(i-1));
                if(caracter==114 && tamano==3){Insertar(new TablaSimbolos("for", 100, 121,"# ",linea));
                aceptado = true;}else{aceptado=false;}
                
                break;
            case 24:
                 tamano=cadena.length();
                caracter=(int) (cadena.charAt(i-1));
                if(caracter==101 && tamano==5){Insertar(new TablaSimbolos("while", 100, 120,"# ",linea));
                aceptado = true;}else{aceptado=false;}
                
                break;
            case 29:
                tamano=cadena.length();
                caracter=(int) (cadena.charAt(i-1));
                if(caracter==110 && tamano==5){Insertar(new TablaSimbolos("begin", 100, 140," #",linea));
                aceptado = true;}else{aceptado=false;}
                
                break;
            case 33:
                 tamano=cadena.length();
                caracter=(int) (cadena.charAt(i-1));
                if(caracter==101 && tamano==4){Insertar(new TablaSimbolos("else", 100, 131,"# ",linea));
                aceptado = true;}else{aceptado=false;}
                
                break;
            case 35:
                tamano=cadena.length();
                caracter=(int) (cadena.charAt(i-1));
                if(caracter==100 && tamano==3){Insertar(new TablaSimbolos("end", 100, 143," #",linea));
                aceptado = true;}else{aceptado=false;}
                break;
        }
        return aceptado;
    }

    /**
     * *************************************************************************************************
     * Metodo para que define el automata de los operadores logicos
     *
     * @param cadena es la cadena a analizar
     * @return aceptado boolean
     * ***********************************************************************************************
     */
    public boolean AutomataOperadoresLogicos(String cadena) {
        int estado = 0;
        int i = 0;
        int caracter;

        boolean aceptado = false;

        while (i < cadena.length()) {
            caracter = (int) (cadena.charAt(i));
            switch (estado) {
                case 0:
                    if (caracter == 124) {
                        estado = 1;
                    } else {
                        if (caracter == 38) {
                            estado = 3;
                        } else {
                            if (caracter == 33) {
                                estado = 5;
                            } else {
                                estado = 6;
                            }
                        }
                    }
                    break;
                case 1:
                    if (caracter == 124) {
                        estado = 2;
                    } else {
                        estado = 6;
                    }
                    break;
                case 3:
                    if (caracter == 38) {
                        estado = 4;
                    } else {
                        estado = 6;
                    }
                    break;
            }
            i++;
        }

        switch (estado) {
            case 0:
                Insertar(new TablaSimbolos("||", 103, 0," #",linea));
                aceptado = true;
                break;
            case 1:
                Insertar(new TablaSimbolos("&&", 102, 0," #",linea));
                aceptado = true;
                break;
            case 2:
                Insertar(new TablaSimbolos("!", 101,0," #",linea));
                aceptado = true;
                break;
        }
        return aceptado;
    }

    /**
     * *************************************************************************************************
     * Metodo para que define el automata de los operadores aritmeticos
     *
     * @param cadena es la cadena a analizar
     * @return aceptado boolean
     * ***********************************************************************************************
     */
    public boolean AutomataOperadoresAritmeticos(String cadena) {
        int estado = 0;
        int i = 0;
        int caracter;

        boolean aceptado = false;

        while (i < cadena.length()) {
            caracter = (int) (cadena.charAt(i));
            switch (estado) {
                case 0:
                    if (caracter == 42) {
                        estado = 1;
                    } else {
                        if (caracter == 43) {
                            estado = 2;
                        } else {
                            if (caracter == 45) {
                                estado = 3;
                            } else {
                                if (caracter == 47) {
                                    estado = 4;
                                } else {
                                    if (caracter == 94) {
                                        estado = 5;
                                    } else {
                                        if (caracter == 37) {
                                            estado = 6;
                                        } else {
                                            estado = 99;
                                        }
                                    }

                                }
                            }
                        }
                        break;
                    }
            }
            i++;
        }
        switch (estado) {
            case 1:
                caracter=(int)(cadena.charAt(i-1));
                if(caracter==42){
                Insertar(new TablaSimbolos("*", 200, 204," #",linea));
                aceptado = true;}else aceptado=false;
                break;
            case 2:
                caracter=(int)(cadena.charAt(i-1));
                if(caracter==43){
                Insertar(new TablaSimbolos("+", 200,200," #",linea));
                aceptado = true;}else aceptado=false;
                break;
            case 3:
                caracter=(int)(cadena.charAt(i-1));
                if(caracter==45){
                Insertar(new TablaSimbolos("-", 200,201," #",linea));
                aceptado = true;}else aceptado=false;
                break;
            case 4:
                caracter=(int)(cadena.charAt(i-1));
                if(caracter==47 && cadena.length()==1){
                Insertar(new TablaSimbolos("/", 200,202," #",linea));
                aceptado = true;}else aceptado=false;
                break;
            case 5:
                caracter=(int)(cadena.charAt(i-1));
                if(caracter==94){
                Insertar(new TablaSimbolos("^", 200,205," #",linea));
                aceptado = true;}else aceptado=false;
                break;
            case 6:
                caracter=(int)(cadena.charAt(i-1));
                if(caracter==37){
                Insertar(new TablaSimbolos("%", 200,203,"# ",linea));
                aceptado = true;}else aceptado=false;
                break;

        }
        return aceptado;
    }

    /**
     * *************************************************************************************************
     * Metodo para que define el automata de los osignos de agrupacion
     *
     * @param cadena es la cadena a analizar
     * @return aceptado boolean
     * ***********************************************************************************************
     */
    public boolean AutomataSignosAgrupacion(String cadena) {
        int estado = 0;
        int i = 0;
        int caracter;

        boolean aceptado = false;

        while (i < cadena.length()) {
            caracter = (int) (cadena.charAt(i));
            switch (estado) {
                case 0:
                    if (caracter == 40) {
                        estado = 1;
                    } else {
                        if (caracter == 41) {
                            estado = 2;
                        } else {
                            if (caracter == 91) {
                                estado = 3;
                            } else {
                                if (caracter == 93) {
                                    estado = 4;
                                } else {
                                    if (caracter == 123) {
                                        estado = 5;
                                    } else {
                                        if (caracter == 125) {
                                            estado = 6;
                                        } else {
                                            estado = 99;
                                        }
                                    }

                                }

                            }
                        }
                    }
                    break;
            }
            i++;
        }

        switch (estado) {
            case 1:
                caracter=(int)(cadena.charAt(i-1));
                if(caracter==40 ){Insertar(new TablaSimbolos("(", 560, 560,"#",linea));
                aceptado = true;}
                else aceptado=false;
                break;
            case 2:
                caracter=(int)(cadena.charAt(i-1));
                if(caracter==41){Insertar(new TablaSimbolos(")", 560, 561,"#",linea));
                aceptado = true;}
                else aceptado= false;
                break;
            case 3:
                caracter=(int)(cadena.charAt(i-1));
                if(caracter==91){Insertar(new TablaSimbolos("[", 560, 564,"#",linea));
                aceptado = true;}
                else aceptado=false;
                break;
            case 4:
                caracter=(int)(cadena.charAt(i-1));
                if(caracter==93){
                Insertar(new TablaSimbolos("]", 560, 565,"#",linea));
                aceptado = true;}
                else aceptado=false;
                break;
            case 5:
                caracter=(int)(cadena.charAt(i-1));
                if(caracter==123){
                Insertar(new TablaSimbolos("{", 560, 562,"#",linea));
                aceptado = true;}
                else aceptado=false;
                break;
            case 6:
                caracter=(int)(cadena.charAt(i-1));
                if(caracter==125){
                Insertar(new TablaSimbolos("}", 560,563,"#",linea));
                aceptado = true;}
                else aceptado=false;
                break;
        }
        return aceptado;
    }

    /**
     * *************************************************************************************************
     * Metodo para que define el automata de los operadores relacionales
     *
     * @param cadena es la cadena a analizar
     * @return aceptado boolean
     * ***********************************************************************************************
     */
    public boolean AutomataOperadoresRelacionales(String cadena) {
        int estado = 0;
        int i = 0;
        int caracter;

        boolean aceptado = false;

        while (i < cadena.length()) {
            caracter = (int) (cadena.charAt(i));
            switch (estado) {
                case 0:
                    if (caracter == 60) {
                        estado = 1;
                        if (caracter == 61) {
                            estado = 3;
                        }
                    } else {
                        if (caracter == 62) {
                            estado = 2;
                            if (caracter == 61) {
                                estado = 4;
                            }
                        } else {
                            if (caracter == 33) {
                                estado = 5;
                            } else {
                                if (caracter == 61) {
                                    estado = 7;
                                    if (caracter == 61) {
                                        estado = 8;
                                    }
                                } else {
                                    if(caracter == 40){estado =9;}else{if(caracter == 41){estado=10;}else{estado=99;}}
                                }

                            }
                        }
                    }
                    break;
                case 5:
                    if (caracter == 61) {
                        estado = 6;
                    }
                    break;
            }
            i++;
        }

        switch (estado) {
            case 1:
                 int tamano=cadena.length();
                caracter=(int) (cadena.charAt(i-1));
                if(caracter==61){
                Insertar(new TablaSimbolos("<=", 300,302,"#",linea));
                aceptado = true;}
                else{if(tamano==1){Insertar(new TablaSimbolos("<",300,300,"#",linea));aceptado=true;}else{aceptado=false;}}
                break;
            case 2:
                tamano=cadena.length();
                caracter=(int) (cadena.charAt(i-1));
                if(caracter==61){
                Insertar(new TablaSimbolos(">=", 300,303,"#",linea));
                aceptado = true;}
                else{if(tamano==1){Insertar(new TablaSimbolos(">",300,301,"#",linea));aceptado=true;}else{aceptado=false;}}
                break;
            case 3:
                 
                Insertar(new TablaSimbolos("<=", 300,302,"#",linea));
                aceptado = true;
                
                break;
            case 4:
                Insertar(new TablaSimbolos(">=", 300, 303,"#",linea));
                aceptado = true;
                break;
            case 6:
                Insertar(new TablaSimbolos("!=", 300,306,"#",linea));
                aceptado = true;
                break;
            case 7:
                Insertar(new TablaSimbolos("=", 300, 305,"#",linea));
                aceptado = true;
                break;
            case 8:
                Insertar(new TablaSimbolos("==", 300, 304,"#",linea));
                aceptado = true;
                break;
            
        }
        return aceptado;
    }

    /**
     * *************************************************************************************************
     * Metodo para que define el automata de los valores enteros
     *
     * @param cadena es la cadena a analizar
     * @return aceptado boolean
     * ***********************************************************************************************
     */
    public boolean AutomataValorInt(String cadena) {
        int estado = 0;
        int i = 0;
        int caracter;

        boolean aceptado = false;

        while (i < cadena.length()) {
            caracter = (int) (cadena.charAt(i));
            switch (estado) {
                case 0:
                    if (caracter > 47 && caracter < 58) {
                        estado = 1;
                    } else {
                        estado = 3;
                    }
                    break;
                case 1:
                    if (caracter > 47 && caracter < 58) {
                        estado = 1;
                    } else {
                        
                            estado = 3;
                        
                    }
                    break;
                case 3:
                    aceptado=false;
                    break;
            }
            i++;
        }

        if (estado == 1) {
            Insertar(new TablaSimbolos("" + cadena, 10, 10,"",linea));
            aceptado = true;
        }
        return aceptado;
    }

    /**
     * *************************************************************************************************
     * Metodo para que define el automata de los valores de tipo double
     *
     * @param cadena es la cadena a analizar
     * @return aceptado boolean
     * ***********************************************************************************************
     */
    public boolean AutomataValorDouble(String cadena) {

        int estado = 0;
        int i = 0;
        int caracter;

        boolean aceptado = false;

        while (i < cadena.length()) {
            caracter = (int) (cadena.charAt(i));
            switch (estado) {
                case 0:
                    if (caracter > 47 && caracter < 58) {
                        estado = 1;
                    } else {
                        estado = 4;
                    }
                    break;

                case 1:
                    if (caracter > 47 && caracter < 58) {
                        estado = 1;
                    } else {
                        if (caracter == 46) {
                            estado = 2;
                        } else {
                            estado = 4;
                        }
                    }
                    break;

                case 2:
                    if (caracter > 47 && caracter < 58) {
                        estado = 2;
                    } else {
                        if (caracter == 46) {
                            estado = 4;
                        }
                    }
                    break;
                case 4:
            }
            i++;
        }

        if (estado == 2) {
            Insertar(new TablaSimbolos("" + cadena, 10,10,"",linea));
            //          InsertarTablaSimbolos("120", cadena, "Double", contador);
            aceptado = true;
        }

        return aceptado;
    }

    /**
     * *************************************************************************************************
     * Metodo para que define el automata de las cadenas
     *
     * @param cadena es la cadena a analizar
     * @return aceptado boolean
     * ***********************************************************************************************
     */
    public boolean AutomataValorString(String cadena) {
        int estado = 0;
        int i = 0;
        int caracter = 0;

        boolean aceptado = false;
        String subtoken = "";

        while (i < cadena.length() && estado != 3 && subtoken.equals("")) {
            caracter = (int) (cadena.charAt(i));

            switch (estado) {
                case 0:
                    if (caracter == 34) {
                        estado = 1;
                    } else {
                        estado = 3;
                    }
                    break;

                case 1:
                    if (caracter != 34) {
                        estado = 1;
                    } else {
                        estado = 2;
                    }
                    break;

                case 2:
                    if ((i + 1) != cadena.length()) {
                        estado = 2;
                        subtoken = cadena.substring(i, cadena.length());
                        //InsertarTablaSimbolos("120", cadena.substring(0, i-1) , "String");

                    } else {
                        estado = 3;
                        subtoken = cadena.substring(i, cadena.length());
                    }

                    break;
            }
            i++;
        }

        if (estado == 2) {
            //System.out.println(""+caracter);
            if (caracter != 34) {
                Insertar(new TablaSimbolos(cadena, 500, 500,"",linea));
                System.out.println("ok");
                //               Insertar("130", cadena.substring(0, i - 1), "String", contador);
            } else {
                  Insertar(new TablaSimbolos(cadena, 500, 500,"",linea));
                System.out.println("ok");
                //             InsertarTablaSimbolos("130", cadena.substring(0, i), "String", contador);
            }
            aceptado = true;
        }

        if (estado == 3 && !subtoken.equals("")) {
            System.out.println("ok");
//            InsertarTablaSimbolos("130", cadena.substring(0, i - 1), "String", contador);
            aceptado = true;
        }

        if (!subtoken.equals("")) {
            definir(subtoken, 0);
        }

        return aceptado;
    }

    /*
    public boolean AutomataValorString(String cadena) {

        int estado = 0;
        int i = 0;
        int caracter = 0;

        boolean aceptado = false;
        String subtoken = "";

        while (i < cadena.length()) {
            caracter = (int) (cadena.charAt(i));

            switch (estado) {
                case 0:
                    if (caracter == 34) {
                        estado = 1;
                    } else {
                        estado = 3;
                    }
                    break;

                case 1:
                    if ((caracter != 34) && ((caracter > 32) && (caracter < 62)) && ((caracter > 96) && (caracter < 126)) && (caracter != 39) && (caracter != 58)) {
                        estado = 1;
                    } else {
                        if (caracter == 34) {
                            estado = 2;
                        } else {
                            estado = 3;
                        }
                    }
                    break;

            }
            i++;
        }

        if (estado == 2) {
            Insertar(new TablaSimbolos("" + cadena, 130, 0));
            aceptado = true;
        }

        return aceptado;
    }
     */
    /**
     * *************************************************************************************************
     * Metodo para que define el automata de los identificadores
     *
     * @param cadena es la cadena a analizar
     * @return aceptado boolean
     * ***********************************************************************************************
     */
    public boolean AutomataIdentificador(String cadena) {

        int estado = 0;
        int i = 0;
        int caracter;

        boolean aceptado = false;
        String subtoken = "";

        while (i < cadena.length()) {
            caracter = (int) (cadena.charAt(i));
            switch (estado) {
                case 0:
                    if (caracter == 36) {
                        estado = 1;
                    } else {
                        estado = 4;
                    }
                    break;
                case 1:
                    if ((caracter > 64 && caracter < 91) || (caracter > 96 && caracter < 123)) {
                        estado = 2;
                    } else {
                        estado = 4;
                    }
                    break;

                case 2:
                    if ((caracter > 64 && caracter < 91) || (caracter > 96 && caracter < 123) || (caracter > 47 && caracter < 58) || caracter == 95) {
                        estado = 2;
                    } else {
                        estado = 3;
                    }
                    break;

                case 4:
            }
            i++;
        }

        if (estado == 2) {
            Insertar(new TablaSimbolos("" + cadena, 1000, 1000+identificador,"",linea));
            aceptado = true;
            identificador++;
        }

        return aceptado;
    }

    /**
     * *************************************************************************************************
     * Metodo para que define el automata del delimitador
     *
     * @param cadena es la cadena a analizar
     * @return aceptado boolean 
    ************************************************************************************************
     */
    public boolean AutomataDelimitador(String cadena) {
        int estado = 0;
        int i = 0;
        int caracter;

        boolean aceptado = false;
        String subtoken = "";

        while (i < cadena.length()) {
            caracter = (int) (cadena.charAt(i));

            switch (estado) {
                case 0:
                    if (caracter == 59) {
                        estado = 1;
                    } else {
                        estado = 2;
                    }
                    break;

                case 1:
                    subtoken = cadena.substring(i, cadena.length());
                    break;

                case 2:
            }
            i++;
        }

        if (estado == 1) {
            Insertar(new TablaSimbolos(";", 400, 144,"",linea));
            aceptado = true;
        }

        return aceptado;
    }

    /**
     * *************************************************************************************************
     * Metodo para que define el automata de los comentarios
     *
     * @param cadena es la cadena a analizar
     * @return aceptado boolean 
    ************************************************************************************************
     */
    public boolean AutomataComentarios(String cadena) {
        int estado = 0;
        int i = 0;
        int caracter;

        boolean aceptado = false;

        while (i < cadena.length()) {
            caracter = (int) (cadena.charAt(i));
            switch (estado) {
                case 0:
                    if (caracter == 92) {
                        estado = 1;
                    } else estado=2;
                    break;
                case 1:
                    if (caracter == 42) {
                        estado = 3;
                    } else {
                        estado = 5;
                    }
                    break;
                case 3:
                    if (caracter > 96 && caracter<123) {
                        estado = 3;
                    } else {
                        if(caracter!=92)
                            estado=2;
                        else estado=4;
                       
                    }
                    break;
                case 4:
                     
                    break;
            }
            i++;
        }
        if(estado==2){aceptado=false;}
        if(estado==4)aceptado=true;
        
        return aceptado;
    }

    /**
     * *************************************************************************************************
     * Metodo para recuperar tabla de Simbolos
     *
     * @param
     * @return TablaSimbolos 
    ************************************************************************************************
     */
    public ArrayList getTabla() {
        
        return tablaSimbolos;
    }
     public ArrayList getPOP() {
        
        return pilaErrores;
    }
    public int getLinea(){linea=0;return linea;}

    /**
     * *************************************************************************************************
     * Metodo para que insertar los tokens en la tabla de simbolos
     *
     * @param ts es el token
     * @return 
    ************************************************************************************************
     */
    public void Insertar(TablaSimbolos ts) {
        tablaSimbolos.add(ts);
    }

    /**
     * *************************************************************************************************
     * Metodo para insertar los errores en la pila de errores
     *
     * @param pe es el error
     * @return aceptado boolean 
    ************************************************************************************************
     */
    public void pushPila(PilaErrores pe) {
        pilaErrores.add(pe);
    }

}
