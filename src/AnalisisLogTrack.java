

public class AnalisisLogTrack {
	public final static double RADIO_TIERRA_KM = 6371;

	/**
	 * Obtiene las estadísticas básicas de la actividad realizada
	 *
	 * @param pInfo información de la actividad (track) del atleta
	 * @return las estadísticas basicas de duracion, velocidad media y distancia total de la actividad
	 */
	public static EstadisticasBasicas obtEstadisticasBasicas(InfoLogTrack pInfo) {
		EstadisticasBasicas BasicStats = new EstadisticasBasicas();

		// Bucle for para sumar todos los registros de FC en la variable sumatorio
		double sumatorio = 0;
		for (int i = 0; i < pInfo.frecCardiaca.length; i++) {
			sumatorio += pInfo.frecCardiaca[i];
		}
		BasicStats.distancia = DistanciaEntrePuntos(pInfo.latitud, pInfo.longitud);
		BasicStats.fCMedia = sumatorio / pInfo.frecCardiaca.length;

		BasicStats.duracion = pInfo.tiempo[pInfo.tiempo.length -1];


		BasicStats.velocidad = (BasicStats.distancia / ((double) BasicStats.duracion / 3600) );
		return BasicStats;
	}


	/**
	 * Genera y guarda el gráfico que muestra el perfil de la actividad junto con
	 * la evolución de la frecuencia cardíaca.
	 *
	 * @param pInfo    Información de la actividad (track) del atleta
	 * @param pFichero Nombre (path) del fichero donde se guardará el gráfico generado
	 */
	public static void graficarPerfil(InfoLogTrack pInfo, String pFichero) {  }


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
		return null;
	}

	/**
	 * Genera el informe completo de las actividades
	 */
	public static void generarInformesTrack(InfoLogTrack pInfo) {
		EstadisticasBasicas Informe = obtEstadisticasBasicas(pInfo);
		int segundosTotales = Informe.duracion;
		int horas = segundosTotales / 3600;
		int minutos = (segundosTotales % 3600) / 60;
		int segundos = segundosTotales % 60;
		String tiempo = String.format("%d:%d:%d", horas,minutos,segundos);
		System.out.println("Frecuendia cardíaca media: " + Informe.fCMedia + " pulsaciones por minuto.");
		System.out.println("Duracion de la actividad: " + tiempo);
		System.out.println("Distancia total recorrida: " + Informe.distancia + " Kilometros");
		System.out.println("Velocidad media del atleta: " + Informe.velocidad + " Kilometros por hora");


	}

// Función que dadas dos arrays con valores de latitud y longitud, devuelve la distancia total recorrida.
	public static float DistanciaEntrePuntos(double[] lat, double[] longi){
		float distancia;
		distancia = 0;
		for (int i = 0; i < lat.length -1; i++) {
			float Dlat = Math.abs((float) (lat[i+1] - lat[i]));
			float Dlong = Math.abs((float) (longi[i+1] - longi[i]));
			Dlat = (float) Math.toRadians(Dlat);
			Dlong = (float) Math.toRadians(Dlong);
			float a = (float) ((float) Math.pow(Math.sin(Dlat)/2, 2) + Math.cos(Math.toRadians(lat[i])) * Math.cos(Math.toRadians(lat[i+1])) * Math.pow(Math.sin(Dlong/2),2));
			float d = (float) (2 * AnalisisLogTrack.RADIO_TIERRA_KM * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)));
			distancia += d;

		}
		return distancia;
	}
}