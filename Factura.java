package ProyectoFactura.eclipse;

public class Factura {
  private int idFac;
  private String dateFac;
  private double total;

  public Factura(int idFac, String dateFac, double total) {
    this.idFac = idFac;
    this.dateFac = dateFac;
    this.total = total;
  }

  @Override
  public String toString() {
    return "factura [idFac=" + idFac + ", dateFac=" + dateFac + ", total=" + total + "]";
  }

  // Getters

  public int getIdFac() {
    return idFac;
  }

  public String getDateFac() {
    return dateFac;
  }

  public double getTotal() {
    return total;
  }

  // Setters

  public void setIdFac(int idFac) {
    this.idFac = idFac;
  }

  public void setDateFac(String dateFac) {
    this.dateFac = dateFac;
  }

  public void setTotal(double total) {
    this.total = total;
  }
}
