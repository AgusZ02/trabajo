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
		int Actividad = 0;
		int Atleta = 0;
		while (Atleta < 1 || Atleta > 7){
			Atleta = pregunta("De qué atleta quieres la informacion? (1-7)");
		}
		while (Actividad > 5 || Actividad < 1){
			Actividad = pregunta("De qué atleta quieres la informacion? (1-5)");
		}

		String ruta = String.format("TrackFiles\\Athlete%d\\activity-Athlete%d-0%d.csv", Atleta, Atleta, Actividad);
		System.out.printf("Log: %s \n",ruta);

		InfoLogTrack atletaTrackpoints = FuncionalidadAuxiliar.cargarInfoCSV(ruta);
		AnalisisLogTrack.generarInformesTrack(atletaTrackpoints);

}

}

