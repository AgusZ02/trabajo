import java.util.Arrays;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		String rutaFichero = "TrackFiles\\Athlete1\\activity-Athlete1-01.csv";
		System.out.println("Hello world");
		InfoLogTrack fichero = FuncionalidadAuxiliar.cargarInfoCSV(rutaFichero);
		System.out.println(Arrays.toString(fichero.frecCardiaca));
		int[] Array = fichero.frecCardiaca;
		System.out.println(Array[1]);
	}
	
}
