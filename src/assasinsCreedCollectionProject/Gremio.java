/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assasinsCreedCollectionProject;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *
 * @author dam117
 */
public class Gremio {

    private Set<Asesino> conjuntoAsesinos;

    /**
     * Constructor que inicializa la lista
     */
    public Gremio() {
        conjuntoAsesinos = new LinkedHashSet<Asesino>();
    }

    /**
     * Inserta un objeto Asesino al conjuto del gremio.
     *
     * @param asesino
     */
    public void insertarAsesino(Asesino asesino) {
        if (!conjuntoAsesinos.add(asesino)) {
            System.out.println("ERROR: EL ASESINO YA SE ENCUENTRA AGREGADO.");
        } else {
            conjuntoAsesinos.add(asesino);
            System.out.println("Miembro registrado con éxito.");
        }

    }
    
    /**
     * Busca el asesino con el nombre ingresado como parámetro y lo intenta eliminar del
     * conjunto.
     * 
     * @param nombre
     * @return true, si se encuentra y se elimina al asesino.
     *          false, si no se encuentra al asesino o si el conjunto está vacío.
     */
    public boolean eliminarAsesino(String nombre) {
        if (conjuntoAsesinos.isEmpty()) {
            System.out.println("ERROR: NO HAY NINGUN MIEMBRO REGISTRADO EN EL GREMIO.");
            return false;
        }
        boolean resultado = conjuntoAsesinos.removeIf(element -> element.getNombre().equalsIgnoreCase(nombre));
        if (resultado) {
            System.out.println("ASESINO ELIMADO DEL GREMIO CON EXITO.");
        } else {
            System.out.println("ERROR: EL ASESINO NO SE ENCUENTRA REGISTRADO EN EL GREMIO.");
        }
        return resultado;
    }
    
    public void mostrarAsesino(){
        conjuntoAsesinos.forEach(element -> System.out.println(element.toString()));
    }
}
