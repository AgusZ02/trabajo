public class FuncionesPropias {

    public static ZonasFC ZonasFrecuencia(InfoLogTrack pInfo) {
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
        for (int i = 0; i < 5; i++) {
          zonas[i] =   
        }
        return zonas;
    }
    public static double CalculoMedia(int[] array){
        double sumatorio;
        double media;
        sumatorio = 0;
        for (int j : array) {
            sumatorio += j;

        }
        media = sumatorio/array.length;
        return media;
    }
}
