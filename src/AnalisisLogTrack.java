
public class AnalisisLogTrack {
	public final static double RADIO_TIERRA_KM = 6371;

	/**
	 * Obtiene las estadísticas básicas de la actividad realizada
	 *
	 * @param pInfo información de la actividad (track) del atleta
	 * @return las estadísticas basicas de duracion, velocidad media y distancia total de la actividad
	 */
	public static EstadisticasBasicas obtEstadisticasBasicas(InfoLogTrack pInfo) {
		EstadisticasBasicas EstBasicas;
		double distancia;

		EstBasicas = new EstadisticasBasicas();
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
		double[] arrayFC;
		double[] arrayDistancias;

		//Crear la array con las distancias en cada instante.

		arrayDistancias = new double[pInfo.tiempo.length];
		sumatorio = 0;
		for (int i = 1; i < arrayDistancias.length; i++) {
			sumatorio += DistanciaEntrePuntos(pInfo.latitud[i-1], pInfo.latitud[i], pInfo.longitud[i-1], pInfo.longitud[i]);
			arrayDistancias[i] = sumatorio;
		}

		// Convertir frecCardiaca a double[]
		arrayFC = new double[pInfo.frecCardiaca.length];

		for (int i = 0; i < arrayFC.length; i++) {
			arrayFC[i] = pInfo.frecCardiaca[i];
		}

		FuncionalidadAuxiliar.generarTrackPlot(arrayDistancias, arrayFC, pInfo.altitud, pFichero, false);
		//FuncionalidadAuxiliar.eliminarPlots();
	}


	/**
	 * Devuelve la distribucion por zonas de la frecuencia cardiaca
	 *
	 * @param pInfo Información de la actividad (track) del atleta
	 * @return lista de enteros indicando en cada posicion la distribucion de la FR
	 */
	public static int[] obtDistribucionRC(InfoLogTrack pInfo) {
		int resistencia, moderado, ritmo, umbral, anaerobico;
		int[] zonas;

		resistencia = moderado = ritmo = umbral = anaerobico = 0;
		zonas = new int[5];

		for (int i = 0; i < pInfo.frecCardiaca.length; i++) {
			if (pInfo.frecCardiaca[i] < 123) {
				resistencia += 1;
			} else if (pInfo.frecCardiaca[i] < 153) {
				moderado += 1;
			} else if (pInfo.frecCardiaca[i] < 169) {
				ritmo += 1;
			} else if (pInfo.frecCardiaca[i] < 184) {
				umbral += 1;
			} else {
				anaerobico += 1;
			}
		}
		zonas[0] = resistencia;
		zonas[1] = moderado;
		zonas[2] = ritmo;
		zonas[3] = umbral;
		zonas[4] = anaerobico;
		return zonas;
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
		double Dtiempo, Dvelocidad, caloriasTotales, MET;
		caloriasTotales = 0;
		for (int i = 1; i < pInfo.latitud.length; i++) {
			Dtiempo = (double) pInfo.tiempo[i]-pInfo.tiempo[i-1]; //diferencia de tiempos en segundos
			Dvelocidad = DistanciaEntrePuntos(pInfo.latitud[i-1], pInfo.latitud[i], pInfo.longitud[i-1], pInfo.longitud[i]) / (Dtiempo/3600); //KM/Horas
			MET = -1.52+0.510*Dvelocidad; //MET en el instante i
			caloriasTotales += (Dtiempo/60) * (3.5*MET*pKg) /200;
		}
		return caloriasTotales;
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
		EstadisticasAvanzadas Avanzadas;
		EstadisticasBasicas Basicas;
		Basicas = obtEstadisticasBasicas(pInfo);
		double km, valor, tiempoKm;
		km = tiempoKm = valor = 0;

		Avanzadas = new EstadisticasAvanzadas();
		Avanzadas.velocidadMaxima = valor;
		Avanzadas.desnivel = 0;
		Avanzadas.velocidadMaxKm = valor;
		Avanzadas.calorias = estimarConsumoCalorias(pInfo, pKg);
		return Avanzadas;
	}

