package ProyectoFactura.eclipse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
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
          4. Mostrar tablas
          5. Facturar
          6. Salir del programa
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

<<<<<<< HEAD
          }
=======
          System.out.print("Introduce el primer apellido: ");
          String apellido1 = scanner.next();

          System.out.print("Introduce el segundo apellido: ");
          String apellido2 = scanner.next();
>>>>>>> cf079df9356cdfaa5a39565c8fefe35153897281

          System.out.print("Introduce el segundo apellido (presione ENTER para omitir): ");
          String apellido2 = scanner.nextLine();

<<<<<<< HEAD
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
          
=======
          System.out.print("Introduce el número de teléfono: ");
          String tel = scanner.next();

          System.out.print("Introduce el email: ");
          String email = scanner.next();

          System.out.print("Introduce el DNI: ");
          String dni = scanner.next();

>>>>>>> cf079df9356cdfaa5a39565c8fefe35153897281


          Cliente cliente = new Cliente(nombre, apellido1, apellido2, tel, email, dni);


          Statement s = conexion.createStatement();
          String insertCliente =
              "INSERT INTO cliente (NomCli,ApeCli,Ape2Cli,TelCli,EmailCli,DNICli) VALUES ('"
                  + cliente.getNombre() + "', '" + cliente.getApellido1() + "', '"
                  + cliente.getApellido2() + "', '" + cliente.getNumTel() + "', '"
                  + cliente.getEmailCli() + "', '" + cliente.getDNI() + "')";


          s.execute(insertCliente);
          break;

        case 2:

          System.out.print("Introduce el nombre del artículo: ");
          String nombreArt = scanner.next();

          System.out.print("Introduce la categoría: ");
          String categoriaArt = scanner.next();

          System.out.print("Introduce el precio del artículo separado con coma: ");
          double precioArt = scanner.nextDouble();

          System.out.print("Introduce el stock del artículo: ");
          int stockArt = scanner.nextInt();

          Articulo articulo = new Articulo(nombreArt, categoriaArt, stockArt, precioArt);

          Statement insertArt = conexion.createStatement();
          String insertArticulo = "INSERT INTO articulo VALUES ('0" + "', '" + articulo.getNombre()
              + "', '" + articulo.getCategoria() + "', '" + articulo.getPrecio() + "', "
              + articulo.getStock() + ")";

          insertArt.execute(insertArticulo);
          break;

        case 3:

          HashMap<Integer, Integer> articulos = new HashMap<Integer, Integer>();

          Mostrar.MostrarClientes();

          System.out.print("Introduzca tu codigo de cliente: ");
          int codcli = scanner.nextInt();
          int opcion = 0;

          do {

            System.out.print("""
                1. Insertar articulo
                2. Confirmar pedido
                3. Cancelar
                Escribe un número: """);

            opcion = scanner.nextInt();
            System.out.println();

            switch (opcion) {
              case 1:
                // Mostrar todos los articulos//
                Mostrar.MostrarArticulos();

                System.out.print("Inserte el codigo del articulo deseado: ");
                int codart = scanner.nextInt();

                System.out.print("Inserte la cantidad deseada de su articulo: ");
                int canart = scanner.nextInt();

                if (articulos.containsKey(codart)) {
                  articulos.put(codart, canart);
                  System.out.println(
                      "El producto seleccionado ya existia en su pedido, cantidad actualizada. ");
                } else {
                  articulos.put(codart, canart);
                  System.out.println("Producto añadido correctamente. ");
                }

                break;

              case 2:

                int CodPeMax = 0;
                Statement j = conexion.createStatement();
                String insertPedido = "INSERT INTO pedido (CodCli) VALUES ( " + codcli + ")";
                j.execute(insertPedido); // Insertamos el pedido actual en la tabla pedidos//

                String codPe = "SELECT MAX(CodPe) FROM pedido"; // Verificar que esto
                                                                // funcione//

                ResultSet querySet = j.executeQuery(codPe);
                // //Select que devuelve el id del
                // ultimo pedido//

                if (querySet.next()) { // Verificar que esto funcione// //Intentamos guardar

                  CodPeMax = querySet.getInt("MAX(CodPe)");
                }
                // el valor de la consulta anteior como int//
                for (Map.Entry<Integer, Integer> set : articulos.entrySet()) {
                  String insertartped = "INSERT INTO art_ped (CodPe, CodArt, CantArt) VALUES ( "
                      + CodPeMax + ", " + set.getKey() + ", " + set.getValue() + " )"; // Recorremos
                  // el HashMap y
                  // creamos un
                  // insert con
                  // el codart y
                  // la cant del
                  // mismo por
                  // cada uno //
                  j.execute(insertartped); // Ejecutamos el isnert anterior de la tabla art_ped
                }
                opcion = 3;
                System.out.println("Se ha creado su pedido correctamente.");
                break;
            }
          } while (opcion != 3);
          break;
        case 4:

          System.out.print(
              "Introduce el nombre de la tabla que quieras listar (Articulo, Cliente, Pedido, Factura): ");
          String eleccion = scanner.next().toLowerCase();

