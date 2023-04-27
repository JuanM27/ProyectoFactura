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
        DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofacturadb", "root", "");

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
          String nombre = scanner.nextLine();
          while(nombre.length==0){
            System.out.println("Debe ingresar su apellido: ");
            nombre=scanner.nextLine();
          }
          
          System.out.print("Introduce el primer apellido: ");
          String apellido = scanner.nextLine();
          while(apellido.length==0){
            System.out.println("Debe ingresar su apellido: ");
            apellido=scanner.nextLine();

          }

          System.out.print("Introduce el segundo apellido (presione ENTER para omitir): ");
          String apellido2 = scanner.nextLine();

          System.out.print("Introduce el DNI/NIE: ");
          String dni = scanner.nextLine();
          while(dni.length()!=9){
            System.out.println("El DNI/NIE de telefono deben ser 9 dígitos, vuelva a         ingresarlo: ");
            dni = scanner.nextLine();
          }

          System.out.print("Introduce el número de teléfono: ");
          String tel = scanner.nextInt();
            while(s.matches(".*[a-z].*")||tel.length()!=9){
              System.out.println("El numero de telefono deben ser 9 numeros, vuelva a         ingresarlo: ");
              tel = scanner.nextInt();
            }
          

          Cliente cliente = new Cliente(nombre, apellidos, dni, tel);


          Statement s = conexion.createStatement();
          String insertCliente = "INSERT INTO cliente VALUES ('0" + "', '" + cliente.getNombre()
              + "', '" + cliente.getApellidos() + "', '" + cliente.getDNI() + "', "
              + cliente.getNumTel() + ")";


          s.execute(insertCliente);
          break;

        case 2:



          break;

        case 3:

          break;
        case 4:

          Statement p = conexion.createStatement();
          ResultSet listado = p.executeQuery("SELECT * FROM cliente");

          while (listado.nextLine()) {
            System.out.println(listado.getString("id") + (" ") + listado.getString("nombre"));
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
