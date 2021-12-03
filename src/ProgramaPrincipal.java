import java.util.Arrays;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		String rutaFichero = "TrackFiles\\Athlete1\\activity-Athlete1-01.csv";
		InfoLogTrack fichero = FuncionalidadAuxiliar.cargarInfoCSV(rutaFichero);
		int[] Frecuencia = fichero.frecCardiaca;
		System.out.println(Frecuencia);
	}
	
}
