package principal;

import calculos.ConsultaTasaDeCambio;
import calculos.DarValor;
import calculos.GeneracionDeArchivo;
import modelos.Transaccion;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String menu = """
                * * * * * Menu* * * * *
                * 1)Peso Mexicano     *
                * 2)Dolar             *
                * 3)Real Brasileño    *
                * 4)Peso colombiano   *
                * 5)Peso argentino    *
                * 6)Boliviano         *
                * 7)Dolar Canadiense  *
                * Otro numero)Salir   *
                * * * * * * * * * * * *
                """;
        Scanner scanner = new Scanner(System.in);
        ConsultaTasaDeCambio consultaTasaDeCambio = new ConsultaTasaDeCambio();
        DarValor darValor = new DarValor();
        GeneracionDeArchivo generacionDeArchivo = new GeneracionDeArchivo();

        while (true) {

            try{
                System.out.println("\n\n\n");
                System.out.println("*************************************************************************");
                System.out.println("Welcome to the los pollos hermanos casa de cambio family");
                System.out.print(menu);
                System.out.println("Selecciona una opcion:");


                var seleccion1 = darValor.obtenerRespuesta(Integer.valueOf(scanner.nextLine()));
                if (seleccion1 == "Salir") {
                    break;
                }else {

                    System.out.println(menu);
                    System.out.println("Selecciona la moneda a la cual desead convertir");
                    var seleccion2 = darValor.obtenerRespuesta(Integer.valueOf(scanner.nextLine()));

                    if (seleccion2 == "Salir" || seleccion2 == "historial") {
                        break;
                    }else {

                        System.out.println("\n");
                        System.out.println("Ingresa la cantidad a convertir");
                        var valor = Double.valueOf(scanner.nextLine());

                        Transaccion transaccion = consultaTasaDeCambio.realizaConversion(seleccion1, seleccion2, valor);
                        System.out.println("\n\nLa suma de: " + valor + seleccion1 + " es de: " + transaccion.conversion_result() + seleccion2);

                        System.out.println("*************************************************************************");
                        try {
                            generacionDeArchivo.guardarJson(transaccion);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Parece que no seleccionaste una opcion valida");
                System.out.println("Intentemos de nuevo");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
