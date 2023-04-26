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
          6. Salir del programa
          7. Mostrar clientes
          Escribe un número: """);
      entrada = scanner.nextInt();
      System.out.println();

      switch (entrada) {
        case 1:

          System.out.print("Introduce el nombre del cliente: ");
          String nombre = scanner.next();

          System.out.print("Introduce los apellidos: ");
          String apellidos = scanner.next();

          scanner.nextLine();

          System.out.print("Introduce el DNI: ");
          String dni = scanner.next();

          System.out.print("Introduce el número de teléfono: ");
          int tel = scanner.nextInt();

          Cliente cliente = new Cliente(nombre, apellidos, dni, tel);


          Statement s = conexion.createStatement();
          String insertCliente = "INSERT INTO cliente VALUES ('0" + "', '" + cliente.getNombre()
              + "', '" + cliente.getApellidos() + "', '" + cliente.getDNI() + "', "
              + cliente.getNumTel() + ")";


          s.execute(insertCliente);
          break;

        case 2:
        System.out.println("Introduce el nombre del artículo: ");
        String nombreArt = scanner.next();

        System.out.println("Introduce la categoría: ");
        String categoriaArt = scanner.next(); 

        System.out.println("Introduce el precio del artículo: ");
        double precioArt = scanner.nextDouble();

        System.out.println("Introduce el stock del artículo: ");
        String stockArt = scanner.next();

        Articulo articulo = new Articulo(nombreArt, categoriaArt, stockArt, precioArt);
        
        Statement insertArt = conexion.createStatement();
        String insertArticulo = "INSERT INTO articulo VALUES ('0" + "', '" + articulo.getNombre()
        + "', '" + articulo.getCategoria() + "', '" + articulo.getPrecio() + "', "
        + articulo.getStock() + ")";

          break;

        case 3:
          

          break;
        case 4:


          break;
        case 5:
          Statement p = conexion.createStatement();
          ResultSet listado = p.executeQuery("SELECT * FROM cliente");

          while (listado.next()) {
            System.out.println(listado.getString("id") + (" ") + listado.getString("nombre"));
          }
          break;
        default:
          break;
      }
    } while (entrada != 6);
    conexion.close();
  }
}
