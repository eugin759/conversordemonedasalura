package calculos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.Transaccion;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GeneracionDeArchivo {
    public void guardarJson(Transaccion transaccion) throws IOException {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyy-MM-dd-HHmm");
        String horaActual = localDateTime.format(dateTimeFormatter);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fileWriter = new FileWriter(transaccion.base_code()
                + "to" + transaccion.target_code() + "_" + horaActual +".json");
        fileWriter.write(gson.toJson(transaccion));
        fileWriter.close();
    }

    public void leerJson(List<Transaccion> historial){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if(historial.isEmpty()){
            System.out.println("Aun no se han generado transacciones");
        }else {
            String listaTransacciones = gson.toJson(historial);
            System.out.println(listaTransacciones);

        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
