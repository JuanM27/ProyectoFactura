package ProyectoFactura.eclipse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Mostrar {
  public static Connection getConexion() throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection conexion =
        DriverManager.getConnection("jdbc:mysql://localhost:3306/pedidos", "root", "");

    return conexion;
  }

  public static void MostrarArticulos() throws ClassNotFoundException, SQLException {

    Connection conexionBD = Mostrar.getConexion();
    Statement s = conexionBD.createStatement();
    ResultSet listado = s.executeQuery("SELECT * FROM articulo");
    ResultSetMetaData metadata = listado.getMetaData();
    int numColumnas = metadata.getColumnCount();

    for (int i = 1; i <= numColumnas; i++) {
      System.out.print(metadata.getColumnName(i) + "\t");
    }

    System.out.println();

    while (listado.next()) {
      for (int i = 1; i <= numColumnas; i++) {
        System.out.print(listado.getString(i) + "\t");
      }
      System.out.println("");
    }

    System.out.println("");
    conexionBD.close();
  }

  public static void MostrarClientes() throws ClassNotFoundException, SQLException {

    Connection conexionBD = Mostrar.getConexion();
    Statement p = conexionBD.createStatement();
    ResultSet listado = p.executeQuery("SELECT * FROM cliente");
    ResultSetMetaData metadata = listado.getMetaData();
    int numColumnas = metadata.getColumnCount();


    while (listado.next()) {
      for (int i = 1; i <= numColumnas; i++) {
        System.out.print(listado.getString(i));
        System.out.print("   ");
      }
      System.out.println("");
    }
    System.out.println("");
    conexionBD.close();
  }

  public static void MostrarPedido() throws ClassNotFoundException, SQLException {

    Connection conexionBD = Mostrar.getConexion();
    Statement p = conexionBD.createStatement();
    ResultSet listado = p.executeQuery("SELECT * FROM pedido");
    ResultSetMetaData metadata = listado.getMetaData();
    int numColumnas = metadata.getColumnCount();

    while (listado.next()) {
      for (int i = 1; i <= numColumnas; i++) {
        System.out.print(listado.getString(i));
        System.out.print("   ");
      }
      System.out.println("");
    }

    System.out.println("");
    conexionBD.close();
  }

  public static void MostrarFactura() throws ClassNotFoundException, SQLException {

    Connection conexionBD = Mostrar.getConexion();
    Statement p = conexionBD.createStatement();
    ResultSet listado = p.executeQuery("SELECT * FROM factura");
    ResultSetMetaData metadata = listado.getMetaData();
    int numColumnas = metadata.getColumnCount();

    while (listado.next()) {
      for (int i = 1; i <= numColumnas; i++) {
        System.out.print(listado.getString(i));
        System.out.print("   ");
      }
      System.out.println("");
    }

    System.out.println("");
    conexionBD.close();
  }
}

