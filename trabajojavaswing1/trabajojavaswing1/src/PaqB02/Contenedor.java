package PaqB02;

public class Contenedor {

    private int idContenedor;
    private float pesoContenedor;
    private String pais_procedencia;
    private boolean inspeccionado;
    private int prioridad;
    private String descripcion_contenido;
    private String empresa_enviadora;
    private String empresa_recibidora;

    public Contenedor(int idContenedor, float pesoContenedor, String pais_procedencia, boolean inspeccionado, int prioridad, String descripcion_contenido, String empresa_enviadora, String empresa_recibidora) {
        this.idContenedor = idContenedor;
        this.pesoContenedor = pesoContenedor;
        this.pais_procedencia = pais_procedencia;
        this.inspeccionado = inspeccionado;
        this.prioridad = prioridad;
        this.descripcion_contenido = descripcion_contenido;
        this.empresa_enviadora = empresa_enviadora;
        this.empresa_recibidora = empresa_recibidora;
    }

    public int getIdContenedor() {
        return idContenedor;
    }

    public void setIdContenedor(int idContenedor) {
        this.idContenedor = idContenedor;
    }

    public float getPesoContenedor() {
        return pesoContenedor;
    }

    public void setPesoContenedor(int pesoContenedor) {
        this.pesoContenedor = pesoContenedor;
    }

    public String getPais_procedencia() {return pais_procedencia;}

    public void setPais_procedencia(String pais_procedencia) {
        this.pais_procedencia = pais_procedencia;
    }

    public boolean isInspeccionado() {
        return inspeccionado;
    }

    public void setInspeccionado(boolean inspeccionado) {
        this.inspeccionado = inspeccionado;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getDescripcion_contenido() {
        return descripcion_contenido;
    }

    public void setDescripcion_contenido(String descripcion_contenido) {this.descripcion_contenido = descripcion_contenido;}

    public String getEmpresa_enviadora() {
        return empresa_enviadora;
    }

    public void setEmpresa_enviadora(String empresa_enviadora) {
        this.empresa_enviadora = empresa_enviadora;
    }

    public String getEmpresa_recibidora() {
        return empresa_recibidora;
    }

    public void setEmpresa_recibidora(String empresa_recibidora) {
        this.empresa_recibidora = empresa_recibidora;
    }

    public float getPeso() {
        return 0;
    }
}
