/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assasinsCreedCollectionProject;

/**
 *
 * @author dam117
 */
public class Templario extends Personaje implements Comparable<Templario>{

    private String organizacion;
    private int nivel_peligrosidad;

    /**
     * Constructor
     *
     * @param organizacion
     * @param nivel_peligrosidad
     * @param nombre
     */
    public Templario(String organizacion, int nivel_peligrosidad, String nombre) {
        super(nombre);
        this.organizacion = organizacion;
        this.nivel_peligrosidad = nivel_peligrosidad;
    }

    /**
     *
     * @return organizacion a la que pertenece el templario
     */
    public String getOrganizacion() {
        return organizacion;
    }

    /**
     *
     * @return Nivel de peligrosidad del templario
     */
    public int getNivel_peligrosidad() {
        return nivel_peligrosidad;
    }

    /**
     * Establece la organizacion a la que pertenece el templario
     *
     * @param organizacion
     */
    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    /**
     * Establece el nivel de peligrosidad de un templario
     *
     * @param nivel_peligrosidad
     */
    public void setNivel_peligrosidad(int nivel_peligrosidad) {
        this.nivel_peligrosidad = nivel_peligrosidad;
    }

    /**
     *
     * @return Datos del objeto Templario que lo invoca
     */
    @Override
    public String toString() {
        return this.nombre + "{" + "organizacion=" + organizacion + ", nivel_peligrosidad=" + nivel_peligrosidad + '}';
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

    @Override
    public int compareTo(Templario o) {
        if (this.getNivel_peligrosidad() > o.getNivel_peligrosidad()) {
            return -1;
        } else {
            return 1;
        }
    }

}
