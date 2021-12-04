public class DistanciaEntrePuntos {

    public static float DistanciaPuntos(float lat1, float lat2, float long1, float long2, float Radio) {
    	float Dlat = lat2 - lat1;
    	float Dlong = long2 - long1;
    	float a = Math.pow(Math.sin(Dlat), 2) = Math.cos(lat1) * Math.cos(lat2) * Math.sin(Dlong);
    	float d = (float) (2 * Radio * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)));
    	return d;
    }
}
