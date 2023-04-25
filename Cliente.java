package ProyectoFactura.eclipse;

public class Cliente {
  private String nombre;
  private String apellidos;
  private String DNI;
  private int numTel;


  public Cliente(String nombre, String apellidos, String DNI, int numTel) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.DNI = DNI;
    this.numTel = numTel;
  }


  @Override
  public String toString() {
    return "cliente [nombre=" + nombre + ", apellidos=" + apellidos + ", DNI=" + DNI + ", numTel="
        + numTel + "]";
  }


  // getters//

  public String getNombre() {
    return nombre;
  }

  public String getApellidos() {
    return apellidos;
  }

  public String getDNI() {
    return DNI;
  }

  public int getNumTel() {
    return numTel;
  }

  // setters//

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public void setDNI(String DNI) {
    this.DNI = DNI;
  }
}

