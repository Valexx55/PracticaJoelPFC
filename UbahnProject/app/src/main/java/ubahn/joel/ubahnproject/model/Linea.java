package ubahn.joel.ubahnproject.model;

/**
 * Created by Usuario on 05/01/2017.
 */
public class Linea {
    public int id;
    public String nombre;
    public String color;


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getColor() {
        return color;
    }


    public void setColor(String color) {
        this.color = color;
    }


    public Linea(int id, String nombre, String color) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.color = color;
    }


}
