package novedades.plataforma;


import novedades.contenido.Novedad;
import novedades.contenido.Resumen;
import novedades.contenido.Trabajador;

import java.util.ArrayList;
import java.util.List;

public class Plataforma {

    private String nombrePl;
    private List<Trabajador> contenidoT;

    public Plataforma(String nombrePl, List<Trabajador> contenidoT) {
        this.nombrePl = nombrePl;
        this.contenidoT = (contenidoT != null) ? contenidoT : new ArrayList<>();
    }

    public Trabajador buscarTrabajador(int cc) {
        return contenidoT.stream()
                .filter(t -> t.getCC() == cc)
                .findFirst()
                .orElse(null);
    }

    public void registrarTrabajador(Trabajador trabajador){
        if (buscarTrabajador(trabajador.getCC()) == null) {
            contenidoT.add(trabajador);
        }
    }

    public void registrarNovedad(int cc, Novedad novedad){
        Trabajador trabajador = buscarTrabajador(cc);

        if(trabajador != null){
            trabajador.agregarNovedad(novedad);
        } else {
            System.out.println("Trabajador no encontrado.");
        }
    }

    public  List<Resumen> getResumen(){
        return contenidoT.stream()
                .map(t-> new Resumen(t.getCC(),t.getNombre(),t.getContenidoN()))
                .toList();
    }
    // Mostrar todos los trabajadores
    public void mostrarT() {
        getResumen().forEach(r ->
                System.out.println("CC: " + r.CC() + " | Nombre: " + r.nombre())
        );
    }

    // Eliminar trabajador por cédula
    public void eliminarTrabajador(int cc) {
        boolean eliminado = contenidoT.removeIf(t -> t.getCC() == cc);
        if (!eliminado) {
            System.out.println("Trabajador no encontrado.\n");
        }
    }
}