package utils;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UtilInputs {
  private static Scanner sc = new Scanner(System.in);

  //Evitamos no sea vacio
  public static String leerTexto(String mensaje){
    String input;
    do{
      System.out.print(mensaje);
      input = sc.nextLine().trim();
      if(input.isEmpty()){
        System.out.println("No puede estar vacio. Intenta de nuevo");
      }
    }while(input.isEmpty());
    return input;
  }

  //Lee numeros validos
  public static int leerEntero(String mensaje){
    while(true){
      System.out.print(mensaje);
      String input = sc.nextLine();
      try{
        return Integer.parseInt(input);
      }catch (NumberFormatException e){
        System.out.println("Debe ingresar un numero valido");
      }
    }
  }

  // validamos el email
  public static String leerEmail(String mensaje){
    String email;
    String patron = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    do{
      System.out.print(mensaje);
      email = sc.nextLine().trim();
      if(!Pattern.matches(patron, email)){
        System.out.println("Email invalido, Ejemplo valido: usuario@dominio.com");
      }
    }while(!Pattern.matches(patron, email));
    return email;
  }

  //Validacion telefonica solo digitos, opcional (+)
  public static String leerTelefono(String mensaje){
    String telefono;
    String patron = "^[+]?[0-9]{6,15}$";
    do {
      System.out.print(mensaje);
      telefono = sc.nextLine().trim();
      if(!Pattern.matches(patron, telefono)){
        System.out.println("Telefono invalido. solo numeros.");
      }
    }while(!Pattern.matches(patron,telefono));
    return telefono;
  }
}
