import java.util.Arrays;
import java.util.Scanner;

public class ProgramaPrincipal {

	public static String pregunta(String enunciado){
		Scanner escaner = new Scanner(System.in);
		System.out.println(enunciado);
		String respuesta = escaner.nextLine();
		return respuesta;
	}
	public static void main(String[] args) {
		String ruta = "";
		String respuesta = pregunta("De qué atleta quieres la informacion? (1-7)");
		switch (respuesta){
			case "1":
				String respuestaFichero = pregunta("Qué actividad quieres leer? (1-5)");
				switch (respuestaFichero){
					case "1":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete1-01.csv";
						break;
					case "2":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete1-02.csv";
						break;
					case "3":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete1-03.csv";
						break;
					case "4":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete1-04.csv";
						break;
					case "5":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete1-05.csv";
						break;
				}

			case "2":
				String respuestaFichero = pregunta("Qué actividad quieres leer? (1-5)");
				switch (respuestaFichero){
					case "1":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete2-01.csv";
						break;
					case "2":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete2-02.csv";
						break;
					case "3":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete2-03.csv";
						break;
					case "4":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete2-04.csv";
						break;
					case "5":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete3-05.csv";
						break;
		}
			case "3":
				String respuestaFichero = pregunta("Qué actividad quieres leer? (1-5)");
				switch (respuestaFichero) {
					case "1":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete3-01.csv";
						break;
					case "2":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete3-02.csv";
						break;
					case "3":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete3-03.csv";
						break;
					case "4":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete3-04.csv";
						break;
					case "5":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete3-05.csv";
						break;

				}
			case "4":
				String respuestaFichero = pregunta("Qué actividad quieres leer? (1-5)");
				switch (respuestaFichero) {
					case "1":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete4-01.csv";
						break;
					case "2":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete4-02.csv";
						break;
					case "3":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete4-03.csv";
						break;
					case "4":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete4-04.csv";
						break;
					case "5":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete4-05.csv";
						break;
				}
			case "5":
				String respuestaFichero = pregunta("Qué actividad quieres leer? (1-5)");
				switch (respuestaFichero) {
					case "1":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete5-01.csv";
						break;
					case "2":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete5-02.csv";
						break;
					case "3":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete5-03.csv";
						break;
					case "4":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete5-04.csv";
						break;
					case "5":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete5-05.csv";
						break;
				}
			case "6":
				String respuestaFichero = pregunta("Qué actividad quieres leer? (1-5)");
				switch (respuestaFichero) {
					case "1":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete6-01.csv";
						break;
					case "2":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete6-02.csv";
						break;
					case "3":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete6-03.csv";
						break;
					case "4":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete6-04.csv";
						break;
					case "5":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete6-05.csv";
						break;
				}
			case "7":
				String respuestaFichero = pregunta("Qué actividad quieres leer? (1-5)");
				switch (respuestaFichero) {
					case "1":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete7-01.csv";
						break;
					case "2":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete7-02.csv";
						break;
					case "3":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete7-03.csv";
						break;
					case "4":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete7-04.csv";
						break;
					case "5":
						ruta = "TrackFiles\\Athlete1\\activity-Athlete7-05.csv";
						break;
				}



		InfoLogTrack atletaTrackpoints = FuncionalidadAuxiliar.cargarInfoCSV(ruta);
		System.out.println(Arrays.toString(atletaTrackpoints.frecCardiaca));
		//FuncionalidadAuxiliar.generarTrackPlot(distancia, FrecuenciaCardiaca, elevacion, "Atleta1", true);

	}


}

