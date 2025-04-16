/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assasinsCreedCollectionProject;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author dam117
 */
public abstract class Personaje implements Serializable {

    protected String nombre;

    /**
     * Constructor
     *
     * @param nombre
     */
    public Personaje(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el nombre del personaje
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el nombre del personaje
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Genera un hashCode para identificar el objeto usando el atributo nombre
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    /**
     * Establece como parámetro de equidad el atributo nombre de cada objeto
     * personaje
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Personaje other = (Personaje) obj;
        return Objects.equals(this.nombre, other.nombre);
    }
    
    /**
     * 
     * @return datos del objeto Persona que lo invoca.
     */
    @Override
    public String toString() {
        return "Personaje{" + "nombre=" + nombre + '}';
    }

}
