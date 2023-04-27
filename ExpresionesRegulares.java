package com.proyectofactura.ProyectoFactura;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ExpresionesRegulares {

  public static String validaTelefono(Scanner scanner){
    String tel="";
    boolean telValido = false;
          while (!telValido) {
            System.out.print("Introduce el número de teléfono: ");
            tel = scanner.nextLine();
            tel = scanner.nextLine();
            if (tel.matches("^[0-9]{9}$")) {
              telValido = true;
            } else {
              System.out.println("El formato del número no es correcto. Intentalo de nuevo");
            }
          }
    return tel;
  }

  public static String validaEmail(Scanner scanner){
    String email="";
    boolean emailValido = false;
          while(!emailValido){
            System.out.print("Introduce el email: ");
            email = scanner.nextLine();
            if (email.matches("^[^@]+@[^@]+.[a-zA-Z]+$")){
              emailValido = true;
            } else {
              System.out.println("El email no tiene el formato correcto. Intentalo de nuevo");
            }
          }    
    return email;
  }

  public static String validaDNI(Scanner scanner) throws ClassNotFoundException, SQLException{
    String dni="";
    Connection conexionBD = Mostrar.getConexion();
    boolean dniValido = false;    
    while (!dniValido) {
      System.out.print("Introduce el DNI: ");
      dni = scanner.next().toUpperCase();
      String consulta = "SELECT IF( EXISTS( SELECT * FROM cliente WHERE DNICli='"+dni+"'), 1, 0) AS DNI_Exist";
      Statement s = conexionBD.createStatement();
      ResultSet resultadoConsulta = s.executeQuery(consulta);
      if (dni.matches("^[0-9]{8}[A-Z]$")) {
        dniValido = true;
      } if (resultadoConsulta.next()) {
        int dniExistente = resultadoConsulta.getInt("DNI_Exist");
        if (dniExistente == 1) {
          System.out.println("Este dni ya está en uso, prueba con otro.");
          dniValido=false;
        }
      } else {
        System.out.println("El DNI introducido no es válido.Debe tener 8 dígitos seguidos de una letra.");
      }
    }    
    return dni;
  }
}
