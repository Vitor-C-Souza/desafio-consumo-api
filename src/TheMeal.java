import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class TheMeal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner read = new Scanner(System.in);
        System.out.println("Digite o nome da receita para a busca: ");
        var meal = read.nextLine().replace(" ", "+");

        String endereco = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + meal;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
