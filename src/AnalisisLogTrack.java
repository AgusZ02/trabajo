

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
		BasicStats.distancia = DistanciaPuntos(pInfo.latitud[0], pInfo.latitud[1], pInfo.longitud[0], pInfo.longitud[2], AnalisisLogTrack.RADIO_TIERRA_KM);
		double acumulador = 0;
		for (int i = 0; i < pInfo.frecCardiaca.length; i++) {
			acumulador += pInfo.frecCardiaca[i];
		}
		BasicStats.fCMedia = acumulador / pInfo.frecCardiaca.length;
		BasicStats.duracion = pInfo.tiempo[pInfo.tiempo.length -1];
		//BasicStats.velocidad;
		return BasicStats;
	}


	/**
	 * Genera y guarda el gráfico que muestra el perfil de la actividad junto con
	 * la evolución de la frecuencia cardíaca.
	 *
	 * @param pInfo    Información de la actividad (track) del atleta
	 * @param pFichero Nombre (path) del fichero donde se guardará el gráfico generado
	 */
	public static void graficarPerfil(InfoLogTrack pInfo, String pFichero) {

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
		return null;
	}


	/**
	 * Genera el informe completo de las actividades
	 */
	public static void generarInformesTrack() {

	}


	public static float DistanciaPuntos(double lat1, double lat2, double long1, double long2, double Radio) {
		float Dlat = (float) (lat2 - lat1);
		float Dlong = (float) (long2 - long1);
		float a = (float) ((float) Math.pow(Math.sin(Dlat), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.sin(Dlong));
		float d = (float) (2 * Radio * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)));
		return (float) d;
	}
}