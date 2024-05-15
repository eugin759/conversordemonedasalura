package calculos;

import com.google.gson.Gson;
import modelos.Transaccion;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaTasaDeCambio {
    public Transaccion realizaConversion(String base, String objetivo, double cantidad){
        URI uri = URI.create("https://v6.exchangerate-api.com/v6/6e9d3d2a3802f15002b56735/pair/"
                + base + "/" + objetivo + "/" + cantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Transaccion.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
