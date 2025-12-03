package CreatividadDigital.Modelo;


import java.time.LocalDate;

public class CampaniaPublicitaria {

    private final int prestupuesto;
    private String codigo;
    private String cliente;
    private int presupuesto;
    private LocalDate fechaInicio;  // <-- ahora es LocalDate

    public CampaniaPublicitaria(String codigo, String cliente, int presupuesto, LocalDate fechaInicio) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.prestupuesto = presupuesto;
        this.fechaInicio = fechaInicio;
    }

    public String getCodigo() { return codigo; }
    public String getCliente() { return cliente; }
    public int getPresupuesto() { return presupuesto; }
    public LocalDate getFechaInicio() { return fechaInicio; }

    @Override
    public String toString() {
        return "CampaniaPublicitaria{" +
                "codigo='" + codigo + '\'' +
                ", cliente='" + cliente + '\'' +
                ", presupuesto=" + presupuesto +
                ", fechaInicio=" + fechaInicio +
                '}';
    }
}