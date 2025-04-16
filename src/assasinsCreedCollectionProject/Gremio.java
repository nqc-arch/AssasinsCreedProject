/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assasinsCreedCollectionProject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    private List<Artefacto> backupInventario;

    /**
     * Constructor que inicializa la lista
     */
    public Gremio() {
        conjuntoAsesinos = new LinkedHashSet<Asesino>();
        inventario = new ArrayList<Artefacto>();
        backupInventario = new ArrayList<Artefacto>();
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
     * Agrega un nuevo tipo de artefacto al Inventario si este no está contenido
     * aún.
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
    public void mostrarInventario() {
        System.out.println("CONTENIDO DEL INVENTARIO:");
        inventario.forEach((Artefacto element) -> System.out.println(element.toString()));
    }

    /**
     * Elimina el primer artefacto que se encuentre en la lista que coincida con
     * el nombre introducido por parámetro
     *
     * @param nombre
     */
    public void eliminarDeInventario(String nombre) {
        inventario.removeIf((Artefacto element) -> element.getNombre().equalsIgnoreCase(nombre));
    }

    /**
     * Guarda una lista con los datos de los asesinos en el fichero indicado
     * como parametro. Si se pone solo el nombre de un fichero, se creará dentro
     * de la carpeta del proyecto.
     *
     * @param archivo
     * @throws IOException
     */
    public void guardarAsesinosEnArchivo(String archivo) throws IOException {
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            fos = new FileOutputStream(archivo, false);
            dos = new DataOutputStream(fos);
            for (Asesino asesino : conjuntoAsesinos) {
//                dos.writeInt(asesino.getEdad());
//                dos.writeUTF(asesino.getRango().name());
//                dos.writeUTF(asesino.getArma_favorita());
//                dos.writeUTF(asesino.getNombre());
//                dos.writeUTF("\n");
                dos.writeUTF(asesino.toString());
                dos.writeUTF("\n");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (fos != null) {
                fos.close();
            }
            if (dos != null) {
                fos.close();
            }
        }
    }

    /**
     * Lee los datos del archivo especificado y los muestra en la pantalla
     *
     * @param archivo
     * @throws IOException
     */
    public void cargarAsesinosDesdeArchivos(String archivo) throws IOException {
        System.out.println("LECTURA DESDE EL ARCHIVO " + archivo);
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream(archivo));
            while (true) {
                String datosAsesino = dis.readUTF();
                System.out.print(datosAsesino);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (dis != null) {
                dis.close();
            }
        }
    }

    /**
     * Guarda el inventario en el archivo indicado como parámetro
     *
     * @param nombreArchivo
     * @throws IOException
     */
    public void guardarInventarioEnArchivo(String nombreArchivo) throws IOException {

        ObjectOutputStream fos = null;
        try {

            fos = new ObjectOutputStream(new FileOutputStream(nombreArchivo, false));
            for (Artefacto artefacto : inventario) {
                fos.writeObject(artefacto);
            }
            System.out.println("INVENTARIO GUARDADO CON EXITO");
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }
    
    /**
     * ELIMINA TODOS LOS ELEMENTOS DEL INVENTARIO
     */
    public void limpiarInventario(){
        inventario.clear();
        System.out.println("INVENTARIO LIMPIADO CON EXITO.");
    }
    
    /**
     * Carga los datos del inventario desde el archivo especificado como parametro
     * 
     * @param archivo
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public void cargarInventarioDesdeArchivo(String archivo) throws IOException, ClassNotFoundException {
        System.out.println("CARGA DE DATOS DE INVENTARIO DESDE ARCHIVO " + archivo);
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(archivo));
            while(true){
                inventario.add((Artefacto) ois.readObject());
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (ois != null) {
                ois.close();
            }
        }
    }
}
