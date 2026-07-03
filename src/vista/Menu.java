package vista;

import servicio.GestorContactos;
import model.Contacto;
import java.util.ArrayList;
import utils.UtilInputs;

public class Menu {
  private GestorContactos gestor = new GestorContactos();

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
      
      opcion = UtilInputs.leerEntero("Ingrese una opcion: ");

      switch (opcion){
        case 1 -> agregar();
        case 2 -> listar();
        case 3 -> buscar();
        case 4 -> modificar();
        case 5 -> eliminar();
        case 0 -> System.out.println("Saliendo del sistema...");
        default -> System.out.println("Opcion Invalida");
      }
    }while (opcion != 0);
  }

  private void agregar(){
    String nombre = UtilInputs.leerTexto("Nombre: ");
    String tel = UtilInputs.leerTelefono("Telefono: ");
    String email = UtilInputs.leerEmail("Email: ");
    gestor.agregarContacto(nombre, tel, email);
    System.out.println("Contacto agregado correctamente.");
  }

  private void listar() {
    ArrayList<Contacto> contactos = gestor.obtenerContactos();
    if (contactos.isEmpty()) {
      System.out.println("No hay contactos cargados.");
    } else {
      System.out.println("\n--- Lista de Contactos ---");
      for (Contacto c : contactos) {
        System.out.println(c);
      }
    }
  }

  private void buscar(){
    String nombre = UtilInputs.leerTexto("Ingrese el nombre a buscar: ");
    Contacto c = gestor.buscarNombre(nombre);
    System.out.println(c != null ? c : "No encontrado.");
  }

  private void modificar(){
    int id = UtilInputs.leerEntero("Ingrese ID del contacto a modificar: ");
    Contacto c = null;
    for (Contacto contacto : gestor.obtenerContactos()) {
      if (contacto.getId() == id) {
        c = contacto;
        break;
      }
    }

    if (c == null) {
      System.out.println("No se encontro ID del contacto.");
      return;
    }

    System.out.println("\nPresione Enter para mantener el valor actual.");
    String tel = UtilInputs.leerTelefono("Nuevo telefono (" + c.getTelefono() + "): ", true);
    String email = UtilInputs.leerEmail("Nuevo email (" + c.getEmail() + "): ", true);

    String finalTel = tel.isEmpty() ? c.getTelefono() : tel;
    String finalEmail = email.isEmpty() ? c.getEmail() : email;

    if (gestor.modificarContacto(id, finalTel, finalEmail)) {
      System.out.println("Contacto modificado correctamente.");
    } else {
      System.out.println("Error al modificar el contacto.");
    }
  }

  private void eliminar(){
    int id = UtilInputs.leerEntero("Ingrese ID del contacto a eliminar: ");
    Contacto c = null;
    for (Contacto contacto : gestor.obtenerContactos()) {
      if (contacto.getId() == id) {
        c = contacto;
        break;
      }
    }

    if (c == null) {
      System.out.println("No se encontro ID para eliminar.");
      return;
    }

    System.out.println("\nSe eliminara el siguiente contacto:");
    System.out.println(c);
    String confirmacion = UtilInputs.leerTexto("¿Esta seguro de eliminar este contacto? (S/N): ");
    if (confirmacion.equalsIgnoreCase("S")) {
      if (gestor.eliminarContacto(id)) {
        System.out.println("Contacto eliminado con exito.");
      } else {
        System.out.println("Error al eliminar el contacto.");
      }
    } else {
      System.out.println("Eliminacion cancelada.");
    }
  }
}
