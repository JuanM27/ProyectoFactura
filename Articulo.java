package ProyectoFactura.eclipse;

public class Articulo {
  private int idArt;
  private String nombre;
  private String categoria;
  private int stock;
  private double precio;


  public Articulo(int idArt, String nombre, String categoria, int stock, double precio) {
    this.idArt = idArt;
    this.nombre = nombre;
    this.categoria = categoria;
    this.stock = stock;
    this.precio = precio;
  }


  @Override
  public String toString() {
    return "articulo [idArt=" + idArt + ", nombre=" + nombre + ", categoria=" + categoria
        + ", stock=" + stock + ", precio=" + precio + "]";
  }

  // getters//

  public int getIdArt() {
    return idArt;
  }


  public String getNombre() {
    return nombre;
  }


  public String getCategoria() {
    return categoria;
  }


  public int getStock() {
    return stock;
  }


  public double getPrecio() {
    return precio;
  }

  // setters//

  public void setIdArt(int idArt) {
    this.idArt = idArt;
  }


  public void setNombre(String nombre) {
    this.nombre = nombre;
  }


  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }


  public void setStock(int stock) {
    this.stock = stock;
  }


  public void setPrecio(double precio) {
    this.precio = precio;
  }

}
