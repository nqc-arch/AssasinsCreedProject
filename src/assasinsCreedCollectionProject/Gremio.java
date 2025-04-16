/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assasinsCreedCollectionProject;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *
 * @author dam117
 */
public class Gremio {

    private Set<Asesino> conjuntoAsesinos;
    private List<Artefacto> inventario;

    /**
     * Constructor que inicializa la lista
     */
    public Gremio() {
        conjuntoAsesinos = new LinkedHashSet<Asesino>();
        inventario = new ArrayList<Artefacto>();
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
            System.out.println("Miembro registrado con éxito.");
        }

    }

    /**
     * Busca el asesino con el nombre ingresado como parámetro y lo intenta
     * eliminar del conjunto.
     *
     * @param nombre
     * @return true, si se encuentra y se elimina al asesino. false, si no se
     * encuentra al asesino o si el conjunto está vacío.
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

    /**
     * Muestra los asesinos registrados en el gremio.
     */
    public void mostrarAsesinos() {
        System.out.println("LISTADO DE ASESINOS");
        conjuntoAsesinos.forEach(element -> System.out.println(element.toString()));
    }

    
    /**
     * Agrega un nuevo tipo de artefacto al Inventario si este no está contenido aún.
     * 
     * @param artefacto 
     */
    public void agregarAInventario(Artefacto artefacto) {
        if (inventario.contains(artefacto)) {
            System.out.println("ERROR: EL ARTEFACTO YA SE ENCUENTRA AGREGADO EN EL INVENTARIO.");
        } else {
            inventario.add(artefacto);
            System.out.println("ARTEFACTO REGISTRADO CORRECTAMENTE.");
        }
    }
    
    /**
     * Muestra los artefactos registrados en el inventario
     */
    public void mostrarInventario(){
        System.out.println("CONTENIDO DEL INVENTARIO:");
        inventario.forEach((Artefacto element) -> System.out.println(element.toString()));
    }
    
    /**
     * Elimina el primer artefacto que se encuentre en la lista que coincida con el nombre 
     * introducido por parámetro
     * 
     * @param nombre 
     */
    public void eliminarDeInventario(String nombre){
        inventario.removeIf((Artefacto element) -> element.getNombre().equalsIgnoreCase(nombre));
    }
}