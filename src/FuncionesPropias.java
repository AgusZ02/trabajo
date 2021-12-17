import java.util.Scanner;

public class FuncionesPropias {

    //Función para leer la entrada del usuario. Devuelve un entero
    public static int pregunta(String enunciado) {
        Scanner escaner = new Scanner(System.in);
        System.out.println(enunciado);
        int respuesta = escaner.nextInt();
        return respuesta;
    }
    //Funcion para cargar la ruta del archivo para leer
    public static String CargarAtleta(){
        int Actividad;
        int Atleta;

        Atleta = 0;
        Actividad = 0;
        try {
            while (Atleta < 1 || Atleta > 7){
            Atleta = FuncionesPropias.pregunta("De qué atleta quieres la informacion? (1-7)");
        }
        while (Actividad > 5 || Actividad < 1){
            Actividad = FuncionesPropias.pregunta("De qué atleta quieres la informacion? (1-5)");
        }

        }
        catch (Exception e){
            System.err.println("Introduce un número válido (1-7)");
            CargarAtleta();
        }

        String ruta = String.format("TrackFiles\\Athlete%d\\activity-Athlete%d-0%d.csv", Atleta, Atleta, Actividad);
        System.out.printf("Log: %s \n",ruta);
        return ruta;

    }
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
    public static double CalculoMedia(int[] array){
        double sumatorio;
        sumatorio = 0;
        for (int i = 0; i < array.length; i++) {
            sumatorio += array[i];

        }
        double media = sumatorio/array.length;
        return media;
    }
}
