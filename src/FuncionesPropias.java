public class FuncionesPropias {

    public static ZonasFC ZonasFrecuencia(InfoLogTrack pInfo) {

        ZonasFC zonas = new ZonasFC();

        for (int i = 0; i < pInfo.frecCardiaca.length; i++) {
            if (pInfo.frecCardiaca[i] < 123) {
                zonas.resistencia += 1;
            } else if (pInfo.frecCardiaca[i] < 153) {
                zonas.moderado += 1;
            } else if (pInfo.frecCardiaca[i] < 169) {
                zonas.ritmo += 1;
            } else if (pInfo.frecCardiaca[i] < 184) {
                zonas.umbral += 1;
            } else {
                zonas.anaerobico += 1;
            }
        }
        return zonas;
    }
    //Funcion que devuelve la media aritmetica con los elementos de una tabla int
    public static double CalculoMedia(int[] array){
        double sumatorio, media;
        sumatorio = 0;
        for (int i : array) {
            sumatorio += i;

        }
        media = sumatorio/array.length;
        return media;
    }
}