	/**
	 * Genera el informe completo de las actividades
	 */
	public static void generarInformesTrack() {
		//Inicializar variables
		InfoLogTrack atletaTrackpoints;
		EstadisticasBasicas InformeBasicas;
		EstadisticasAvanzadas InformeAvanzadas;
		int segundosTotales, horas, minutos, segundos;
		String tiempo;
		double peso, resistencia, moderado, ritmo, umbral, anaerobico;
		int[] zonas;
		String ruta;
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 5; j++) {
				ruta = String.format("TrackFiles\\Athlete%d\\activity-Athlete%d-0%d.csv", i, i, j);
				atletaTrackpoints = FuncionalidadAuxiliar.cargarInfoCSV(ruta);
				peso = FuncionalidadAuxiliar.obtPesoAtleta(String.format("Athlete%d",i));
				InformeBasicas = obtEstadisticasBasicas(atletaTrackpoints);

				InformeAvanzadas = obtEstadisticasAvanzadas(atletaTrackpoints, peso);

				System.out.printf("Log: %s \n", ruta);



				//Tiempo de la actividad
				segundosTotales = InformeBasicas.duracion;
				horas = segundosTotales / 3600;
				minutos = (segundosTotales % 3600) / 60;
				segundos = segundosTotales % 60;
				tiempo = String.format("%dh:%dm:%ds", horas, minutos, segundos);
				System.out.println("Duracion de la actividad: " + tiempo);
				System.out.println("Distancia total recorrida: " + String.format("%.2f", InformeBasicas.distancia) + " Km");
				System.out.println("Velocidad media del atleta: " + String.format("%.2f", InformeBasicas.velocidad) + " Km/h");
				System.out.println(String.format("Calorías totales quemadas: %.2f", InformeAvanzadas.calorias));
				System.out.println("Frecuendia cardíaca media: " + String.format("%.2f", InformeBasicas.fCMedia) + " p/m");


				//Zonas de esfuerzo
				System.out.println("Distribución de zonas FC:");
				zonas = obtDistribucionRC(atletaTrackpoints);
				//Porcentaje de zonas de esfuerzo
				resistencia = ((double)(zonas[0] * 100) / atletaTrackpoints.frecCardiaca.length);
				moderado = ((double)(zonas[1] * 100) / atletaTrackpoints.frecCardiaca.length);
				ritmo = ((double)(zonas[2] * 100) / atletaTrackpoints.frecCardiaca.length);
				umbral = ((double)(zonas[3] * 100) / atletaTrackpoints.frecCardiaca.length);
				anaerobico = ((double)(zonas[4] * 100) / atletaTrackpoints.frecCardiaca.length);

				System.out.println("Z1 Resistencia: " + String.format("%.2f",resistencia));
				System.out.println("Z2 Moderado: " + String.format("%.2f", moderado));
				System.out.println("Z3 Ritmo: " + String.format("%.2f", ritmo));
				System.out.println("Z4 Umbral: " + String.format("%.2f", umbral));
				System.out.println("Z5 Anaeróbico: " + String.format("%.2f", anaerobico));

				System.out.println("\n");
				//Generar la gráfica
				graficarPerfil(atletaTrackpoints, String.format("GeneratedPlots\\%s\\plot-%s-0%d.png", String.format("Athlete%d",i), String.format("Athlete%d",i), j));
			}
		}



	}

// Función que dadas dos valores de latitud y longitud, devuelve la distancia total recorrida.
	public static double DistanciaEntrePuntos(double lat1, double lat2, double lon1, double lon2){
		double Dlat, Dlong, a, d;

		Dlat = Math.abs(lat2 - lat1);
		Dlong = Math.abs(lon2 - lon1);
		Dlat = Math.toRadians(Dlat);
		Dlong = Math.toRadians(Dlong);
		a = (Math.pow(Math.sin(Dlat)/2, 2) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.pow(Math.sin(Dlong/2),2));
		d = 2 * AnalisisLogTrack.RADIO_TIERRA_KM * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return d;
	}
}