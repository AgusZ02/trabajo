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
    public static DatosIniciales CargarAtleta(){
        DatosIniciales dato;

        dato = new DatosIniciales();

        try {
            while (dato.atleta < 1 || dato.atleta > 7){
            dato.atleta = FuncionesPropias.pregunta("De qué atleta quieres la informacion? (1-7)");
        }
        while (dato.actividad > 5 || dato.actividad < 1){
            dato.actividad = FuncionesPropias.pregunta("De qué atleta quieres la informacion? (1-5)");
        }
        dato.ID = String.format("Athlete%d", dato.atleta);
        }
        catch (Exception e){
            System.err.println("Introduce un número válido (1-7)");
            CargarAtleta();
        }

        dato.ruta = String.format("TrackFiles\\Athlete%d\\activity-Athlete%d-0%d.csv", dato.atleta, dato.atleta, dato.actividad);
        System.out.printf("Log: %s \n",dato.ruta);
        return dato;

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
        double media;
        sumatorio = 0;
        for (int i = 0; i < array.length; i++) {
            sumatorio += array[i];

        }
        media = sumatorio/array.length;
        return media;
    }
}
