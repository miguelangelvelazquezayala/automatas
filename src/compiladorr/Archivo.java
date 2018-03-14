/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladorr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author migue
 */

/**
 * *************************************************************************************************
 * Clase para leer el archivo
 *
 * @param 
 * @return  
    ************************************************************************************************
 */
public class Archivo {

    int contador = 0;
    AnalizadorLexico a = new AnalizadorLexico();
    ArrayList<TablaSimbolos> array;
     ArrayList<PilaErrores> arrayP;
     int linea;

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getLinea() {
        this.linea=linea;
        return linea;
    }
        /***************************************************************************************************
     * Metodo para leer el archivo 
     * @param   
     * @return  
    *************************************************************************************************/    
    public void LeerArchivo(String ruta) {
        try {
           FileReader lector = new FileReader(ruta);
            BufferedReader bw = new BufferedReader(lector);

            String line;
            String tokenArray[] = null;

            line = bw.readLine();

            while (line != null) {
                tokenArray = line.split(" ");

                for (int i = 0; i < tokenArray.length; i++) {
                    a.definir(tokenArray[i], contador + 1);
                }
                line = bw.readLine();
                contador++;
            }
            //a.imprimir();
            setArray(a.getTabla());
            setArrayP(a.getPOP());
           contador=0;
            bw.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo");
        }
    }
    public void setArray(ArrayList<TablaSimbolos> array){
        this.array=array;
    }
    public ArrayList<TablaSimbolos> getArray(){
        this.array=array;
        return array;
    }
     public void setArrayP(ArrayList<PilaErrores> array){
        this.arrayP=array;
    }
    public ArrayList<PilaErrores> getArrayP(){
        this.arrayP=arrayP;
        return arrayP;
    }
}
