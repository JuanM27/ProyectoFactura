package ProyectoFactura.eclipse;

public class Cliente {
  private String nombre;
  private String apellido1;
  private String apellido2;
  private String DNI;
  private String emailCli;
  private String numTel;


  public Cliente(String nombre, String ape1, String ape2, String numTel, String em, String DNI) {
    this.nombre = nombre;
    this.apellido1 = ape1;
    this.apellido2 = ape2;
    this.numTel = numTel;
    this.emailCli = em;
    this.DNI = DNI;
    this.numTel = numTel;
  }

  public String getApellido1() {
    return apellido1;
  }


  public String getApellido2() {
    return apellido2;
  }


  public String getEmailCli() {
    return emailCli;
  }


  public String getNombre() {
    return nombre;
  }


  public String getDNI() {
    return DNI;
  }

  public String getNumTel() {
    return numTel;
  }

  public void setApellido1(String apellido1) {
    this.apellido1 = apellido1;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setEmailCli(String emailCli) {
    this.emailCli = emailCli;
  }

  public void setNumTel(String numTel) {
    this.numTel = numTel;
  }

  public void setDNI(String DNI) {
    this.DNI = DNI;
  }

  public void setApellido2(String apellido2) {
    this.apellido2 = apellido2;
  }

}

