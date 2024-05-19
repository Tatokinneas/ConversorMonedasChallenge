

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Convert {

    private String url_api;
    private int qty;
    private String country1;
    private String country2;

    public Convert(String url_api, int qty, String country1, String country2){
        this.qty = qty;
        this.url_api = url_api;
        this.country1 = country1;
        this.country2 = country2;
    }

    public String conversion() throws IOException, InterruptedException {
       // System.out.println(getUrl_api() + getCountry1() + "/"+ getCountry2() + "/" + String.valueOf(getQty()));
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(getUrl_api() + getCountry1() +
                        "/"+ getCountry2() + "/" + String.valueOf(getQty())))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(response.body());
        Gson gson = new Gson();
        ConvertExchanges results = gson.fromJson(response.body(), ConvertExchanges.class);
        return "El resultado de convertir " + getQty() + " " + getCountry1() + " a " +
                getCountry2() + " es: " + results.conversion_result() + " " +
                getCountry2();
    }

    public String getUrl_api() {
        return url_api;
    }

    public void setUrl_api(String url_api) {
        this.url_api = url_api;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getCountry1() {
        return country1;
    }

    public void setCountry1(String country1) {
        this.country1 = country1;
    }

    public String getCountry2() {
        return country2;
    }

    public void setCountry2(String country2) {
        this.country2 = country2;
    }
}
