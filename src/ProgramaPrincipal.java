import java.util.Arrays;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		String rutaFichero = "TrackFiles\\Athlete1\\activity-Athlete1-01.csv";
		InfoLogTrack atleta1 = FuncionalidadAuxiliar.cargarInfoCSV(rutaFichero);
		int[] FrecuenciaCardiaca = atleta1.frecCardiaca;
		for (int i = 0; i < FrecuenciaCardiaca.length; i++) {

		}
		System.out.println(FrecuenciaCardiaca.length);

		//FuncionalidadAuxiliar.generarTrackPlot(distancia, FrecuenciaCardiaca, elevacion, "Atleta1", true);

	}


}

