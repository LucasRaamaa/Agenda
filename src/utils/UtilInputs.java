package utils;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UtilInputs {
  private static Scanner sc = new Scanner(System.in);

  
  public static String leerTexto(String mensaje){
    return leerTexto(mensaje, false);
  }

  public static String leerTexto(String mensaje, boolean permitirVacio){
    String input;
    do{
      System.out.print(mensaje);
      input = sc.nextLine().trim();
      if(input.isEmpty() && !permitirVacio){
        System.out.println("No puede estar vacio. Intenta de nuevo");
      }
    }while(input.isEmpty() && !permitirVacio);
    return input;
  }

  
  public static int leerEntero(String mensaje){
    while(true){
      System.out.print(mensaje);
      String input = sc.nextLine().trim();
      try{
        return Integer.parseInt(input);
      }catch (NumberFormatException e){
        System.out.println("Debe ingresar un numero valido");
      }
    }
  }

  
  public static String leerEmail(String mensaje){
    return leerEmail(mensaje, false);
  }

  public static String leerEmail(String mensaje, boolean permitirVacio){
    String email;
    String patron = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    do{
      System.out.print(mensaje);
      email = sc.nextLine().trim();
      if(permitirVacio && email.isEmpty()){
        return "";
      }
      if(!Pattern.matches(patron, email)){
        System.out.println("Email invalido. Ejemplo valido: usuario@dominio.com");
      }
    }while(!Pattern.matches(patron, email));
    return email;
  }

  
  public static String leerTelefono(String mensaje){
    return leerTelefono(mensaje, false);
  }

  public static String leerTelefono(String mensaje, boolean permitirVacio){
    String telefono;
    String patron = "^[+]?[0-9]{6,15}$";
    do {
      System.out.print(mensaje);
      telefono = sc.nextLine().trim();
      if(permitirVacio && telefono.isEmpty()){
        return "";
      }
      if(!Pattern.matches(patron, telefono)){
        System.out.println("Telefono invalido. Solo numeros.");
      }
    }while(!Pattern.matches(patron,telefono));
    return telefono;
  }
}
