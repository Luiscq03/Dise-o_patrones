
package Datos;


import Negocio.entidades.Huesped;
import java.util.List;

public class PruebaHuesped {

    public static void main(String[] args) {

        HuespedRepositorio repositorio = new HuespedRepositorioMySQL();

        try {

            // Crear un huésped de prueba
            Huesped h = new Huesped();

            h.setNombre("Juan Perez");
            h.setDocumento("12345678");
            h.setTelefono("987654321");
            h.setEmail("juan@gmail.com");

            // Registrar
            int id = repositorio.guardar(h);

            System.out.println("Huesped registrado. ID: " + id);

            // Listar huéspedes
            List<Huesped> lista = repositorio.listar();

            System.out.println("\nLISTA DE HUESPEDES");

            for (Huesped x : lista) {

                System.out.println(
                        x.getId() + " - "
                        + x.getNombre() + " - "
                        + x.getDocumento()
                );
            }

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}
