/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assasinsCreedCollectionProject;

/**
 *
 * @author Soliloquy
 */
public class Main {
    public static void main(String[] args){
        
        Gremio gremio = new Gremio();
        
        gremio.insertarAsesino(new Asesino(32 , "mentor" , "Hoja oculta doble" , "Ezio Auditore"));
        gremio.insertarAsesino(new Asesino(25 , "maestro" , "Espada de los Asesinos" , "Altaïr Ibn-La'Ahad"));
        gremio.insertarAsesino(new Asesino(27 , "iniciado" , "Hoja de zapato" , "Shao Jun"));
        gremio.mostrarAsesinos();
        System.out.println();
        
        System.out.println("Se vuelve a agregar al asesino Shao Jun");
        gremio.insertarAsesino(new Asesino(27 , "iniciado" , "Hoja de zapato" , "Shao Jun"));
        gremio.mostrarAsesinos();
        
        gremio.eliminarAsesino("Shao Jun");
        gremio.mostrarAsesinos();
        
        Temple temple = new Temple();
        temple.insertarTemplario(new Templario("Orden del Temple" , 9 , "Rodrigo Borgia"));
        temple.insertarTemplario(new Templario("Abstergo" , 8 , "Haytham Kenway"));
        temple.insertarTemplario(new Templario("Orden del Temple" , 10 , "Cesar Borgia"));
        temple.mostrarTemplarios(false);
        
        gremio.agregarAInventario(new Artefacto("Fruto del Eden" , "Precursores" , "Otorga control mental"));
        gremio.agregarAInventario(new Artefacto("Baston de Hermes" , "Precursores" , "Concede inmortalidad"));
        gremio.agregarAInventario(new Artefacto("Espada del Eden" , "Precursores" , "Habilidades sobrenaturales"));
        gremio.agregarAInventario(new Artefacto("Caliz del Eden" , "Precursores" , "Sana heridas y confiere longevidad"));
        gremio.mostrarInventario();
        
        gremio.agregarAInventario(new Artefacto("Espada del Eden" , "Eden" , "Habilidades sobrenaturales"));
        gremio.mostrarInventario();
        
        gremio.eliminarDeInventario("Espada del Eden");
    }
}
