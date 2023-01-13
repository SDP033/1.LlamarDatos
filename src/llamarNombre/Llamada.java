package llamarNombre;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Llamada {

	public static void main(String[] args) throws IOException {
		File directorio = new File("C:\\Users\\sergi\\eclipse-workspace\\CrearDatos\\bin");

		ProcessBuilder pb = new ProcessBuilder("java.exe", "generarNombre.Nombre", "Sergio");

		pb.directory(directorio);

		System.out.printf("Directorio de trabajo: %s%n", pb.directory());

		Process p = pb.start();

		// COMPROBACION DE ERROR - 0 bien - 1 mal
		int salida = -1;
		try {
			salida = p.waitFor();
			System.out.println("Valor de Salida: " + salida);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (salida == 0) {

			// obtener la salida devuelta por el proceso
			try {
				InputStream is = p.getInputStream();
				int c;
				while ((c = is.read()) != -1)
					System.out.print((char) c);
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}