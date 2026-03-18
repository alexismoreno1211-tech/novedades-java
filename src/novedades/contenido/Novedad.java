package novedades.contenido;

import java.time.LocalDate;

public class Novedad {

    private int idNovedad;
    private String tipoNovedad;
    private String motivoNovedad;
    private LocalDate fechaNovedad;
    private Supervisor supervisor;

    public Novedad(LocalDate fechaNovedad, int idNovedad, String motivoNovedad, String tipoNovedad, Supervisor supervisor) {
        this.fechaNovedad = fechaNovedad;
        this.idNovedad = idNovedad;
        this.motivoNovedad = motivoNovedad;
        this.tipoNovedad = tipoNovedad;
        this.supervisor = supervisor;
    }

    public int getIdNovedad() {
        return idNovedad;
    }

    public String getTipoNovedad() {
        return tipoNovedad;
    }

    public String getMotivoNovedad() {
        return motivoNovedad;
    }

    public LocalDate getFechaNovedad() {
        return fechaNovedad;
    }
}