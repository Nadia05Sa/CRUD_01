package mx.edu.utez.model;

public class Ventas {
    private int ID_Ventas;
    private String Nombre;
    private String Descripcion;
    private boolean Estado;
    private int Total;


    public Ventas() {
    }

    // Constructor con todos los parámetros
    public Ventas(int ID_Ventas, String Nombre, String Descripcion, boolean Estado, int Total) {
        this.ID_Ventas = ID_Ventas;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
        this.Total= Total;
    }

    // Getters y Setters
    public int getID_Ventas() {
        return ID_Ventas;
    }
    public void setID_Ventas(int ID_Ventas) {this.ID_Ventas = ID_Ventas;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public boolean getEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public int getTotal() {
        return Total;
    }
    public void setTotal(int Total) {this.Total = Total;
    }
}