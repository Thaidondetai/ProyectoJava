// Clase Producto (crearla en un archivo separado, Producto.java)
package Interfaz;

public class Producto {
    private String nombre, id;
    private int stock;
    private double precio;

    public Producto() {
    }
    
    

    public Producto(String id, String nombre, int stock, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    // Getters y setters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public int getStock() { return stock; }
    public double getPrecio() { return precio; }
    public void setId(String id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setStock(int stock) { this.stock = stock; }
    public void setPrecio(double precio) { this.precio = precio; }
}
