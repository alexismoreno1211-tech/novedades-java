package novedades.contenido;

import java.util.ArrayList;
import java.util.List;

public class Trabajador {

    private int CC;
    private String nombre;
    private List<Novedad> contenidoN;

    public Trabajador(int CC, String nombre) {
        this.CC = CC;
        this.nombre = nombre;
        this.contenidoN = new ArrayList<>();
    }

    public void agregarNovedad(Novedad novedad){
        if(novedad != null){
            contenidoN.add(novedad);
        }
    }

    public List<Novedad> getContenidoN(){
        return List.copyOf(contenidoN);
    }

    public int getCC() {
        return CC;
    }

    public String getNombre() {
        return nombre;
    }
}