package vista;

import servicio.GestorContactos;
import model.Contacto;
import java.util.Scanner;
import utils.UtilInputs;


public class Menu {
  private GestorContactos gestor = new GestorContactos();
  private Scanner sc = new Scanner(System.in);

  public void iniciar() {
    int opcion;
    do {
      System.out.println("\n--- Agenda de Contactos ---\n ");
      System.out.println("1. Agregar contacto");
      System.out.println("2. Listar Contactos");
      System.out.println("3. Buscar contacto por nombre");
      System.out.println("4. Modificar contacto");
      System.out.println("5. Eliminar contacto");
      System.out.println("0. Salir del sistema");
      System.out.println("Ingrese una opcion: ");
      opcion = sc.nextInt();
      sc.nextLine(); //limpiamos buffer de memoria

      switch (opcion){
        case 1 -> agregar();
        case 2 -> gestor.listarContactos();
        case 3 -> buscar();
        case 4 -> modificar();
        case 5 -> eliminar();
        case 0 -> System.out.println("Saliendo del sistema...");
        default -> System.out.println("Opcion Invalida");
      }
    }while (opcion !=0);
  }

  // Luego validar que telefono sea numerico, email contenga @ y . y en nombre no sean numeros
  private void agregar(){
    String nombre = UtilInputs.leerTexto("Nombre: ");
    String tel = UtilInputs.leerTelefono("Telefono: ");
    String email = UtilInputs.leerEmail("Email: ");
    gestor.agregarContacto(nombre, tel, email);
    System.out.println("Contacto agregado correctamente.");
  }

  private void buscar(){
    System.out.print("Ingrese el nombre a buscar: ");
    String nombre = sc.nextLine();
    Contacto c = gestor.buscarNombre(nombre);
    System.out.println(c != null ? c: "No encontrado.");
  }

  private void modificar(){
    int id = UtilInputs.leerEntero("Ingrese ID del contaco: ");
    sc.nextLine();
    System.out.print("Nuevo telefono: ");
    String tel = sc.nextLine();
    System.out.println("Nuevo email: ");
    String email = sc.nextLine();

    if (gestor.modificarContacto(id, tel, email)){
      System.out.println("Contacto modificado.");
    }else {
      System.out.println("No se encontro Id del contacto.");
    }
  }

  private void eliminar(){
    System.out.print("Ingrese ID del contacto a eliminar: ");
    int id = sc.nextInt();
    if(gestor.eliminarContacto(id)) {
      System.out.println("Contacto eliminado con exito: ");
    }else {
      System.out.println("No se encontro ID para eliminar.");
    }
  }
}
