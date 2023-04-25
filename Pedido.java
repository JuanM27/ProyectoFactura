package ProyectoFactura.eclipse;

public class Pedido {
  private int idPed;
  private boolean facturado;
  private String datePed;
  private double total;

  public Pedido(int idPed, boolean facturado, String datePed, double total) {
    this.idPed = idPed;
    this.facturado = facturado;
    this.datePed = datePed;
    this.total = total;
  }

  @Override
  public String toString() {
    return "pedido [idPed=" + idPed + ", facturado=" + facturado + ", datePed=" + datePed
        + ", total=" + total + "]";
  }

  // Getters//

  public int getIdPed() {
    return idPed;
  }

  public boolean isFacturado() {
    return facturado;
  }

  public String getDatePed() {
    return datePed;
  }

  public double getTotal() {
    return total;
  }

  // Setters

  public void setIdPed(int idPed) {
    this.idPed = idPed;
  }

  public void setFacturado(boolean facturado) {
    this.facturado = facturado;
  }

  public void setDatePed(String datePed) {
    this.datePed = datePed;
  }

  public void setTotal(double total) {
    this.total = total;
  }
}
