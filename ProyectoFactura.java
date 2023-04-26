package ProyectoFactura.eclipse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class ProyectoFactura {

  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    Scanner scanner = new Scanner(System.in);
    int entrada;
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection conexion =
        DriverManager.getConnection("jdbc:mysql://localhost:3306/pedidos", "root", "");

    do {
      System.out.print("""
          1. Introducir un cliente
          2. Introducir un artículo
          3. Crear un pedido
          4. Mostrar clientes
          5. Salir del programa
          Escribe un número: """);
      entrada = scanner.nextInt();
      System.out.println();

      switch (entrada) {
        case 1:

          System.out.print("Introduce el nombre del cliente: ");
          String nombre = scanner.next();

          System.out.print("Introduce el primer apellido: ");
          String apellido1 = scanner.next();

          System.out.print("Introduce el segundo apellido: ");
          String apellido2 = scanner.next();

          scanner.nextLine();

          System.out.print("Introduce el número de teléfono: ");
          String tel = scanner.next();

          System.out.print("Introduce el email: ");
          String email = scanner.next();

          System.out.print("Introduce el DNI: ");
          String dni = scanner.next();



          Cliente cliente = new Cliente(nombre, apellido1, apellido2, dni, email, tel);


          Statement s = conexion.createStatement();
          String insertCliente = "INSERT INTO cliente VALUES ('0" + "', '" + cliente.getNombre()
              + "', '" + cliente.getApellido1() + "', '" + cliente.getApellido2() + "', '"
              + cliente.getEmailCli() + "', '" + cliente.getDNI() + "', " + cliente.getNumTel()
              + ")";


          s.execute(insertCliente);
          break;

        case 2:



          break;

        case 3:

          break;
        case 4:

          Statement p = conexion.createStatement();
          ResultSet listado = p.executeQuery("SELECT * FROM cliente");

          while (listado.next()) {
            System.out
                .println(String.format("%s10 %s10 %s10 %s10 %s10 %s10", listado.getString("CodCli"),
                    listado.getString("NomCli"), listado.getString("ApeCli"),
                    listado.getString("Ape2Cli"), listado.getString("TelCli"),
                    listado.getString("EmailCli"), listado.getString("DNICli")));
          }

          break;
        case 5:

          break;
        default:
          break;
      }
    } while (entrada != 5);
    conexion.close();
  }
}
