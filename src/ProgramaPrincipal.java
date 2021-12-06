import java.util.Arrays;
import java.util.Scanner;

public class ProgramaPrincipal {

	public static String pregunta(String enunciado) {
		Scanner escaner = new Scanner(System.in);
		System.out.println(enunciado);
		String respuesta = escaner.nextLine();
		return respuesta;
	}

	public static void main(String[] args) {
		String ruta = "";
		String respuesta = pregunta("De qué atleta quieres la informacion? (1-7)");
		String respuestaFichero = "";
		switch (respuesta) {
			case "1":
				respuestaFichero = pregunta("Qué actividad quieres leer? (1-5)");
				ruta = FunSwitch(1, Integer.valueOf(respuestaFichero));
				break;
			case "2":
				respuestaFichero = pregunta("Qué actividad quieres leer? (1-5)");
				ruta = FunSwitch(2, Integer.valueOf(respuestaFichero));
				break;
			case "3":
				respuestaFichero = pregunta("Qué actividad quieres leer? (1-5)");
				ruta = FunSwitch(3, Integer.valueOf(respuestaFichero));
				break;
			case "4":
				respuestaFichero = pregunta("Qué actividad quieres leer? (1-5)");
				ruta = FunSwitch(4, Integer.valueOf(respuestaFichero));
				break;
			case "5":
				respuestaFichero = pregunta("Qué actividad quieres leer? (1-5)");
				ruta = FunSwitch(5, Integer.valueOf(respuestaFichero));
				break;
			case "6":
				respuestaFichero = pregunta("Qué actividad quieres leer? (1-5)");
				ruta = FunSwitch(6, Integer.valueOf(respuestaFichero));
				break;
			case "7":
				respuestaFichero = pregunta("Qué actividad quieres leer? (1-5)");
				ruta = FunSwitch(7, Integer.valueOf(respuestaFichero));
				break;
		}


		InfoLogTrack atletaTrackpoints = FuncionalidadAuxiliar.cargarInfoCSV(ruta);
		EstadisticasBasicas BasicStats =AnalisisLogTrack.obtEstadisticasBasicas(atletaTrackpoints);




}



	public static String FunSwitch(int Atleta, int Actividad){
		String rutaO = "TrackFiles\\AthleteN\\activity-AthleteN-JJ.csv";
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

