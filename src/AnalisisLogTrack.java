import java.util.Arrays;

public class AnalisisLogTrack {
	public final static double RADIO_TIERRA_KM = 6371;

	/**
	 * Obtiene las estadísticas básicas de la actividad realizada
	 *
	 * @param pInfo información de la actividad (track) del atleta
	 * @return las estadísticas basicas de duracion, velocidad media y distancia total de la actividad
	 */
	public static EstadisticasBasicas obtEstadisticasBasicas(InfoLogTrack pInfo) {
		EstadisticasBasicas EstBasicas = new EstadisticasBasicas();
		double distancia;
		distancia = 0;

		//Crear el sumatorio de todos los tracks de la frecuencia cardíaca
		for (int i = 1; i < pInfo.latitud.length; i++) {
			distancia += DistanciaEntrePuntos(pInfo.latitud[i-1], pInfo.latitud[i], pInfo.longitud[i-1], pInfo.longitud[i]);
		}

		EstBasicas.distancia = distancia;
		EstBasicas.fCMedia = FuncionesPropias.CalculoMedia(pInfo.frecCardiaca);
		EstBasicas.duracion = pInfo.tiempo[pInfo.tiempo.length -1];
		EstBasicas.velocidad = (EstBasicas.distancia / (EstBasicas.duracion / 3600) );

		return EstBasicas;
	}


	/**
	 * Genera y guarda el gráfico que muestra el perfil de la actividad junto con
	 * la evolución de la frecuencia cardíaca.
	 *
	 * @param pInfo    Información de la actividad (track) del atleta
	 * @param pFichero Nombre (path) del fichero donde se guardará el gráfico generado
	 */
	public static void graficarPerfil(InfoLogTrack pInfo, String pFichero) {
		double sumatorio;
		sumatorio = 0;

		//Crear la array con las distancias en cada instante.
		double[] arrayDistancias = new double[pInfo.tiempo.length];
		for (int i = 1; i < arrayDistancias.length; i++) {
			sumatorio += DistanciaEntrePuntos(pInfo.latitud[i-1], pInfo.latitud[i], pInfo.longitud[i-1], pInfo.longitud[i]);
			arrayDistancias[i] = sumatorio;
		}

		// Convertir frecCardiaca a double[]
		double[] arrayFC = new double[pInfo.frecCardiaca.length];
		for (int i = 0; i < arrayFC.length; i++) {
			arrayFC[i] = pInfo.frecCardiaca[i];
		}

		FuncionalidadAuxiliar.generarTrackPlot(arrayDistancias, arrayFC, pInfo.altitud, pFichero, true);
		FuncionalidadAuxiliar.eliminarPlots();
	}


	/**
	 * Devuelve la distribucion por zonas de la frecuencia cardiaca
	 *
	 * @param pInfo Información de la actividad (track) del atleta
	 * @return lista de enteros indicando en cada posicion la distribucion de la FR
	 */
	public static int[] obtDistribucionRC(InfoLogTrack pInfo) {
		return null;
	}

	/**
	 * Calcula el consumo de calorías del ciclista durante su actividad basandose
	 * en el método Metabolic Equivalent Task (MET).
	 *
	 * @param pInfo Información de la actividad (track) del atleta.
	 * @param pKg   Peso corporal del atletam en kilogramos.
	 * @return Las calorías consumidas en la actividad.
	 */
	public static double estimarConsumoCalorias(InfoLogTrack pInfo, double pKg) {
		return 0.0;
	}

	/**
	 * Obtiene las estadísticas avanzadas de la actividad realizada
	 *
	 * @param pInfo informacion de la actividad del atleta
	 * @param pKg   peso corporal del atleta
	 * @return la estadisticas avanzadas que incluyen velocidad máxima,
	 * km más rápido, consumo calórico y desnivel positivo
	 */
	public static EstadisticasAvanzadas obtEstadisticasAvanzadas(InfoLogTrack pInfo, double pKg) {
		EstadisticasAvanzadas Avanzadas = new EstadisticasAvanzadas();
		double[] arrayDistancia = new double[pInfo.tiempo.length];

		for (int i = 1; i < pInfo.tiempo.length; i += 1) {

			arrayDistancia[i] += DistanciaEntrePuntos(pInfo.latitud[i-1], pInfo.latitud[i], pInfo.longitud[i-1], pInfo.longitud[i]); ;
		}

		return Avanzadas;
	}

	/**
	 * Genera el informe completo de las actividades
	 */
	public static void generarInformesTrack(InfoLogTrack pInfo) {

		//Inicializar y declarar variables
		EstadisticasBasicas Informe = obtEstadisticasBasicas(pInfo);
		ZonasFC zonas = FuncionesPropias.ZonasFrecuencia(pInfo);
		int segundosTotales = Informe.duracion;
		int horas = segundosTotales / 3600;
		int minutos = (segundosTotales % 3600) / 60;
		int segundos = segundosTotales % 60;

		String tiempo = String.format("%dh:%dm:%ds", horas,minutos,segundos);

		System.out.println("Frecuendia cardíaca media: " + String.format("%.2f", Informe.fCMedia) + " p/m");
		//Zonas de esfuerzo
		System.out.println("Zonas de frecuencia cardíaca:");
		System.out.println("Z1 Resistencia: " + String.format("%.2f%" + "%", zonas.resistencia*100/pInfo.frecCardiaca.length));
		System.out.println("Z2 Moderado: " + String.format("%.2f%" + "%", zonas.moderado*100/pInfo.frecCardiaca.length));
		System.out.println("Z3 Ritmo: " + String.format("%.2f%" + "%", zonas.ritmo*100/pInfo.frecCardiaca.length));
		System.out.println("Z4 Umbral: " + String.format("%.2f%" + "%", zonas.umbral*100/pInfo.frecCardiaca.length));
		System.out.println("Z5 Anaeróbico: " + String.format("%.2f%" + "%", zonas.anaerobico*100/pInfo.frecCardiaca.length));


		System.out.println("Duracion de la actividad: " + tiempo);
		System.out.println("Distancia total recorrida: " + String.format("%.2f", Informe.distancia) + " Km");
		System.out.println("Velocidad media del atleta: " + String.format("%.2f", Informe.velocidad) + " Km/h");
		//Generar la gráfica
		graficarPerfil(pInfo, "Gráfica1");


	}

// Función que dadas dos valores de latitud y longitud, devuelve la distancia total recorrida.
	public static float DistanciaEntrePuntos(double lat1, double lat2, double lon1, double lon2){
		float Dlat = Math.abs((float) (lat2 - lat1));
		float Dlong = Math.abs((float) (lon2 - lon1));
		Dlat = (float) Math.toRadians(Dlat);
		Dlong = (float) Math.toRadians(Dlong);
		float a = (float) ((float) Math.pow(Math.sin(Dlat)/2, 2) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.pow(Math.sin(Dlong/2),2));
		float d = (float) (2 * AnalisisLogTrack.RADIO_TIERRA_KM * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)));

		return d;
	}
}