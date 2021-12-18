
public class ProgramaPrincipal {


	public static void main(String[] args) {

		InfoLogTrack atletaTrackpoints;

		atletaTrackpoints = FuncionalidadAuxiliar.cargarInfoCSV(FuncionesPropias.CargarAtleta());
		AnalisisLogTrack.generarInformesTrack(atletaTrackpoints);

}

}

