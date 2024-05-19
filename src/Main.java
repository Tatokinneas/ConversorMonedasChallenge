import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Convert conv = new Convert("",0,"","");
        boolean menuSelection = true;
        String menuText = "|****************************************| \n" +
                "Sea bienvenido/a al Conversor de Monedas \n" +
                "Ahora indique cual conversión desea realizar \n" +
                "1) Dólar estadounidense =>> Peso chileno \n" +
                "2) Peso chileno =>> Dólar estadounidense \n" +
                "3) Dólar estadounidense =>> Real brasileño \n" +
                "4) Real brasileño =>> Dólar estadounidense \n" +
                "5) Dólar estadounidense =>> Peso colombiano \n" +
                "6) Peso colombiano =>> Dólar estadounidense \n" +
                "7) Dólar estadounidense =>> Peso mexicano \n" +
                "8) Peso mexicano =>> Dólar estadounidense \n" +
                "9) Salir \n" +
                "Elija una opción válida:";
        String menuConverted =  "|***************************************| \n" +
                "Elige la cantidad que deseas convertir:  ";
        Scanner opt = new Scanner(System.in);
        System.out.println(menuText);


        String url_api = "https://v6.exchangerate-api.com/v6/146601e2c21bb2ec0a2a430f/pair/";
        while(menuSelection){
            System.out.println(menuText);
            try{
                int option = opt.nextInt();
                if (option == 9) {
                    menuSelection = false;
                    System.out.println("Gracias por usar el conversor de monedas. ¡Adiós!");
                    break;
                }
                Scanner qty = new Scanner(System.in);
                System.out.println(menuConverted);
                int qt = qty.nextInt();
                switch (option) {
                    case 1: {
                        // Dólar estadounidense =>> Peso chileno
                        conv.setQty(qt);
                        conv.setUrl_api(url_api);
                        conv.setCountry1("USD");
                        conv.setCountry2("CLP");
                        System.out.println(conv.conversion());
                        break;
                    }
                    case 2: {
                        // Peso chileno =>> Dólar estadounidense
                        conv.setQty(qt);
                        conv.setUrl_api(url_api);
                        conv.setCountry1("CLP");
                        conv.setCountry2("USD");
                        System.out.println(conv.conversion());
                        break;
                    }
                    case 3: {
                        // Dólar estadounidense =>> Real brasileño
                        conv.setQty(qt);
                        conv.setUrl_api(url_api);
                        conv.setCountry1("USD");
                        conv.setCountry2("BRL");
                        System.out.println(conv.conversion());
                        break;
                    }
                    case 4: {
                        // Real brasileño =>> Dólar estadounidense
                        conv.setQty(qt);
                        conv.setUrl_api(url_api);
                        conv.setCountry1("BRL");
                        conv.setCountry2("USD");
                        System.out.println(conv.conversion());
                        break;
                    }
                    case 5: {
                        // Dólar estadounidense =>> Peso colombiano
                        conv.setQty(qt);
                        conv.setUrl_api(url_api);
                        conv.setCountry1("USD");
                        conv.setCountry2("COP");
                        System.out.println(conv.conversion());
                        break;
                    }
                    case 6: {
                        // Peso colombiano =>> Dólar estadounidense
                        conv.setQty(qt);
                        conv.setUrl_api(url_api);
                        conv.setCountry1("COP");
                        conv.setCountry2("USD");
                        System.out.println(conv.conversion());
                        break;
                    }
                    case 7: {
                        // Dólar estadounidense =>> Peso mexicano
                        conv.setQty(qt);
                        conv.setUrl_api(url_api);
                        conv.setCountry1("USD");
                        conv.setCountry2("MXN");
                        System.out.println(conv.conversion());
                        break;
                    }
                    case 8: {
                        // Peso mexicano =>> Dólar estadounidense
                        conv.setQty(qt);
                        conv.setUrl_api(url_api);
                        conv.setCountry1("MXN");
                        conv.setCountry2("USD");
                        System.out.println(conv.conversion());
                        break;
                    }
                    default: {
                        System.out.println("Opción no válida. Por favor, elija una opción entre 1 y 9.");
                        break;
                    }
                }
            }catch (InputMismatchException ex){
                System.out.println("Debe ingresar obligatoriamente un número entero.");
                opt.next();
            }

        }
    }
}