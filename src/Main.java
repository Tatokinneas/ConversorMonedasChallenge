import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        boolean menuSelection = true;
        String menuText = "|*************************************|" +
                    "Bienvenido";
        Scanner sc = new Scanner(System.in);
        System.out.println(menuText);
        String url_api = "https://v6.exchangerate-api.com/v6/146601e2c21bb2ec0a2a430f/pair/USD/MXN/1";
        while(menuSelection){
            int option = sc.nextInt();
            if (option==0){
                menuSelection=false;
            }
            if(option==1){
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(url_api))
                                .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println(response.body());
            }
        }
    }
}