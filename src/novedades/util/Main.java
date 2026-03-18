package novedades.util;

import novedades.contenido.Novedad;
import novedades.contenido.Supervisor;
import novedades.contenido.Trabajador;
import novedades.plataforma.Plataforma;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final int REGISTRAR_NOVEDAD  = 1;
    private static final int MOSTRAR_TRABAJADORES = 2;
    private static final int BUSCAR_TRABAJADOR  = 3;
    private static final int ELIMINAR_TRABAJADOR = 4;
    private static final int SALIR              = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Trabajador> listaTrabajador = new ArrayList<>();
        Plataforma plataforma = new Plataforma("Novedades", listaTrabajador);

        while (true) {

            System.out.println("""
                    ===== MENÚ =====
                    1. Registrar novedad
                    2. Mostrar trabajadores
                    3. Buscar trabajador
                    4. Eliminar trabajador
                    0. Salir
                    =================
                    """);

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case REGISTRAR_NOVEDAD -> {
                    System.out.print("Cédula trabajador: ");
                    int cc = sc.nextInt();
                    sc.nextLine();

                    Trabajador trabajador = plataforma.buscarTrabajador(cc);

                    if (trabajador == null) {
                        System.out.print("Nombre trabajador: ");
                        String nombre = sc.nextLine();
                        trabajador = new Trabajador(cc, nombre);
                        plataforma.registrarTrabajador(trabajador);
                    }

                    System.out.print("ID novedad: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Motivo: ");
                    String motivo = sc.nextLine();

                    System.out.print("Tipo: ");
                    String tipo = sc.nextLine();

                    System.out.print("Supervisor (MARIA, IRIS, SOIL, PEDRO, URIEL, FRANK, GUATAME): ");
                    String nombreSupervisor = sc.nextLine();

                    try {
                        Supervisor supervisor = Supervisor.valueOf(nombreSupervisor.toUpperCase());
                        Novedad nov = new Novedad(LocalDate.now(), id, motivo, tipo, supervisor);
                        plataforma.registrarNovedad(cc, nov);
                        System.out.println("Novedad registrada.\n");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Supervisor no válido.\n");
                    }
                }

                case MOSTRAR_TRABAJADORES -> plataforma.mostrarT();

                case BUSCAR_TRABAJADOR -> {
                    System.out.print("Ingrese cédula: ");
                    int cc = sc.nextInt();
                    sc.nextLine();

                    Trabajador t = plataforma.buscarTrabajador(cc);

                    if (t != null) {
                        System.out.println("Nombre: " + t.getNombre());
                    } else {
                        System.out.println("No encontrado.\n");
                    }
                }

                case ELIMINAR_TRABAJADOR -> {
                    System.out.print("Ingrese cédula a eliminar: ");
                    int cc = sc.nextInt();
                    sc.nextLine();
                    plataforma.eliminarTrabajador(cc);
                }

                case SALIR -> {
                    System.out.println("Saliendo...");
                    sc.close();
                    return;
                }

                default -> System.out.println("Opción no válida.\n");
            }
        }
    }
}