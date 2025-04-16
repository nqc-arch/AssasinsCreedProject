/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assasinsCreedCollectionProject;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Soliloquy
 */
public class Artefacto implements Serializable {

    private String nombre;
    private String origen;
    private String poder;
    
    /**
     * Constrcutor 
     * 
     * @param nombre
     * @param origen
     * @param poder 
     */
    public Artefacto(String nombre, String origen, String poder) {
        this.nombre = nombre;
        this.origen = origen;
        this.poder = poder;
    }
    
    /**
     * 
     * @return nombre del artefacto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * 
     * @return origen del artefacto
     */
    public String getOrigen() {
        return origen;
    }
    
    /**
     * 
     * @return poder del artefacto
     */
    public String getPoder() {
        return poder;
    }
    
    /**
     * Establece el nombre del artefacto
     * 
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Establece el origen del artefacto
     * 
     * @param origen 
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }
    /**
     * Establece el poder del artefacto
     * @param poder 
     */
    public void setPoder(String poder) {
        this.poder = poder;
    }
    
    /**
     * 
     * @return datos del artefacto que lo invoca
     */
    @Override
    public String toString() {
        return "Artefacto{" + "nombre=" + nombre + ", origen=" + origen + ", poder=" + poder + '}';
    }
    
    /**
     * Crea un valor hashCode para el objeto Artefacto que lo invoque
     * 
     * @return el valor del hashCode generado
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        return hash;
    }
    
    /**
     * Decide si dos objetos artefactos son iguales comparando su nombre
     * 
     * @param obj
     * @return true, si los objetos tienen el mismo nombre
     *         false, si los objetos no tienen el mismo nombre
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
        final Artefacto other = (Artefacto) obj;
        return Objects.equals(this.nombre, other.nombre);
    }
    
    
}
