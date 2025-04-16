/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assasinsCreedCollectionProject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.TreeSet;

/**
 *
 * @author dam117
 */
public class Temple {
    
    private TreeSet<Templario> conjuntoTemplarios;
    
    /**
     * Constructor
     */
    public Temple() {
        conjuntoTemplarios = new TreeSet<Templario>();
    }
    
    
    /**
     * Inserta un objeto Templario en el TreeSet conjuntoTemplarios siempre que no
     * tengan el mismo nombre.
     * 
     * @param t 
     */
    public void insertarTemplario(Templario t){
        if (!conjuntoTemplarios.add(t)){
            System.out.println("ERROR: EL TEMPLARIO YA SE ENCUENTRA REGISTRADO.");
        } else {
            System.out.println("TEMPLARIO REGISTRADO CON EXITO.");
        }
    }
    
    /**
     * Elimina un elemento Templario si el nombre pasado por parámetro coincide con el nombre
     * de un elemento Templario contenido.
     * 
     * @param nombre
     * @return true, si se encuentra y se elimina un elemento templario.
     *          false, si no se encuentra un elemento Templario o si la lista está vacía.
     */
    public boolean eliminarTemplario(String nombre){
        if (conjuntoTemplarios.isEmpty()) {
            System.out.println("ERROR: NO HAY NINGUN MIEMBRO REGISTRADO EN EL TEMPLE.");
            return false;
        }
        boolean resultado = conjuntoTemplarios.removeIf(element -> element.getNombre().equalsIgnoreCase(nombre));
        if (resultado) {
            System.out.println("TEMPLARIO ELIMADO DEL REGOSTRO CON EXITO.");
        } else {
            System.out.println("ERROR: EL TEMPLARIO NO SE ENCUENTRA REGISTRADO EN EL TEMPLE.");
        }
        return resultado;
    }
    
    /**
     * Muestra los Templarios registrados ordenados de acuerdo a su nivel de peligrosidad.
     */
    public void mostrarTemplarios(){
        System.out.println("LISTADO DE TEMPLARIOS:");
        conjuntoTemplarios.forEach((Templario element) -> System.out.println(element.toString()));
    }
    /**
     * Muestra los Templarios registrados ordenados de acuerdo a su nivel de peligrosidad y al 
     * paramentro indicado. Si se indica true, se mostrarán en orden ascedente, si se indica false,
     * se mostrarán en orden descendente.
     * 
     * @param ascendente 
     */
    public void mostrarTemplarios(boolean ascendente){
        if(ascendente){
            System.out.println("LISTADO DE TEMPLARIOS:");
            this.mostrarTemplarios();
        } else {
            System.out.println("LISTADO DE TEMPLARIOS ORDENADOS POR ORDEN DESCENDENTE DE PELIGROSIDAD:");
            conjuntoTemplarios.reversed();
        }
    }
    
    /**
     * Guarda los objetos Templarios en el archivo especificado por parametro
     * 
     * @param archivo
     * @throws IOException 
     */
    public void guardarTemplariosEnArchivo(String archivo) throws IOException{
         ObjectOutputStream fos = null;
        try {

            fos = new ObjectOutputStream(new FileOutputStream(archivo, false));
            for (Templario templario : conjuntoTemplarios) {
                fos.writeObject(templario);
            }
            System.out.println("TEMPLARIOS GUARDADOS CON EXITO.");
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }
    
    /**
     * Carga los datos de los templarios desde el archivo de texto especificado como parametro
     * @param archivo
     * @throws ClassNotFoundException
     * @throws IOException 
     */
    public void cargarTemplariosDesdeArchivo(String archivo) throws ClassNotFoundException, IOException{
        System.out.println("CARGA DE TEMPLARIOS DESDE ARCHIVO " + archivo);
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(archivo));
            while(true){
                conjuntoTemplarios.add((Templario) ois.readObject());
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (ois != null) {
                ois.close();
            }
        }
    }
    
    /**
     * Elimina todos los datos de los Templarios guardados
     */
    public void limpiarTemplarios(){
        conjuntoTemplarios.clear();
        System.out.println("TEMPLARIOS ELIMINADOS CON EXITO");
    }
    
    public void exportarDatos(String archivo){
        
    }
}
