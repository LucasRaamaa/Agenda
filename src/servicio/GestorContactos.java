package servicio;
import model.Contacto;
import java.util.ArrayList;

public class GestorContactos {

  private ArrayList<Contacto> contactos = new ArrayList<>();
  private int nextId = 1;

  public void agregarContacto(String nombre, String telefono, String email){
    contactos.add(new Contacto(nextId++ , nombre, telefono,email));
  }
  public void listarContactos(){
    if(contactos.isEmpty()){
      System.out.println("No hay contactos cargados.");
    }else {
      for (Contacto c : contactos){
        System.out.println(c);
      }
    }
  }

  public Contacto buscarNombre(String nombre){
    for(Contacto c : contactos){
      if (c.getNombre().equalsIgnoreCase(nombre)){
        return c;
      }
    }
    return null;
  }

  public boolean eliminarContacto(int id){
    return contactos.removeIf(c -> c.getId() == id);
  }

  public boolean modificarContacto(int id, String nuevoTel, String nuevoEmail){
    for (Contacto c : contactos) {
      if(c.getId() == id){
        c.setTelefono(nuevoTel);
        c.setEmail(nuevoEmail);
        return true;
      }
    }
    return false;
  }

}
