package novedades.contenido;

import java.util.List;

public record Resumen(
        int CC,
        String nombre,
        List<Novedad> contenidoN
) {
}