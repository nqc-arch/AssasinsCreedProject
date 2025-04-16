/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assasinsCreedCollectionProject;

import java.util.Comparator;

/**
 *
 * @author Soliloquy
 */
public class ComparadorTemplarios implements Comparator<Templario> {
    
    /**
     * Compara los objetos Templario pasados por parámetro usando su atributo 
     * nivel_peligrosidad.
     * 
     * @param o1
     * @param o2
     * @return 1 si el 
     */
    @Override
    public int compare(Templario o1, Templario o2) {
        if (o1.getNivel_peligrosidad() > o2.getNivel_peligrosidad()) {
            return 1;
        } else {
            return -1;
        }
    }
    
}
