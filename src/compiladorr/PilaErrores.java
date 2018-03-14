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

    /***************************************************************************************************
     * Clase de la pila de errores
     * @param 
     * @return 
    *************************************************************************************************/    
public class PilaErrores {
    String error,token;
    int iderror;

    public int getIderror() {
        return iderror;
    }

    public void setIderror(int iderror) {
        this.iderror = iderror;
    }

    /***************************************************************************************************
     * Metodo constructor de la pila de eerores 
     * @param error es el error  
     * @return 
    *************************************************************************************************/    
    public PilaErrores(String error,int iderror) {
        this.error = error;
    }
    private String string;

    /**
     * Get the value of string
     *
     * @return the value of string
     */
    public String getString() {
        return string;
    }

    /**
     * Set the value of string
     *
     * @param string new value of string
     */
    public void setString(String string) {
        this.string = string;
    }
    /**
     * Get the value of string
     *
     * @return the value of string
     */

    public String getError() {
        return error;
    }
    /**
     * Set the value of string
     *
     * @param string new value of string
     */

    public void setError(String error) {
        this.error = error;
    }
    
}
