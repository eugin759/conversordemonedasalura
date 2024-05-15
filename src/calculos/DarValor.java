package calculos;

public class DarValor {
    public String obtenerRespuesta(int escaner){
        switch (escaner){
            case 1:
                return "MXN";
            case 2:
                return "USD";
            case 3:
                return "BRL";

            case 4:
                return "COP";

            case 5:
                return "ARS";

            case 6:
                return  "BOB";

            case 7:
                return  "CAD";

            case 100:
                return "historial";

            default: return "Salir";

        }
    }
}
