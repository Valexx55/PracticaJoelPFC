package ubahn.joel.ubahnproject.model;


public class Estacion {
    public int id;
    public String nombre;
    public int id_linea;
    public int id_servicio;
    public String mapa;



    public Estacion(int id, String nombre, int id_linea, int id_servicio, String mapa) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.id_linea = id_linea;
        this.id_servicio = id_servicio;
        this.mapa = mapa;
    }
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
    public int getId_linea() {
        return id_linea;
    }
    public void setId_linea(int id_linea) {
        this.id_linea = id_linea;
    }
    public int getId_servicio() {
        return id_servicio;
    }
    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }
    public String getMapa() {
        return mapa;
    }
    public void setMapa(String mapa) {
        this.mapa = mapa;
    }
}