<<<<<<< HEAD
          while (listado.nextLine()) {
            System.out.println(listado.getString("id") + (" ") + listado.getString("nombre"));
=======
          if (eleccion.equals("articulo")) {
            Mostrar.MostrarArticulos();
          } else if (eleccion.equals("cliente")) {
            Mostrar.MostrarClientes();
          } else if (eleccion.equals("pedido")) {
            Mostrar.MostrarPedido();
          } else if (eleccion.equals("factura")) {
            Mostrar.MostrarFactura();
>>>>>>> cf079df9356cdfaa5a39565c8fefe35153897281
          }

          break;
        case 5:
          /* MIRAR MAÑANA */
          /* Muestro los pedidos */
          Mostrar.MostrarPedido();
          System.out.println("Introduce el código del pedido que quieras facturar: ");
          String CodPedScanner = scanner.next();
          Statement h = conexion.createStatement();
          /* Verifico si el pedido ya está facturado */
          String verificarFacturado =
              "SELECT IF(EXISTS(SELECT * FROM factura WhERE CodPed='" + CodPedScanner + "'),1,0)";
          /* Consulta para ver que la tabla este vacia */
          String verificarTablaLLena = "SELECT * FROM factura";

          /* Para sacar el año */
          Calendar ca = Calendar.getInstance();

          String anio = Integer.toString(ca.get(Calendar.YEAR));

          /* Si ya está facturado imprime el mensaje */
          if (!h.execute(verificarFacturado)) {
            System.out.println("Lo siento el pedido que inenta facturar ya está facturado");
          } else {
            /* Si la tabala está vacia mete una factura con numero 2023001 */
            if (!h.execute(verificarTablaLLena)) {
              String insertFactura =
                  "INSERT INTO factura (CodPed,NumFac) VALUES ('" + CodPedScanner + "',2023001)";
              h.execute(insertFactura);
            } else {
              /*
               * Coge la factura con numero mas alto, nos quedamos con las 3 ultimas letras las
               * parseamos a entero y le sumamos uno, luego la parseamos a String y la concatenamos
               * y hacemos el insert
               */
              String sacarMaxFac = "SELECT MAX(NumFac) FROM factura";
              ResultSet numeroFacMax = h.executeQuery(sacarMaxFac);
              String numMaxFac = "";
              if (numeroFacMax.next()) {
                numMaxFac = numeroFacMax.getString("MAX(NumFac)");
              }
              int ult = Integer.parseInt(numMaxFac.substring(5, 7)) + 1;
              String numFacNuevo = anio + Integer.toString(ult);

              String insertFactura = "INSERT INTO factura (CodPed,NumFac) VALUES ('" + CodPedScanner
                  + "','" + numFacNuevo + "')";
              h.execute(insertFactura);
            }
          }

          break;

        default:
          break;
      }
    } while (entrada != 6);
    conexion.close();
  }
}
