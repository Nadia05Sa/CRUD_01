package mx.edu.utez.model;

import java.sql.Date;

public class Productos {

    private int ID_Producto;
    private String Nombre;
    private String Descripcion;
    private float Precio; // Cambiado a float
    private int Stock;
    private Date Fecha_Creacion;
    private String Imagen;
    private boolean Estado;

    // Constructor
    public Productos() {

    }
    // Constructor con todos los parámetros
    public Productos(int ID_Producto, String nombre, String descripcion, float precio, int stock, Date fecha_Creacion, String imagen, boolean estado) {
        this.ID_Producto = ID_Producto;
        this.Nombre = nombre;
        this.Descripcion = descripcion;
        this.Precio = precio;
        this.Stock = stock;
        this.Fecha_Creacion = fecha_Creacion;
        this.Imagen = imagen;
        this.Estado = estado;
    }



    // Getters y Setters

    public int getID_Producto() {
        return ID_Producto;
    }

    public void setID_Producto(int ID_Producto) {
        this.ID_Producto = ID_Producto;
    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float precio) {
        this.Precio = precio;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        this.Stock = stock;
    }

    public Date getFecha_Creacion() {
        return Fecha_Creacion;
    }

    public void setFecha_Creacion(Date fecha_Creacion) {
        this.Fecha_Creacion = fecha_Creacion;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        this.Imagen = imagen;
    }

    public boolean getEstado() {
        return Estado;
    }

    public void setEstado(boolean estado) {
        this.Estado = estado;
    }
}