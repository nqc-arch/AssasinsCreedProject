/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assasinsCreedCollectionProject;

enum RANGO {
    INICIADO,
    MAESTRO,
    MENTOR;
}

/**
 *
 * @author dam117
 */
public class Asesino extends Personaje {

    private int edad;
    private RANGO rango;
    private String arma_favorita;

    /**
     * Constructor
     *
     * @param edad
     * @param arma_favorita
     * @param nombre
     */
    public Asesino(int edad, String rango, String arma_favorita, String nombre) {    
        super(nombre);
        this.edad = edad;
        this.arma_favorita = arma_favorita;
        rango = rango.toUpperCase();
        switch (rango){
            case "INICIADO":
                this.rango = RANGO.INICIADO;
                break;
            case "MAESTRO":
                this.rango = RANGO.MAESTRO;
                break;
            case "MENTOR":
                this.rango = RANGO.MENTOR;
                break;
            default:
                System.out.println("ERROR: RANGO NO DISPONIBLE.ELIJA ENTRE INICIADO, MAESTRO O MENTOR.");
                break;
        }
    }

    /**
     *
     * @return edad del asesino
     */
    public int getEdad() {
        return edad;
    }

    /**
     *
     * @return arma favorita del asesino
     */
    public String getArma_favorita() {
        return arma_favorita;
    }

    /**
     *
     * @return el rango del asesino
     */
    public RANGO getRango() {
        return rango;
    }

    /**
     * Establece el rango del asesino
     *
     * @param rango
     */
    public void setRango(RANGO rango) {
        this.rango = rango;
    }

    /**
     * Establece edad del asesino
     *
     * @param edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Establece el arma favorita de un asesino
     *
     * @param arma_favorita
     */
    public void setArma_favorita(String arma_favorita) {
        this.arma_favorita = arma_favorita;
    }

    /**
     * Metodo hashCode heredado de la clase personaje
     *
     * @return
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Metodo equals heredado de la clase Personaje
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    
    /**
     * 
     * @return datos del objeto Asesino que lo invoca
     */
    @Override
    public String toString() {
        return this.nombre+"{" + "edad=" + edad + ", rango=" + rango + ", arma_favorita=" + arma_favorita + '}';
    }
    
    
    
}
