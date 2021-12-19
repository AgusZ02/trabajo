
public class ProgramaPrincipal {


	public static void main(String[] args) {
		InfoLogTrack atletaTrackpoints;
		DatosIniciales datos;
		datos= FuncionesPropias.CargarAtleta();
		atletaTrackpoints = FuncionalidadAuxiliar.cargarInfoCSV(datos.ruta);
		AnalisisLogTrack.estimarConsumoCalorias(atletaTrackpoints, 83.5);
		//AnalisisLogTrack.generarInformesTrack();

}

}

