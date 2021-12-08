import java.util.Arrays;
import java.util.Scanner;

public class ProgramaPrincipal {

	public static int pregunta(String enunciado) {
		Scanner escaner = new Scanner(System.in);
		System.out.println(enunciado);
		int respuesta = escaner.nextInt();
		return respuesta;
	}

	public static void main(String[] args) {
		String ruta = "";
		int respuesta = pregunta("De qué atleta quieres la informacion? (1-7)");
		int respuestaFichero = 0;
		switch (respuesta) {
			case 1:
				respuestaFichero = pregunta("Qué actividad quieres leer? (1-5)");
				ruta = FunSwitch(1, Integer.valueOf(respuestaFichero));
				break;
			case 2:
				respuestaFichero = pregunta("Qué actividad quieres leer? (1-5)");
				ruta = FunSwitch(2, Integer.valueOf(respuestaFichero));
				break;
			case 3:
				respuestaFichero = pregunta("Qué actividad quieres leer? (1-5)");
				ruta = FunSwitch(3, Integer.valueOf(respuestaFichero));
				break;
			case 4:
				respuestaFichero = pregunta("Qué actividad quieres leer? (1-5)");
				ruta = FunSwitch(4, Integer.valueOf(respuestaFichero));
				break;
			case 5:
				respuestaFichero = pregunta("Qué actividad quieres leer? (1-5)");
				ruta = FunSwitch(5, Integer.valueOf(respuestaFichero));
				break;
			case 6:
				respuestaFichero = pregunta("Qué actividad quieres leer? (1-5)");
				ruta = FunSwitch(6, Integer.valueOf(respuestaFichero));
				break;
			case 7:
				respuestaFichero = pregunta("Qué actividad quieres leer? (1-5)");
				ruta = FunSwitch(7, Integer.valueOf(respuestaFichero));
				break;
	}

		InfoLogTrack atletaTrackpoints = FuncionalidadAuxiliar.cargarInfoCSV(ruta);
		AnalisisLogTrack.generarInformesTrack(atletaTrackpoints);
		AnalisisLogTrack.DistanciaEntrePuntos(atletaTrackpoints.latitud, atletaTrackpoints.longitud);
}
	public static String FunSwitch(int Atleta, int Actividad){
		String rutaO = String.format("TrackFiles\\Athlete%d\\activity-Athlete%d-%2d.csv", Atleta, Actividad);
		String rutaR = "";
		String ruta = rutaO.replace("N", Integer.toString(Atleta));


		switch (Actividad){
			case 1:
				rutaR = ruta.replace("JJ", "01");
				break;

			case 2:
				rutaR = ruta.replace("JJ", "02");
				break;
			case 3:
				rutaR = ruta.replace("JJ", "03");
				break;
			case 4:
				rutaR = ruta.replace("JJ", "04");
				break;
			case 5:
				rutaR = ruta.replace("JJ", "05");
				break;

		}
		return rutaR;
	}
}

