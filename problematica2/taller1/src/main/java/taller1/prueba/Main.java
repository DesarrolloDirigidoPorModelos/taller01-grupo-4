package taller1.prueba;

import java.sql.Date;

import problematica2.Acto;
import problematica2.Patrocinador;
import problematica2.Supervisor;
import problematica2.TipoActo;

public class Main {

	public static void main(String[] args) {

		Supervisor supervisor = new Supervisor("1234567890", "Juan", "Perez", new Date(1990, 10, 10), "0992555555",
				"correo@correo.com", "direccion");

		TipoActo actoPublico = new TipoActo("1", "Acto publico", null);
		TipoActo actoPrivado = new TipoActo("1", "Acto privado", null);

		Patrocinador patrocinador = new Patrocinador("9998887770", "Patrocinador principal", "patrocinador@correo.com",
				"456789111", "direccion patrocinador", null);

		Acto acto1 = new Acto(1, new Date(2022, 10, 15), "Acto 1", "Acto publico", "Lugar del acto 1", 5000D,
				supervisor, patrocinador, actoPublico);
		Acto acto2 = new Acto(1, new Date(2022, 10, 15), "Acto 1", "Acto privado", "Lugar del acto 1", 8000D,
				supervisor, patrocinador, actoPrivado);

		System.out.println("******* TALLER 1 - PROBLEMATICA 2 *******");

		System.out.println("El supervisor " + supervisor.getNombre() + " tiene a cargo " + supervisor.getActos().size()
				+ " actos");

		System.out
				.println("El acto " + acto1.getNombre() + " es patrocinado por " + acto1.getPatrocinador().getNombre());
		System.out
				.println("El acto " + acto2.getNombre() + " es patrocinado por " + acto2.getPatrocinador().getNombre());

	}

}
