/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladorr;

/**
 *
 * @author migue
 */
/**
 * *************************************************************************************************
 * clase  de la tabla de simbolos
 *
 * @param 
 * @return 
    ************************************************************************************************
 */
public class TablaSimbolos {

    String token,valor;
    int claveGeneral, ClaveEspecifica,linea;
    
    /***************************************************************************************************
     * Metodo constructor de la tabla de simbolos 
     * @param token es el token 
     * @param claveGeneral es la clave general del token
     * @param claveEspecifica es la clave especifica del token en caso de necesitarla
     * @return 
    *************************************************************************************************/    
    public TablaSimbolos(String token, int claveGeneral, int ClaveEspecifica,String valor,int linea) {
        this.token = token;
        this.claveGeneral = claveGeneral;
        this.ClaveEspecifica = ClaveEspecifica;
        this.valor=valor;
        this.linea=linea;
    }
    public TablaSimbolos(Menu s){
        
    }
     /**
     * Get the value of string
     *
     * @return the value of string
     */
    public String getToken() {
        return token;
    }
    
    /**
     * Set the value of string
     *
     * @param string new value of string
     */
    public void setToken(String token) {
        this.token = token;
    }
    /**
     * Get the value of string
     *
     * @return the value of string
     */
    public int getClaveGeneral() {
        return claveGeneral;
    }
    
    /**
     * Set the value of string
     *
     * @param string new value of string
     */
    public void setClaveGeneral(int claveGeneral) {
        this.claveGeneral = claveGeneral;
    }
    
    /**
     * Get the value of string
     *
     * @return the value of string
     */
    public int getClaveEspecifica() {
        return ClaveEspecifica;
        
    }
    
    /**
     * Set the value of string
     *
     * @param string new value of string
     */
    public void setClaveEspecifica(int ClaveEspecifica) {
        this.ClaveEspecifica = ClaveEspecifica;
    }
    public void setLinea(int linea){
        this.linea=linea;
    }
    public int getlinea(){
        return linea;
    }
    public void setValor(String valor){
     this.valor=valor;
    }
    public String getValor(){
        return valor;
    }
    public void LeerLineas(String [] arreglo){
    
    }
   

}
